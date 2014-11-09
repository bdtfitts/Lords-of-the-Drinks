package com.example.lordsofthedrinks;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.soundcloud.android.crop.Crop;
public class PlayerSelectActivity extends Activity {
	private Button pictureButton;
	private Button startGameButton;
	private ListView playerList;
	private ArrayList<Player> players;
	private PlayersAdapter playersAdapter;
	private Uri picFile;
	private final int ADD_PLAYER = 21;
	private final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	/** Create a file Uri for saving an image or video */
	private Uri getOutputMediaFileUri(){
	      return Uri.fromFile(getOutputMediaFile());
	}

	
	/** Create a File for saving an image or video */
	private File getOutputMediaFile(){
	    // To be safe, you should check that the SDCard is mounted
	    // using Environment.getExternalStorageState() before doing this.

	    File mediaStorageDir = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
	    // This location works best if you want the created images to be shared
	    // between applications and persist after your app has been uninstalled.

	    // Create the storage directory if it does not exist
	    if (! mediaStorageDir.exists()){
	        if (! mediaStorageDir.mkdirs()){
	            return null;
	        }
	    }

	    // Create a media file name
	    File mediaFile;
	    int currNumPlayers = players.size();
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + "playerPicture"+
        					(currNumPlayers+1)+".jpg");

	    return mediaFile;
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
	        if (resultCode == RESULT_OK) {
	        	Crop photoCrop = new Crop(picFile);
	        	photoCrop.output(picFile);
	        	photoCrop.asSquare();
	        	photoCrop.withMaxSize(250, 250);
	        	photoCrop.start(this);
	            // Image captured and saved to fileUri specified in the Intent
	      
	        } else if (resultCode == RESULT_CANCELED) {
		        finish();
	        } else {
	            finish();// Image capture failed, advise user
	        }
	    } else if (requestCode == Crop.REQUEST_CROP) {
	    	if (resultCode == RESULT_OK) {
	    		Intent nextPage = new Intent(PlayerSelectActivity.this, TakePictureActivity.class);
	    		nextPage.setData(picFile);
	        	startActivityForResult(nextPage, ADD_PLAYER);
	    	}
	    } else if (requestCode == ADD_PLAYER) {
	    	if (resultCode == RESULT_OK) {
	    		Player player = data.getParcelableExtra("Player");
	    		if (player != null) {
	    			players.add(player);
	    			playersAdapter.notifyDataSetChanged();
	    		}
	    	}
	    }
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_select);
		
		pictureButton = (Button) findViewById(R.id.take_picture_button);
		startGameButton = (Button) findViewById(R.id.game_start_button);
		playerList = (ListView) findViewById(R.id.playerList);
		if (players == null) {
			players = new ArrayList<Player>();
		}
		if (playersAdapter == null) {
			playersAdapter = new PlayersAdapter(this, players);
		}
		
		playerList.setAdapter(playersAdapter);
		
		pictureButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				picFile = getOutputMediaFileUri();
				cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, picFile);
				startActivityForResult(cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
				
			}
		});
		
		startGameButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (players.size() < 0 /*!!!DEBUG, 3*/) {
					new AlertDialog.Builder(PlayerSelectActivity.this).setMessage("You don't have enough players!").show();
				} else {
					Intent nextPage = new Intent(PlayerSelectActivity.this, TurnStartActivity.class);
					nextPage.putParcelableArrayListExtra("Players", players);
					startActivity(nextPage);
				}
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
