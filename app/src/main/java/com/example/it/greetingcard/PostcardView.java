package com.example.it.greetingcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PostcardView extends View {
    float[] snow_x = new float[25];
    float[] snow_y = new float[25];

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // при каждом касании двигаем снежинки вниз
        for (int i = 0; i < snow_x.length; i++) {
            snow_y[i] += 0.02;
            if (snow_y[i] > 1) {
                snow_y[i] = 0;
            }
        }
        // после изменения координат дать команду на перерисовку
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.DKGRAY);
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        float w = canvas.getWidth();
        float h = canvas.getHeight();
        for (int i = 0; i < snow_x.length; i++) {
            canvas.drawCircle(snow_x[i] * w, snow_y[i] * h, 10, p);
        }
    }

    public PostcardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // задаём случайные координаты снежинок при создании View
        for (int i = 0; i < snow_x.length; i++) {
            snow_x[i] = (float) Math.random();
            snow_y[i] = (float) Math.random() - 1;
        }

    }
}
