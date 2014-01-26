package com.gdg.miagegi.syscohada;

import java.util.ArrayList;
import java.util.HashMap;

import com.gdg.miagegi.syscohada.R;
import com.gdg.miagegi.syscohada.Ressource;

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

public class Ressource extends Activity {

	private ListView lv;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<	String, String>> productList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ressource);
		String liste_ressources[] = {
				"10 - CAPITAL",
				"101 -- CAPITAL SOCIAL",
				"1011 --- Capital souscrit, non appelé",
				"1012 --- Capital souscrit, appelé, non versé",
				"1013 --- Capital souscrit, appelé, versé, non amorti",
				"1014 --- Capital souscrit, appelé, versé, amorti ",
				"1018 --- Capital souscrit soumis à des conditions particulières ",
				"102 -- CAPITAL PAR DOTATION ",
				"1021 --- Dotation initiale ",
				"1022 --- Dotations complémentaires ",
				"1028 --- Autres dotations ",
				"103 -- CAPITAL PERSONNEL ",
				"104 -- COMPTE DE L'EXPLOITANT ",
				"1041 --- Apports temporaires ",
				"1042 --- Opérations courantes ",
				"1043 --- Rémunérations, impôts et autres charges personnelles ",
				"1047 --- Prélèvements d’autoconsommation ",
				"1048 --- Autres prélèvements ",
				"105 -- PRIMES LIÉES AUX CAPITAUX PROPRES ",
				"1051 --- Primes d'émission ",
				"1052 --- Primes d'apport ",
				"1053 --- Primes de fusion ",
				"1054 --- Primes de conversion ",
				"1058 --- Autres primes ",
				"106 -- ÉCARTS DE RÉÉVALUATION ",
				"1061 --- Écarts de réévaluation légale ",
				"1062 --- Écarts de réévaluation libre ",
				"109 -- ACTIONNAIRES, CAPITAL SOUSCRIT, NON APPELÉ ",
				"11 - RÉSERVES ",
				"111 -- RÉSERVE LÉGALE",
				"112 -- RÉSERVES STATUTAIRES OU CONTRACTUELLES",
				"113 -- RÉSERVES RÉGLEMENTÉES ",
				"1131 --- Réserves de plus-values nettes à long terme ",
				"1133 --- Réserves consécutives à l'octroi de subventions d'investissement ",
				"1138 --- Autres réserves réglementées ",
				"118 -- AUTRES RÉSERVES ",
				"1181 --- Réserves facultatives ",
				"1188 --- Réserves diverses ",
				"12 -- REPORT À NOUVEAU ",
				"121 -- REPORT À NOUVEAU CRÉDITEUR ",
				"129 --REPORT À NOUVEAU DÉBITEUR ",
				"1291 --- Perte nette à reporter ",
				"1292 --- Perte - Amortissements réputés différés ",
				"13 - RÉSULTAT NET DE L'EXERCICE",
				"130 -- RÉSULTAT EN INSANCE D’AFFECTATION ",
				"1301 --- Résultat en instance d'affectation : Bénéfice ",
				"1309 --- Résultat en instance d'affectation : Perte ",
				"131 -- RÉSULTAT NET : BÉNÉFICE ",
				"132 -- MARGE BRUTE (M.B.) ",
				"1321 --- Marge brute sur marchandises ",
				"1322 --- Marge brute sur matières ",
				"133 -- VALEUR AJOUTÉE (V.A.) ",
				"134 -- EXCÉDENT BRUT D'EXPLOITATION (E.B.E.) ",
				"135 -- RÉSULTAT D'EXPLOITATION (R.E.) ",
				"136 -- RÉSULTAT FINANCIER (R.F.) ",
				"137 -- RÉSULTAT DES ACTIVITÉS ORDINAIRES (R.A.O.) ",
				"138 -- RÉSULTAT HORS ACTIVITÉS ORDINAIRES (R.H.A.O.) ",
				"139 -- RÉSULTAT NET : PERTE ",
				"14 - SUBVENTIONS D'INVESTISSEMENT ",
				"141 -- SUBVENTIONS D'ÉQUIPEMENT A ",
				"1411 --- État ",
				"1412 --- Régions ",
				"1413 --- Départements ",
				"1414 --- Communes et collectivités publiques décentralisées ",
				"1415 --- Entreprises publiques ou mixtes  ",
				"1416 --- Entreprises et organismes privés ",
				"1417 --- Organismes internationaux ",
				"1418 --- Autres ",
				"142 -- SUBVENTIONS D'ÉQUIPEMENT B ",
				"148 -- AUTRES SUBVENTIONS D'INVESTISSEMENT ",
				"15 - PROVISIONS RÉGLEMENTÉESET FONDS ASSIMILÉS ",
				"151 -- AMORTISSEMENTS DÉROGATOIRES ",
				"152 -- PLUS-VALUES DE CESSION À RÉINVESTIR ",
				"153 -- FONDS RÉGLEMENTÉS ",
				"1531 --- Fonds National",
				"1532 --- Prélèvement pour le Budget ",
				"154 -- PROVISION SPÉCIALE DE RÉÉVALUATION ",
				"155 -- PROVISIONS RÉGLEMENTÉES RELATIVES AUX IMMOBILISATIONS ",
				"1551 --- Reconstitution des gisements miniers et pétroliers ",
				"156 -- PROVISIONS RÉGLEMENTÉES RELATIVES AUX STOCKS ",
				"1561 --- Hausse de prix ",
				"1562 --- Fluctuation des cours ",
				"157 -- PROVISIONS POUR INVESTISSEMENT ",
				"158 -- AUTRES PROVISIONS ET FONDS RÉGLEMENTES ",
				"16 - EMPRUNTS ET DETTES ASSIMILÉES ",
				"161 -- EMPRUNTS OBLIGATAIRES",
				"1611 --- Emprunts obligataires ordinaires ",
				"1612 --- Emprunts obligataires convertibles ",
				"1618 --- Autres emprunts obligataires ",
				"162 -- EMPRUNTS ET DETTES AUPRÈS DES ÉTABLISSEMENTS DE CRÉDIT ",
				"163 -- AVANCES REÇUES DE L'ÉTAT ",
				"164 -- AVANCES REÇUES ET COMPTES COURANTS BLOQUÉS",
				"165 -- DÉPÔTS ET CAUTIONNEMENTS RECUS ",
				"1651 --- Dépôts ",
				"1652 --- Cautionnements",
				"166 --- INTÉRÊTS COURUS ",
				"1661 --- sur emprunts obligataires ",
				"1662 --- sur emprunts et dettes auprès des établissements de crédit ",
				"1663 --- sur avances reçues de l'État ",
				"1664 --- sur avances reçues et comptes courants bloqués ",
				"1665 --- sur dépôts et cautionnements reçus ",
				"1667 --- sur avances assorties de conditions particulières ",
				"1668 --- sur autres emprunts et dettes ",
				"167 -- AVANCES ASSORTIES DE CONDITIONS PARTICULIÈRES ",
				"1671 --- Avances bloquées pour augmentation du capital ",
				"1672 --- Avances conditionnées par l'État ",
				"1673 --- Avances conditionnées par les autres organismes africains ",
				"1674 --- Avances conditionnées par les organismes internationaux ",
				"1676 --- Droits du concédant exigibles en nature",
				"168 -- AUTRES EMPRUNTS ET DETTES ",
				"1681 --- Rentes viagères capitalisées ",
				"1682 --- Billets de fonds",
				"1683 --- Dettes consécutives à des titres empruntés ",
				"1684 --- Dettes du concédant exigibles en nature ",
				"1685 --- Emprunts participatifs",
				"1686 --- Participation des travailleurs aux bénéfices ",
				"17 - DETTES DE CRÉDIT - BAIL ET CONTRATS ASSIMILÉS ",
				"172 -- EMPRUNTS ÉQUIVALENTS DE CRÉDIT - BAIL IMMOBILIER",
				"173 -- EMPRUNTS ÉQUIVALENTS DE CRÉDIT - BAIL MOBILIER ",
				"176 -- INTÉRÊTS COURUS",
				"1762 --- sur emprunts équivalents de crédit – bail immobilier",
				"1763 --- sur emprunts équivalents de crédit – bail mobilier ",
				"1768 --- sur emprunts équivalents d’autres contrats ",
				"178 -- EMPRUNTS ÉQUIVALENTSD’AUTRES CONTRATS ",
				"18 - DETTES LIÉES À DES PARTICIPATIONS ET COMPTES DE LIAISON DES ÉTABLISSEMENTS ET SOCIÉTÉS EN PARTICIPATION ",
				"181 -- DETTES LIÉES À DES PARTICIPATIONS ",
				"1811 --- Dettes liées à des participations (groupe) ",
				"1812 --- Dettes liées à des participations (hors groupe) ",
				"182 --- DETTES LIÉES À DES SOCIÉTÉS EN PARTICIPATION ",
				"183 --- INTÉRÊTS COURUS SUR DETTES LIÉES À DES PARTICIPATIONS ",
				"184 --- COMPTES PERMANENTS BLOQUÉS DES ÉTABLISSEMENTS ET SUCCURSALES  ",
				"185 --- COMPTES PERMANENTS NON BLOQUÉS DES ÉTABLISSEMENTS ET SUCCURSALES ",
				"186 -- COMPTES DE LIAISON CHARGES ",
				"187 -- COMPTES DE LIAISON PRODUITS ",
				"188 -- COMPTES DE LIAISON DES SOCIÉTÉS EN PARTICIPATION",
				"19 - PROVISIONS FINANCIERES POUR RISQUES ET CHARGES ",
				"191 -- PROVISIONS POUR LITIGES",
				"192 -- PROVISIONS POUR GARANTIES DONNÉES AUX CLIENTS ",
				"193 -- PROVISIONS POUR PERTES SUR MARCHÉS À ACHÈVEMENT FUTUR ",
				"194 -- PROVISIONS POUR PERTES DE CHANGE",
				"195 -- PROVISIONS POUR IMPÔTS ",
				"196 -- PROVISIONS POUR PENSIONS ET OBLIGATIONS SIMILAIRES ",
				"197 -- PROVISIONS POUR CHARGES À REPARTIR SUR PLUSIEURS EXERCICES ",
				"1971 --- Provisions pour grosses réparations ",
				"198 -- AUTRES PROVISIONS FINANCIÈRES POUR RISQUES ET CHARGES ",
				"1981 --- Provisions pour amendes et pénalités ",
				"1982 --- Provisions pour renouvellement des immobilisations (entreprises concessionnaires) ",
				"1983 --- Provisions de propre assureur ",
				"1988 --- Autres provisions financières pour risques et charges ",
		};
		lv = (ListView) findViewById(R.id.liste_comptes_ressources);
        inputSearch = (EditText) findViewById(R.id.Recherche_ressources);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nom_compte, liste_ressources);
        lv.setAdapter(adapter);
        
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                Ressource.this.adapter.getFilter().filter(cs);  
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
		getMenuInflater().inflate(R.menu.ressource, menu);
		return true;
	}

public boolean onOptionsItemSelected(MenuItem item){
		
		
		if (item.getItemId() == R.id.action_settings) {
       	startActivity(new Intent(this, About.class));
         }
		
		return super.onOptionsItemSelected(item);
		
	}
}
