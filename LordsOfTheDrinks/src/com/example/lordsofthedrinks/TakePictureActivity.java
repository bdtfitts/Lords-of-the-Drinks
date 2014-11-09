package com.example.lordsofthedrinks;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class TakePictureActivity extends Activity {
	private ImageView playerPicture;
	private EditText editPlayerName;
	private Button playerReadyButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_take_picture);
		playerPicture = (ImageView) findViewById(R.id.playerPicture);
		editPlayerName = (EditText) findViewById(R.id.playerName);
		playerReadyButton = (Button) findViewById(R.id.playerReadyButton);
		final Uri pictureFile = getIntent().getData();
		playerPicture.setImageURI(pictureFile);
		
		playerReadyButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String playerName = editPlayerName.getText().toString();
				System.out.println(playerName);
				if (playerName.trim().isEmpty()) {
					AlertDialog.Builder errBuilder = new AlertDialog.Builder(TakePictureActivity.this);
					errBuilder.setMessage("Enter a name first");
					errBuilder.show();
				}
				else {
					Player player = new Player(pictureFile, playerName);
					Intent backPage = getIntent();
					backPage.putExtra("Player", player);
					setResult(RESULT_OK, backPage);
					finish();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.take_picture, menu);
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
