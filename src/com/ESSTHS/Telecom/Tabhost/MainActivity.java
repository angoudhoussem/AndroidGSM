package com.ESSTHS.Telecom.Tabhost;

 


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.ESSTHS.Telecom.info.GettingNetwork;
import com.ESSTHS.Telecom.info.GettingPhone;
import com.ESSTHS.Telecom.info.GettingSIM;
import com.example.ttttt.R;

public class MainActivity extends TabActivity {
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost);
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setup();
		 
		TabSpec tab1 = tabHost.newTabSpec("Network");
		TabSpec tab2 = tabHost.newTabSpec("Phone");
		TabSpec tab3 = tabHost.newTabSpec("SIM");

		tab1.setIndicator("Network",getResources().getDrawable(R.drawable.ic_network)); 
		tab1.setContent(new Intent(this, GettingNetwork.class));
		tabHost.addTab(tab1);
		
		tab2.setIndicator("Phone",getResources().getDrawable(R.drawable.ic_phone)); 
		tab2.setContent(new Intent(this, GettingPhone.class));
		tabHost.addTab(tab2);
		
		
		tab3.setIndicator("SIM",getResources().getDrawable(R.drawable.ic_sim)); 
		tab3.setContent(new Intent(this, GettingSIM.class));
		tabHost.addTab(tab3);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
