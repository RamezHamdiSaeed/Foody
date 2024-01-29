
	 

	

package com.example.foody;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;

public class sign_up_activity extends Activity {

	
	private View _bg__sign_up_ek2;
	private View _bg__titttle_ek1;
	private TextView create_an_account;
	private TextView let_s_help_you_set_up_your_account__it_won_t_take_long_;
	private View _bg__forgot_password_ek1;
	private TextView accept_terms___condition;
	private View rectangle_6;
	private View _bg__button_ek1;
	private View rectangle_642;
	private View _bg__icons8_google_240_1_ek1;
	private ImageView vector;
	private ImageView vector_ek1;
	private ImageView vector_ek2;
	private ImageView vector_ek3;
	private TextView _already_a_member__sign_in;
	private View _bg__line_ek1;
	private ImageView line_6;
	private ImageView line_5;
	private TextView or_sign_in_with;
	private View _bg__input_field_ek1;
	private View rectangle_6_ek1;
	private TextView placeholder;
	private TextView label;
	private View _bg__input_field_ek3;
	private View rectangle_6_ek2;
	private TextView placeholder_ek1;
	private TextView label_ek1;
	private View _bg__input_field_ek5;
	private View rectangle_6_ek3;
	private TextView placeholder_ek2;
	private TextView label_ek2;
	private View _bg__input_field_ek7;
	private View rectangle_6_ek4;
	private TextView placeholder_ek3;
	private TextView label_ek3;
	private View _bg__home_indicator_ek1;
	private View line_ek2;
	private View _bg___big_button_ek1;
	private TextView label_ek4;
	private View _bg__icon_general_arrow_right_ek1;
	private View rectangle_1;
	private ImageView union;
	private View _bg__status_bar_ek1;
	private View _bg__symbols_ek1;
	private View _bg__battery_ek1;
	private ImageView rectangle;
	private View rectangle_ek1;
	private ImageView combined_shape;
	private ImageView wi_fi;
	private View _bg__bars_status___time_ek1;
	private TextView ___time;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);

		
		_bg__sign_up_ek2 = (View) findViewById(R.id._bg__sign_up_ek2);
		_bg__titttle_ek1 = (View) findViewById(R.id._bg__titttle_ek1);
		create_an_account = (TextView) findViewById(R.id.create_an_account);
		let_s_help_you_set_up_your_account__it_won_t_take_long_ = (TextView) findViewById(R.id.let_s_help_you_set_up_your_account__it_won_t_take_long_);
		_bg__forgot_password_ek1 = (View) findViewById(R.id._bg__forgot_password_ek1);
		accept_terms___condition = (TextView) findViewById(R.id.accept_terms___condition);
		rectangle_6 = (View) findViewById(R.id.rectangle_6);
		_bg__button_ek1 = (View) findViewById(R.id._bg__button_ek1);
		rectangle_642 = (View) findViewById(R.id.rectangle_642);
		_bg__icons8_google_240_1_ek1 = (View) findViewById(R.id._bg__icons8_google_240_1_ek1);
		vector = (ImageView) findViewById(R.id.vector);
		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		vector_ek2 = (ImageView) findViewById(R.id.vector_ek2);
		vector_ek3 = (ImageView) findViewById(R.id.vector_ek3);
		_already_a_member__sign_in = (TextView) findViewById(R.id._already_a_member__sign_in);
		_bg__line_ek1 = (View) findViewById(R.id._bg__line_ek1);
		line_6 = (ImageView) findViewById(R.id.line_6);
		line_5 = (ImageView) findViewById(R.id.line_5);
		or_sign_in_with = (TextView) findViewById(R.id.or_sign_in_with);
		_bg__input_field_ek1 = (View) findViewById(R.id._bg__input_field_ek1);
		rectangle_6_ek1 = (View) findViewById(R.id.rectangle_6_ek1);
		placeholder = (TextView) findViewById(R.id.placeholder);
		label = (TextView) findViewById(R.id.label);
		_bg__input_field_ek3 = (View) findViewById(R.id._bg__input_field_ek3);
		rectangle_6_ek2 = (View) findViewById(R.id.rectangle_6_ek2);
		placeholder_ek1 = (TextView) findViewById(R.id.placeholder_ek1);
		label_ek1 = (TextView) findViewById(R.id.label_ek1);
		_bg__input_field_ek5 = (View) findViewById(R.id._bg__input_field_ek5);
		rectangle_6_ek3 = (View) findViewById(R.id.rectangle_6_ek3);
		placeholder_ek2 = (TextView) findViewById(R.id.placeholder_ek2);
		label_ek2 = (TextView) findViewById(R.id.label_ek2);
		_bg__input_field_ek7 = (View) findViewById(R.id._bg__input_field_ek7);
		rectangle_6_ek4 = (View) findViewById(R.id.rectangle_6_ek4);
		placeholder_ek3 = (TextView) findViewById(R.id.placeholder_ek3);
		label_ek3 = (TextView) findViewById(R.id.label_ek3);
		_bg__home_indicator_ek1 = (View) findViewById(R.id._bg__home_indicator_ek1);
		line_ek2 = (View) findViewById(R.id.line_ek2);
		_bg___big_button_ek1 = (View) findViewById(R.id._bg___big_button_ek1);
		label_ek4 = (TextView) findViewById(R.id.label_ek4);
		_bg__icon_general_arrow_right_ek1 = (View) findViewById(R.id._bg__icon_general_arrow_right_ek1);
		rectangle_1 = (View) findViewById(R.id.rectangle_1);
		union = (ImageView) findViewById(R.id.union);
		_bg__status_bar_ek1 = (View) findViewById(R.id._bg__status_bar_ek1);
		_bg__symbols_ek1 = (View) findViewById(R.id._bg__symbols_ek1);
		_bg__battery_ek1 = (View) findViewById(R.id._bg__battery_ek1);
		rectangle = (ImageView) findViewById(R.id.rectangle);
		rectangle_ek1 = (View) findViewById(R.id.rectangle_ek1);
		combined_shape = (ImageView) findViewById(R.id.combined_shape);
		wi_fi = (ImageView) findViewById(R.id.wi_fi);
		_bg__bars_status___time_ek1 = (View) findViewById(R.id._bg__bars_status___time_ek1);
		___time = (TextView) findViewById(R.id.___time);
	
		
		_already_a_member__sign_in.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
//				Intent nextScreen = new Intent(getApplicationContext(), sign_in_activity.class);
//				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	