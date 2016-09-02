package com.example.hxf.day28customlistview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 16-8-31.
 */
public class MyList extends View implements View.OnTouchListener {
    Paint paint=null;
    float numHeight;
    Canvas mycanvas=null;
    String num ="";
    String[] strings={
            "A","B","C","D","E","F","G","H","I","J","K","L","M",
            "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };
    public MyList(Context context) {
        this(context, null);
    }

    public MyList(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyList(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
        //numHeight=(getHeight()-50)/(strings.length-1);
        this.setOnTouchListener(this);
    }

    private void initPaint() {
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mycanvas=canvas;
        numHeight=Math.abs((getMeasuredHeight()-50)/(strings.length-1));
        //canvas.drawColor(Color.WHITE);
        paint.setTextSize(30);

        for (int i = 0; i <strings.length ; i++) {
            canvas.drawText(strings[i],
                    30,50+i*((getMeasuredHeight()-50)/strings.length),paint);
        }
        DrawCharactor(num);
    }
    //创建一个方法来完成画中心的字母
    private  void DrawCharactor(String str){
        //Log.d("hxff","ppp========="+str);
        paint.setTextSize(100);
        paint.setColor(Color.BLUE);
        mycanvas.drawText(str,getWidth()/2,getHeight()/2,paint);

    }
    //监听控件的触摸事件
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int  action=event.getAction();
        float y=0;
        switch (action){
            case MotionEvent.ACTION_DOWN:
                y=event.getY();
                Log.d("hxff","y====="+y);
                int i= (int) ((y-50)/numHeight+1);
                if (y>0&&y<(50+numHeight)){
                    num=strings[0];
                }else if (i>0&&i<26){
                    num=strings[i];
                }

                invalidate();//重绘界面

                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }
        return false;
    }
}
