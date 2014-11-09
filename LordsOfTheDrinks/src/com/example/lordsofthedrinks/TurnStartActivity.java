package com.example.lordsofthedrinks;

import java.util.Random;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;

public class TurnStartActivity extends Activity {
	View wheelView;
	PickerView pkView;
	int selectedPlayer;
	int numOfPlayer = 7;
	int mWheelPosX;
	int mWheelPosY;
	int mWheelRadius = 200;
	int pkYOffset = 230;
	int pkWidth = 200;
	
	public void goToNextGame(View view) {
		Intent intent = new Intent(this, TiltTheBeeActivity.class);
        startActivity(intent);
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_start);
        
        final FrameLayout mainView = 
        		(android.widget.FrameLayout)findViewById(R.id.main_view);
		
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mWheelPosX = size.x / 2;
        mWheelPosY = size.y / 2 - 25;
        
		//create initial wheel		
		WheelView mWheelView = new WheelView(this, mWheelPosX, mWheelPosY, mWheelRadius, numOfPlayer);
		wheelView = mWheelView;
		
		PickerView pkView = new PickerView(this, mWheelPosX, pkYOffset, pkWidth);
		this.pkView = pkView;
		
		
		mainView.addView(mWheelView); //add wheel to main screen
		mainView.addView(pkView); //add picker to main screen
		
		mWheelView.invalidate(); //call onDraw in WheelView
		pkView.invalidate(); //call onDraw in PickerView
    }

    public void spinWheel(View view) {
    	
    	
    	Random rn = new Random(System.currentTimeMillis());
    	//minimum: 8 full spins = 8 * 360 = 2880
    	int min = 2880 * 3;
    	//max: 15 full spins = 15 * 360  = 5400
    	int max = 5400 * 3;
    	int angleOfRotation = rn.nextInt(max - min + 1) + min;
    	int angleFrom0ToTop = (630 - (angleOfRotation%360))%360;
    	selectedPlayer = (int)(angleFrom0ToTop * numOfPlayer / 360) + 1;

    	
    	ObjectAnimator animation1 = ObjectAnimator.ofFloat(wheelView,
    	          "rotation", angleOfRotation);
    	animation1.setDuration(200 * (angleOfRotation/360) / 3);
    	
    	animation1.addListener(new AnimatorListener() {
    	    @Override 
    	    public void onAnimationEnd(Animator animation) {
    	    	pkView.setChosenPlayer(selectedPlayer);
            	pkView.invalidate();           
    	    }
    	    
    	    public void onAnimationCancel(Animator animation) {
    	    	
    	    }
    	    public void onAnimationStart(Animator animation) {
    	    	pkView.setChosenPlayer(0);
            	pkView.invalidate(); 
    	    }
    	    public void onAnimationRepeat(Animator animation) {
    	    	
    	    }
    	});
    	
    	animation1.start();
  		//Log.i("DisplayMessageActivity", "Selected player: " + selectedPlayer);
    }
}
