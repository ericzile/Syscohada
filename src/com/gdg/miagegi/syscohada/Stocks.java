package com.gdg.miagegi.syscohada;

import java.util.ArrayList;
import java.util.HashMap;

import com.gdg.miagegi.syscohada.R;
import com.gdg.miagegi.syscohada.Stocks;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Stocks extends Activity {

	private ListView lv;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<	String, String>> productList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stocks);
		String liste_stocks[] = {
				"31 - MARCHANDISES ",
				"311 - MARCHANDISES A",
				"3111 --- Marchandises A1", 
				"3112 --- Marchandises A2 ",
				"312 -- MARCHANDISES B ",
				"3121 --- Marchandises B1 ",
				"3122 --- Marchandises B2 ",
				"318 -- MARCHANDISES HORS ACTIVIT�S ORDINAIRES (H.A.O.) ",
				"32 - MATI�RES PREMI�RES ET FOURNITURES LI�ES",
				"321 -- MATI�RES A ",
				"322 -- MATI�RES B ",
				"323 -- FOURNITURES (A,B)", 
				"33 - AUTRES APPROVISIONNEMENTS ",
				"331 -- MATI�RES CONSOMMABLES ",
				"332 -- FOURNITURES D'ATELIER ET D'USINE ",
				"333 -- FOURNITURES DE MAGASIN ",
				"334 -- FOURNITURES DE BUREAU ",
				"335 -- EMBALLAGES ",
				"3351 --- Emballages perdus", 
				"3352 --- Emballages r�cup�rables non identifiables ",
				"3353 --- Emballages � usage mixte ",
				"3358 --- Autres emballages ",
				"338 -- AUTRES MATI�RES ",
				"34 - PRODUITS EN COURS ",
				"341 -- PRODUITS EN COURS ",
				"3411 --- Produits en cours P1 ",
				"3412 --- Produits en cours P2 ",
				"342 -- TRAVAUX EN COURS ",
				"3421 --- Travaux en cours T1",
				"3422 --- Travaux en cours T2 ",
				"343 -- PRODUITS INTERM�DIAIRES EN COURS", 
				"3431 --- Produits interm�diaires A ",
				"3432 --- Produits interm�diaires B ",
				"344 -- PRODUITS R�SIDUELS EN COURS ",
				"3441 --- Produits r�siduels A ",
				"3442 --- Produits r�siduels B ",
				"35 - SERVICES EN COURS ",
				"351 -- �TUDES EN COURS",
				"3511 --- �tudes en cours E1",
				"3512 --- �tudes en cours E2",
				"352 -- PRESTATIONS DE SERVICES EN COURS ",
				"3521 --- Prestations de services S1 ",
				"3522 --- Prestations de services S2 ",
				"36 - PRODUITS FINIS ",
				"361 -- PRODUITS FINIS A ",
				"362 -- PRODUITS FINIS B ",
				"37 - PRODUITS INTERM�DIAIRES ET R�SIDUELS ",
				"371 -- PRODUITS INTERM�DIAIRES ",
				"3711 --- Produits interm�diaires A ",
				"3712 --- Produits interm�diaires B ",
				"372 -- PRODUITS R�SIDUELS ",
				"3721 --- D�chets ",
				"3722 --- Rebuts ",
				"3723 --- Mati�res de R�cup�ration ",
				"38 - STOCKS EN COURS DE ROUTE, EN CONSIGNATION OU EN D�P�T ",
				"381 -- MARCHANDISES EN COURS DE ROUTE ",
				"38 - MATI�RES PREMI�RES ET FOURNITURES LI�ES EN COURS DE ROUTE ",
				"383 -- AUTRES APPROVISIONNEMENTS EN COURS DE ROUTE ",
				"386 -- PRODUITS FINIS EN COURS DE ROUTE ",
				"387 -- STOCK EN CONSIGNATION OU EN D�P�T ",
				"3871 --- Stock en consignation ",
				"3872 --- Stock en d�p�t ",
				"388 -- STOCK PROVENANT D'IMMOBILISATIONS MISES HORS SERVICE OU AU REBUT ",
				"39 - D�PR�CIATIONS DES STOCKS ",
				"391 -- D�PR�CIATIONS DES STOCKS DE MARCHANDISES",
				"392 -- D�PR�CIATIONS DES STOCKS DE MATI�RES PREMI�RES ET FOURNITURES LI�ES",
				"393 -- D�PR�CIATIONS DES STOCKS D'AUTRES APPOVISIONNEMENTS",
				"394 -- D�PR�CIATIONS DES PRODUCTIONS EN COURS",
				"395 -- D�PR�CIATIONS DES SERVICES EN COURS",
				"396 -- D�PR�CIATIONS DES STOCKS DE PRODUITS FINIS",
				"397 -- D�PR�CIATIONS DES STOCKS DE PRODUITS INTERM�DIAIRES ET R�SIDUELS",
				"398 -- D�PR�CIATIONS DES STOCKS EN COURS DE ROUTE, EN CONSIGNATION OU EN D�P�T",
		};
		lv = (ListView) findViewById(R.id.liste_comptes_stocks);
        inputSearch = (EditText) findViewById(R.id.Recherche_stocks);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nom_compte, liste_stocks);
        lv.setAdapter(adapter);
        
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                Stocks.this.adapter.getFilter().filter(cs);  
            }
             
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub
                 
            }
             
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub                         
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stocks, menu);
		return true;
	}
	
		public boolean onOptionsItemSelected(MenuItem item){
		
		
		if (item.getItemId() == R.id.action_settings) {
       	startActivity(new Intent(this, About.class));
         }
		
		return super.onOptionsItemSelected(item);
		
	}

}
