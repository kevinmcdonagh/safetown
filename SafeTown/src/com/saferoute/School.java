package com.saferoute;


public class School {
	private String name, religion;
	private int lat;
	private int longi;
	public School(int lat, int longi, String religion, String name){
		this.lat = lat;
		this.longi = longi;
		this.name = name;
		this.religion = religion;
		
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public int getLongi() {
		return longi;
	}
	public void setLongi(int longi) {
		this.longi = longi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLat() {
		return lat;
	}
	public void setLat(int lat) {
		this.lat = lat;
	}


}
