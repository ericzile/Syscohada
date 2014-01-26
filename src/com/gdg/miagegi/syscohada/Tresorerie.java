package com.gdg.miagegi.syscohada;

import java.util.ArrayList;
import java.util.HashMap;

import com.gdg.miagegi.syscohada.R;
import com.gdg.miagegi.syscohada.Tresorerie;

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

public class Tresorerie extends Activity {

	private ListView lv;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<	String, String>> productList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tresorerie);
		String liste_tresorerie[] = {
				"50 - TITRES DE PLACEMENT ",
				"501 -- TITRES DU TRÉSOR ET BONS DE CAISSE À COURT TERME ",
				"5011 --- Titres du Trésor à court terme ",
				"5012 --- Titres d'organismes financiers ",
				"5013 --- Bons de caisse à court terme ",
				"502 -- ACTIONS ",
				"5021 --- Actions propres ",
				"5022 --- Actions cotées ",
				"5023 --- Actions non cotées ",
				"5024 --- Actions démembrées (certificats d'investissement ; droits de vote) ",
				"5025 --- Autres titres conférant un droit de propriété ",
				"503 -- OBLIGATIONS ",
				"5031 --- Obligations émises par la société et rachetées par elle ",
				"5032 --- Obligations cotées ",
				"5033 --- Obligations non cotées ",
				"5035 --- Autres titres conférant un droit de créance  ",
				"504 -- BONS DE SOUSCRIPTION ",
				"5042 --- Bons de souscription d'actions ",
				"5043 --- Bons de souscription d'obligations ",
				"505 -- TITRES NÉGOCIABLES HORS REGION ",
				"506 -- INTÉRÊTS COURUS ",
				"5061 --- Titres du Trésor et bons de caisse à court terme ",
				"5062 --- Actions ",
				"5063 --- Obligations ",
				"508 -- AUTRES VALEURS ASSIMILÉES", 
				"51 - VALEURS À ENCAISSER ",
				"511 -- EFFETS À ENCAISSER ",
				"512 -- EFFETS À L'ENCAISSEMENT ",
				"513 -- CHÈQUES À ENCAISSER ",
				"514 -- CHÈQUES À L'ENCAISSEMENT ",
				"515 -- CARTES DE CRÉDIT À ENCAISSER ",
				"518 -- AUTRES VALEURS À L'ENCAISSEMENT ",
				"5181 --- Warrants ",
				"5182 --- Billets de fonds ",
				"5185 --- Chèques de voyage ",
				"5186 --- Coupons échus ",
				"5187 --- Intérêts échus des obligations ",
				"52 - BANQUES ",
				"521 -- BANQUES LOCALES ",
				"5211 --- BANQUES X ",
				"5212 --- BANQUE Y ",
				"522 -- BANQUES AUTRES ÉTATS REGION ",
				"523 -- BANQUES AUTRES ETATS ZONE MONETAIRE ",
				"524 -- BANQUES HORS ZONE MONETAIRE ",
				"526 -- BANQUES, INTERETS COURUS ",		
				"53 - ÉTABLISSEMENTS FINANCIERS ET ASSIMILÉS ",
				"531 -- CHÈQUES POSTAUX ",
				"532 -- TRÉSOR ",
				"533 -- SOCIÉTÉS DE GESTION ET D'INTERMÉDIATION (S.G.I.) ",
				"536 -- ETABLISSEMENTS FINANCIERS, INTERETS COURUS ",
				"538 -- AUTRES ORGANISMES FINANCIERS ",
				"54 - INSTRUMENTS DE TRÉSORERIE ",
				"541 -- OPTIONS DE TAUX D'INTÉRÊT ",
				"542 -- OPTIONS DE TAUX DE CHANGE ",
				"543 -- OPTIONS DE TAUX BOURSIERS ",
				"544 -- INSTRUMENTS DE MARCHÉS À TERME ",
				"545 -- AVOIRS D'OR ET AUTRES MÉTAUX PRÉCIEUX ",
				"56 - BANQUES, CRÉDITS DE TRÉSORERIE ET D'ESCOMPTE ",
				"561 -- CRÉDITS DE TRÉSORERIE ",
				"564 -- ESCOMPTE DE CRÉDITS DE CAMPAGNE ",
				"565 -- ESCOMPTE DE CRÉDITS ORDINAIRES ",
				"566 -- BANQUES, CREDITS DE TRESORERIE, INTERETS COURUS ",
				"57 - CAISSE ",
				"571 -- CAISSE SIÈGE SOCIAL ",
				"5711 --- en unités monétaires légales ",
				"5712 --- en devises ",
				"572 -- CAISSE SUCCURSALE A ",
				"5721 --- en unités monétaires légales ",
				"5722 --- en devises ",
				"573 -- CAISSE SUCCURSALE B ",
				"5731 --- en unités monétaires légales ",
				"5732 --- en devises ",
				"58 - RÉGIES D'AVANCES, ACCRÉDITIFS ET VIREMENTS INTERNES ",
				"581 -- RÉGIES D'AVANCE", 
				"582 -- ACCRÉDITIFS ",
				"585 -- VIREMENTS DE FONDS ",
				"588 -- AUTRES VIREMENTS INTERNES ",
				"59 - DÉPRÉCIATIONS ET RISQUES PROVISIONNÉS ",
				"590 -- DÉPRÉCIATIONS DES TITRES DE PLACEMENT ",
				"591 -- DÉPRÉCIATIONS DES TITRES ET VALEURS À ENCAISSER ",
				"592 -- DÉPRÉCIATIONS DES COMPTES BANQUES ",
				"593 -- DÉPRÉCIATIONS DES COMPTES ÉTABLISSEMENTS FINANCIERS ET ASSIMILÉS ",
				"594 -- DÉPRÉCIATIONS DES COMPTES D’INSTRUMENTS DE TRÉSORERIE ",
				"599 -- RISQUES PROVISIONNÉS À CARACTÈRE FINANCIER ",
		};
		lv = (ListView) findViewById(R.id.liste_comptes_tresorerie);
        inputSearch = (EditText) findViewById(R.id.Recherche_tresorerie);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nom_compte, liste_tresorerie);
        lv.setAdapter(adapter);
        
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                Tresorerie.this.adapter.getFilter().filter(cs);  
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
		getMenuInflater().inflate(R.menu.tresorerie, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		
		
		if (item.getItemId() == R.id.action_settings) {
       	startActivity(new Intent(this, About.class));
         }
		
		return super.onOptionsItemSelected(item);
		
	}

}
