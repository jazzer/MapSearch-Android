package de.slzm.MapSearch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MapSearchActivity extends Activity {

	private MapLayout map;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		map = (MapLayout) findViewById(R.id.maplayout);
		map.init();
	}


}