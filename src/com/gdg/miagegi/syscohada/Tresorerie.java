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
				"501 -- TITRES DU TR�SOR ET BONS DE CAISSE � COURT TERME ",
				"5011 --- Titres du Tr�sor � court terme ",
				"5012 --- Titres d'organismes financiers ",
				"5013 --- Bons de caisse � court terme ",
				"502 -- ACTIONS ",
				"5021 --- Actions propres ",
				"5022 --- Actions cot�es ",
				"5023 --- Actions non cot�es ",
				"5024 --- Actions d�membr�es (certificats d'investissement ; droits de vote) ",
				"5025 --- Autres titres conf�rant un droit de propri�t� ",
				"503 -- OBLIGATIONS ",
				"5031 --- Obligations �mises par la soci�t� et rachet�es par elle ",
				"5032 --- Obligations cot�es ",
				"5033 --- Obligations non cot�es ",
				"5035 --- Autres titres conf�rant un droit de cr�ance  ",
				"504 -- BONS DE SOUSCRIPTION ",
				"5042 --- Bons de souscription d'actions ",
				"5043 --- Bons de souscription d'obligations ",
				"505 -- TITRES N�GOCIABLES HORS REGION ",
				"506 -- INT�R�TS COURUS ",
				"5061 --- Titres du Tr�sor et bons de caisse � court terme ",
				"5062 --- Actions ",
				"5063 --- Obligations ",
				"508 -- AUTRES VALEURS ASSIMIL�ES", 
				"51 - VALEURS � ENCAISSER ",
				"511 -- EFFETS � ENCAISSER ",
				"512 -- EFFETS � L'ENCAISSEMENT ",
				"513 -- CH�QUES � ENCAISSER ",
				"514 -- CH�QUES � L'ENCAISSEMENT ",
				"515 -- CARTES DE CR�DIT � ENCAISSER ",
				"518 -- AUTRES VALEURS � L'ENCAISSEMENT ",
				"5181 --- Warrants ",
				"5182 --- Billets de fonds ",
				"5185 --- Ch�ques de voyage ",
				"5186 --- Coupons �chus ",
				"5187 --- Int�r�ts �chus des obligations ",
				"52 - BANQUES ",
				"521 -- BANQUES LOCALES ",
				"5211 --- BANQUES X ",
				"5212 --- BANQUE Y ",
				"522 -- BANQUES AUTRES �TATS REGION ",
				"523 -- BANQUES AUTRES ETATS ZONE MONETAIRE ",
				"524 -- BANQUES HORS ZONE MONETAIRE ",
				"526 -- BANQUES, INTERETS COURUS ",		
				"53 - �TABLISSEMENTS FINANCIERS ET ASSIMIL�S ",
				"531 -- CH�QUES POSTAUX ",
				"532 -- TR�SOR ",
				"533 -- SOCI�T�S DE GESTION ET D'INTERM�DIATION (S.G.I.) ",
				"536 -- ETABLISSEMENTS FINANCIERS, INTERETS COURUS ",
				"538 -- AUTRES ORGANISMES FINANCIERS ",
				"54 - INSTRUMENTS DE TR�SORERIE ",
				"541 -- OPTIONS DE TAUX D'INT�R�T ",
				"542 -- OPTIONS DE TAUX DE CHANGE ",
				"543 -- OPTIONS DE TAUX BOURSIERS ",
				"544 -- INSTRUMENTS DE MARCH�S � TERME ",
				"545 -- AVOIRS D'OR ET AUTRES M�TAUX PR�CIEUX ",
				"56 - BANQUES, CR�DITS DE TR�SORERIE ET D'ESCOMPTE ",
				"561 -- CR�DITS DE TR�SORERIE ",
				"564 -- ESCOMPTE DE CR�DITS DE CAMPAGNE ",
				"565 -- ESCOMPTE DE CR�DITS ORDINAIRES ",
				"566 -- BANQUES, CREDITS DE TRESORERIE, INTERETS COURUS ",
				"57 - CAISSE ",
				"571 -- CAISSE SI�GE SOCIAL ",
				"5711 --- en unit�s mon�taires l�gales ",
				"5712 --- en devises ",
				"572 -- CAISSE SUCCURSALE A ",
				"5721 --- en unit�s mon�taires l�gales ",
				"5722 --- en devises ",
				"573 -- CAISSE SUCCURSALE B ",
				"5731 --- en unit�s mon�taires l�gales ",
				"5732 --- en devises ",
				"58 - R�GIES D'AVANCES, ACCR�DITIFS ET VIREMENTS INTERNES ",
				"581 -- R�GIES D'AVANCE", 
				"582 -- ACCR�DITIFS ",
				"585 -- VIREMENTS DE FONDS ",
				"588 -- AUTRES VIREMENTS INTERNES ",
				"59 - D�PR�CIATIONS ET RISQUES PROVISIONN�S ",
				"590 -- D�PR�CIATIONS DES TITRES DE PLACEMENT ",
				"591 -- D�PR�CIATIONS DES TITRES ET VALEURS � ENCAISSER ",
				"592 -- D�PR�CIATIONS DES COMPTES BANQUES ",
				"593 -- D�PR�CIATIONS DES COMPTES �TABLISSEMENTS FINANCIERS ET ASSIMIL�S ",
				"594 -- D�PR�CIATIONS DES COMPTES D�INSTRUMENTS DE TR�SORERIE ",
				"599 -- RISQUES PROVISIONN�S � CARACT�RE FINANCIER ",
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
