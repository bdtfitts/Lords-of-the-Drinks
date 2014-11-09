package com.example.lordsofthedrinks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class CupView extends View{
	int x;
	int y;
	Context mContext;
	
	public CupView(Context context, int x, int y) {
		super(context);
		this.x = x;
		this.y = y;
		this.mContext = context;
	}
	
	protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        BitmapDrawable pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.cup);
        
        Bitmap picResized = Bitmap.createScaledBitmap(pic.getBitmap(), 100, 100, false);
        canvas.drawBitmap(picResized, x - 50, y - 50, null);
	}
}
