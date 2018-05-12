package com.example.chany.lab4;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import android.util.Log;


public class MainActivity extends AppCompatActivity {


    int curx;
    int cury;

    public class Vertex{
        Vertex(float ax, float ay, boolean ad){
            x = ax;
            y = ay;
            draw = ad;
        }
        float x;
        float y;
        boolean draw; // true to draw
    }

    ArrayList<Vertex> arVertex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyView mv = new MyView(this);
        setContentView(mv);

        arVertex = new ArrayList<Vertex>();
    }


    protected class MyView extends View {
        Context context;
        Canvas cv;
        public MyView(Context ctx) {
            super(ctx);
            context = ctx;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            cv=canvas;
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);

            canvas.drawColor(Color.WHITE);

            paint.setStrokeWidth(20);
            Log.d("juno", "onDraw");


            for (int i=0; i<arVertex.size(); i++){
                if(arVertex.get(i).draw) {
                    canvas.drawLine(arVertex.get(i - 1).x, arVertex.get(i - 1).y, arVertex.get(i).x, arVertex.get(i).y, paint);
                    canvas.drawCircle(arVertex.get(i).x, arVertex.get(i).y,10,paint);
                }
            }

        }


        public boolean onTouchEvent(MotionEvent event) {

            if(event.getAction() == MotionEvent.ACTION_DOWN){
                arVertex.add(new Vertex(event.getX(), event.getY(), false));
                return true;
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE){
                arVertex.add(new Vertex(event.getX(), event.getY(), true));
                invalidate();
                return true;
            }
            return false;
        }
    }







}