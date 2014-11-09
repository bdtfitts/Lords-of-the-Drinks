package com.example.lordsofthedrinks;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayersAdapter extends ArrayAdapter<Player> {
	
	private static class ViewHolder {
		ImageView playerPic;
		TextView playerName;
	}
	public PlayersAdapter(Context context, ArrayList<Player> players) {
		super(context, 0, players);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Player player = getItem(position);
		ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_player, parent, false);
			viewHolder.playerPic = (ImageView) convertView.findViewById(R.id.playerProfilePic);
	        viewHolder.playerName = (TextView) convertView.findViewById(R.id.playerProfileName);
	        convertView.setTag(viewHolder);
		} else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		viewHolder.playerPic.setImageURI(player.getPlayerPictureUri());
		viewHolder.playerName.setText(player.getPlayerName());
		
		return convertView;
	}
}
