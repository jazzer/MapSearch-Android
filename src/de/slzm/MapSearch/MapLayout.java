package de.slzm.MapSearch;

import java.text.MessageFormat;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.location.GpsStatus;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MapLayout extends FrameLayout {

	private ImageView marker;
	private TextView textviewTown;
	private Button buttonNextTown;
	private PaintView paintView;

	private static final int X_DIFF = 10;
	private static final int Y_DIFF = 32;

	private int paddingX = 0;
	private int paddingY = 0;

	private static final float LATITUDE_LEFT_TOP = 54.927142f;
	private static final float LONGITUDE_LEFT_TOP = 5.203857f;
	private static final float LATITUDE_RIGHT_BOTTOM = 47.219568f;
	private static final float LONGITUDE_RIGHT_BOTTOM = 15.421142f;
	private static final float FULL_DIST_KM = 1170.0f;
	private static final float GPS_HEIGHT = LATITUDE_LEFT_TOP
			- LATITUDE_RIGHT_BOTTOM;
	private static final float GPS_WIDTH = LONGITUDE_RIGHT_BOTTOM
			- LONGITUDE_LEFT_TOP;

	private int map_height;
	private int map_width;
	private double map_diag;
	private double dist_per_pixel;

	private int townIndex = -1;
	private List<Town> townsList;
	private int[] townPos;

	private Context context;

	public MapLayout(Context context) {
		super(context);
	}

	public MapLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MapLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void init(final List<Town> townsList, Context context) {

		this.context = context;
		this.townsList = townsList;

		marker = (ImageView) ((Activity) context).findViewById(R.id.marker);
		textviewTown = (TextView) ((Activity) context)
				.findViewById(R.id.textviewtown);
		buttonNextTown = (Button) ((Activity) context)
				.findViewById(R.id.buttonnexttown);
		paintView = (PaintView) ((Activity) context)
				.findViewById(R.id.paintview);

		buttonNextTown.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				map_height = paintView.getMeasuredHeight();
				map_width = paintView.getMeasuredWidth();
				map_diag = Math.sqrt(Math.pow(map_height, 2)
						+ Math.pow(map_width, 2));
				dist_per_pixel = FULL_DIST_KM / map_diag;
				
				setResult();
				nextTown();
			}
		});

		setWillNotDraw(false);
	}
	
	private void nextTown() {
		townIndex++;
		Town town = townsList.get(townIndex);
		textviewTown.setText(town.getName());
		townPos = getPos(town.getLatitude(), town.getLongitude());
	}

	private void setResult() {
		if (townIndex > -1) {
			paintView.setPosToDraw(townPos);
			double dist = getDistanceFromTown();
			Toast toast = Toast.makeText(context, String.format(
					"%.0f km von %s entfernt.", dist, townsList.get(townIndex)
							.getName()), Toast.LENGTH_LONG);
			toast.show();
		}
	}

	private double getDistanceFromTown() {
		int[] pinPos = new int[2];
		pinPos[0] = paddingX + X_DIFF;
		pinPos[1] = paddingY + Y_DIFF;
		return dist_per_pixel
				* Math.sqrt(Math.pow(townPos[0] - pinPos[0], 2)
						+ Math.pow(townPos[1] - pinPos[1], 2));
	}

	private int[] getPos(float latitude, float longitude) {
		int[] resPos = new int[2];

		float relativeY = (LATITUDE_LEFT_TOP - latitude) / GPS_HEIGHT;
		float relativeX = (longitude - LONGITUDE_LEFT_TOP) / GPS_WIDTH;

		resPos[0] = (int) (relativeX * map_width);
		resPos[1] = (int) (relativeY * map_height);

		return resPos;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// Log.d("xy", (int) event.getX() + " " + (int) event.getY());
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
//		case MotionEvent.ACTION_MOVE:
			paddingX = (int) event.getX() - X_DIFF;
			paddingY = (int) event.getY() - Y_DIFF;
			marker.setPadding(paddingX, paddingY, 0, 0);
			break;
		default:
			break;
		}
		return true;
	}

}
