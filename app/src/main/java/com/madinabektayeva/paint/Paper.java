package com.madinabektayeva.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by madina on 01.05.18.
 */

public class Paper extends View {

    Paint paint;
    Path path;


    public Paper(Context context, AttributeSet attrs) {

        super(context, attrs);
        paint = new Paint();
        path = new Path();

        paint.setAntiAlias(true);
        paint.setARGB(255, 126, 192, 238);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);

    }

    protected void onDraw(Canvas canvas){

        super.onDraw(canvas);
        canvas.drawPath(path, paint);

    }

    public boolean onTouchEvent(MotionEvent event){

        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;

        }

        invalidate();
        return true;
    }
}
