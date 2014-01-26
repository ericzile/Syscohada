package com.gdg.miagegi.syscohada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gdg.miagegi.syscohada.Actif;
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

public class Actif extends Activity {

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
		setContentView(R.layout.activity_actif);
		
		String liste_actifs[] = {
				"20 - CHARGES IMMOBILIS�ES ",
				"201 -- FRAIS D'�TABLISSEMENT ",
				"2011 --- Frais de constitution  ",
				"2012 --- Frais de prospection ",
				"2013 --- Frais de publicit� et de lancement ",
				"2014 --- Frais de fonctionnement ant�rieurs au d�marrage",
				"2015 --- Frais de modification du capital (fusions, scissions, transformations)",
				"2016 --- Frais d'entr�e � la Bourse ",
				"2017 --- Frais de restructuration ",
				"2018 --- Frais divers d'�tablissement ",
				"202 -- CHARGES � R�PARTIR SUR PLUSIEURS EXERCICES",
				"2021 --- Charges diff�r�es ",
				"2022 --- Frais d'acquisition d'immobilisations ",
				"2026 --- Frais d'�mission des emprunts ",
				"2028 --- Charges � �taler ",
				"206 -- PRIMES DE REMBOURSEMENT DES OBLIGATIONS ",
				"2061 --- Obligations ordinaires ",
				"2062 --- Obligations convertibles ",
				"2068 --- Autres emprunts obligataires",
				"21 - IMMOBILISATIONS INCORPORELLES ",
				"211 -- FRAIS DE RECHERCHE ET DE D�VELOPPEMENT ",
				"212 -- BREVETS, LICENCES, CONCESSIONS ET DROITS SIMILAIRES ",
				"213 -- LOGICIELS ",
				"214 -- MARQUES ",
				"215 -- FONDS COMMERCIAL ",
				"216 -- DROIT AU BAIL ",
				"217 -- INVESTISSEMENTS DE CR�ATION",
				"218 -- AUTRES DROITS ET VALEURS INCORPORELS ",
				"219 -- IMMOBILISATIONS INCORPORELLES EN COURS ",
				"2191 --- Frais de recherche etde d�veloppement ",
				"2193 --- Logiciels ",
				"2198 --- Autres droits et valeurs incorporels ",
				"22 - TERRAINS ",
				"221 -- TERRAINS AGRICOLES ET FORESTIERS ",
				"2211 --- Terrains d'exploitation agricole ",
				"2212 --- Terrains d'exploitation foresti�re ",
				"2218 --- Autres terrains ",
				"222 -- TERRAINS NUS ",
				"2221 --- Terrains � b�tir ",
				"2228 --- Autres terrains nus ",
				"223 -- TERRAINS B�TIS ",
				"2231 --- pour b�timents industriels et agricoles ",
				"2232 --- pour b�timents administratifs et commerciaux ",
				"2234 --- pour b�timents affect�s aux autres op�rations professionnelles ",
				"2235 --- pour b�timents affect�s aux autres op�rations non professionnelles ",
				"2238 --- Autres terrains b�tis ",
				"224 -- TRAVAUX DE MISE EN VALEUR DES TERRAINS ",
				"2241 --- Plantation d'arbres et d'arbustes ",
				"2248 --- Autres travaux ",
				"225 -- TERRAINS DE GISEMENT ",
				"2251 --- Carri�res",
				"226 --- TERRAINS AM�NAG�S ",
				"2261 --- Parkings ",
				"227 -- TERRAINS MIS EN CONCESSION ",
				"228 -- AUTRES TERRAINS ",
				"2281 --- Terrains des immeubles de rapport ",
				"2285 --- Terrains des logements affect�s au personnel ",
				"2288 --- Autres terrains ",
				"229 -- AM�NAGEMENTS DE TERRAINS EN COURS",
				"2291 --- Terrains agricoles et forestiers",
				"2292 --- Terrains nus ",
				"2295 --- Terrains de gisement ",
				"2298 --- Autres terrains ",
				"23 - B�TIMENTS, INSTALLATIONS TECHNIQUES ET AGENCEMENTS ",
				"231 -- B�TIMENTS INDUSTRIELS, AGRICOLES, ADMINISTRATIFS ET COMMERCIAUX SUR SOL PROPRE",
				"2311 --- B�timents industriels ",
				"2312 --- B�timents agricoles ",
				"2313 --- B�timents administratifs et commerciaux  ",
				"2314 --- B�timents affect�s au logement du personnel ",
				"2315 --- Immeubles de rapport ",
				"232 -- B�TIMENTS INDUSTRIELS, AGRICOLES, ADMINISTRATIFS ET COMMERCIAUX SUR SOL D�AUTRUI ",
				"2321 --- B�timents industriels ",
				"2322 --- B�timents agricoles ",
				"2323 --- B�timents administratifs et commerciaux ",
				"2324 --- B�timents affect�s au logement du personnel ",
				"2325 --- Immeubles de rapport ",
				"233 -- OUVRAGES D�INFRASTRUCTURE ",
				"2331 --- Voies de terre ",
				"2332 --- Voies de fer ",
				"2333 --- Voies d�eau ",
				"2334 --- Barrages, Digues ",
				"2335 --- Pistes d�a�rodrome ",
				"2338 --- Autres",
				"234 -- INSTALLATIONS TECHNIQUES ",
				"2341 --- Installations complexes sp�cialis�es sur sol propre ",
				"2342 --- Installations complexes sp�cialis�es sur sol d�autrui ",
				"2343 --- Installations � caract�re sp�cifique sur sol propre ",
				"2344 --- Installations � caract�re sp�cifique sur sol d�autrui ",
				"235 -- AMENAGEMENTS DE BUREAUX ",
				"2351 --- Installations g�n�rales ",
				"2358 --- Autres ",
				"237 -- B�TIMENTS INDUSTRIELS, AGRICOLES ET COMMERCIAUX MIS EN CONCESSION ",
				"238 -- AUTRES INSTALLATIONS ET AGENCEMENTS ",
				"239 -- B�TIMENTS ET INSTALLATIONS EN COURS ",
				"24 - MAT�RIEL ",
				"241 -- MAT�RIEL ET OUTILLAGE INDUSTRIEL ET COMMERCIAL ",
				"2411 --- Mat�riel industriel ",
				"2412 --- Outillage industriel ",
				"2413 --- Mat�riel commercial ",
				"2414 --- Outillage commercial ",
				"242 -- MAT�RIEL ET OUTILLAGE AGRICOLE  ",
				"2421 --- Mat�riel agricole ",
				"2422 --- Outillage agricole ",
				"243 -- MAT�RIEL D�EMBALLAGE R�CUP�RABLE ET IDENTIFIABLE",
				"244 -- MAT�RIEL ET MOBILIER ",
				"2441 --- Mat�riel de bureau ",
				"2442 --- Mat�riel informatique",
				"2443 --- Mat�riel bureautique ",
				"2444 --- Mobilier de bureau ",
				"2446 --- Mat�riel et mobilier des immeubles de rapport ",
				"2447 --- Mat�riel et mobilier des logements du personnel ",
				"245 -- MAT�RIEL DE TRANSPORT ",
				"2451 --- Mat�riel automobile ",
				"2452 --- Mat�riel ferroviaire ",
				"2453 --- Mat�riel fluvial, lagunaire ",
				"2454 --- Mat�riel naval ",
				"2455 --- Mat�riel a�rien ",
				"2456 --- Mat�riel hippomobile ",
				"2458 --- Autres (v�lo, mobylette, moto)",
				"246 -- IMMOBILISATIONS ANIMALES ET AGRICOLES ",
				"2461 --- Cheptel, animaux de trait ",
				"2462 --- Cheptel, animaux reproducteurs",
				"2463 --- Animaux de garde ",
				"2465 --- Plantations agricoles ",
				"2468 --- Autres ",
				"247 -- AGENCEMENTS ET AM�NAGEMENTS DU MAT�RIEL ",
				"248 -- AUTRES MAT�RIELS ",
				"2481 --- Collections et �uvres d�art ",
				"249 -- MAT�RIEL EN COURS ",
				"2491 --- Mat�riel et outillage industriel et commercial ",
				"2492 --- Mat�riel et outillage agricole ",
				"2493 --- Mat�riel d�emballage r�cup�rable et identifiable ",
				"2494 --- Mat�riel et mobilier de bureau ",
				"2495 --- Mat�riel de transport ",
				"2496 --- Immobilisations animales et agricoles  ",
				"2497 --- Agencements et am�nagements du mat�riel ",
				"2498 --- Autres mat�riels ",
				"25 - AVANCES ET ACOMPTES VERS�S SUR IMMOBILISATIONS ",
				"251 -- AVANCES ET ACOMPTES VERS�S SUR IMMOBILISATIONS INCORPORELLES ",
				"252 -- AVANCES ET ACOMPTES VERS�S SUR IMMOBILISATIONS CORPORELLES ",
				"26 - TITRES DE PARTICIPATION ",
				"261 -- TITRES DE PARTICIPATION DANS DES SOCI�T�S SOUS CONTR�LE EXCLUSIF ",
				"261 -- TITRES DE PARTICIPATION DANS DES SOCI�T�S SOUS CONTR�LE EXCLUSIF ",
				"263 -- TITRES DE PARTICIPATION DANS DES SOCI�T�S CONF�RANT UNE INFLUENCE NOTABLE ",
				"265 -- PARTICIPATIONS DANS DES ORGANISMES PROFESSIONNELS ",
				"266 -- PARTS DANS DES GROUPEMENTS D�INT�R�T �CONOMIQUE (G.I.E.) ",
				"268 -- AUTRES TITRES DE PARTICIPATION ",
				"27 - AUTRES IMMOBLISATIONS FINANCI�RES",
				"271 -- PR�TS ET CR�ANCES NON COMMERCIALES",
				"2711 --- Pr�ts participatifs ",
				"2712 --- Pr�ts aux associ�s ",
				"2713 --- Billets de fonds ",
				"2714 --- Titres pr�t�s ",
				"272 --- PR�TS AU PERSONNEL ",
				"2721 --- Pr�ts immobiliers ",
				"2722 --- Pr�ts mobiliers et d�installation ",
				"2728 --- Autres pr�ts (frais d��tudes�) ",
				"273 -- CR�ANCES SUR L��TAT",
				"2731 --- Retenues de garantie ",
				"2733 --- Fonds r�glement� ",
				"2738 --- Autres ",
				"274 -- TITRES IMMOBILIS�S",
				"2741 --- Titres immobilis�s de l�activit�de portefeuille (T.I.A.P.) ",
				"2742 --- Titres participatifs ",
				"2743 --- Certificats d�investissement ",
				"2744 --- Parts de fonds commun de placement (F.C.P.) ",
				"2748 --- Autres titres immobilis�s ",
				"275 -- D�P�TS ET CAUTIONNEMENTS VERS�S ",
				"2751 --- D�p�ts pour loyers d�avance ",
				"2752 --- D�p�ts pour l��lectricit� ",
				"2753 --- D�p�ts pour l�eau ",
				"2754 --- D�p�ts pour le gaz ",
				"2755 --- D�p�ts pour le t�l�phone, le t�lex, la t�l�copie ",
				"2756 --- Cautionnements sur march�s publics ",
				"2757 --- Cautionnements sur autres op�rations ",
				"2758 --- Autres d�p�ts et cautionnements ",
				"276 -- INT�R�TS COURUS",
				"2761 --- Pr�ts et cr�ances non commerciales ",
				"2762 --- Pr�ts au personnel ",
				"2763 --- Cr�ances sur l'Etat ",
				"2764 --- Titres immobilis�s ",
				"2765 --- D�p�ts et cautionnements vers�s ",
				"2767 --- Cr�ances rattach�es � des participations ",
				"2768 --- Immobilisations financi�res diverses ",
				"277 -- CR�ANCES RATTACH�ES � DES PARTICIPATIONS ET AVANCES � DES G.I.E.",
				"2771 --- Cr�ances rattach�es � des participations (groupe) ",
				"2772 --- Cr�ances rattach�es � des participations (hors groupe) ",
				"2773 --- Cr�ances rattach�es � des soci�t�s en participation ",
				"2774 --- Avances � des Groupements d'int�r�t �conomique (G.I.E.) ",
				"278 --- IMMOBILISATIONS FINANCI�RES DIVERSES ",
				"2781 --- Cr�ances diverses groupe ",
				"2782 --- Cr�ances divers hors groupe ",
				"2785 --- Or et m�taux pr�cieux",
				"28 - AMORTISSEMENTS ",
				"281 -- AMORTISSEMENTS DES IMMOBILISATIONS INCORPORELLES ",
				"2811 --- Amortissements des frais de recherche et de d�veloppement ",
				"2812 --- Amortissements des brevets, licences, concessions et droits similaires ",
				"2813 --- Amortissements des logiciels  ",
				"2814 --- Amortissements des marques ",
				"2815 --- Amortissements du fonds commercial ",
				"2816 --- Amortissements du droit au bail ",
				"2817 --- Amortissements des investissements de cr�ation ",
				"2818 --- Amortissements des autres droits et valeurs incorporels ",
				"282 -- AMORTISSEMENTS DES TERRAINS ",
				"2821 --- Amortissements des terrains agricoles et forestiers ",
				"2824 --- Amortissements des travaux de mise en valeur des terrains ",
				"2825 --- Amortissements des terrains de gisement ",
				"283 -- AMORTISSEMENTS DES B�TIMENTS, INSTALLATIONS TECHNIQUES ET AGENCEMENTS ",
				"2831 --- Amortissements des b�timents industriels, agricoles, administratifs et commerciaux sur sol propre",
				"2832 --- Amortissements des b�timents industriels, agricoles, administratifs et commerciaux sur sol d'autrui ",
				"2833 --- Amortissements des ouvrages d'infrastructure ",
				"2834 --- Amortissements des installations techniques ",
				"2835 --- Amortissements des am�nagements de bureaux ",
				"2837 --- Amortissements des b�timents industriels, agricoles et commerciaux mis en concession ",
				"2838 --- Amortissements des autres installations et agencements ",
				"284 -- AMORTISSEMENTS DU MAT�RIEL",
				"2841 --- Amortissements du mat�riel et outillage industriel et commercial ",
				"2842 --- Amortissements du mat�riel et outillage agricole ",
				"2843 --- Amortissements du mat�riel d'emballage r�cup�rable et identifiable ",
				"2844 --- Amortissements du mat�riel et mobilier ",
				"2845 --- Amortissements du mat�riel de transport",
				"2846 --- Amortissements des immobilisations animales et agricoles ",
				"2847 --- Amortissements des agencements etam�nagements du mat�riel ",
"2848 --- Amortissements des autres mat�riels ",
"29 - PROVISIONS POUR DEPRECIATION ",
"291 -- PROVISIONS POUR D�PR�CIATION DES IMMOBILISATIONS INCORPORELLES",
"2912 --- Provisions pour d�pr�ciation des brevets, licences, concessions et droits similaires ",
"2913 --- Provisions pour d�pr�ciation des logiciels ",
"2914 --- Provisions pour d�pr�ciation des marques ",
"2915 --- Provisions pour d�pr�ciation du fonds commercial ",				
"2916 --- Provisions pour d�pr�ciation du droit au bail ",
"2917 --- Provisions pour d�pr�ciation des investissements de cr�ation ",
"2918 --- Provisions pour d�pr�ciation des autres droits et valeurs incorporels ",
"2919 --- Provisions pour d�pr�ciation des immobilisations incorporelles en cours ",
"292 -- PROVISIONS POUR D�PR�CIATION DES TERRAINS ",
"2921 --- Provisions pour d�pr�ciation des terrains agricoles et forestiers ",
"2922 --- Provisions pour d�pr�ciation des terrains nus ",
"2923 --- Provisions pour d�pr�ciation des terrains b�tis ",
"2924 --- Provisions pour d�pr�ciation des travaux de mise en valeur des terrains ",
"2925 --- Provisions pour d�pr�ciation des terrains de gisement ",
"2926 --- Provisions pour d�pr�ciation des terrains am�nag�s",
"2927 --- Provisions pour d�pr�ciation des terrains mis en concession",
"2928 --- Provisions pour d�pr�ciation des autres terrains",
"2929 --- Provisions pour d�pr�ciation des am�nagements de terrains en cours ",
"293 -- PROVISIONS POUR D�PR�CIATION DES B�TIMENTS, INSTALLATIONS , TECHNIQUES ET AGENCEMENTS", 
"2931 --- Provisions pour d�pr�ciation des b�timents industriels, agricoles, administratif et commerciaux sur sol propre ",
"2932 --- Provisions pour d�pr�ciation des b�timents industriels, agricoles, administratif et commerciaux sur sol d'autrui",
"2933 --- Provisions pour d�pr�ciation des ouvrages d'infrastructures", 
"2934 Provisions pour d�pr�ciation des installations techniques", 
"2935 --- Provisions pour d�pr�ciation des am�nagements de bureaux ",
"2937 --- Provisions pour d�pr�ciation des b�timents industriels, agricoles et commerciaux mis en concession ",
"2938 --- Provisions pour d�pr�ciation des autres installations et agencements ",
"2939 --- Provisions pour d�pr�ciation des b�timents et installations en cours" ,

"294 -- PROVISIONS POUR D�PR�CIATION DE MAT�RIEL ",
"2941 --- Provisions pour d�pr�ciation du mat�riel et outillage industriel et commercial ",
"2942 --- Provisions pour d�pr�ciation du mat�riel et outillage agricole ",
"2943 --- Provisions pour d�pr�ciation du mat�riel d'emballage r�cup�rable et identifiable ",
"2944 --- Provisions pour d�pr�ciation du mat�riel et mobilier ",
"2945 --- Provisions pour d�pr�ciation du mat�riel de transport ",
"2946 --- Provisions pour d�pr�ciation des immobilisations animales et agricoles", 
"2947 --- Provisions pour d�pr�ciation des agencements et am�nagements du mat�riel ",
"2948 --- Provisions pour d�pr�ciation des autres mat�riels  ",
"2949 --- Provisions pour d�pr�ciation de mat�riel en cours ",
"295 -- PROVISIONS POUR D�PR�CIATION DES AVANCES ET ACOMPTES VERS�S SUR IMMOBILISATIONS ",
"2951 --- Provisions pour d�pr�ciation des avances et acomptes vers�s sur immobilisations incorporelles ",
"2952 --- Provisions pour d�pr�ciation des avances et acomptes vers�s sur immobilisations corporelles ",
"296 -- PROVISIONS POUR D�PR�CIATION DES TITRES DE PARTICIPATION ",
"2961 --- Provisions pour d�pr�ciation des titres de participation dans des soci�t�s sous contr�le exclusif ",
"2962 --- Provisions pour d�pr�ciation des titres de participation dans les soci�t�s sous contr�le conjoint ",
"2963 --- Provisions pour d�pr�ciation des titres de participation dans les soci�t�s conf�rant une influence notable ",
"2965 --- Provisions pour d�pr�ciation des participations dans des organismes professionnels ",
"2966 --- Provisions pour d�pr�ciation des parts dans des GIE ",
"2968 --- Provisions pour d�pr�ciation des autres titres de participation",
"297 -- PROVISIONS POUR D�PR�CIATION DES AUTRES IMMOBILISATIONS FINANCI�RES",
"2971 --- Provisions pour d�pr�ciation des pr�ts et cr�ances non commerciales ",
"2972 --- Provisions pour d�pr�ciation des pr�ts au personnel ",
"2973 --- Provisions pour d�pr�ciation des cr�ances sur l'Etat ",
"2974 --- Provisions pour d�pr�ciation des titres immobilis�s ",
"2975 --- Provisions pour d�pr�ciation des d�p�ts et cautionnements vers�s ",
"2977 --- Provisions pour d�pr�ciation des cr�ances rattach�es � des participations et avances � des GIE ",
"2978 --- Provisions pour d�pr�ciation des cr�ances financi�res diverses ",
		};
		
		
	   
    lv = (ListView) findViewById(R.id.liste_comptes_actif);
    inputSearch = (EditText) findViewById(R.id.Recherche_actif);
    mAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nom_compte, liste_actifs);
    lv.setAdapter(mAdapter);
    
    inputSearch.addTextChangedListener(new TextWatcher() {
         
        @Override
        public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
            Actif.this.mAdapter.getFilter().filter(cs);  
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
	getMenuInflater().inflate(R.menu.actif, menu);
	return true;
}
public boolean onOptionsItemSelected(MenuItem item){
	
	
	if (item.getItemId() == R.id.action_settings) {
   	startActivity(new Intent(this, About.class));
     }
	
	return super.onOptionsItemSelected(item);
	
}
}
