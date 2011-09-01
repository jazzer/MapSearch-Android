package de.slzm.MapSearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MapSearchActivity extends Activity {

	private ImageView map;
	private TextView mytext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mytext = (TextView) findViewById(R.id.mytextview);
		mytext.setText("blablub");

		map = (ImageView) findViewById(R.id.map);
		map.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				mytext.setPadding((int) event.getX(), (int) event.getY(), 0, 0);
				return false;
			}
		});
	}
}