package com.nanjing.tqlhl.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.module_tool.utils.toast
import com.nanjing.tqlhl.model.SendViewModel
import com.feisukj.base.widget.loaddialog.LoadingDialog
import com.goyourfly.multi_picture.ImageLoader
import com.goyourfly.multi_picture.MultiPictureView
import com.nanjing.tqlhl.R
import kotlinx.android.synthetic.main.activity_send_feedback.*

class SendFeedbackActivity: AppCompatActivity() {
    companion object{
        private const val PICK_IMAGE_CODE=11
    }
    private val sendViewModel by lazy { ViewModelProvider(this,object :ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.newInstance()
        }
    }).get(SendViewModel::class.java) }
    private val pullImageLoadingDialog by lazy { LoadingDialog(this)
            .also {
                it.setTitleText("上传中...")
                it.setCancelable(false)
            }
    }
    private val loadingDialog by lazy {
        LoadingDialog(this)
    }
    private val imagePicture=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_feedback)
        MultiPictureView.setImageLoader(object : ImageLoader {
            override fun loadImage(image: ImageView, uri: Uri) {
                Glide.with(image.context)
                    .load(uri)
//                    .placeholder(R.drawable.ic_placeholder_loading)
//                    .error(R.drawable.ic_placeholder_loading)
                    .into(image)
            }
        })
        initListener()
    }

    private fun initListener(){
        inputText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                textCount.text="${s?.length?:0}/255字"
            }

        })
        multiImageView.addClickCallback=object : MultiPictureView.AddClickCallback{
            override fun onAddClick(view: View) {
                val intent=Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, PICK_IMAGE_CODE)
            }
        }
        sendFeedback.setOnClickListener {
            val content=inputText.text.toString()
            val contact=callText.text.toString()
            if(content.isBlank()){
                toast("请输入您的问题")
                return@setOnClickListener
            }
            if (contact.isBlank()){
                toast("请输入联系方式")
                return@setOnClickListener
            }
            loadingDialog.setTitleText("请稍后...")
            sendViewModel.send(content,contact,imagePicture,{
                toast("反馈成功")
                loadingDialog.dismiss()
                finish()
            },{
                loadingDialog.dismiss()
                toast(it)
            })
        }
        multiImageView.deleteClickCallback=object : MultiPictureView.DeleteClickCallback {
            override fun onDeleted(view: View, index: Int) {
                multiImageView.removeItem(index)
                imagePicture.removeAt(index)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== PICK_IMAGE_CODE){
            val uri=data?.data
            if (uri!=null){
                multiImageView.addItem(uri,true)
                pullImageLoadingDialog.show()
                sendViewModel.pullImageView(uri,{
                    runOnUiThread {
                        pullImageLoadingDialog.dismiss()
                        imagePicture.add(it)
                    }
                },{
                    runOnUiThread {
                        multiImageView.removeItem(multiImageView.getCount()-1)
                        pullImageLoadingDialog.dismiss()
                        toast(it)
                    }
                })
            }
        }
    }
}