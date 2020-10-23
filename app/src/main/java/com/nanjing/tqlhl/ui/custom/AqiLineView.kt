package com.nanjing.tqlhl.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.module_ad.utils.LogUtils
import com.example.module_ad.utils.SizeUtils
import com.nanjing.tqlhl.utils.ColorUtil
import com.nanjing.tqlhl.utils.WeatherUrl
import com.nanjing.tqlhl.utils.WeatherUtils

/**
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.custom
 * @class describe
 * @author wujinming QQ:1245074510
 * @time 2020/10/21 11:15
 * @class describe
 */
class AqiLineView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val mLinePaint = Paint()
    private val mTrianglePaint = Paint()
    private val mTextPaint = Paint()
    private val mContext = context
    private val mTriangleWidth = SizeUtils.dip2px(context, 8f).toFloat()
    private var mTrianglePosition = 0f
    private var mAqiValue = 0
    private var mTrianglePath = Path()
    private var mWidth = 0f
    private var mHeight = 0f

    init {

        mLinePaint.apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
            strokeWidth = SizeUtils.dip2px(context, 10f).toFloat()
            isAntiAlias = true
        }

        mTrianglePaint.apply {
            color = Color.BLACK
            style = Paint.Style.FILL
            strokeWidth = 1f
            isAntiAlias = true
        }

        mTextPaint.apply {
            color = Color.BLACK
            style = Paint.Style.FILL
            textSize = SizeUtils.sp2px(context, 16f).toFloat()
            textAlign = Paint.Align.CENTER
            isAntiAlias = true
        }

    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        mWidth = width.toFloat()
        mHeight = height.toFloat()
        setMeasuredDimension(width, height)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画线
        drawColorLine(canvas)
        //画指示点
        drawPointText(canvas)
    }

    private fun drawColorLine(canvas: Canvas) {
        for (i in 0 until 6) {
            mLinePaint.color = ColorUtil.AQI_COLOR[i]
            canvas.drawLine((mWidth / 6f) * i, mHeight, (mWidth / 6f) * (i + 1), mHeight, mLinePaint)
        }
    }

    private fun drawPointText(canvas: Canvas) {
        mTrianglePosition=((mWidth / 6f)/2)*WeatherUtils.aqiPoint(mAqiValue)
        mTrianglePath.moveTo(mTrianglePosition - mTriangleWidth / 2, mHeight / 1.5f)
        mTrianglePath.lineTo(mTrianglePosition + mTriangleWidth / 2, mHeight / 1.5f)
        mTrianglePath.lineTo(mTrianglePosition, mHeight / 1.5f + mTriangleWidth)
        mTrianglePath.close()
        val aqiBg = WeatherUtils.aqiBg(mAqiValue)
        mTrianglePaint.color=aqiBg
        canvas.drawPath(mTrianglePath, mTrianglePaint)
        mTextPaint.color=aqiBg
        canvas.drawText(mAqiValue.toString(), mTrianglePosition, mHeight / 1.5f - SizeUtils.dip2px(mContext, 6f), mTextPaint)
    }

    fun setAqiValue(aqi: Int) {
        mAqiValue = aqi
    }


}