package com.example.lordsofthedrinks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class WheelView extends View {
	public float x;
    public float y;
    public int numOfSlices;
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private float[] value_degree;
    private int[] COLORS={Color.BLACK,Color.GREEN,Color.GRAY,Color.CYAN,Color.RED, Color.WHITE, Color.DKGRAY, Color.MAGENTA};
    RectF rectf;
    int temp=0;
    
    //construct new ball object
    public WheelView(Context context, float x, float y, int r, int numOfSlices) {
        super(context);
        //color hex is [transparency][red][green][blue]
        mPaint.setColor(0xFF00FF00);  //not transparent. color is green
        this.x = x;
        this.y = y;
        this.numOfSlices = numOfSlices;
        this.rectf = new RectF (x-r, y-r, x+r, y+r);
        this.value_degree=new float[numOfSlices];
        for (int i = 0; i < numOfSlices; i ++) {
        	this.value_degree[i] = 360 / numOfSlices;
        }
    }               
        
    //called by invalidate()
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        for (int i = 0; i < value_degree.length; i++) {//values2.length; i++) {
            if (i == 0) {
                paint.setColor(COLORS[i]);
                canvas.drawArc(rectf, 0, value_degree[i], true, paint);
            } 
            else
            {
                    temp += (int) value_degree[i - 1];
                    paint.setColor(COLORS[i]);
                    canvas.drawArc(rectf, temp, value_degree[i], true, paint);
            }
        }
    } 
}