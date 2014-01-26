package com.gdg.miagegi.syscohada;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		/**
         * Creating all buttons instances
         * */
        // bouton du menu affichage par classe 
        Button btn_classe = (Button) findViewById(R.id.menu1);
 
        // bouton du menu affichage complet
        Button btn_tous = (Button) findViewById(R.id.menu2);
        
        /**
         * Handling all button click events
         * */
 
        // Listening to News Feed button click
        btn_classe.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), MenuClasse.class);
                startActivity(i);
                
            }
        });
        
        btn_tous.setOnClickListener(new View.OnClickListener() {
        	 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Liste.class);
                startActivity(i);
                
            }
        });
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		
		
		if (item.getItemId() == R.id.action_settings) {
       	startActivity(new Intent(this, About.class));
         }
		
		return super.onOptionsItemSelected(item);
		
	}
}
