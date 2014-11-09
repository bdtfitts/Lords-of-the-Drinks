package com.example.lordsofthedrinks;

import android.graphics.Color;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
public class Player implements Parcelable{
	private Uri playerPictureUri;
	private String playerName;
	private int color;
	private static int[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.RED, Color.YELLOW, Color.MAGENTA, Color.LTGRAY};
	private int NUM_OF_COLORS = 8;
	private int score = 0;
	
	private int pickRandomColor() {
		do {
			int choice = (int)(Math.random() * (NUM_OF_COLORS-1));
			if (colors[choice] != -1)
			{
				int color = colors[choice];
				colors[choice] = -1;
				return color;
			}
		}while(true);
	}
	public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
		public Player createFromParcel(Parcel in) {
		    return new Player(in);
		}
		
		public Player[] newArray(int size) {
		    return new Player[size];
		}
	};

	public int describeContents() {
		return 0;
	}
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(playerPictureUri.getPath());
		out.writeString(playerName);
		out.writeInt(score);
		out.writeInt(color);
	}
	public Player(Uri pictureUri, String name) {
		playerPictureUri = pictureUri;
		playerName = name;
		color = pickRandomColor();
	}
	private Player(Parcel in) {
		playerPictureUri = Uri.parse(in.readString());
		playerName = in.readString();
		score = in.readInt();
		color = in.readInt();
	}
	public Uri getPlayerPictureUri() {
		return playerPictureUri;
	}

	public void setPlayerPictureUri(Uri playerPictureUri) {
		this.playerPictureUri = playerPictureUri;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
}
