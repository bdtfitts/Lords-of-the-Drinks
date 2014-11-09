package com.example.lordsofthedrinks;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TurnStartActivity extends Activity {
	private View view;
	private ArrayList<Player> players;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Random rand = new Random(System.currentTimeMillis());
		setContentView(R.layout.activity_turn_start);
		view = findViewById(R.id.view1);
		players = getIntent().getParcelableArrayListExtra("Players");
		int choice = rand.nextInt(players.size());
		view.setBackgroundColor(players.get(choice).getColor());
		for (int i = 0; i < players.size(); ++i) {
			System.out.println(players.get(i).getColor());
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.turn_start, menu);
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
