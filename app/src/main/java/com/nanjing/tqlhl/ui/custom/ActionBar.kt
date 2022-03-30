package com.nanjing.tqlhl.ui.custom

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.gyf.barlibrary.ImmersionBar
import com.nanjing.tqlhl.R
import kotlinx.android.synthetic.main.item_action_bar.view.*

class ActionBar @JvmOverloads constructor(context: Context,attrs: AttributeSet?=null,defSty:Int=0):FrameLayout(context,attrs,defSty) {
    init {
        LayoutInflater.from(context).inflate(R.layout.item_action_bar,this,true)
        fitsSystemWindows=true
        if (context is Activity){
            ImmersionBar.with(context)
                .statusBarDarkFont(true)
                .init()
            goBack.setOnClickListener {
                context.finish()
            }
        }
        val typedArray=context.obtainStyledAttributes(attrs,R.styleable.ActionBar)
        titleText.text=typedArray.getString(R.styleable.ActionBar_title)
        typedArray.recycle()
    }

    fun setTitle(text:CharSequence){
        titleText.text=text
    }
}