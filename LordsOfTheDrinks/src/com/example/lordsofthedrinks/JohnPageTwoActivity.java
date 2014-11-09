package com.example.lordsofthedrinks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JohnPageTwoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_john_page_two);
	}
	
	public void goToJohnGame(View view) {
		Intent intent = new Intent(this, JohnGameActivity.class);
        startActivity(intent);
	}
}
