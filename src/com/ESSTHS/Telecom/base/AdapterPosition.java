package com.ESSTHS.Telecom.base;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ttttt.R;

public class AdapterPosition extends BaseAdapter {

	private ArrayList<Position> listData;

	private LayoutInflater layoutInflater;

	public AdapterPosition(Context context, ArrayList<Position> listData) {
		this.listData = listData;
		layoutInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return listData.size();
	}

	public Object getItem(int position) {
		return listData.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {

			convertView = layoutInflater.inflate(R.layout.list_item, null);

			holder = new ViewHolder();
			//
			holder.nom = (TextView) convertView.findViewById(R.id.textView1);
			holder.latitude = (TextView) convertView
					.findViewById(R.id.textView2);
			holder.logitude = (TextView) convertView
					.findViewById(R.id.textView3);
			holder.date = (TextView) convertView.findViewById(R.id.textView4);

			convertView.setTag(holder);
		} else {

			holder = (ViewHolder) convertView.getTag();
		}

		Position news = (Position) listData.get(position);
		holder.nom.setText(news.getNomBts());
		holder.latitude.setText(news.getLatitude());
		holder.logitude.setText(news.getLongitude());
		holder.date.setText(news.getDate());
		return convertView;
	}

	static class ViewHolder {
		TextView nom;
		TextView latitude;
		TextView logitude;
		TextView date;

	}
}
