package com.example.lordsofthedrinks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity {
	private Button play_button;
	private Button rules_button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		play_button = (Button) findViewById(R.id.game_start_button);
		rules_button = (Button) findViewById(R.id.rules_button);
		
		play_button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent nextPage = new Intent(getApplicationContext(), PlayerSelectActivity.class);
					startActivity(nextPage);
				}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
