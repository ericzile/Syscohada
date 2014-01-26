package com.gdg.miagegi.syscohada;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MenuClasse extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_classe);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_classe, menu);
		 // bouton du menu affichage complet
        Button menu_classe1 = (Button) findViewById(R.id.menu_classe1);
        Button menu_classe2 = (Button) findViewById(R.id.menu_classe2);
        Button menu_classe3 = (Button) findViewById(R.id.menu_classe3);
        Button menu_classe4 = (Button) findViewById(R.id.menu_classe4);
        Button menu_classe5 = (Button) findViewById(R.id.menu_classe5);
        Button menu_classe6 = (Button) findViewById(R.id.menu_classe6);
        Button menu_classe7 = (Button) findViewById(R.id.menu_classe7);
        Button menu_classe8 = (Button) findViewById(R.id.menu_classe8);
        
        /**
         * Handling all button click events
         * */
 
        // Listening to News Feed button click
        menu_classe1.setOnClickListener(new View.OnClickListener() {
        	 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Ressource.class);
                startActivity(i);
                
            }
        });
        
        menu_classe2.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Actif.class);
                startActivity(i);
                
            }
        });
        menu_classe3.setOnClickListener(new View.OnClickListener() {
       	 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Stocks.class);
                startActivity(i);
                
            }
        });
        
        menu_classe4.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Tiers.class);
                startActivity(i);
                
            }
        });
        menu_classe5.setOnClickListener(new View.OnClickListener() {
       	 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Tresorerie.class);
                startActivity(i);
                
            }
        });
        
        menu_classe6.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Charges.class);
                startActivity(i);
                
            }
        });
        menu_classe7.setOnClickListener(new View.OnClickListener() {
       	 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Produits.class);
                startActivity(i);
                
            }
        });
        
        menu_classe8.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Autres.class);
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
