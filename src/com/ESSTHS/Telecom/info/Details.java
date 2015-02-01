package com.ESSTHS.Telecom.info;

import com.example.ttttt.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Details extends Activity {

	TextView t, tt, ttt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.details);

		TextView t = (TextView) findViewById(R.id.textView1);
		TextView tt = (TextView) findViewById(R.id.textView2);
		TextView ttt = (TextView) findViewById(R.id.textView3);

		t.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// start the animation

				Intent intent = new Intent(getApplicationContext(),
						GettingNetwork.class);

				startActivity(intent);
			}
		});
		tt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// start the animation

				Intent intent = new Intent(getApplicationContext(),
						GettingSIM.class);

				startActivity(intent);
			}
		});
		ttt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// start the animation

				Intent intent = new Intent(getApplicationContext(),
						GettingPhone.class);

				startActivity(intent);
			}
		});

	}

}
