package com.example.lordsofthedrinks;

import java.util.Random;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class JohnGameActivity extends Activity {
	
	
	GoldStackView smallStack;
	GoldStackView mediumStack;
	GoldStackView bigStack;
	
	CupView cupView1;
	CupView cupView2;
	CupView cupView3;
	
	public void goToGameOver() {
		Intent intent = new Intent(this, GameOverActivity.class);
        startActivity(intent);
	}
	
	public void cupTouched() {
		String msg = ""; 
		Random rn = new Random(System.currentTimeMillis());
    	int min = 1;
    	int max = 3;
    	int size = rn.nextInt(max - min + 1) + min;
		
		switch (size) {
			case 1:
				msg = "You got the least gold. Pour only one serving in the cup";
				break;
			case 2:
				msg = "You got a fair amount of gold, Pour two servings.";
				break;
			case 3:
				msg = "You got the most gold! You can pour up to three servings in the cup. (Be careful not to burn bridges though)";
		}
		new AlertDialog.Builder(this)
	    .setTitle("Congratulations!")
	    .setMessage(msg)
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	goToGameOver();
	        }
	     })
	    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	goToGameOver();
	        }
	     })
	    .setIcon(android.R.drawable.ic_dialog_alert)
	     .show();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_john_game);

        final FrameLayout mainView = 
        		(android.widget.FrameLayout)findViewById(R.id.main_view);
        
		//add three gold images  
        GoldStackView goldStackViewSmall = new GoldStackView(this, 150, 350, 1);
		GoldStackView goldStackViewMedium = new GoldStackView(this, 550, 350, 2);		
		GoldStackView goldStackViewBig = new GoldStackView(this, 350, 700, 3);
		
		
		this.smallStack = goldStackViewSmall;
		this.mediumStack = goldStackViewMedium;
		this.bigStack = goldStackViewBig;
		
		mainView.addView(goldStackViewSmall);
		mainView.addView(goldStackViewMedium);
		mainView.addView(goldStackViewBig);
		goldStackViewSmall.invalidate();
		goldStackViewMedium.invalidate();
		goldStackViewBig.invalidate();
		//add three cup images
		cupView1 = new CupView(this, 150, 250);
		cupView2 = new CupView(this, 550, 250);
		cupView3 = new CupView(this, 350, 600);
		
		mainView.addView(cupView1);
		mainView.addView(cupView2);
		mainView.addView(cupView3);
		cupView1.invalidate();
		cupView2.invalidate();
		cupView3.invalidate();
		//keep track on cup images
		//delete gold images
		//move cup images
		//on touch pop up message
	}
	
	public void startJohnGameAnimation(View view) {
		ObjectAnimator mover100 = ObjectAnimator.ofFloat(cupView1,
		          "translationY", 0, 100);
		ObjectAnimator mover200 = ObjectAnimator.ofFloat(cupView2,
		          "translationY", 0, 100);
		ObjectAnimator mover300 = ObjectAnimator.ofFloat(cupView3,
		          "translationY", 0, 100);
		
		ObjectAnimator mover101 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 0, 200);
		ObjectAnimator mover102 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 200, 400);
		ObjectAnimator mover103 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 400, 200);
		ObjectAnimator mover104 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 200, 0);
		ObjectAnimator mover105 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 0, 200);
		ObjectAnimator mover106 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 200, 400);
		ObjectAnimator mover107 = ObjectAnimator.ofFloat(cupView1,
		          "translationY", 100, 450);
		ObjectAnimator mover108 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 400, 200);
		ObjectAnimator mover109 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 200, 0);
		ObjectAnimator mover110 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 0, 200);
		ObjectAnimator mover111 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 200, 400);
		ObjectAnimator mover112 = ObjectAnimator.ofFloat(cupView1,
		          "translationY", 450, 100);
		ObjectAnimator mover113 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 400, 200);
		ObjectAnimator mover114 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 200, 0);
		ObjectAnimator mover115 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 0, 200);
		ObjectAnimator mover116 = ObjectAnimator.ofFloat(cupView1,
		          "translationY", 100, 450);
		ObjectAnimator mover117 = ObjectAnimator.ofFloat(cupView1,
		          "translationX", 200, 0);
		ObjectAnimator mover118 = ObjectAnimator.ofFloat(cupView1,
		          "translationY", 450, 100);
		ObjectAnimator mover119 = ObjectAnimator.ofFloat(cupView1,
		          "translationY", 100, 450);
		ObjectAnimator mover120 = ObjectAnimator.ofFloat(cupView1,
		          "translationY", 450, 100);
		
		ObjectAnimator mover201 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", 0, -200);
		ObjectAnimator mover202 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", -200, -400);
		ObjectAnimator mover203 = ObjectAnimator.ofFloat(cupView2,
		          "translationY", 100, 450);
		ObjectAnimator mover204 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", -400, -200);
		ObjectAnimator mover205 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", -200, -400);
		ObjectAnimator mover206 = ObjectAnimator.ofFloat(cupView2,
		          "translationY", 450, 100);
		ObjectAnimator mover207 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", -400, -200);
		ObjectAnimator mover208 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", -200, 0);
		ObjectAnimator mover209 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", 0, -200);
		ObjectAnimator mover210 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", -200, -400);
		ObjectAnimator mover211 = ObjectAnimator.ofFloat(cupView2,
		          "translationY", 100, 450);
		ObjectAnimator mover212 = ObjectAnimator.ofFloat(cupView2,
		          "translationY", 450, 100);
		ObjectAnimator mover213 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", -400, -200);
		ObjectAnimator mover214 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", -200, 0);
		ObjectAnimator mover215 = ObjectAnimator.ofFloat(cupView2,
		          "translationY", 100, 450);
		ObjectAnimator mover216 = ObjectAnimator.ofFloat(cupView2,
		          "translationY", 450, 100);
		ObjectAnimator mover217 = ObjectAnimator.ofFloat(cupView2,
		          "translationY", 100, 450);
		ObjectAnimator mover218 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", 0, -200);
		ObjectAnimator mover219 = ObjectAnimator.ofFloat(cupView2,
		          "translationX", -200, 0);
		ObjectAnimator mover220 = ObjectAnimator.ofFloat(cupView2,
		          "translationY", 450, 100);
		
		ObjectAnimator mover301 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 0, 200);
		ObjectAnimator mover302 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 200, 0);
		ObjectAnimator mover303 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 0, 200);
		ObjectAnimator mover304 = ObjectAnimator.ofFloat(cupView3,
		          "translationY", 100, -250);
		ObjectAnimator mover305 = ObjectAnimator.ofFloat(cupView3,
		          "translationY", -250, 100);
		ObjectAnimator mover306 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 200, 0);
		ObjectAnimator mover307 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 0, -200);
		ObjectAnimator mover308 = ObjectAnimator.ofFloat(cupView3,
		          "translationY", 100, -250);
		ObjectAnimator mover309 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", -200, 0);
		ObjectAnimator mover310 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 0, 200);
		ObjectAnimator mover311 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 200, 0);
		ObjectAnimator mover312 = ObjectAnimator.ofFloat(cupView3,
		          "translationY", -250, 100);
		ObjectAnimator mover313 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 0, 200);
		ObjectAnimator mover314 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 200, 0);
		ObjectAnimator mover315 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 0, -200);
		ObjectAnimator mover316 = ObjectAnimator.ofFloat(cupView3,
		          "translationY", 100, -250);
		ObjectAnimator mover317 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", -200, 0);
		ObjectAnimator mover318 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 0, 200);
		ObjectAnimator mover319 = ObjectAnimator.ofFloat(cupView3,
		          "translationY", -250, 100);
		ObjectAnimator mover320 = ObjectAnimator.ofFloat(cupView3,
		          "translationX", 200, 0);
		
		mover100.addListener(new AnimatorListener() {
    	    @Override 
    	    public void onAnimationEnd(Animator animation) {
    	    	//delete gold images
    	    	smallStack.setVisibility(View.GONE);
    	    	mediumStack.setVisibility(View.GONE);
    	    	bigStack.setVisibility(View.GONE);
    	    	
    	    	cupView1.setOnClickListener(
    	        		new View.OnClickListener() {
    	        			public void onClick(View v) {
    	        				cupTouched();
    	        		}
    	        	});
    	    	cupView2.setOnClickListener(
    	        		new View.OnClickListener() {
    	        			public void onClick(View v) {
    	        				cupTouched();
    	        		}
    	        	});
    	    	cupView3.setOnClickListener(
    	        		new View.OnClickListener() {
    	        			public void onClick(View v) {
    	        				cupTouched();
    	        		}
    	        	});
    	    }
    	    
    	    public void onAnimationCancel(Animator animation) {
    	    	
    	    }
    	    public void onAnimationStart(Animator animation) { 
    	    }
    	    public void onAnimationRepeat(Animator animation) {
    	    	
    	    }
    	});
		
		AnimatorSet as1 = new AnimatorSet();
		as1.playSequentially(mover100, mover101, mover102, mover103, mover104,
							 mover105, mover106, mover107, mover108, mover109,
							 mover110, mover111, mover112, mover113, mover114,
							 mover115, mover116, mover117, mover118, mover119,
							 mover120);
		as1.setDuration(250);
		as1.start();
		
		AnimatorSet as2 = new AnimatorSet();
		as2.playSequentially(mover200, mover201, mover202, mover203, mover204,
							 mover205, mover206, mover207, mover208, mover209,
							 mover210, mover211, mover212, mover213, mover214,
							 mover215, mover216, mover217, mover218, mover219,
							 mover220);
		as2.setDuration(250);
		as2.start();
		
		AnimatorSet as3 = new AnimatorSet();
		as3.playSequentially(mover300, mover301, mover302, mover303, mover304,
							 mover305, mover306, mover307, mover308, mover309,
							 mover310, mover311, mover312, mover313, mover314,
							 mover315, mover316, mover317, mover318, mover319,
							 mover320);
		as3.setDuration(250);
		as3.start();
	}
}