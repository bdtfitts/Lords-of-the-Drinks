package com.example.lordsofthedrinks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.soundcloud.android.crop.Crop;
public class PlayerSelectActivity extends Activity {
	private Button pictureButton;
	private Button startGameButton;
	private final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
	        if (resultCode == RESULT_OK) {
	        	new Crop(data.getData()).output(data.getData()).asSquare().withMaxSize(200, 200).start(this);
	            // Image captured and saved to fileUri specified in the Intent
	      
	        } else if (resultCode == RESULT_CANCELED) {
		        finish();
	        } else {
	            finish();// Image capture failed, advise user
	        }
	    } else if (requestCode == Crop.REQUEST_CROP) {
	    	if (resultCode == RESULT_OK) {
	    		Intent nextPage = new Intent(PlayerSelectActivity.this, TakePictureActivity.class);
	    		nextPage.setData(Crop.getOutput(data));
	        	startActivity(nextPage);
	    	}
	    }
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_select);
		pictureButton = (Button) findViewById(R.id.take_picture_button);
		startGameButton = (Button) findViewById(R.id.game_start_button);
		pictureButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
				
			}
		});
		
		startGameButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent nextPage = new Intent(PlayerSelectActivity.this, TakePictureActivity.class);
				startActivity(nextPage);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player_select, menu);
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
