package com.ESSTHS.Telecom.info;

import com.example.ttttt.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class GettingSIM extends Activity {

	private int signalDBM = 0;
	private int ber = 0;
	TextView t1, t2, t3, t4, t5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gettingsimdetails);

		// Get the instance of TelephonyManager
		TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String IMEINumber = tm.getDeviceId();
		String subscriberID = tm.getDeviceId();
		String SIMSerialNumber = tm.getSimSerialNumber();
	
		t1 = (TextView) findViewById(R.id.idtext);
		t2 = (TextView) findViewById(R.id.textView5);
		t3 = (TextView) findViewById(R.id.textView4);

		t4 = (TextView) findViewById(R.id.textView7);
		t5 = (TextView) findViewById(R.id.idmnc);
		String networkOperator = tm.getNetworkOperator();

		if (networkOperator != null) {
			int mcc = Integer.parseInt(networkOperator.substring(0, 3));
			int mnc = Integer.parseInt(networkOperator.substring(3));

			t4.setText(String.valueOf(mcc));
			t5.setText(String.valueOf(mnc));
		}

		t1.setText(IMEINumber);
		t2.setText(subscriberID);
		t3.setText(SIMSerialNumber);

	}

}
