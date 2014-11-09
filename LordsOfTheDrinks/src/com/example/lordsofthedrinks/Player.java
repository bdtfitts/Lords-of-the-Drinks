package com.example.lordsofthedrinks;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
public class Player implements Parcelable{
	private Uri playerPictureUri;
	private String playerName;
	private int score = 0;
	
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
	}
	public Player(Uri pictureUri, String name) {
		playerPictureUri = pictureUri;
		playerName = name;
	}
	private Player(Parcel in) {
		playerPictureUri = Uri.parse(in.readString());
		playerName = in.readString();
		score = in.readInt();
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
}
