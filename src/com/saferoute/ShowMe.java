package com.saferoute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ShowMe extends Activity {
    
    private static final String[] mAdjs = {
    	"Violent", "Peaceful"
    };
    
    private static final String[] mNouns = {
    	"Primary Schools", "Secondary Schools", "Catholic schools" 
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_showme);
		
		 Spinner s1 = (Spinner) findViewById(R.id.showme_spin_nouns);
	       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	                android.R.layout.simple_spinner_item, mNouns);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        s1.setAdapter(adapter);
	        
	    s1 = (Spinner) findViewById(R.id.showme_spin_adjectives);
	    adapter = new ArrayAdapter<String>(this,
	        		android.R.layout.simple_spinner_item, mAdjs);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    s1.setAdapter(adapter);
		
	    Button btn = (Button)findViewById(R.id.showme_btn_go);
	    btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(ShowMe.this, SafeRouteActivity.class));
			}
		});
	}
}
