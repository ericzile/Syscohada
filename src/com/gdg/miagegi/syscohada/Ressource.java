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
				"1011 --- Capital souscrit, non appel�",
				"1012 --- Capital souscrit, appel�, non vers�",
				"1013 --- Capital souscrit, appel�, vers�, non amorti",
				"1014 --- Capital souscrit, appel�, vers�, amorti ",
				"1018 --- Capital souscrit soumis � des conditions particuli�res ",
				"102 -- CAPITAL PAR DOTATION ",
				"1021 --- Dotation initiale ",
				"1022 --- Dotations compl�mentaires ",
				"1028 --- Autres dotations ",
				"103 -- CAPITAL PERSONNEL ",
				"104 -- COMPTE DE L'EXPLOITANT ",
				"1041 --- Apports temporaires ",
				"1042 --- Op�rations courantes ",
				"1043 --- R�mun�rations, imp�ts et autres charges personnelles ",
				"1047 --- Pr�l�vements d�autoconsommation ",
				"1048 --- Autres pr�l�vements ",
				"105 -- PRIMES LI�ES AUX CAPITAUX PROPRES ",
				"1051 --- Primes d'�mission ",
				"1052 --- Primes d'apport ",
				"1053 --- Primes de fusion ",
				"1054 --- Primes de conversion ",
				"1058 --- Autres primes ",
				"106 -- �CARTS DE R��VALUATION ",
				"1061 --- �carts de r��valuation l�gale ",
				"1062 --- �carts de r��valuation libre ",
				"109 -- ACTIONNAIRES, CAPITAL SOUSCRIT, NON APPEL� ",
				"11 - R�SERVES ",
				"111 -- R�SERVE L�GALE",
				"112 -- R�SERVES STATUTAIRES OU CONTRACTUELLES",
				"113 -- R�SERVES R�GLEMENT�ES ",
				"1131 --- R�serves de plus-values nettes � long terme ",
				"1133 --- R�serves cons�cutives � l'octroi de subventions d'investissement ",
				"1138 --- Autres r�serves r�glement�es ",
				"118 -- AUTRES R�SERVES ",
				"1181 --- R�serves facultatives ",
				"1188 --- R�serves diverses ",
				"12 -- REPORT � NOUVEAU ",
				"121 -- REPORT � NOUVEAU CR�DITEUR ",
				"129 --REPORT � NOUVEAU D�BITEUR ",
				"1291 --- Perte nette � reporter ",
				"1292 --- Perte - Amortissements r�put�s diff�r�s ",
				"13 - R�SULTAT NET DE L'EXERCICE",
				"130 -- R�SULTAT EN INSANCE D�AFFECTATION ",
				"1301 --- R�sultat en instance d'affectation : B�n�fice ",
				"1309 --- R�sultat en instance d'affectation : Perte ",
				"131 -- R�SULTAT NET : B�N�FICE ",
				"132 -- MARGE BRUTE (M.B.) ",
				"1321 --- Marge brute sur marchandises ",
				"1322 --- Marge brute sur mati�res ",
				"133 -- VALEUR AJOUT�E (V.A.) ",
				"134 -- EXC�DENT BRUT D'EXPLOITATION (E.B.E.) ",
				"135 -- R�SULTAT D'EXPLOITATION (R.E.) ",
				"136 -- R�SULTAT FINANCIER (R.F.) ",
				"137 -- R�SULTAT DES ACTIVIT�S ORDINAIRES (R.A.O.) ",
				"138 -- R�SULTAT HORS ACTIVIT�S ORDINAIRES (R.H.A.O.) ",
				"139 -- R�SULTAT NET : PERTE ",
				"14 - SUBVENTIONS D'INVESTISSEMENT ",
				"141 -- SUBVENTIONS D'�QUIPEMENT A ",
				"1411 --- �tat ",
				"1412 --- R�gions ",
				"1413 --- D�partements ",
				"1414 --- Communes et collectivit�s publiques d�centralis�es ",
				"1415 --- Entreprises publiques ou mixtes  ",
				"1416 --- Entreprises et organismes priv�s ",
				"1417 --- Organismes internationaux ",
				"1418 --- Autres ",
				"142 -- SUBVENTIONS D'�QUIPEMENT B ",
				"148 -- AUTRES SUBVENTIONS D'INVESTISSEMENT ",
				"15 - PROVISIONS R�GLEMENT�ESET FONDS ASSIMIL�S ",
				"151 -- AMORTISSEMENTS D�ROGATOIRES ",
				"152 -- PLUS-VALUES DE CESSION � R�INVESTIR ",
				"153 -- FONDS R�GLEMENT�S ",
				"1531 --- Fonds National",
				"1532 --- Pr�l�vement pour le Budget ",
				"154 -- PROVISION SP�CIALE DE R��VALUATION ",
				"155 -- PROVISIONS R�GLEMENT�ES RELATIVES AUX IMMOBILISATIONS ",
				"1551 --- Reconstitution des gisements miniers et p�troliers ",
				"156 -- PROVISIONS R�GLEMENT�ES RELATIVES AUX STOCKS ",
				"1561 --- Hausse de prix ",
				"1562 --- Fluctuation des cours ",
				"157 -- PROVISIONS POUR INVESTISSEMENT ",
				"158 -- AUTRES PROVISIONS ET FONDS R�GLEMENTES ",
				"16 - EMPRUNTS ET DETTES ASSIMIL�ES ",
				"161 -- EMPRUNTS OBLIGATAIRES",
				"1611 --- Emprunts obligataires ordinaires ",
				"1612 --- Emprunts obligataires convertibles ",
				"1618 --- Autres emprunts obligataires ",
				"162 -- EMPRUNTS ET DETTES AUPR�S DES �TABLISSEMENTS DE CR�DIT ",
				"163 -- AVANCES RE�UES DE L'�TAT ",
				"164 -- AVANCES RE�UES ET COMPTES COURANTS BLOQU�S",
				"165 -- D�P�TS ET CAUTIONNEMENTS RECUS ",
				"1651 --- D�p�ts ",
				"1652 --- Cautionnements",
				"166 --- INT�R�TS COURUS ",
				"1661 --- sur emprunts obligataires ",
				"1662 --- sur emprunts et dettes aupr�s des �tablissements de cr�dit ",
				"1663 --- sur avances re�ues de l'�tat ",
				"1664 --- sur avances re�ues et comptes courants bloqu�s ",
				"1665 --- sur d�p�ts et cautionnements re�us ",
				"1667 --- sur avances assorties de conditions particuli�res ",
				"1668 --- sur autres emprunts et dettes ",
				"167 -- AVANCES ASSORTIES DE CONDITIONS PARTICULI�RES ",
				"1671 --- Avances bloqu�es pour augmentation du capital ",
				"1672 --- Avances conditionn�es par l'�tat ",
				"1673 --- Avances conditionn�es par les autres organismes africains ",
				"1674 --- Avances conditionn�es par les organismes internationaux ",
				"1676 --- Droits du conc�dant exigibles en nature",
				"168 -- AUTRES EMPRUNTS ET DETTES ",
				"1681 --- Rentes viag�res capitalis�es ",
				"1682 --- Billets de fonds",
				"1683 --- Dettes cons�cutives � des titres emprunt�s ",
				"1684 --- Dettes du conc�dant exigibles en nature ",
				"1685 --- Emprunts participatifs",
				"1686 --- Participation des travailleurs aux b�n�fices ",
				"17 - DETTES DE CR�DIT - BAIL ET CONTRATS ASSIMIL�S ",
				"172 -- EMPRUNTS �QUIVALENTS DE CR�DIT - BAIL IMMOBILIER",
				"173 -- EMPRUNTS �QUIVALENTS DE CR�DIT - BAIL MOBILIER ",
				"176 -- INT�R�TS COURUS",
				"1762 --- sur emprunts �quivalents de cr�dit � bail immobilier",
				"1763 --- sur emprunts �quivalents de cr�dit � bail mobilier ",
				"1768 --- sur emprunts �quivalents d�autres contrats ",
				"178 -- EMPRUNTS �QUIVALENTSD�AUTRES CONTRATS ",
				"18 - DETTES LI�ES � DES PARTICIPATIONS ET COMPTES DE LIAISON DES �TABLISSEMENTS ET SOCI�T�S EN PARTICIPATION ",
				"181 -- DETTES LI�ES � DES PARTICIPATIONS ",
				"1811 --- Dettes li�es � des participations (groupe) ",
				"1812 --- Dettes li�es � des participations (hors groupe) ",
				"182 --- DETTES LI�ES � DES SOCI�T�S EN PARTICIPATION ",
				"183 --- INT�R�TS COURUS SUR DETTES LI�ES � DES PARTICIPATIONS ",
				"184 --- COMPTES PERMANENTS BLOQU�S DES �TABLISSEMENTS ET SUCCURSALES  ",
				"185 --- COMPTES PERMANENTS NON BLOQU�S DES �TABLISSEMENTS ET SUCCURSALES ",
				"186 -- COMPTES DE LIAISON CHARGES ",
				"187 -- COMPTES DE LIAISON PRODUITS ",
				"188 -- COMPTES DE LIAISON DES SOCI�T�S EN PARTICIPATION",
				"19 - PROVISIONS FINANCIERES POUR RISQUES ET CHARGES ",
				"191 -- PROVISIONS POUR LITIGES",
				"192 -- PROVISIONS POUR GARANTIES DONN�ES AUX CLIENTS ",
				"193 -- PROVISIONS POUR PERTES SUR MARCH�S � ACH�VEMENT FUTUR ",
				"194 -- PROVISIONS POUR PERTES DE CHANGE",
				"195 -- PROVISIONS POUR IMP�TS ",
				"196 -- PROVISIONS POUR PENSIONS ET OBLIGATIONS SIMILAIRES ",
				"197 -- PROVISIONS POUR CHARGES � REPARTIR SUR PLUSIEURS EXERCICES ",
				"1971 --- Provisions pour grosses r�parations ",
				"198 -- AUTRES PROVISIONS FINANCI�RES POUR RISQUES ET CHARGES ",
				"1981 --- Provisions pour amendes et p�nalit�s ",
				"1982 --- Provisions pour renouvellement des immobilisations (entreprises concessionnaires) ",
				"1983 --- Provisions de propre assureur ",
				"1988 --- Autres provisions financi�res pour risques et charges ",
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
