package com.example.lordsofthedrinks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
public class AnimatedView extends ImageView{
    private Context mContext;
    int x = -1;
    int y = -1;
    public int xVelocity = 10;
    public int yVelocity = 5;
    private Handler h;
    private final int FRAME_RATE = 30;

    public void setXVelocity(int xVeloc) {
    	this.xVelocity = xVeloc;
    }
    
    public void setYVelocity(int yVeloc) {
    	this.yVelocity = yVeloc;
    }
    
    public AnimatedView(Context context, AttributeSet attrs)  {
        super(context, attrs);
        mContext = context;
        h = new Handler();
    }
     private Runnable r = new Runnable() {
             @Override
             public void run() {
                     invalidate();
             }
     };
     protected void onDraw(Canvas c) {
         BitmapDrawable ball = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.bee);
         Bitmap ballResized = Bitmap.createScaledBitmap(ball.getBitmap(), 100, 79, false);
         if (x<0 && y <0) {
             x = this.getWidth()/2;
             y = this.getHeight()/2;
         } else {
             x += xVelocity;
             y += yVelocity;
             if ((x > this.getWidth() - ballResized.getWidth()) || (x < 0)) {
                     xVelocity = xVelocity*-1;
             }
             if ((y > this.getHeight() - ballResized.getHeight()) || (y < 0)) {
                     yVelocity = yVelocity*-1;
             }
         }
         c.drawBitmap(ballResized, x, y, null);
         h.postDelayed(r, FRAME_RATE);
     }
}
