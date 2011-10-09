package com.saferoute;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class HeaderBar extends LinearLayout {

	private Context context;

	
	public HeaderBar(Context context) {
		super(context);
		this.context=context;
		init();
	}

	public HeaderBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context=context;
		init();
	}

	private void init(){
		LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.headerbar, this);
	}

}
