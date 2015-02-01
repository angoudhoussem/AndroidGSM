package com.ESSTHS.Telecom.info;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import com.example.ttttt.R;

public class GettingPhone extends Activity {
	private int signalDBM = 0;
	private int ber = 0;
	TextView t1, t2, t3, t4, t5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gettingphonedetails);

		TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String IMEINumber = tm.getLine1Number();
		String subscriberID = tm.getDeviceId();
		String SIMSerialNumber = tm.getSimSerialNumber();

		t1 = (TextView) findViewById(R.id.textView3);
		t2 = (TextView) findViewById(R.id.textView5);
		t3 = (TextView) findViewById(R.id.textView7);
		t4 = (TextView) findViewById(R.id.textView9);

		String manufacturer = Build.MANUFACTURER;
		// String brand = Build.BRAND;

		String v = Build.VERSION.RELEASE;
		t4.setText(v);

		BluetoothAdapter myDevice = BluetoothAdapter.getDefaultAdapter();
		String deviceName = myDevice.getName();

		String model = Build.MODEL;

		t2.setText(model);

		t3.setText(manufacturer);

		String strphoneType = "";

		int phoneType = tm.getPhoneType();

		switch (phoneType) {
		case (TelephonyManager.PHONE_TYPE_CDMA):
			strphoneType = "CDMA";
			t1.setText(strphoneType);
			break;
		case (TelephonyManager.PHONE_TYPE_GSM):
			strphoneType = "GSM";
			t1.setText(strphoneType);
			break;
		case (TelephonyManager.PHONE_TYPE_NONE):
			strphoneType = "NONE";
			t1.setText(strphoneType);
			break;
		}

	}

}
