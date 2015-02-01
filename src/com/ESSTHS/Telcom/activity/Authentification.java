package com.ESSTHS.Telcom.activity;

import java.sql.SQLException;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ESSTHS.Telecom.base.Databasehelper;
import com.example.ttttt.R;

public class Authentification extends Activity {

	Button connect;
	Button annuler;
	TextView t;
	EditText login, password;
	Databasehelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authentification);

		connect = (Button) findViewById(R.id.bnt1);
		annuler = (Button) findViewById(R.id.bnt2);
		login = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);

		t = (TextView) findViewById(R.id.textView3);
		dbHelper = new Databasehelper(this);
		connect.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String l = login.getText().toString();
				String p = password.getText().toString();
				if ((l.length() != 0) && (p.length() != 0)) {

					dbHelper.open();
					Cursor cur = dbHelper.recherche(l, p);
					if (cur.getCount() != 0) {

						Intent myIntent = new Intent(getApplicationContext(),
								MainActivity.class);
						startActivityForResult(myIntent, 0);

						LayoutInflater inflater = getLayoutInflater();
						View layout = inflater
								.inflate(
										R.layout.toast_costum_layout_success,
										(ViewGroup) findViewById(R.id.toast_layout_root));
						TextView text = (TextView) layout
								.findViewById(R.id.textView1);
						text.setText("Login et Mot de passe Valides");
						Toast toast = new Toast(getApplicationContext());
						toast.setGravity(Gravity.BOTTOM, 0, 110);
						toast.setDuration(Toast.LENGTH_LONG);
						toast.setView(layout);
						toast.show();

						dbHelper.close();

					} else {

						LayoutInflater inflater = getLayoutInflater();
						View layout = inflater
								.inflate(
										R.layout.toast_costum_layout_error,
										(ViewGroup) findViewById(R.id.toast_layout_root));
						TextView text = (TextView) layout
								.findViewById(R.id.textView1);
						text.setText("Entrer login et mot de passe non valides");
						Toast toast = new Toast(getApplicationContext());
						toast.setGravity(Gravity.BOTTOM, 0, 110);
						toast.setDuration(Toast.LENGTH_LONG);
						toast.setView(layout);
						toast.show();

						login.setError("Erreur");
						password.setError("Erreur");

					}
				} else {

					LayoutInflater inflater = getLayoutInflater();
					View layout = inflater.inflate(
							R.layout.toast_costum_layout_error,
							(ViewGroup) findViewById(R.id.toast_layout_root));
					TextView text = (TextView) layout
							.findViewById(R.id.textView1);
					text.setText("login et mot de passe sont obligatoires");
					Toast toast = new Toast(getApplicationContext());
					toast.setGravity(Gravity.BOTTOM, 0, 110);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(layout);
					toast.show();

					login.setError("Vide");
					password.setError("Vide");
				}

			}
		});
		annuler.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				login.setText("");
				password.setText("");

			}
		});
		t.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(),
						Inscription.class);
				startActivity(i);
			}
		});
	}

}
