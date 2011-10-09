package com.saferoute;

import java.util.HashSet;


public class LondonSchools{
	double microdegs = 1E6;
	String[][] rawSchools = {
	               		  {"Sir John Casss Foundation Primary School","Church of England","533498","181201"},
	               		  {"Argyle Primary School","Does not apply","530238","182761"},
	               		  {"Beckford Primary School","Does not apply","524888","185067"},
	               		  {"Brecknock Primary School","Does not apply","529938","184777"},
	               		  {"Brookfield Primary School","Does not apply","528706","186594"},
	               		  {"Carlton Primary School","Does not apply","528386","185209"},
	               		  {"Edith Neville Primary School","Does not apply","529725","183195"},
	               		  {"Fleet Primary School","Does not apply","527677","185424"},
	               		  {"Hawley Infant School","Does not apply","528895","184038"}}; 
	 private HashSet<School> schools;
	public LondonSchools(){
		schools = new HashSet<School>();
		generate();
		
	}
	public HashSet<School> getSchools(){
		return schools;
	}

	private void generate(){

		int size = rawSchools.length;
		IngConverter converter = new IngConverter();
		for(String[] s: rawSchools){
		
			int lat =  Integer.parseInt(s[2]);
			int lon = Integer.parseInt(s[3]);
			Double[] location = converter.ConvertOSToLatLon(lat, lon);
			//double dMicroDegs = Double.parseDouble(Integer.toString(microdegs);
			lat = (int)(location[0] * microdegs);
			lon = (int)(location[1] * microdegs);
			schools.add(new School(lat, lon, s[1],s[0]));
			
			
		}
	}

}
