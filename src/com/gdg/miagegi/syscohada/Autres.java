package com.gdg.miagegi.syscohada;

import java.util.ArrayList;
import java.util.HashMap;

import com.gdg.miagegi.syscohada.Autres;
import com.gdg.miagegi.syscohada.R;

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

public class Autres extends Activity {

	private ListView lv;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<	String, String>> productList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_autres);
		String liste_autres[] = {
				"81 - VALEURS COMPTABLES DES CESSIONS D'IMMOBILISATIONS ",
				"811 -- IMMOBILISATIONS INCORPORELLES ",
				"812 -- IMMOBILISATIONS CORPORELLES ",
				"816 -- IMMOBILISATIONS FINANCIÈRES ",
				"82 - PRODUITS DES CESSIONSD'IMMOBILISATIONS ",
				"821 -- IMMOBILISATIONS INCORPORELLES ",
				"822 -- IMMOBILISATIONS CORPORELLES ",
				"826 -- IMMOBILISATIONS FINANCIÈRES  ", 	
				"83 - CHARGES HORS ACTIVITÉS ORDINAIRES ",
				"831 -- CHARGES H.A.O. CONSTATÉES ",
				"834 -- PERTES SUR CRÉANCES H.A.O. ",
				"835 -- DONS ET LIBÉRALITÉS ACCORDÉS ",
				"836 -- ABANDONS DE CRÉANCES CONSENTIS ",
				"839 -- CHARGES PROVISIONNÉES H.A.O. ",
				"84 - PRODUITS HORS ACTIVITÉS ORDINAIRES ",
				"841 -- PRODUITS H.A.O CONSTATÉS ",
				"845 -- DONS ET LIBÉRALITÉS OBTENUS ",
				"846 -- ABANDONS DE CRÉANCES OBTENUS ",
				"848 -- TRANSFERTS DE CHARGES H.A.O ",
				"849 -- REPRISES DES CHARGES PROVISIONNÉES H.A.O. ",
				"85 - DOTATIONS HORS ACTIVITÉS ORDINAIRES ",
				"851 -- DOTATIONS AUX PROVISIONS RÉGLEMENTÉES ",
				"852 -- DOTATIONS AUX AMORTISSEMENTS H.A.O. ",
				"853 -- DOTATIONS AUX PROVISIONS POUR DÉPRÉCIATION H.A.O. ",
				"854 -- DOTATIONS AUX PROVISIONS POUR RISQUES ET CHARGES H.A.O. ",
				"858 -- AUTRES DOTATIONS H.A.O. ",
				"86 - REPRISES HORS ACTIVITÉS ORDINAIRES ",
				"861 -- REPRISES DE PROVISIONS RÉGLEMENTÉES ",
				"862 -- REPRISES D’AMORTISSEMENTS ",
				"863 -- REPRISES DE PROVISIONS POUR DÉPRÉCIATION H.A.O. ",
				"864 -- REPRISES DE PROVISIONS POUR RISQUES ET CHARGES H.A.O. ",
				"865 -- REPRISES DE SUBVENTIONS D’INVESTISSEMENT ",
				"868 -- AUTRES REPRISES H.A.O. ",
				"87 - PARTICIPATION DES TRAVAILLEURS", 
				"871 -- PARTICIPATION LÉGALE AUX BÉNÉFICES ",
				"874 -- PARTICIPATION CONTRACTUELLE AUX BÉNÉFICES", 
				"878 -- AUTRES PARTICIPATIONS ",
				"88 - SUBVENTIONS D'ÉQUILIBRE ",
				"881 -- ÉTAT ",
				"884 -- COLLECTIVITÉS PUBLIQUES ",
				"886 -- GROUPE ",
				"888 -- AUTRES  ",
				"89 - IMPÔTS SUR LE RÉSULTAT ",
				"891 -- IMPÔTS SUR LES BÉNÉFICES DE L'EXERCICE ",
				"8911 --- Activités exercées dans l'État ",
				"8912 --- Activités exercées dans les autres États de la Région ",
				"8913 --- Activités exercées hors Région ",
				"892 -- RAPPEL D'IMPÔTS SUR RÉSULTATS ANTÉRIEURS ",
				"895 -- IMPÔT MINIMUM FORFAITAIRE (I.M.F.) ",
				"899 -- DÉGRÈVEMENTS ET ANNULATIONS D’IMPÔTS SUR RÉSULTATS ANTÉRIEURS ",
				"8991 --- Dégrèvements ",
				"8994 --- Annulations pour pertes rétroactives "
		};
		lv = (ListView) findViewById(R.id.liste_comptes_autres);
        inputSearch = (EditText) findViewById(R.id.Recherche_autres);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nom_compte, liste_autres);
        lv.setAdapter(adapter);
        
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
               Autres.this.adapter.getFilter().filter(cs);  
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
		getMenuInflater().inflate(R.menu.autres, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item){
		
		
		if (item.getItemId() == R.id.action_settings) {
       	startActivity(new Intent(this, About.class));
         }
		
		return super.onOptionsItemSelected(item);
		
	}
}
