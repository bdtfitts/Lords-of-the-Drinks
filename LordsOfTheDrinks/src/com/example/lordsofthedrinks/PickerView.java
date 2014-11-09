package com.example.lordsofthedrinks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class PickerView extends View {
	public int x;
	public int y;
	public int width;
	public int chosenPlayer = 0;
	private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final Context mContext;
	private final RectF rect1;
    private final RectF rect2;
	
    public void setChosenPlayer(int chosenPlayer) {
    	this.chosenPlayer = chosenPlayer;
    }
    
	public PickerView(Context context, int x, int y, int width) {
		super(context);
		this.mContext = context;
		
		this.x = x;
		this.y = y;
		this.width = width;
		
		rect1 = new RectF (x - width, y + width / 2, x , y + width * 3 / 2);
	    rect2 = new RectF (x, y + width / 2, x + width , y + width * 3 / 2);
	}
	
	//called by invalidate()
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(0xFF00FF00);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        
        BitmapDrawable pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.question_mark);
        switch (this.chosenPlayer) {
        	case 0:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.question_mark);
        		break;
        	case 1:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.player1);
        		break;
        	case 2:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.player2);
        		break;
        	case 3:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.player3);
        		break;
        	case 4:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.player4);
        		break;
        	case 5:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.player5);
        		break;
        	case 6:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.player6);
        		break;
        	case 7:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.player7);
        		break;
        	case 8:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.player8);
        		break;
        	default:
        		pic = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.question_mark);
        		break;
        }
        
        Bitmap picResized = Bitmap.createScaledBitmap(pic.getBitmap(), width - 20, width - 20, false);
        
        canvas.drawLine(x - width / 2, y + width / 2, x - width / 2, y - width / 2, mPaint);
        canvas.drawLine(x - width / 2, y - width / 2, x + width / 2, y - width / 2, mPaint);
        canvas.drawLine(x + width / 2, y + width / 2, x + width / 2, y - width / 2, mPaint);
        
        canvas.drawArc(rect1, 270, 90, false, mPaint);
        canvas.drawArc(rect2, 180, 90, false, mPaint);

        canvas.drawBitmap(picResized, x - width / 2 + 10, y - width / 2 + 10, null);
    }
}
