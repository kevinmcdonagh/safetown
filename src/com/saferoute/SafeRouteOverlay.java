package com.saferoute;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class SafeRouteOverlay extends ItemizedOverlay {

	private ArrayList<OverlayItem> overlays = new ArrayList<OverlayItem>();
	private Context context;
	
	public SafeRouteOverlay(Drawable defaultMarker)
	{
		super(boundCenterBottom(defaultMarker)); 
	}
	
	public SafeRouteOverlay(Drawable defaultMarker, Context ctx)
	{
		this(defaultMarker);
		context = ctx; 
	}
	
	public void addOverlay(OverlayItem overlay)
	{
		overlays.add(overlay);
		populate(); 
	}
	
	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return overlays.get(i); 
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return overlays.size(); 
	}
	
	protected boolean onTap(int index)
	{
		OverlayItem item = overlays.get(index); 
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.setCancelable(false); 
		dialog.setNeutralButton("etc...", new DialogInterface.OnClickListener() {
			//onShowDialog(){
				
			//}
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
			}
		});
		
		
		
		dialog.show();
		return true; 
	}

}
