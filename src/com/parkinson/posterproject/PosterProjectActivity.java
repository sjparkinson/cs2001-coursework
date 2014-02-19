package com.parkinson.posterproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

public class PosterProjectActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Draw custom title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

		setContentView(R.layout.activity_posterproject);

		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titlebar);

		// Titlebar user icon link
		RelativeLayout title_user_btn = (RelativeLayout) findViewById(R.id.titlebarUserIconBtn);
		title_user_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), LoginActivity.class);
				startActivity(intent);
			}
		});

		// Categories link
		Button categories_btn = (Button) findViewById(R.id.mainCategoriesBtn);
		categories_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),
						CategoriesActivity.class);
				startActivity(intent);
			}
		});

	}

	/* Creates the menu items */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.home, menu);
		return true;
	}
	
	/* Handles item selections */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
    	case R.id.about:
    		Intent intent = new Intent(this.getBaseContext(),
					AboutActivity.class);
			startActivity(intent);
            return true;
        }
        return false;
    }

	// If the back button is pressed on the home screen, suspend application
	@Override
	public void onBackPressed() {
		// do something on back.
		moveTaskToBack(true);
		return;
	}
}