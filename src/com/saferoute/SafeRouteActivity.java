package com.saferoute;


import java.util.HashSet;
import java.util.List;

import org.taptwo.android.widget.TitleFlowIndicator;
import org.taptwo.android.widget.ViewFlow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class SafeRouteActivity extends MapActivity {
    
	private MapView mapView; 
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
		LondonSchools schools = new LondonSchools();
		HashSet<School> list = schools.getSchools();
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true); 
        setupLocationInfo();
        
        List<Overlay> mapOverlays = mapView.getOverlays(); 
        Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
        SafeRouteOverlay itemOverlay = new SafeRouteOverlay(drawable, this);
        GeoPoint point = new GeoPoint(19240000, -99120000);
        OverlayItem ovItemWalk = new OverlayItem(point, "Hola", "Walk");
		//
        for(School s : list){
        	GeoPoint school = new GeoPoint(s.getLat(),s.getLongi());
            OverlayItem item = new OverlayItem(new GeoPoint(s.getLat(),s.getLongi()), s.getName(), s.getName());
            itemOverlay.addOverlay(item);
        }

        itemOverlay.addOverlay(ovItemWalk);
        mapOverlays.add(itemOverlay);

		ViewFlow viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		AndroidVersionAdapter adapter = new AndroidVersionAdapter(this);
		viewFlow.setAdapter(adapter, 1);
		TitleFlowIndicator indicator = (TitleFlowIndicator) findViewById(R.id.viewflowindic);
		indicator.setTitleProvider(adapter);
		viewFlow.setFlowIndicator(indicator);
    }
    
    private void centerLocation(GeoPoint centerGeoPoint)
    {
    	mapView.getController().animateTo(centerGeoPoint);
  
    };
    
    private void setupLocationInfo()
    {
    	LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE); 
    	LocationListener locationListener = new LocationListener()
    	{

			@Override
			public void onLocationChanged(Location location) {
				GeoPoint myGeoPoint = new GeoPoint(
				(int)(location.getLatitude()*1000000),
				(int)(location.getLongitude()*1000000));
				centerLocation(myGeoPoint);
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}
    		
    	};
    	
    	locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener); 
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}