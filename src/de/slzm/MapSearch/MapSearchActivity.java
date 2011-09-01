package de.slzm.MapSearch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MapSearchActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView mytext = (TextView) findViewById(R.id.mytextview);
        mytext.setText("blablub");
        
    }
}