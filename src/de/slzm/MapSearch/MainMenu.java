package de.slzm.MapSearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {
	
	private Button buttonStart;
	private Button buttonExit;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		
		buttonStart = (Button) findViewById(R.id.buttonstart);
		buttonExit = (Button) findViewById(R.id.buttonexit);
		
		buttonStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainMenu.this, MapSearchActivity.class);
				startActivity(i);
			}
		});
	}
}
