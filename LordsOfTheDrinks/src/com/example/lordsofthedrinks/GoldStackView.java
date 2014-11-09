package com.example.lordsofthedrinks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class GoldStackView extends View {
	int x;
	int y;
	int size;
	Context mContext;
	
	public GoldStackView(Context context, int x, int y, int size) {
		super(context);
		this.x = x;
		this.y = y;
		this.size = size;
		this.mContext = context;
	}
	
	protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        BitmapDrawable pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.gold_small_stack);
        switch(this.size) {
        	case 1:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.gold_small_stack);
        		break;
        	case 2:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.gold_medium_stack);
        		break;
        	case 3:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.gold_big_stack);
        		break;
        	default:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.gold_small_stack);
        		break;
        }
        
        Bitmap picResized = Bitmap.createScaledBitmap(pic.getBitmap(), 80, 80, false);
        canvas.drawBitmap(picResized, x - 40, y - 40, null);
	}
}
