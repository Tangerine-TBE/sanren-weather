package com.nanjing.tqlhl.ui.custom.mj15day;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.nanjing.tqlhl.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ZzWeatherView
 *
 * @author Zz
 * 2016/12/8 9:29
 */
public class ZzWeatherView extends HorizontalScrollView {

    private List<WeatherModel> list;
    private Paint dayPaint;
    private Paint nightPaint;

    protected Path pathDay;
    protected Path pathNight;

    public static final int LINE_TYPE_CURVE = 1; //曲线
    public static final int LINE_TYPE_DISCOUNT = 2; //折线

    private int lineType = LINE_TYPE_CURVE;
    private float lineWidth = 6f;

    private int dayLineColor = 0xff78ad23;
    private int nightLineColor = 0xff23acb3;

    private int columnNumber = 6;

    private OnWeatherItemClickListener weatherItemClickListener;
    private LinearLayout mLlRoot;
    private WeatherItemView mItemView;

    public ZzWeatherView(Context context) {
        this(context, null);
    }

    public ZzWeatherView(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }

    public ZzWeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs,defStyleAttr);
        init();
    }

    private void init() {
        dayPaint = new Paint();
        dayPaint.setColor(dayLineColor);
        dayPaint.setAntiAlias(true);
        dayPaint.setStrokeWidth(lineWidth);
        dayPaint.setStyle(Paint.Style.STROKE);

        nightPaint = new Paint();
        nightPaint.setColor(nightLineColor);
        nightPaint.setAntiAlias(true);
        nightPaint.setStrokeWidth(lineWidth);
        nightPaint.setStyle(Paint.Style.STROKE);

        pathDay = new Path();
        pathNight = new Path();

        mLlRoot = new LinearLayout(getContext());
        mLlRoot.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mLlRoot.setOrientation(LinearLayout.HORIZONTAL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(View.LAYER_TYPE_HARDWARE, null);
        if (getChildCount() > 0) {
            ViewGroup root = (ViewGroup) getChildAt(0);

            if (root.getChildCount() > 0) {

                float intensity = 0.16f;

                WeatherItemView c = (WeatherItemView) root.getChildAt(0);
                int dX = c.getTempX();
                int dY = c.getTempY();
                int nX = c.getTempX();
                int nY = c.getTempY();


                TemperatureView tv =c.findViewById(R.id.ttv_day);

                postInvalidate();
                tv.setRadius(10);

                int x0 = (int) (dX + tv.getxPointDay());
                int y0 = (int) (dY + tv.getyPointDay());
                int x = (int) (nX + tv.getxPointNight());
                int y = (int) (nY + tv.getyPointNight());

                pathDay.reset();
                pathNight.reset();

                pathDay.moveTo(x0, y0);
                pathNight.moveTo(x, y);

                if (lineType == LINE_TYPE_CURVE) {

                    int lineSize = root.getChildCount();

                    //曲线
                    float prePreviousPointX = Float.NaN;
                    float prePreviousPointY = Float.NaN;
                    float previousPointX = Float.NaN;
                    float previousPointY = Float.NaN;
                    float currentPointX = Float.NaN;
                    float currentPointY = Float.NaN;
                    float nextPointX = Float.NaN;
                    float nextPointY = Float.NaN;

                    float prePreviousPointX1 = Float.NaN;
                    float prePreviousPointY1 = Float.NaN;
                    float previousPointX1 = Float.NaN;
                    float previousPointY1 = Float.NaN;
                    float currentPointX1 = Float.NaN;
                    float currentPointY1 = Float.NaN;
                    float nextPointX1 = Float.NaN;
                    float nextPointY1 = Float.NaN;

                    for (int i = 0; i < lineSize; i++) {

                        //Day
                        if (Float.isNaN(currentPointX)) {
                            WeatherItemView curWI = (WeatherItemView) root.getChildAt(i);
                            int dayX = curWI.getTempX() + curWI.getWidth() * i;
                            int dayY = curWI.getTempY();
                            int nightX = curWI.getTempX() + curWI.getWidth() * i;
                            int nightY = curWI.getTempY();
                            TemperatureView tempV = (TemperatureView) curWI.findViewById(R.id.ttv_day);
                            tempV.setRadius(10);

                            //day2
                            currentPointX = (int) (dayX + tempV.getxPointDay());
                            currentPointY = (int) (dayY + tempV.getyPointDay());
                            //night2
                            int x2 = (int) (nightX + tempV.getxPointNight());
                            int y2 = (int) (nightY + tempV.getyPointNight());

                        }
                        if (Float.isNaN(previousPointX)) {
                            if (i > 0) {
                                WeatherItemView preWI = (WeatherItemView) root.getChildAt(Math.max(i-1, 0));

                                int dayX0 = preWI.getTempX() + preWI.getWidth() * (i-1);
                                int dayY0 = preWI.getTempY();
                                int nightX0 = preWI.getTempX() + preWI.getWidth() * (i-1);
                                int nightY0 = preWI.getTempY();
                                TemperatureView tempV0 = (TemperatureView) preWI.findViewById(R.id.ttv_day);
                                tempV0.setRadius(10);


                                //day1
                                previousPointX = (int) (dayX0 + tempV0.getxPointDay());
                                previousPointY = (int) (dayY0 + tempV0.getyPointDay());


                            } else {
                                previousPointX = currentPointX;
                                previousPointY = currentPointY;
                            }
                        }

                        if (Float.isNaN(prePreviousPointX)) {
                            if (i > 1) {

                                WeatherItemView preWI = (WeatherItemView) root.getChildAt(Math.max(i-2, 0));

                                int dayX0 = preWI.getTempX() + preWI.getWidth() * (i-2);
                                int dayY0 = preWI.getTempY();
                                int nightX0 = preWI.getTempX() + preWI.getWidth() * (i-2);
                                int nightY0 = preWI.getTempY();
                                TemperatureView tempV0 = (TemperatureView) preWI.findViewById(R.id.ttv_day);
                                tempV0.setRadius(10);

                                //pre pre day
                                prePreviousPointX = (int) (dayX0 + tempV0.getxPointDay());
                                prePreviousPointY = (int) (dayY0 + tempV0.getyPointDay());


                            } else {
                                prePreviousPointX = previousPointX;
                                prePreviousPointY = previousPointY;
                            }
                        }

                        // nextPoint is always new one or it is equal currentPoint.
                        if (i < lineSize - 1) {

                            WeatherItemView nextWI = (WeatherItemView) root.getChildAt(Math.min(root.getChildCount()-1, i + 1));


                            int dayX1 = nextWI.getTempX() + nextWI.getWidth() * (i + 1);
                            int dayY1 = nextWI.getTempY();
                            int nightX1 = nextWI.getTempX() + nextWI.getWidth() * (i + 1);
                            int nightY1 = nextWI.getTempY();


                            TemperatureView tempV1 = (TemperatureView) nextWI.findViewById(R.id.ttv_day);

                            tempV1.setRadius(10);
                            //day3
                            nextPointX = (int) (dayX1 + tempV1.getxPointDay());
                            nextPointY = (int) (dayY1 + tempV1.getyPointDay());
                            //night3
                            int x22 = (int) (nightX1 + tempV1.getxPointNight());
                            int y22 = (int) (nightY1 + tempV1.getyPointNight());

                        } else {
                            nextPointX = currentPointX;
                            nextPointY = currentPointY;
                        }

                        /*****************************Night************************/
                        if (Float.isNaN(currentPointX1)) {
                            WeatherItemView curWI = (WeatherItemView) root.getChildAt(i);
                            int nightX = curWI.getTempX() + curWI.getWidth() * i;
                            int nightY = curWI.getTempY();
                            TemperatureView tempV =  curWI.findViewById(R.id.ttv_day);
                            tempV.setRadius(10);

                            //night2
                            currentPointX1 = nightX + tempV.getxPointNight();
                            currentPointY1 = nightY + tempV.getyPointNight();

                        }
                        if (Float.isNaN(previousPointX1)) {
                            if (i > 0) {
                                WeatherItemView preWI = (WeatherItemView) root.getChildAt(Math.max(i-1, 0));

                                int nightX0 = preWI.getTempX() + preWI.getWidth() * (i-1);
                                int nightY0 = preWI.getTempY();
                                TemperatureView tempV0 = (TemperatureView) preWI.findViewById(R.id.ttv_day);
                                tempV0.setRadius(10);

                                //night
                                previousPointX1 = (int) (nightX0 + tempV0.getxPointNight());
                                previousPointY1 = (int) (nightY0 + tempV0.getyPointNight());

                            } else {
                                previousPointX1 = currentPointX1;
                                previousPointY1 = currentPointY1;
                            }
                        }

                        if (Float.isNaN(prePreviousPointX1)) {
                            if (i > 1) {

                                WeatherItemView preWI = (WeatherItemView) root.getChildAt(Math.max(i-2, 0));

                                int nightX0 = preWI.getTempX() + preWI.getWidth() * (i-2);
                                int nightY0 = preWI.getTempY();
                                TemperatureView tempV0 = (TemperatureView) preWI.findViewById(R.id.ttv_day);
                                tempV0.setRadius(10);

                                //pre pre day
                                prePreviousPointX1 = (int) (nightX0 + tempV0.getxPointNight());
                                prePreviousPointY1 = (int) (nightY0 + tempV0.getyPointNight());


                            } else {
                                prePreviousPointX1 = previousPointX1;
                                prePreviousPointY1 = previousPointY1;
                            }
                        }

                        // nextPoint is always new one or it is equal currentPoint.
                        if (i < lineSize - 1) {

                            WeatherItemView nextWI = (WeatherItemView) root.getChildAt(Math.min(root.getChildCount()-1, i + 1));
                            int nightX1 = nextWI.getTempX() + nextWI.getWidth() * (i + 1);
                            int nightY1 = nextWI.getTempY();

                            TemperatureView tempV1 = (TemperatureView) nextWI.findViewById(R.id.ttv_day);

                            tempV1.setRadius(10);
                            //night3
                            nextPointX1 = (int) (nightX1 + tempV1.getxPointNight());
                            nextPointY1 = (int) (nightY1 + tempV1.getyPointNight());

                        } else {
                            nextPointX1 = currentPointX1;
                            nextPointY1 = currentPointY1;
                        }

                        //Day and Night
                        if (i == 0) {
                            // Move to start point.
                            pathDay.moveTo(currentPointX, currentPointY);
                            pathNight.moveTo(currentPointX1, currentPointY1);
                        } else {
                            // Calculate control points.
                            final float firstDiffX = (currentPointX - prePreviousPointX);
                            final float firstDiffY = (currentPointY - prePreviousPointY);
                            final float secondDiffX = (nextPointX - previousPointX);
                            final float secondDiffY = (nextPointY - previousPointY);
                            final float firstControlPointX = previousPointX + (intensity * firstDiffX);
                            final float firstControlPointY = previousPointY + (intensity * firstDiffY);
                            final float secondControlPointX = currentPointX - (intensity * secondDiffX);
                            final float secondControlPointY = currentPointY - (intensity * secondDiffY);
                            pathDay.cubicTo(firstControlPointX, firstControlPointY, secondControlPointX, secondControlPointY,
                                    currentPointX, currentPointY);

                            final float firstDiffX1 = (currentPointX1 - prePreviousPointX1);
                            final float firstDiffY1 = (currentPointY1 - prePreviousPointY1);
                            final float secondDiffX1 = (nextPointX1 - previousPointX1);
                            final float secondDiffY1 = (nextPointY1 - previousPointY1);
                            final float firstControlPointX1 = previousPointX1 + (intensity * firstDiffX1);
                            final float firstControlPointY1 = previousPointY1 + (intensity * firstDiffY1);
                            final float secondControlPointX1 = currentPointX1 - (intensity * secondDiffX1);
                            final float secondControlPointY1 = currentPointY1 - (intensity * secondDiffY1);
                            pathNight.cubicTo(firstControlPointX1, firstControlPointY1, secondControlPointX1, secondControlPointY1,
                                    currentPointX1, currentPointY1);
                        }

                        // Shift values by one back to prevent recalculation of values that have
                        // been already calculated.
                        prePreviousPointX = previousPointX;
                        prePreviousPointY = previousPointY;
                        previousPointX = currentPointX;
                        previousPointY = currentPointY;
                        currentPointX = nextPointX;
                        currentPointY = nextPointY;

                        prePreviousPointX1 = previousPointX1;
                        prePreviousPointY1 = previousPointY1;
                        previousPointX1 = currentPointX1;
                        previousPointY1 = currentPointY1;
                        currentPointX1 = nextPointX1;
                        currentPointY1 = nextPointY1;

                    }

                    canvas.drawPath(pathDay, dayPaint);
                    canvas.drawPath(pathNight, nightPaint);
                } else {
                    //折线
                    for (int i = 0; i < root.getChildCount() - 1; i++) {
                        WeatherItemView child = (WeatherItemView) root.getChildAt(i);
                        WeatherItemView child1 = (WeatherItemView) root.getChildAt(i + 1);
                        int dayX = child.getTempX() + child.getWidth() * i;
                        int dayY = child.getTempY();
                        int nightX = child.getTempX() + child.getWidth() * i;
                        int nightY = child.getTempY();
                        int dayX1 = child1.getTempX() + child1.getWidth() * (i + 1);
                        int dayY1 = child1.getTempY();
                        int nightX1 = child1.getTempX() + child1.getWidth() * (i + 1);
                        int nightY1 = child1.getTempY();

                        TemperatureView tempV = (TemperatureView) child.findViewById(R.id.ttv_day);
                        TemperatureView tempV1 = (TemperatureView) child1.findViewById(R.id.ttv_day);

                        tempV.setRadius(10);
                        tempV1.setRadius(10);

                        int x1 = (dayX + tempV.getxPointDay());
                        int y1 = (dayY + tempV.getyPointDay());
                        int x2 = (nightX + tempV.getxPointNight());
                        int y2 = (nightY + tempV.getyPointNight());

                        int x11 = (dayX1 + tempV1.getxPointDay());
                        int y11 = (dayY1 + tempV1.getyPointDay());
                        int x22 = (nightX1 + tempV1.getxPointNight());
                        int y22 = (nightY1 + tempV1.getyPointNight());

                        canvas.drawLine(x1, y1, x11, y11, dayPaint);
                        canvas.drawLine(x2, y2, x22, y22, nightPaint);


                    }
                }
            }

        }

    }


    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
        dayPaint.setStrokeWidth(lineWidth);
        nightPaint.setStrokeWidth(lineWidth);

    }

    public void setDayLineColor(int color) {
        this.dayLineColor = color;
        dayPaint.setColor(dayLineColor);

    }

    public void setNightLineColor(int color) {
        this.nightLineColor = color;
        nightPaint.setColor(nightLineColor);

    }

    public void setDayAndNightLineColor(int dayColor, int nightColor) {
        this.dayLineColor = dayColor;
        this.nightLineColor = nightColor;
        dayPaint.setColor(dayLineColor);
        nightPaint.setColor(nightLineColor);

    }

    public List<WeatherModel> getList() {
        return list;
    }

    public void setOnWeatherItemClickListener(OnWeatherItemClickListener weatherItemClickListener) {
        this.weatherItemClickListener = weatherItemClickListener;
    }

    public void setList(final List<WeatherModel> list) {
        if (list != null) {
            removeAllViews();
            mLlRoot.removeAllViews();
            this.list = list;
            int screenWidth = getScreenWidth();
            int maxDay = getMaxDayTemp(list);
            int maxNight = getMaxNightTemp(list);
            int minDay = getMinDayTemp(list);
            int minNight = getMinNightTemp(list);
            int max = maxDay > maxNight ? maxDay : maxNight;
            int min = minDay < minNight ? minDay : minNight;


            for (int i = 0; i < list.size(); i++) {
                WeatherModel model = list.get(i);
                mItemView = new WeatherItemView(getContext());
                mItemView.setMaxTemp(max);
                mItemView.setMinTemp(min);
                mItemView.setDate(model.getDate());
                mItemView.setWeek(model.getWeek());
                mItemView.setDayTemp(model.getDayTemp());
                mItemView.setDayWeather(model.getDayWeather());
                if (model.getDayPic() == 0) {
                    if (model.getDayWeather() != null){
                        mItemView.setDayImg(PicUtil.getDayWeatherPic(model.getDayWeather()));
                    }
                } else {
                    mItemView.setDayImg(model.getDayPic());
                }
                mItemView.setNightWeather(model.getNightWeather());
                mItemView.setNightTemp(model.getNightTemp());
                if (model.getNightPic() == 0) {
                    if (model.getNightWeather() != null){
                        mItemView.setNightImg(PicUtil.getNightWeatherPic(model.getNightWeather()));
                    }
                } else {
                    mItemView.setNightImg(model.getNightPic());
                }
                mItemView.setWindOri(model.getWindOrientation());
                mItemView.setWindLevel(model.getWindLevel());
                mItemView.setAirLevel(model.getAirLevel());
                mItemView.setLayoutParams(new LinearLayout.LayoutParams(screenWidth / columnNumber, ViewGroup.LayoutParams.WRAP_CONTENT));
                mItemView.setClickable(true);
                final int finalI = i;
                mItemView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (weatherItemClickListener != null) {

                            weatherItemClickListener.onItemClick(mItemView, finalI, list.get(finalI));

                        }
                    }
                });

                mLlRoot.addView(mItemView);
            }
            addView(mLlRoot);
        }
    }

    public void setColumnNumber(int num) throws Exception {
        if (num > 2) {
            this.columnNumber = num;
            setList(this.list);
        } else {
            throw new Exception("ColumnNumber should lager than 2");
        }
    }

    private int getScreenWidth() {
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    private int getMinDayTemp(List<WeatherModel> list) {
        if (list != null) {
            return Collections.min(list, new DayTempComparator()).getDayTemp();
        }
        return 0;
    }

    private int getMinNightTemp(List<WeatherModel> list) {
        if (list != null) {
            return Collections.min(list, new NightTempComparator()).getNightTemp();
        }
        return 0;
    }


    private int getMaxNightTemp(List<WeatherModel> list) {
        if (list != null) {
            return Collections.max(list, new NightTempComparator()).getNightTemp();
        }
        return 0;
    }

    private int getMaxDayTemp(List<WeatherModel> list) {
        if (list != null) {
            return Collections.max(list, new DayTempComparator()).getDayTemp();
        }
        return 0;
    }

    public int getLineType() {
        return lineType;
    }

    public void setLineType(int lineType) {
        this.lineType = lineType;
    }

    private static class DayTempComparator implements Comparator<WeatherModel> {

        @Override
        public int compare(WeatherModel o1, WeatherModel o2) {
            if (o1.getDayTemp() == o2.getDayTemp()) {
                return 0;
            } else if (o1.getDayTemp() > o2.getDayTemp()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private static class NightTempComparator implements Comparator<WeatherModel> {

        @Override
        public int compare(WeatherModel o1, WeatherModel o2) {
            if (o1.getNightTemp() == o2.getNightTemp()) {
                return 0;
            } else if (o1.getNightTemp() > o2.getNightTemp()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public interface OnWeatherItemClickListener {
        void onItemClick(WeatherItemView itemView, int position, WeatherModel weatherModel);
    }

}
