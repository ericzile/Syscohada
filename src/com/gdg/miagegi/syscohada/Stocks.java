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
				"318 -- MARCHANDISES HORS ACTIVITÉS ORDINAIRES (H.A.O.) ",
				"32 - MATIÈRES PREMIÈRES ET FOURNITURES LIÉES",
				"321 -- MATIÈRES A ",
				"322 -- MATIÈRES B ",
				"323 -- FOURNITURES (A,B)", 
				"33 - AUTRES APPROVISIONNEMENTS ",
				"331 -- MATIÈRES CONSOMMABLES ",
				"332 -- FOURNITURES D'ATELIER ET D'USINE ",
				"333 -- FOURNITURES DE MAGASIN ",
				"334 -- FOURNITURES DE BUREAU ",
				"335 -- EMBALLAGES ",
				"3351 --- Emballages perdus", 
				"3352 --- Emballages récupérables non identifiables ",
				"3353 --- Emballages à usage mixte ",
				"3358 --- Autres emballages ",
				"338 -- AUTRES MATIÈRES ",
				"34 - PRODUITS EN COURS ",
				"341 -- PRODUITS EN COURS ",
				"3411 --- Produits en cours P1 ",
				"3412 --- Produits en cours P2 ",
				"342 -- TRAVAUX EN COURS ",
				"3421 --- Travaux en cours T1",
				"3422 --- Travaux en cours T2 ",
				"343 -- PRODUITS INTERMÉDIAIRES EN COURS", 
				"3431 --- Produits intermédiaires A ",
				"3432 --- Produits intermédiaires B ",
				"344 -- PRODUITS RÉSIDUELS EN COURS ",
				"3441 --- Produits résiduels A ",
				"3442 --- Produits résiduels B ",
				"35 - SERVICES EN COURS ",
				"351 -- ÉTUDES EN COURS",
				"3511 --- Études en cours E1",
				"3512 --- Études en cours E2",
				"352 -- PRESTATIONS DE SERVICES EN COURS ",
				"3521 --- Prestations de services S1 ",
				"3522 --- Prestations de services S2 ",
				"36 - PRODUITS FINIS ",
				"361 -- PRODUITS FINIS A ",
				"362 -- PRODUITS FINIS B ",
				"37 - PRODUITS INTERMÉDIAIRES ET RÉSIDUELS ",
				"371 -- PRODUITS INTERMÉDIAIRES ",
				"3711 --- Produits intermédiaires A ",
				"3712 --- Produits intermédiaires B ",
				"372 -- PRODUITS RÉSIDUELS ",
				"3721 --- Déchets ",
				"3722 --- Rebuts ",
				"3723 --- Matières de Récupération ",
				"38 - STOCKS EN COURS DE ROUTE, EN CONSIGNATION OU EN DÉPÔT ",
				"381 -- MARCHANDISES EN COURS DE ROUTE ",
				"38 - MATIÈRES PREMIÈRES ET FOURNITURES LIÉES EN COURS DE ROUTE ",
				"383 -- AUTRES APPROVISIONNEMENTS EN COURS DE ROUTE ",
				"386 -- PRODUITS FINIS EN COURS DE ROUTE ",
				"387 -- STOCK EN CONSIGNATION OU EN DÉPÔT ",
				"3871 --- Stock en consignation ",
				"3872 --- Stock en dépôt ",
				"388 -- STOCK PROVENANT D'IMMOBILISATIONS MISES HORS SERVICE OU AU REBUT ",
				"39 - DÉPRÉCIATIONS DES STOCKS ",
				"391 -- DÉPRÉCIATIONS DES STOCKS DE MARCHANDISES",
				"392 -- DÉPRÉCIATIONS DES STOCKS DE MATIÈRES PREMIÈRES ET FOURNITURES LIÉES",
				"393 -- DÉPRÉCIATIONS DES STOCKS D'AUTRES APPOVISIONNEMENTS",
				"394 -- DÉPRÉCIATIONS DES PRODUCTIONS EN COURS",
				"395 -- DÉPRÉCIATIONS DES SERVICES EN COURS",
				"396 -- DÉPRÉCIATIONS DES STOCKS DE PRODUITS FINIS",
				"397 -- DÉPRÉCIATIONS DES STOCKS DE PRODUITS INTERMÉDIAIRES ET RÉSIDUELS",
				"398 -- DÉPRÉCIATIONS DES STOCKS EN COURS DE ROUTE, EN CONSIGNATION OU EN DÉPÔT",
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
