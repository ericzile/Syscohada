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
        
        
        /**
         * Handling all button click events
         * */
 
        
		return true;
	}
	
public boolean onOptionsItemSelected(MenuItem item){
		
		
		if (item.getItemId() == R.id.action_settings) {
       	startActivity(new Intent(this, About.class));
         }
		
		return super.onOptionsItemSelected(item);
		
	}
public void clickClasse1(View view) {
    // Launching News Feed Screen
    Intent i = new Intent(getApplicationContext(), Ressource.class);
    startActivity(i);
    
}


public void clickClasse2(View view) {
    // Launching News Feed Screen
    Intent i = new Intent(getApplicationContext(), Actif.class);
    startActivity(i);
    
}

public void clickClasse3(View view) {
    // Launching News Feed Screen
    Intent i = new Intent(getApplicationContext(), Stocks.class);
    startActivity(i);
    
}

public void clickClasse4(View view) {
    // Launching News Feed Screen
    Intent i = new Intent(getApplicationContext(), Tiers.class);
    startActivity(i);
    
}

public void clickClasse5(View view) {
    // Launching News Feed Screen
    Intent i = new Intent(getApplicationContext(), Tresorerie.class);
    startActivity(i);
    
}

public void clickClasse6(View view) {
    // Launching News Feed Screen
    Intent i = new Intent(getApplicationContext(), Charges.class);
    startActivity(i);
    
}

public void clickClasse7(View view) {
    // Launching News Feed Screen
    Intent i = new Intent(getApplicationContext(), Produits.class);
    startActivity(i);
    
}



public void clickClasse8(View view) {
    // Launching News Feed Screen
    Intent i = new Intent(getApplicationContext(), Autres.class);
    startActivity(i);
    
}

public void clickClasse9(View view) {
    // Launching News Feed Screen
    Intent i = new Intent(getApplicationContext(), Engagement.class);
    startActivity(i);
    
}

}
