package com.nanjing.tqlhl.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.module_ad.utils.SizeUtils;
import com.nanjing.tqlhl.R;

/**
 * @author wujinming QQ:1245074510
 * @name My Application
 * @class name：com.example.myapplication
 * @class describe
 * @time 2020/9/14 11:32
 * @class describe
 */
public class AqiCircle extends View {

    private  Context mContext;
    /*--------------画笔----------------*/
    private Paint mCenterCirclePaint; //中心圆
    private Paint mBrokenLinePaint;//虚线
    private Paint mInnerRingPaint;//内环
    private Paint mOutRingPaint;//外环
    private Paint mTextPaint;//字体
    /*---------------------------------*/
    private int x;//圆心X轴坐标
    private int y;//圆心Y轴坐标
    private int mCenterRadius;//中心圆半径
    private int mRingRadius;//外环半径
    private Paint mIndexPaint;

    private int centerCircleColor=0x31FFFFFF;
    private int BrokenLineColor=0xFFFFFFFF;
    private int IndexRingColor=0xFFFFFFFF;
    private int InnerRingColor=0xFF00FF00;
    private int OutRingColor=0x31FFFFFF;
    private int msgColor=0xFFFFFFFF;
    private int msgSize=40;
    private String msgContext="";



    public AqiCircle(Context context) {
        this(context,null);
    }

    public AqiCircle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AqiCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.AqiCircle);
        centerCircleColor= attributes.getColor(R.styleable.AqiCircle_centerCircleColor,centerCircleColor);
        BrokenLineColor=attributes.getColor(R.styleable.AqiCircle_brokenLineColor,BrokenLineColor);
        IndexRingColor=attributes.getColor(R.styleable.AqiCircle_indexRingColor,IndexRingColor);
        InnerRingColor=attributes.getColor(R.styleable.AqiCircle_innerRingColor,InnerRingColor);
        OutRingColor=attributes.getColor(R.styleable.AqiCircle_outRingColor,OutRingColor);
        msgColor=attributes.getColor(R.styleable.AqiCircle_msgColor,msgColor);
        msgSize=attributes.getDimensionPixelOffset(R.styleable.AqiCircle_msgSize,msgSize);
        msgContext=attributes.getString(R.styleable.AqiCircle_msgContext);
        attributes.recycle();

        this.mContext=context;

    }
    private void initPaint(Context context) {
        mCenterCirclePaint = new Paint();
        mCenterCirclePaint.setColor(centerCircleColor);
        mCenterCirclePaint.setAntiAlias(true);
        mCenterCirclePaint.setStyle(Paint.Style.FILL);
        mCenterCirclePaint.setStrokeWidth(2);

        mIndexPaint = new Paint();
        mIndexPaint.setColor(IndexRingColor);
        mIndexPaint.setAntiAlias(true);
        mIndexPaint.setStyle(Paint.Style.FILL);
        mIndexPaint.setStrokeWidth(3);


        mBrokenLinePaint = new Paint();
        mBrokenLinePaint.setColor(BrokenLineColor);
        mBrokenLinePaint.setAntiAlias(true);
        mBrokenLinePaint.setStyle(Paint.Style.STROKE);
        mBrokenLinePaint.setStrokeWidth(5);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{16,20,16,20},0);
        mBrokenLinePaint.setPathEffect(dashPathEffect);


        mInnerRingPaint = new Paint();
        mInnerRingPaint.setColor(InnerRingColor);
        mInnerRingPaint.setAntiAlias(true);
        mInnerRingPaint.setStyle(Paint.Style.STROKE);
        mInnerRingPaint.setStrokeWidth(SizeUtils.dip2px(context,4f));

        mOutRingPaint = new Paint();
        mOutRingPaint.setColor(OutRingColor);
        mOutRingPaint.setAntiAlias(true);
        mOutRingPaint.setStyle(Paint.Style.STROKE);
        mOutRingPaint.setStrokeWidth(SizeUtils.dip2px(context,8f));

        mTextPaint = new Paint();
        mTextPaint.setColor(msgColor);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(msgSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        x = width / 2;
        y = height / 2;
        mCenterRadius=x/2;
        mRingRadius=x/2+60;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint(mContext);
        //中心圆
        canvas.drawCircle(x,y,mCenterRadius, mCenterCirclePaint);
        //外环
        canvas.drawCircle(x,y,mRingRadius, mOutRingPaint);
        //内环
        canvas.drawCircle(x,y,mRingRadius, mInnerRingPaint);
        //字体
        Rect bounds = new Rect();
        mTextPaint.getTextBounds(msgContext, 0, msgContext.length(), bounds);
        Paint.FontMetricsInt fontMetrics = mTextPaint.getFontMetricsInt();
        //计算长宽
        int y1 = (getMeasuredHeight() - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        canvas.drawText(msgContext,x,y1, mTextPaint);
        //虚线
        Path path = new Path();
        path.addCircle(x,y,mCenterRadius-1,Path.Direction.CCW);
        canvas.drawPath(path, mBrokenLinePaint);
        //将坐标原点移到圆心处
        canvas.translate(x,y);
        for (int i = 0; i < 8; i++) {
            //这里刻度线长度我设置为25
            canvas.drawLine(mCenterRadius+25, 0,mRingRadius-SizeUtils.dip2px(mContext,5f), 0, mIndexPaint);
            canvas.rotate(45);
        }

    }

    public void setInnerRingColor(int innerRingColor) {
        this.InnerRingColor = innerRingColor;
    }

    public void setMsgContext(String msgContext) {
        this.msgContext = msgContext;
    }
}
