package de.slzm.MapSearch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class PaintView extends ImageView{
	
	private int[] pos;
	
	public PaintView(Context context) {
		super(context);
	}
	
	public PaintView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public PaintView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	
	public void setPosToDraw(int[] pos) {
		this.pos = pos;
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setStyle(Style.FILL);
		
		if(pos != null) {
			canvas.drawCircle(pos[0], pos[1], 5, paint);
		}
		
		
		
	}
}
