package com.parkinson.posterproject;

import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class AboutActivity extends MapActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		// Draw custom title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

		setContentView(R.layout.activity_about);

		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titlebar);

		// Titlebar home icon link
		final RelativeLayout titlebar_home_btn = (RelativeLayout) findViewById(R.id.titlebarHomeBtn);
		final ImageView titlebar_home_icon = (ImageView) findViewById(R.id.titlebarHome);
		final TextView titlebar_home_title = (TextView) findViewById(R.id.titlebarTitle);
		titlebar_home_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), PosterProjectActivity.class);
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
		RelativeLayout title_user_btn = (RelativeLayout) findViewById(R.id.titlebarUserIconBtn);
		title_user_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), LoginActivity.class);
				startActivity(intent);
			}
		});

		// Find our map
		MapView mapView = (MapView) findViewById(R.id.aboutMap);

		// Get our marker drawable
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(
				R.drawable.ic_marker);

		// CustomItemizedOverlay itemizedOverlay = new CustomItemizedOverlay(drawable);

		// Set the location we want to mark
		GeoPoint point = new GeoPoint((int) (51.5323687 * 1E6),
				(int) (-0.4723514 * 1E6));

		// Place our marker on the map
		OverlayItem overlayitem = new OverlayItem(point, null, null);

		// itemizedOverlay.addOverlay(overlayitem);
		// mapOverlays.add(itemizedOverlay);

		// Setup map controls
		MapController mapController = mapView.getController();

		// Move and zoom the map to our marker
		mapController.animateTo(point);
		mapController.setZoom(15);

	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
