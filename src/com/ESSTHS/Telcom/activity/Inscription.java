package com.ESSTHS.Telcom.activity;

import android.app.Activity;
import android.content.Intent;
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
import com.ESSTHS.Telecom.base.User;
import com.example.ttttt.R;

public class Inscription extends Activity {
	EditText nom, prenom, login, password, tel;
	Button Creer;
	Button Annuler;
	Databasehelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compte);

		nom = (EditText) findViewById(R.id.editText1);
		prenom = (EditText) findViewById(R.id.editText2);
		login = (EditText) findViewById(R.id.editText3);
		password = (EditText) findViewById(R.id.editpssword);
		tel = (EditText) findViewById(R.id.editText5);
		Creer = (Button) findViewById(R.id.button1);
		Annuler = (Button) findViewById(R.id.button2);
		dbHelper = new Databasehelper(this);
		Creer.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String Nom = nom.getText().toString();
				String Prenom = prenom.getText().toString();
				String Login = login.getText().toString();
				String Password = password.getText().toString();
				String Tel = tel.getText().toString();
				
				if ((Nom.length() != 0) && (Prenom.length() != 0)
						&& (Login.length() != 0) && (Password.length() != 0)
						&& (Tel.length() != 0)) {

					try {
						dbHelper.open();
						User user = new User(Nom, Prenom, Login, Password, Tel);

						dbHelper.Add(user);
						dbHelper.close();

						Intent intent = new Intent(getApplicationContext(),
								Authentification.class);
						startActivity(intent);

						LayoutInflater inflater = getLayoutInflater();
						View layout = inflater
								.inflate(
										R.layout.toast_costum_layout_success,
										(ViewGroup) findViewById(R.id.toast_layout_root));
						TextView text = (TextView) layout
								.findViewById(R.id.textView1);
						text.setText("Inscription validé");
						Toast toast = new Toast(getApplicationContext());
						toast.setGravity(Gravity.BOTTOM, 0, 110);
						toast.setDuration(Toast.LENGTH_LONG);
						toast.setView(layout);
						toast.show();
					} catch (Exception e) {
						System.out.println("erreur" + e.getMessage());
					}

				} else {
					LayoutInflater inflater = getLayoutInflater();
					View layout = inflater.inflate(
							R.layout.toast_costum_layout_error,
							(ViewGroup) findViewById(R.id.toast_layout_root));
					TextView text = (TextView) layout
							.findViewById(R.id.textView1);
					text.setText("Les Champs Vides");
					Toast toast = new Toast(getApplicationContext());
					toast.setGravity(Gravity.BOTTOM, 0, 110);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(layout);
					toast.show();

				}

			}
		});
		Annuler.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				nom.setText("");
				prenom.setText("");
				login.setText("");
				password.setText("");
				tel.setText("");
			}
		});
	}

}
