package com.nanjing.tqlhl.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.module_tool.base.BaseConstant
import com.nanjing.tqlhl.utils.ImageFormatUtil
import okhttp3.*
import org.json.JSONObject
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.security.MessageDigest

class SendViewModel : ViewModel() {
    private val okHttpClient by lazy {
        OkHttpClient()
    }

    fun send(
        content: String,
        contact: String,
        imageUrl: List<String>,
        successAction: () -> Unit,
        failAction: (String) -> Unit,
    ) {
        val map = mapOf<String, String>(
            "content" to content,
            "contact" to contact,
            "user_id" to "111",
            "user_system" to "1",
            "user_package" to BaseConstant.application.packageName,
            "package_chn" to "三人雨时天气"
        )
        val imageP = HashMap<String, String>()
        if (imageUrl.size >= 1) {
            imageP["img_one"] = imageUrl.first()
        }
        if (imageUrl.size >= 2) {
            imageP["img_two"] = imageUrl[1]
        }
        if (imageUrl.size >= 3) {
            imageP["img_three"] = imageUrl[2]
        }
        sendPostSecret("http://position.aisou.club/usercenter/public/feedback", map, {
//            iLog(it,"反馈")
            BaseConstant.mainHandler.post {
                try {
                    val data = JSONObject(it)
                    val code = data.getString("code")
                    if (code == "200") {
                        successAction.invoke()
                    } else {
                        failAction.invoke(data.getString("msg"))
                    }
                } catch (e: Exception) {
                    failAction.invoke("服务异常")
                }
            }

        }, {
//            iLog(it,"反馈")
            BaseConstant.mainHandler.post {
                failAction.invoke("服务异常")
            }
        }, imageP)
    }

    fun pullImageView(uri: Uri, action: (String) -> Unit, failAction: (String) -> Unit) {
        val mediaType = MediaType.parse("application/octet-stream; charset=utf-8")

        val file = uriToTempFile(uri)
        val body = RequestBody.create(mediaType, file)
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("thumb", file.name, body)
            .build()
        val request = Request.Builder()
            .url("http://position.aisou.club/usercenter/position/uploadImg")
            .post(requestBody)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
//                iLog("异常","上传图片")
                failAction.invoke("网络异常")
            }

            override fun onResponse(call: Call, response: Response) {
                val bodyString = response.body()?.string()
//                iLog(bodyString?:"null","上传图片")
                if (bodyString != null) {
                    try {
                        val jsonObject = JSONObject(bodyString)
                        action.invoke(jsonObject.getJSONObject("data").getString("img_url"))
                    } catch (e: Exception) {
                        failAction.invoke("服务器异常")
                    }
                } else {
                    failAction.invoke("服务器异常")
                }
            }
        })
    }

    private fun uriToTempFile(uri: Uri): File {
        val file = File(BaseConstant.application.cacheDir, "temp")
        if (file.exists()) {
            file.delete()
        }
        BaseConstant.application.contentResolver.openInputStream(uri)?.use { inputStream ->
            val byteArray = ByteArray(1024)
            var length = 0
            file.outputStream().use { outputStream ->
                while (inputStream.read(byteArray).let {
                        length = it
                        it != -1
                    }) {
                    outputStream.write(byteArray, 0, length)
                }
            }
        }
        val suffix = ImageFormatUtil.getPicType(
            FileInputStream(file))

        val fileSize = file.length()
        val tM = 2 * 1000 * 1000
        var s = fileSize / tM
        if (s > 1) {
            val file2 = File(BaseConstant.application.cacheDir, "temp2.$suffix")
            do {
                val option = BitmapFactory.Options()
                option.inSampleSize = (s.toInt() + 1)
//                iLog("inSampleSize:${option.inSampleSize}","压缩图片")
                val bitmap = BitmapFactory.decodeFile(file.absolutePath, option)
                if (file2.exists()) {
                    file2.delete()
                }
                if (suffix.equals("png", true)) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, file2.outputStream())
                } else if (suffix.equals("jpg", true)) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, file2.outputStream())
                } else {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, file2.outputStream())
                }
                s++
            } while (file2.length() > tM)
//            iLog("原大小:${Formatter.formatFileSize(BaseConstant.application,fileSize)}," +
//                    "压缩后:${Formatter.formatFileSize(BaseConstant.application,file2.length())}" +
//                    "压缩比:${fileSize.toFloat()/file2.length().toFloat()}","压缩图片")
            return file2
        } else {
            return file
        }
    }


    private fun sendPostSecret(
        url: String,
        parameter: Map<String, String>,
        success: (String) -> Unit,
        fail: (msg: String) -> Unit,
        parameter2: Map<String, String>? = null,
    ) {
        val t = (System.currentTimeMillis() / 1000).toString()
        val builder = FormBody.Builder()
        parameter.forEach {
            builder.add(it.key, it.value)
        }
        parameter2?.forEach {
            builder.add(it.key, it.value)
        }
        builder.add("timestamp", t)
        builder.add("signature", getSignature(url, parameter, t))
        val request = Request.Builder()
            .url(url)
            .post(builder.build())
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                fail.invoke(e.message ?: "出错了")
            }

            override fun onResponse(call: Call, response: Response) {
                val s = response.body()?.string() ?: return fail.invoke("出错了")
                success.invoke(s)
            }

        })
    }

    private fun getSignature(url: String, parameter: Map<String, Any>, t: String): String {
        val stringBuilder = StringBuilder()
        parameter.values.map { it.toString() }.sorted().forEach {
            stringBuilder.append(it)
        }
        val d = stringBuilder.toString()
        val timestamp = t
        val token = "x389fh^feahykge"
        val nonce = 523146
        val service = url.substringAfter("/").substringAfter("?").split("/").let { list ->
            if (list.size >= 2) {
                val sb = StringBuilder()
                list.takeLast(2).forEach {
                    sb.append(it)
                    sb.append("/")
                }
                sb.removeSuffix("/")
                sb.toString()
            } else {
                ""
            }.removeSuffix("/")
        }
        val signature = (token + timestamp + nonce + service + d).toMd5()

        return signature
    }

    override fun onCleared() {
        super.onCleared()
        okHttpClient.dispatcher().cancelAll()
    }

    fun String.toMd5(): String {
        val string = this
        if (string.isEmpty()) {
            return string
        }
        val md5 = MessageDigest.getInstance("MD5")
        val byteArray = md5.digest(string.toByteArray())
        return try {
            val result = StringBuilder()
            byteArray.forEach {
                var t = Integer.toHexString(it.toInt() and 0xff)
                if (t.length == 1) {
                    t = "0$t"
                }
                result.append(t)
            }
            result.toString()
        } catch (e: Exception) {
            ""
        }
    }

}