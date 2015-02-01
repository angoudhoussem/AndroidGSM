package com.ESSTHS.Telecom.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBasePosition extends SQLiteOpenHelper {
	SQLiteDatabase db;
	static final String DB_name = "position.db";
	public static final String USER_TABLE = "tabpositon";
	public static final String COL_ID = "ID";
	public final static String COL_NOMBTS = "nombts";
	public static final String COL_LATITUDE = "latitude";
	public static final String COL_LONGITUDE = "logitude";
	public static final String COL_DATE = "date";
	private static final int DATABASE_VERSION = 1;

	public DataBasePosition(Context context) {
		super(context, DB_name, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE IF NOT EXISTS " + USER_TABLE + " (" + COL_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_LATITUDE
				+ " TEXT NOT NULL, " + COL_LONGITUDE + " TEXT NOT NULL, "
				+ COL_DATE + " TEXT NOT NULL, " + COL_NOMBTS
				+ " TEXT NOT NULL);");

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

	public void Add(Position pos) {

		ContentValues cv = new ContentValues();

		cv.put(COL_NOMBTS, pos.getNomBts());
		cv.put(COL_LATITUDE, pos.getLatitude());
		cv.put(COL_LONGITUDE, pos.getLongitude());
		cv.put(COL_DATE, pos.getDate());
		db.insert(USER_TABLE, COL_NOMBTS, cv);
		db.close();

	}

	public Cursor recherche() {
		Cursor cursor = null;
		String sql = "SELECT * FROM " + USER_TABLE;
		cursor = getWritableDatabase().rawQuery(sql, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		return cursor;
	}

}
