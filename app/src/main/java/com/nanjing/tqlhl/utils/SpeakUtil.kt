package com.nanjing.tqlhl.utils


import com.baidu.tts.client.SpeechError
import com.baidu.tts.client.SpeechSynthesizer
import com.baidu.tts.client.SpeechSynthesizerListener
import com.baidu.tts.client.TtsMode
import com.nanjing.tqlhl.base.BaseApplication


import java.util.*

/**
 * @name AlarmClock
 * @class name：com.example.alarmclock.util
 * @class describe
 * @author wujinming QQ:1245074510
 * @time 2021/1/13 19:10:37
 * @class describe
 */
object  SpeakUtil {
    //普通女声 0
    //普通男声 1
    //特别男声 2
    //情感男声<度逍遥> 3
    //普通女声普通女声 4
    //度博文（情感男声） 106
    //度小童（情感儿童声） 110
    //度小萌（情感女声） 111
    //度米朵（情感儿童声） 103
    // 度小娇（情感女声） 5
    private val speakerType= arrayListOf("0","1","2","3","4","5","106","110","111","103")

        const val id="23537278"
        const val key="dSijt9iG7C4P64T4d2jUL0QQ"
        const val value="4NX8b00KenZUNvFGYCfw6ujohLMjGRQM"


    private val mSpeak by lazy {
        SpeechSynthesizer.getInstance()
    }

    private var isSpeak=false
    init {
        mSpeak.apply {
            setContext(BaseApplication.application)
            setAppId(id)
            setApiKey(key, value)
            initTts(TtsMode.ONLINE)
            setParam(SpeechSynthesizer.PARAM_SPEAKER,
                speakerType[Random().nextInt(speakerType.size)]
            )
            setSpeechSynthesizerListener(object : SpeechSynthesizerListener{
                override fun onSynthesizeStart(p0: String?) {

                }

                override fun onSpeechFinish(p0: String?) {
                    mListener?.onStop()
                    isSpeak=false
                }

                override fun onSpeechProgressChanged(p0: String?, p1: Int) {
                    isSpeak=true
                }

                override fun onSynthesizeFinish(p0: String?) {
                    isSpeak=false

                }

                override fun onSpeechStart(p0: String?) {
                    mListener?.onStart()
                }

                override fun onSynthesizeDataArrived(p0: String?, p1: ByteArray?, p2: Int, p3: Int) {


                }

                override fun onError(p0: String?, p1: SpeechError?) {
                    isSpeak=false
                    mListener?.onStop()

                }

            })
        }

    }


    fun isSpeaking()= isSpeak


    fun speakText(str:String){
        if (isSpeak) { mSpeak?.stop() }
        mSpeak?.speak(str)

    }

   fun  stopSpeak(){
       if (isSpeak) {
           mSpeak?.stop()
       }

    }

    fun releaseSrc(){
        mSpeak?.release()
    }

    interface OnSpeechListener{
       fun  onStart()
       fun  onStop()
    }

    private var mListener:OnSpeechListener?=null
    fun setOnSpeechListener(listener:OnSpeechListener){
        mListener=listener
    }

}