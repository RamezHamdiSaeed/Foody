
	 

	

package com.example.foody;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen_activity extends Activity {

	
	private View _bg__splash_screen_ek2;
	private ImageView rectangle_6;
	private View _bg__frame_2_ek1;
	private ImageView image_11;
	private TextView premium_recipe;
	private View _bg__text_ek1;
	private TextView header_title;
	private TextView caption;
	private View _bg___medium_button_ek1;
	private TextView label;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);

		
		_bg__splash_screen_ek2 = (View) findViewById(R.id._bg__splash_screen_ek2);
		rectangle_6 = (ImageView) findViewById(R.id.rectangle_6);
		_bg__frame_2_ek1 = (View) findViewById(R.id._bg__frame_2_ek1);
		image_11 = (ImageView) findViewById(R.id.image_11);
		premium_recipe = (TextView) findViewById(R.id.premium_recipe);
		_bg__text_ek1 = (View) findViewById(R.id._bg__text_ek1);
		header_title = (TextView) findViewById(R.id.header_title);
		caption = (TextView) findViewById(R.id.caption);
		_bg___medium_button_ek1 = (View) findViewById(R.id._bg___medium_button_ek1);
		label = (TextView) findViewById(R.id.label);
	
		

	
	}
}
	
	