package de.slzm.MapSearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MapLayout extends FrameLayout {

	private ImageView map;
	private ImageView marker;
	private TextView textviewTown;
	private Button buttonNextTown;

	private static final int X_DIFF = -10;
	private static final int Y_DIFF = -80;
	
	private static final float LATITUDE_LEFT_TOP = 54.927142f;
	private static final float LONGITUDE_LEFT_TOP = 5.203857f;
	private static final float LATITUDE_RIGHT_BOTTOM = 47.219568f;
	private static final float LONGITUDE_RIGHT_BOTTOM = 15.421142f;		
	private static final float GPS_HEIGHT = LATITUDE_RIGHT_BOTTOM - LATITUDE_LEFT_TOP;
	private static final float GPS_WIDTH = LONGITUDE_RIGHT_BOTTOM - LONGITUDE_LEFT_TOP;
	
	private int map_height;
	private int map_width;
	
	public MapLayout(Context context) {
		super(context);
	}

	public MapLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MapLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public void init() {
		map = (ImageView) findViewById(R.id.map);
		marker = (ImageView) findViewById(R.id.marker);
		textviewTown = (TextView) findViewById(R.id.textviewtown);
		buttonNextTown = (Button) findViewById(R.id.buttonnexttown);
		
		map_height = map.getHeight();
		map_width = map.getWidth();
	}

	private int[] getPos(float latitude, float longitude) {
		int[] resPos = new int[2];
		
		float relativeY = (latitude - LATITUDE_LEFT_TOP)/GPS_HEIGHT;
		float relativeX = (longitude - LONGITUDE_LEFT_TOP)/GPS_WIDTH;
		
		resPos[0] = (int) (relativeX * map_width);
		resPos[1] = (int) (relativeY * map_height);
		
		return resPos;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//Log.d("xy", (int) event.getX() + " " + (int) event.getY());
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_MOVE:
			marker.setPadding((int) event.getX() + X_DIFF,
					(int) event.getY() + Y_DIFF, 0, 0);
			break;
		default:
			break;
		}
		return true;
	}
	
	

	

	
}
