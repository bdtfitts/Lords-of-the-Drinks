package com.example.lordsofthedrinks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TiltTheBeeResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tilt_the_bee_result);
	}
	
	public void goToJohn(View view) {
		Intent intent = new Intent(this, JohnPageOneActivity.class);
        startActivity(intent);
	}
}
