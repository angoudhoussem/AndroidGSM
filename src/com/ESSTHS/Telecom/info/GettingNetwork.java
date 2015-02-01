package com.ESSTHS.Telecom.info;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ttttt.R;

public class GettingNetwork extends Activity {
	
	   TextView t1,t2,t3,t4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gettingnetworkdetails);
	
        TelephonyManager  tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String networkCountryISO=tm.getNetworkCountryIso();  
        String NetworkOperator=tm.getNetworkOperator();  
       // String SIMSerialNumber=tm.getNetworkType();  
        
		 t1=(TextView)findViewById(R.id.textView4);
		 t2=(TextView)findViewById(R.id.textView5);
		 t3=(TextView)findViewById(R.id.textView7);
		 t4=(TextView)findViewById(R.id.textView11);
		 
		 t1.setText(networkCountryISO);
		 t2.setText(NetworkOperator);
		 t3.setText(networkCountryISO);
		// t4.setText(text);
		
	        String strphoneType="";  
	           
	        int phoneType=tm.getPhoneType();  
	  
	        switch (phoneType)   
	        {  
	                case (TelephonyManager.PHONE_TYPE_CDMA):  
	                           strphoneType="CDMA";  
	                
	        	    
	  		      t4.setText(strphoneType);
	                //Toast.makeText(getApplicationContext(), "type"+strphoneType, 50000).show();
	                
	                               break;  
	                case (TelephonyManager.PHONE_TYPE_GSM):  
	                	
	                           strphoneType="GSM";   
	                
		  		      t4.setText(strphoneType);
	              //  Toast.makeText(getApplicationContext(), "type"+strphoneType, 50000).show();
	                               break;  
	                case (TelephonyManager.PHONE_TYPE_NONE):  
	                            strphoneType="NONE";  
	                
		  		      t4.setText(strphoneType);
	             //   Toast.makeText(getApplicationContext(), "type"+strphoneType, 50000).show();
	                                break;  
	         }  
	


	}}


