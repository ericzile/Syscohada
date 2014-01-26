package com.gdg.miagegi.syscohada;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		Button btn_cancel = (Button) findViewById(R.id.cancel);
		 // Listening to News Feed button click
        btn_cancel.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                
            }
        });
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}

}
