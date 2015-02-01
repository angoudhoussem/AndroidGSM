package com.ESSTHS.Telecom.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {
	SQLiteDatabase db;
	static final String DB_name = "sql.db";
	public static final String USER_TABLE = "user";
	public static final String COL_ID = "userID";
	public final static String COL_LOGIN = "userLogin";
	public static final String COL_PASSWORD = "userPassword";
	public static final String COL_Tel = "usertel";
	public static final String COL_Nom = "usernom";
	public static final String COL_Prenom = "userprenom";
	private static final int DATABASE_VERSION = 1;

	public Databasehelper(Context context) {
		super(context, DB_name, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE IF NOT EXISTS " + USER_TABLE + " (" + COL_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_Nom
				+ " TEXT NOT NULL, " + COL_Prenom + " TEXT NOT NULL, "
				+ COL_LOGIN + " TEXT NOT NULL, " + COL_PASSWORD
				+ " TEXT NOT NULL, " + COL_Tel + " TEXT NOT NULL);");

	}

	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	public void open() {

		db = this.getWritableDatabase();

	}

	public void close() {

		db.close();
	}

	public void Add(User usr) {

		ContentValues cv = new ContentValues();

		cv.put(COL_LOGIN, usr.getLogin());
		cv.put(COL_PASSWORD, usr.getPassword());
		cv.put(COL_Tel, usr.getLogin());
		cv.put(COL_Nom, usr.getNom());
		cv.put(COL_Prenom, usr.getPrenom());
		db.insert(USER_TABLE, COL_LOGIN, cv);
		db.close();

	}

	public Cursor recherche(String login, String password) {
		Cursor cursor = null;
		String[] columns = new String[] { COL_ID, COL_LOGIN, COL_PASSWORD };

		cursor = db.query(USER_TABLE, columns, COL_LOGIN + "='" + login
				+ "' AND " + COL_PASSWORD + "='" + password + "'", null, null,
				null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		return cursor;
	}

}
