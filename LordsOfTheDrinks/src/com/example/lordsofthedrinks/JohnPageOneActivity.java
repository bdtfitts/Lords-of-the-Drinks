package com.example.lordsofthedrinks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JohnPageOneActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_john_page_one);
	}
	
	public void goToJohnPageTwo(View view) {
		Intent intent = new Intent(this, JohnPageTwoActivity.class);
        startActivity(intent);
	}
}
