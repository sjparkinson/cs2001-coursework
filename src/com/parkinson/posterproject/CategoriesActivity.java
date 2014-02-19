package com.parkinson.posterproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NodeList;

import static us.monoid.web.Resty.*;
import us.monoid.web.Resty;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CategoriesActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Draw custom title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

		setContentView(R.layout.activity_categories);

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

		// Titlebar user icon link
		final RelativeLayout title_user_btn = (RelativeLayout) findViewById(R.id.titlebarUserIconBtn);
		title_user_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), LoginActivity.class);
				startActivity(intent);
			}
		});
		
		// change user icon bg colour
		title_user_btn.setOnTouchListener(new View.OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				title_user_btn.setBackgroundColor(R.color.light_gray);
				return false;
			}
		});

		// setup our categories
		List<String> categories = new ArrayList<String>();
		
		LibAPI api = new LibAPI();
		
		if (api.callAPI("CategoryList", "categories/category/name")) {
			NodeList nodes = api.getXML();
			
			for (int i = 0; i < nodes.getLength(); i++) {
				categories.add(nodes.item(i).getTextContent().toString());
			}
			
			// set up the list adapter to be used by the ListView
			setListAdapter(new ArrayAdapter<String>(this,
					R.layout.list_category_item, R.id.listCategoryLabel, categories));
		}

	}
	
	// Setup category intents to poster list view
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	}

}
