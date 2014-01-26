package com.gdg.miagegi.syscohada;

import java.util.ArrayList;
import java.util.HashMap;

import com.gdg.miagegi.syscohada.Produits;
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

public class Produits extends Activity {

	private ListView lv;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<	String, String>> productList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produits);
		String liste_produits[] =  {
				"70 - VENTES ",
				"701 -- VENTES DE MARCHANDISES ",
				"7011 --- dans la Région ",
				"7012 --- hors Région", 
				"7013 --- aux entreprises du groupe dans la Région ",
				"7014 --- aux entreprises du groupe hors Région ",
				"702 -- VENTES DE PRODUITS FINIS ",
				"7021 --- dans la Région", 
				"7022 --- hors Région", 
				"7023 --- aux entreprises du groupe dans la Région ",
				"7024 --- aux entreprises du groupe hors Région ",
				"703 -- VENTES DE PRODUITS INTERMÉDIAIRES ",
				"7031 --- dans la Région", 
				"7032 --- hors Région", 
				"7033 --- aux entreprises du groupe dans la Région ",
				"7034 --- aux entreprises du groupe hors Région ",
				"704 -- VENTES DE PRODUITS RÉSIDUELS ",
				"7041 --- dans la Région", 
				"7042 --- hors Région", 
				"7043 --- aux entreprises du groupe dans la Région ",
				"7044 --- aux entreprises du groupe hors Région ",
				"705 -- TRAVAUX FACTURÉS ",
				"7051 --- dans la Région", 
				"7052 --- hors Région",
				"7053 --- aux entreprises du groupe dans la Région ",
				"7054 --- aux entreprises du groupe hors Région ",
				"706 -- SERVICES VENDUS ",
				"7061 --- dans la Région", 
				"7062 --- hors Région", 
				"7063 --- aux entreprises du groupe dans la Région ",
				"7064 --- aux entreprises du groupe hors Région ",
				"707 -- PRODUITS ACCESSOIRES ",
				"7071 --- Ports, emballages perdus et autres frais facturés ",
				"7072 --- Commissions et courtages",
				"7073 --- Locations", 
				"7074 --- Bonis sur reprises et cessions d'emballages ",
				"7075 --- Mise à disposition de personnel", 
				"7076 --- Redevances pour brevets, logiciels,marques et droits similaires", 
				"7077 --- Services exploités dans l'intérêt du personnel ",
				"7078 --- Autres produits accessoires ",
				"71 - SUBVENTIONS D'EXPLOITATION ",
				"711 -- SUR PRODUITS À L'EXPORTATION ",
				"712 -- SUR PRODUITS À L'IMPORTATION ",
				"713 -- SUR PRODUITS DE PÉRÉQUATION ",
				"718 -- AUTRES SUBVENTIONS D'EXPLOITATION ",
				"7181 --- Versées par l'État et les collectivités publiques ",
				"7182 --- Versées par les organismes internationaux ",
				"7183 --- Versées par des tiers ",
				"72 - PRODUCTION IMMOBILISÉE ",
				"721 -- IMMOBILISATIONS INCORPORELLES ",
				"722 -- IMMOBILISATIONS CORPORELLES ",
				"726 -- IMMOBILISATIONS FINANCIÈRES ",
				"73 - VARIATIONS DES STOCKS DE BIENS ET DE SERVICES PRODUITS ",
				"734 -- VARIATIONS DES STOCKS DE PRODUITS EN COURS ",
				"7341 --- Produits en cours ",
				"7342 --- Travaux en cours ",
				"735 -- VARIATIONS DES EN-COURS DE SERVICES ",
				"7351 --- Études en cours  ",
				"7352 --- Prestations de services en cours", 
				"736 -- VARIATIONS DES STOCKS DE PRODUITS FINIS ",
				"737 -- VARIATIONS DES STOCKS DE PRODUITS INTERMÉDIAIRES ET RÉSIDUELS ",
				"7371 --- Produits intermédiaires ",
				"7372 --- Produits résiduels ",
				"75 - AUTRES PRODUITS ",
				"752 -- QUOTE-PART DE RÉSULTAT SUR OPÉRATIONS FAITES EN COMMUN",
				"7521 --- Quote-part transférée de pertes (comptabilité du gérant) ",
				"7525 --- Bénéfices attribués par transfert (comptabilité des associés non gérants) ",
				"753 -- QUOTE-PART DE RÉSULTAT SUR EXÉCUTION PARTIELLE DE CONTRATS PLURI-EXERCICES",
				"754 -- PRODUITS DES CESSIONS COURANTES D'IMMOBILISATIONS ",
				"758 -- PRODUITS DIVERS ",
				"7581 --- Jetons de présence et autres rémunérations d'administrateurs ",
				"7582 --- Indemnités d’assurances reçues ",
				"759 -- REPRISES DE CHARGES PROVISIONNÉES D'EXPLOITATION",
				"7591 --- sur risques à court terme ",
				"7593 --- sur stocks ",
				"7594 --- sur créances ",
				"7598 --- sur autres charges provisionnées ",
				"77 - REVENUS FINANCIERS ET PRODUITS ASSIMILÉS",
				"771 -- INTÉRÊTS DE PRÊTS",
				"772 -- REVENUS DE PARTICIPATIONS ",
				"773 -- ESCOMPTES OBTENUS ",
				"774 -- REVENUS DE TITRES DE PLACEMENT ",
				"776 -- GAINS DE CHANGE ",
				"777 -- GAINS SUR CESSIONS DE TITRES DE PLACEMENT ",
				"778 -- GAINS SUR RISQUES FINANCIERS ",
				"7781 --- sur rentes viagères ",
				"7782 --- sur opérations financières ",
				"7784 --- sur instruments de trésorerie ",
				"779 -- REPRISES DE CHARGES PROVISIONNÉES FINANCIÈRES ",
				"7791 --- sur risques financiers ",
				"7795 --- sur titres de placement  ",
				"7798 --- autres charges provisionnées financières ",
				"78 - TRANSFERTS DE CHARGES ",
				"781 -- TRANSFERTS DE CHARGES D'EXPLOITATION ",
				"787 -- TRANSFERTS DE CHARGES FINANCIERES ",
				"79 - REPRISES DE PROVISIONS ",
				"791 -- REPRISES DE PROVISIONS D'EXPLOITATION ",
				"7911 --- pour risques et charges ",
				"7912 --- pour grosses réparations ",
				"7913 --- pour dépréciation des immobilisations incorporelles ",
				"7914 --- pour dépréciation des immobilisations corporelles ",
				"797 -- REPRISES DE PROVISIONS FINANCIÈRES ",
				"7971 --- pour risques et charges ",
				"7972 --- pour dépréciation des immobilisations financières ",
				"798 -- REPRISES D'AMORTISSEMENTS " ,
		};
		lv = (ListView) findViewById(R.id.liste_comptes_produits);
        inputSearch = (EditText) findViewById(R.id.Recherche_produits);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nom_compte, liste_produits);
        lv.setAdapter(adapter);
        
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                Produits.this.adapter.getFilter().filter(cs);  
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
		getMenuInflater().inflate(R.menu.produits, menu);
		return true;
	}
	
public boolean onOptionsItemSelected(MenuItem item){
		
		
		if (item.getItemId() == R.id.action_settings) {
       	startActivity(new Intent(this, About.class));
         }
		
		return super.onOptionsItemSelected(item);
		
	}
}
