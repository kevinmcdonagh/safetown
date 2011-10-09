/*
 * Copyright (C) 2011 Patrik Åkerfeldt
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.saferoute;

import java.util.HashSet;

import org.taptwo.android.widget.TitleProvider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AndroidVersionAdapter extends BaseAdapter implements TitleProvider {

	private LayoutInflater mInflater;

	private static final String[] names = {"Least Violent","Where you are","Most Violent"};
	private static final String[] versions = {"1.5","1.6","2.1"};
	
	public AndroidVersionAdapter(Context context) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}
	
	@Override
	public int getCount() {
		return names.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position; 
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			convertView = mInflater.inflate(R.layout.flow_item, null);
		}
		LondonSchools schools = new LondonSchools();
		HashSet<School> sList = schools.getSchools();
		School choice = null; 
		int i = 0; 
		String crime = Integer.toString(position+1); 
		for(School s : sList)
		{
			choice = s;
			
			if(i == position+1)
				break;
			++i; 
		}
		
		updateTextView(convertView, choice, crime); 
		
		
		return convertView;
	}

	

	private void updateTextView(View convertView, School choice, String crime) 
	{
		((TextView) convertView.findViewById(R.id.textLabelSchool)).setText(choice.getName()); 
		((TextView) convertView.findViewById(R.id.textLabel)).setText(crime);	
	}
 
	/* (non-Javadoc)
	 * @see org.taptwo.android.widget.TitleProvider#getTitle(int)
	 */
	@Override
	public String getTitle(int position) {
		return names[position];
	}

}
