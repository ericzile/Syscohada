package com.gdg.miagegi.syscohada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gdg.miagegi.syscohada.Engagement;
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

public class Engagement extends Activity {

	private ListView lv;
    ArrayAdapter<String> mAdapter;
    EditText inputSearch;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<	String, String>> productList;
     
     
    // ArrayList for Listview
   // ArrayList<HashMap<	String, String>> productList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_engagement);
		
		String liste_engagement[] = {
				"90 - ENGAGEMENTS OBTENUS ET ENGAGEMENTS ACCORD�S",
				"901 -- ENGAGEMENTS DE FINANCEMENT OBTENUS" ,
				"9011 --- Cr�dits confirm�s obtenus ",
				"9012 --- Emprunts restant � encaisser",
				"9013 --- Facilit�s de financement renouvelables", 
				"9014 --- Facilit�s d'�mission ",
				"9018 --- Autres engagements de financement obtenus", 
				"902 --- ENGAGEMENTS DE GARANTIE OBTENUS",
				"9021 --- Avals obtenus",
				"9022 ---bCautions, garanties obtenues", 
				"9023 --- Hypoth�ques obtenues",
				"9024 --- Effets endoss�s par des tiers", 
				"9028 --- Autres garanties obtenues",
				"903 -- ENGAGEMENTS R�CIPROQUES",
				"9031 --- Achats de marchandises � terme", 
				"9032 --- Achats � terme de devises",
				"9033 --- Commandes fermes des clients", 
				"9038 --- Autres engagements r�ciproques", 
				"904 -- AUTRES ENGAGEMENTS OBTENUS",
				"9041 --- Abandons de cr�ances conditionnels", 
				"9043 --- Ventes avec clause de r�serve de propri�t�", 
				"9048 --- Divers engagements obtenus",
				"905 -- ENGAGEMENTS DE FINANCEMENT ACCORD�S", 
				"9051 --- Cr�dits accord�s non d�caiss�s",
				"9058 --- Autres engagements de financement accord�s", 
				"906 -- ENGAGEMENTS DE GARANTIE ACCORD�S",
				"9061 --- Avals accord�s",
				"9062 --- Cautions, garanties accord�es",
				"9063 --- Hypoth�ques accord�es",
				"9064 --- Effets endoss�s par l'entreprise",
				"9068 --- Autres garanties accord�es",
				"907 -- ENGAGEMENTS R�CIPROQUES",
				"9071 --- Ventes de marchandises � terme",
				"9072 --- Ventes � terme de devises",
				"9073 --- Commandes fermes aux fournisseurs", 
				"9078 --- Autres engagements r�ciproques",
				"907 -- AUTRES ENGAGEMENTS ACCORD�S",
				"9081 --- Annulations conditionnelles de dettes", 
				"9082 --- Engagements de retraite",
				"9083 --- Achats avec clause de r�serve de propri�t�",
				"9088 --- Divers engagements accord�s",
				"91 - CONTREPARTIES DES ENGAGEMENTS",
				"911 � 914 -- CONTREPARTIE DES ENGAGEMENTS OBTENUS, 901 � 904",
				"915 � 918 -- CONTREPARTIE DES ENGAGEMENTS ACCORD�S, 905 � 908",
				"92 - COMPTES REFLECHIS",
				"93 - COMPTES DE RECLASSEMENTS", 
				"94 - COMPTES DE CO�TS",
				"95 - COMPTES DE STOCKS", 
				"96 - COMPTES D'ECARTS SUR COUTS PREETABLIS", 
				"97 - COMPTES DE DIFFERENCES DE TRAITEMENT COMPTABLE",  
				"98 - COMPTES DE RESULTATS",
				"99 - COMPTES DE LIAISONS INTERNES",
		};
		
		
	   
    lv = (ListView) findViewById(R.id.liste_comptes_engagement);
    inputSearch = (EditText) findViewById(R.id.Recherche_engagement);
    mAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nom_compte, liste_engagement);
    lv.setAdapter(mAdapter);
    
    inputSearch.addTextChangedListener(new TextWatcher() {
         
        @Override
        public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
            Engagement.this.mAdapter.getFilter().filter(cs);  
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
	getMenuInflater().inflate(R.menu.engagement, menu);
	return true;
}
public boolean onOptionsItemSelected(MenuItem item){
	
	
	if (item.getItemId() == R.id.action_settings) {
   	startActivity(new Intent(this, About.class));
     }
	
	return super.onOptionsItemSelected(item);
	
}
}
