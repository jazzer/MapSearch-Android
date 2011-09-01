package de.slzm.MapSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MapSearchActivity extends Activity {

	private MapLayout map;
	private List<Town> townsList = new ArrayList<Town>(75);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		map = (MapLayout) findViewById(R.id.maplayout);
		map.init();
		readTownsFromRawTextFile(this, R.raw.germanycoords);
	}

	public static void readTownsFromRawTextFile(Context ctx, int resId) {
		try {
			InputStream inputStream = ctx.getResources().openRawResource(resId);
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(streamReader);
			String line;
			while ((line = reader.readLine()) != null) {
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}