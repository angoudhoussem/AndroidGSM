package com.ESSTHS.Telecom.Statistique;

import java.util.ArrayList;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ESSTHS.Telcom.activity.MainActivity;
import com.ESSTHS.Telecom.base.AdapterPosition;
import com.ESSTHS.Telecom.base.DataBasePosition;
import com.ESSTHS.Telecom.base.Position;
import com.example.ttttt.R;

public class Statistique extends Activity {

	
	int[] distribution;
	int[] colors;
	private int signalDBM;
	DataBasePosition db;
	Cursor cursor = null;
	ListView lv;
	ArrayList<Position> listinfo = new ArrayList<Position>();
	ArrayList<String> listinfo1 = new ArrayList<String>();
	String[] mMonth;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistique);
		lv = (ListView) findViewById(R.id.listView1);
		GetParams listener = new GetParams();
		TelephonyManager TelManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		TelManager.listen(listener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);

		db = new DataBasePosition(this);

		cursor = db.recherche();
		System.out.println("cursor" + cursor.getCount());
		
		if(cursor.moveToFirst()){
			do{
		Position p = new Position();

		p.setNomBts(cursor.getString(cursor.getColumnIndex("nombts")));
		p.setLatitude(cursor.getString(cursor.getColumnIndex("latitude")));
		p.setLongitude(cursor.getString(cursor.getColumnIndex("logitude")));
		p.setDate(cursor.getString(cursor.getColumnIndex("date")));
		listinfo.add(p);
		
			}while(cursor.moveToNext());
		}
		cursor.close();
		ListAdapter listinfoadapter = new AdapterPosition(
				getApplicationContext(), listinfo);
		lv.setAdapter(listinfoadapter);
		for (int i=0;i<listinfo.size();i++){
			
			String q= listinfo.get(i).getDate();
			 mMonth = new String[] {q,"ff","cccc","ff","cccc","ff","cccc","ff","cccc","ff","cccc"};
			 System.out.println("date"+ listinfo.get(i).getDate());
			}
		 System.out.println("mMonth"+ mMonth.length);
	}

	  private void openChart(){
	        int[] x = { 1,2,3,4,5,6,7,8 };
	        int[] income = { 2000,2500,2700,3000,2800,3500,3700,3800};
	        int[] expense = {2200, 2700, 2900, 2800, 2600, 3000, 3300, 3400 };
	 
	        // Creating an  XYSeries for Income
	        XYSeries incomeSeries = new XYSeries("Income");
	       
	        // Creating an  XYSeries for Expense
	        XYSeries expenseSeries = new XYSeries("Expense");
	      
	        // Adding data to Income and Expense Series
	        for(int i=0;i<x.length;i++){
	            incomeSeries.add(x[i], income[i]);
	            expenseSeries.add(x[i],expense[i]);
	        }
	 
	        // Creating a dataset to hold each series
	        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
	        // Adding Income Series to the dataset
	        dataset.addSeries(incomeSeries);
	        // Adding Expense Series to dataset
	        dataset.addSeries(expenseSeries);
	 
	        // Creating XYSeriesRenderer to customize incomeSeries
	        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();
	        incomeRenderer.setColor(Color.GRAY);
	        incomeRenderer.setPointStyle(PointStyle.CIRCLE);
	        incomeRenderer.setFillPoints(true);
	        incomeRenderer.setLineWidth(10);
	        incomeRenderer.setChartValuesTextSize(100);
	        incomeRenderer.setDisplayChartValues(true);
	 
	        // Creating XYSeriesRenderer to customize expenseSeries
	        XYSeriesRenderer expenseRenderer = new XYSeriesRenderer();
	        expenseRenderer.setColor(Color.YELLOW);
	        expenseRenderer.setPointStyle(PointStyle.CIRCLE);
	        expenseRenderer.setFillPoints(true);
	        expenseRenderer.setLineWidth(10);
	        expenseRenderer.setDisplayChartValues(true);
	 
	        // Creating a XYMultipleSeriesRenderer to customize the whole chart
	        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
	        multiRenderer.setXLabels(0);
	        multiRenderer.setChartTitle("Income vs Expense Chart");
	        multiRenderer.setXTitle("Year 2012");
	        multiRenderer.setYTitle("Amount in Dollars");
	        multiRenderer.setChartValuesTextSize(100);
	        multiRenderer.setZoomButtonsVisible(true);
	        for(int i=0;i<x.length;i++){
	            multiRenderer.addXTextLabel(i+1, mMonth[i]);
	        }
	 
	        // Adding incomeRenderer and expenseRenderer to multipleRenderer
	        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
	        // should be same
	        multiRenderer.addSeriesRenderer(incomeRenderer);
	        multiRenderer.addSeriesRenderer(expenseRenderer);
	 
	        // Creating an intent to plot line chart using dataset and multipleRenderer
	        Intent intent = ChartFactory.getLineChartIntent(getBaseContext(), dataset, multiRenderer);
	 
	        // Start Activity
	        startActivity(intent);
	    }

	public class GetParams extends PhoneStateListener {

		@Override
		public void onSignalStrengthsChanged(SignalStrength signalStrength) {
			super.onSignalStrengthsChanged(signalStrength);
			if (signalStrength.isGsm()) {
				signalDBM = signalStrength.getGsmSignalStrength();
				if (signalStrength.getGsmSignalStrength() != 99)
					signalDBM = signalStrength.getGsmSignalStrength() * 2 - 113;
				else
					signalDBM = signalStrength.getGsmSignalStrength();

				Log.v("value", String.valueOf(signalDBM));
			}

			else {
				final int cdmaDbm = signalStrength.getCdmaDbm();
				signalDBM = cdmaDbm;

			}

		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			startActivity(new Intent(getApplicationContext(),
					MainActivity.class));

		}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.item1:
			Toast.makeText(this, "You selected the camera option",
				Toast.LENGTH_SHORT).show();
			 openChart();
			
			break;
		case R.id.item2:
			Toast.makeText(this, "You selected the save option",
					Toast.LENGTH_SHORT).show();
			
			 openChart();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}