package com.parkinson.posterproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Draw custom title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

		setContentView(R.layout.activity_login);

		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titlebar);

		// Titlebar home icon link (about us page)
		final RelativeLayout titlebar_home_btn = (RelativeLayout) findViewById(R.id.titlebarHomeBtn);
		final ImageView titlebar_home_icon = (ImageView) findViewById(R.id.titlebarHome);
		final TextView titlebar_home_title = (TextView) findViewById(R.id.titlebarTitle);
		titlebar_home_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),
						PosterProjectActivity.class);
				startActivity(intent);
			}
		});
		titlebar_home_icon.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				titlebar_home_btn.performClick();
			}
		});
		titlebar_home_title.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				titlebar_home_btn.performClick();

			}
		});

		// Register link
		TextView register_link = (TextView) findViewById(R.id.loginRegister);
		register_link.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),
						RegisterActivity.class);
				startActivity(intent);
			}
		});

	}
}