package com.example.lordsofthedrinks;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.FrameLayout;

public class TiltTheBeeActivity extends Activity implements SensorEventListener {

	private SensorManager sensorManager;
	private int targetX = 500;
	private int targetY = 100;
	private int beeRadius = 64;
	private int targetRadius = 100;
	 public void onAccuracyChanged(Sensor sensor,int accuracy){
			
	}
		
	public void onSensorChanged(SensorEvent event){
		
		// check sensor type
		if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
			
			// assign directions
			float x=event.values[0];
			float y=event.values[1];
			
			int speedFactor = 15;
			
			AnimatedView ballView = (AnimatedView)findViewById(R.id.anim_view);
			ballView.setXVelocity(-(int)x * speedFactor);
			ballView.setYVelocity((int)y * speedFactor);
			
			
			double distBeeTarget = Math.sqrt((double)((ballView.x - targetX) * (ballView.x - targetX) + (ballView.y - targetY) * (ballView.y - targetY)));
			if( distBeeTarget < (targetRadius + beeRadius)) {
				Intent intent = new Intent(this, TiltTheBeeResultActivity.class);
		        startActivity(intent);
			}
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tilt_the_bee);
        
        final FrameLayout mainView = 
        		(android.widget.FrameLayout)findViewById(R.id.main_view);
        
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
		// add listener. The listener will be HelloAndroid (this) class
		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
        
		
		//create initial target
		int mTargetPosX = targetX;
		int mTargetPosY = targetY;
		TargetView mTargetView = new TargetView(this, mTargetPosX, mTargetPosY, targetRadius);
		
		mainView.addView(mTargetView); //add ball to main screen
		mTargetView.invalidate(); //call onDraw in BallView
    }	
}
