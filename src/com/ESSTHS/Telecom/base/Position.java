package com.ESSTHS.Telecom.base;

public class Position { 
	
	
	String latitude;
	String longitude;
	String date;
	String NomBts;
	public Position(String latitude, String longitude, String date,
			String nomBts) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.NomBts = nomBts;
	}
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNomBts() {
		return NomBts;
	}
	public void setNomBts(String nomBts) {
		NomBts = nomBts;
	}
	
	
}
