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
				"20 - CHARGES IMMOBILISÉES ",
				"201 -- FRAIS D'ÉTABLISSEMENT ",
				"2011 --- Frais de constitution  ",
				"2012 --- Frais de prospection ",
				"2013 --- Frais de publicité et de lancement ",
				"2014 --- Frais de fonctionnement antérieurs au démarrage",
				"2015 --- Frais de modification du capital (fusions, scissions, transformations)",
				"2016 --- Frais d'entrée à la Bourse ",
				"2017 --- Frais de restructuration ",
				"2018 --- Frais divers d'établissement ",
				"202 -- CHARGES À RÉPARTIR SUR PLUSIEURS EXERCICES",
				"2021 --- Charges différées ",
				"2022 --- Frais d'acquisition d'immobilisations ",
				"2026 --- Frais d'émission des emprunts ",
				"2028 --- Charges à étaler ",
				"206 -- PRIMES DE REMBOURSEMENT DES OBLIGATIONS ",
				"2061 --- Obligations ordinaires ",
				"2062 --- Obligations convertibles ",
				"2068 --- Autres emprunts obligataires",
				"21 - IMMOBILISATIONS INCORPORELLES ",
				"211 -- FRAIS DE RECHERCHE ET DE DÉVELOPPEMENT ",
				"212 -- BREVETS, LICENCES, CONCESSIONS ET DROITS SIMILAIRES ",
				"213 -- LOGICIELS ",
				"214 -- MARQUES ",
				"215 -- FONDS COMMERCIAL ",
				"216 -- DROIT AU BAIL ",
				"217 -- INVESTISSEMENTS DE CRÉATION",
				"218 -- AUTRES DROITS ET VALEURS INCORPORELS ",
				"219 -- IMMOBILISATIONS INCORPORELLES EN COURS ",
				"2191 --- Frais de recherche etde développement ",
				"2193 --- Logiciels ",
				"2198 --- Autres droits et valeurs incorporels ",
				"22 - TERRAINS ",
				"221 -- TERRAINS AGRICOLES ET FORESTIERS ",
				"2211 --- Terrains d'exploitation agricole ",
				"2212 --- Terrains d'exploitation forestière ",
				"2218 --- Autres terrains ",
				"222 -- TERRAINS NUS ",
				"2221 --- Terrains à bâtir ",
				"2228 --- Autres terrains nus ",
				"223 -- TERRAINS BÂTIS ",
				"2231 --- pour bâtiments industriels et agricoles ",
				"2232 --- pour bâtiments administratifs et commerciaux ",
				"2234 --- pour bâtiments affectés aux autres opérations professionnelles ",
				"2235 --- pour bâtiments affectés aux autres opérations non professionnelles ",
				"2238 --- Autres terrains bâtis ",
				"224 -- TRAVAUX DE MISE EN VALEUR DES TERRAINS ",
				"2241 --- Plantation d'arbres et d'arbustes ",
				"2248 --- Autres travaux ",
				"225 -- TERRAINS DE GISEMENT ",
				"2251 --- Carrières",
				"226 --- TERRAINS AMÉNAGÉS ",
				"2261 --- Parkings ",
				"227 -- TERRAINS MIS EN CONCESSION ",
				"228 -- AUTRES TERRAINS ",
				"2281 --- Terrains des immeubles de rapport ",
				"2285 --- Terrains des logements affectés au personnel ",
				"2288 --- Autres terrains ",
				"229 -- AMÉNAGEMENTS DE TERRAINS EN COURS",
				"2291 --- Terrains agricoles et forestiers",
				"2292 --- Terrains nus ",
				"2295 --- Terrains de gisement ",
				"2298 --- Autres terrains ",
				"23 - BÂTIMENTS, INSTALLATIONS TECHNIQUES ET AGENCEMENTS ",
				"231 -- BÂTIMENTS INDUSTRIELS, AGRICOLES, ADMINISTRATIFS ET COMMERCIAUX SUR SOL PROPRE",
				"2311 --- Bâtiments industriels ",
				"2312 --- Bâtiments agricoles ",
				"2313 --- Bâtiments administratifs et commerciaux  ",
				"2314 --- Bâtiments affectés au logement du personnel ",
				"2315 --- Immeubles de rapport ",
				"232 -- BÂTIMENTS INDUSTRIELS, AGRICOLES, ADMINISTRATIFS ET COMMERCIAUX SUR SOL D’AUTRUI ",
				"2321 --- Bâtiments industriels ",
				"2322 --- Bâtiments agricoles ",
				"2323 --- Bâtiments administratifs et commerciaux ",
				"2324 --- Bâtiments affectés au logement du personnel ",
				"2325 --- Immeubles de rapport ",
				"233 -- OUVRAGES D’INFRASTRUCTURE ",
				"2331 --- Voies de terre ",
				"2332 --- Voies de fer ",
				"2333 --- Voies d’eau ",
				"2334 --- Barrages, Digues ",
				"2335 --- Pistes d’aérodrome ",
				"2338 --- Autres",
				"234 -- INSTALLATIONS TECHNIQUES ",
				"2341 --- Installations complexes spécialisées sur sol propre ",
				"2342 --- Installations complexes spécialisées sur sol d’autrui ",
				"2343 --- Installations à caractère spécifique sur sol propre ",
				"2344 --- Installations à caractère spécifique sur sol d’autrui ",
				"235 -- AMENAGEMENTS DE BUREAUX ",
				"2351 --- Installations générales ",
				"2358 --- Autres ",
				"237 -- BÂTIMENTS INDUSTRIELS, AGRICOLES ET COMMERCIAUX MIS EN CONCESSION ",
				"238 -- AUTRES INSTALLATIONS ET AGENCEMENTS ",
				"239 -- BÂTIMENTS ET INSTALLATIONS EN COURS ",
				"24 - MATÉRIEL ",
				"241 -- MATÉRIEL ET OUTILLAGE INDUSTRIEL ET COMMERCIAL ",
				"2411 --- Matériel industriel ",
				"2412 --- Outillage industriel ",
				"2413 --- Matériel commercial ",
				"2414 --- Outillage commercial ",
				"242 -- MATÉRIEL ET OUTILLAGE AGRICOLE  ",
				"2421 --- Matériel agricole ",
				"2422 --- Outillage agricole ",
				"243 -- MATÉRIEL D’EMBALLAGE RÉCUPÉRABLE ET IDENTIFIABLE",
				"244 -- MATÉRIEL ET MOBILIER ",
				"2441 --- Matériel de bureau ",
				"2442 --- Matériel informatique",
				"2443 --- Matériel bureautique ",
				"2444 --- Mobilier de bureau ",
				"2446 --- Matériel et mobilier des immeubles de rapport ",
				"2447 --- Matériel et mobilier des logements du personnel ",
				"245 -- MATÉRIEL DE TRANSPORT ",
				"2451 --- Matériel automobile ",
				"2452 --- Matériel ferroviaire ",
				"2453 --- Matériel fluvial, lagunaire ",
				"2454 --- Matériel naval ",
				"2455 --- Matériel aérien ",
				"2456 --- Matériel hippomobile ",
				"2458 --- Autres (vélo, mobylette, moto)",
				"246 -- IMMOBILISATIONS ANIMALES ET AGRICOLES ",
				"2461 --- Cheptel, animaux de trait ",
				"2462 --- Cheptel, animaux reproducteurs",
				"2463 --- Animaux de garde ",
				"2465 --- Plantations agricoles ",
				"2468 --- Autres ",
				"247 -- AGENCEMENTS ET AMÉNAGEMENTS DU MATÉRIEL ",
				"248 -- AUTRES MATÉRIELS ",
				"2481 --- Collections et œuvres d’art ",
				"249 -- MATÉRIEL EN COURS ",
				"2491 --- Matériel et outillage industriel et commercial ",
				"2492 --- Matériel et outillage agricole ",
				"2493 --- Matériel d’emballage récupérable et identifiable ",
				"2494 --- Matériel et mobilier de bureau ",
				"2495 --- Matériel de transport ",
				"2496 --- Immobilisations animales et agricoles  ",
				"2497 --- Agencements et aménagements du matériel ",
				"2498 --- Autres matériels ",
				"25 - AVANCES ET ACOMPTES VERSÉS SUR IMMOBILISATIONS ",
				"251 -- AVANCES ET ACOMPTES VERSÉS SUR IMMOBILISATIONS INCORPORELLES ",
				"252 -- AVANCES ET ACOMPTES VERSÉS SUR IMMOBILISATIONS CORPORELLES ",
				"26 - TITRES DE PARTICIPATION ",
				"261 -- TITRES DE PARTICIPATION DANS DES SOCIÉTÉS SOUS CONTRÔLE EXCLUSIF ",
				"261 -- TITRES DE PARTICIPATION DANS DES SOCIÉTÉS SOUS CONTRÔLE EXCLUSIF ",
				"263 -- TITRES DE PARTICIPATION DANS DES SOCIÉTÉS CONFÉRANT UNE INFLUENCE NOTABLE ",
				"265 -- PARTICIPATIONS DANS DES ORGANISMES PROFESSIONNELS ",
				"266 -- PARTS DANS DES GROUPEMENTS D’INTÉRÊT ÉCONOMIQUE (G.I.E.) ",
				"268 -- AUTRES TITRES DE PARTICIPATION ",
				"27 - AUTRES IMMOBLISATIONS FINANCIÈRES",
				"271 -- PRÊTS ET CRÉANCES NON COMMERCIALES",
				"2711 --- Prêts participatifs ",
				"2712 --- Prêts aux associés ",
				"2713 --- Billets de fonds ",
				"2714 --- Titres prêtés ",
				"272 --- PRÊTS AU PERSONNEL ",
				"2721 --- Prêts immobiliers ",
				"2722 --- Prêts mobiliers et d’installation ",
				"2728 --- Autres prêts (frais d’études…) ",
				"273 -- CRÉANCES SUR L’ÉTAT",
				"2731 --- Retenues de garantie ",
				"2733 --- Fonds réglementé ",
				"2738 --- Autres ",
				"274 -- TITRES IMMOBILISÉS",
				"2741 --- Titres immobilisés de l’activitéde portefeuille (T.I.A.P.) ",
				"2742 --- Titres participatifs ",
				"2743 --- Certificats d’investissement ",
				"2744 --- Parts de fonds commun de placement (F.C.P.) ",
				"2748 --- Autres titres immobilisés ",
				"275 -- DÉPÔTS ET CAUTIONNEMENTS VERSÉS ",
				"2751 --- Dépôts pour loyers d’avance ",
				"2752 --- Dépôts pour l’électricité ",
				"2753 --- Dépôts pour l’eau ",
				"2754 --- Dépôts pour le gaz ",
				"2755 --- Dépôts pour le téléphone, le télex, la télécopie ",
				"2756 --- Cautionnements sur marchés publics ",
				"2757 --- Cautionnements sur autres opérations ",
				"2758 --- Autres dépôts et cautionnements ",
				"276 -- INTÉRÊTS COURUS",
				"2761 --- Prêts et créances non commerciales ",
				"2762 --- Prêts au personnel ",
				"2763 --- Créances sur l'Etat ",
				"2764 --- Titres immobilisés ",
				"2765 --- Dépôts et cautionnements versés ",
				"2767 --- Créances rattachées à des participations ",
				"2768 --- Immobilisations financières diverses ",
				"277 -- CRÉANCES RATTACHÉES À DES PARTICIPATIONS ET AVANCES À DES G.I.E.",
				"2771 --- Créances rattachées à des participations (groupe) ",
				"2772 --- Créances rattachées à des participations (hors groupe) ",
				"2773 --- Créances rattachées à des sociétés en participation ",
				"2774 --- Avances à des Groupements d'intérêt économique (G.I.E.) ",
				"278 --- IMMOBILISATIONS FINANCIÈRES DIVERSES ",
				"2781 --- Créances diverses groupe ",
				"2782 --- Créances divers hors groupe ",
				"2785 --- Or et métaux précieux",
				"28 - AMORTISSEMENTS ",
				"281 -- AMORTISSEMENTS DES IMMOBILISATIONS INCORPORELLES ",
				"2811 --- Amortissements des frais de recherche et de développement ",
				"2812 --- Amortissements des brevets, licences, concessions et droits similaires ",
				"2813 --- Amortissements des logiciels  ",
				"2814 --- Amortissements des marques ",
				"2815 --- Amortissements du fonds commercial ",
				"2816 --- Amortissements du droit au bail ",
				"2817 --- Amortissements des investissements de création ",
				"2818 --- Amortissements des autres droits et valeurs incorporels ",
				"282 -- AMORTISSEMENTS DES TERRAINS ",
				"2821 --- Amortissements des terrains agricoles et forestiers ",
				"2824 --- Amortissements des travaux de mise en valeur des terrains ",
				"2825 --- Amortissements des terrains de gisement ",
				"283 -- AMORTISSEMENTS DES BÂTIMENTS, INSTALLATIONS TECHNIQUES ET AGENCEMENTS ",
				"2831 --- Amortissements des bâtiments industriels, agricoles, administratifs et commerciaux sur sol propre",
				"2832 --- Amortissements des bâtiments industriels, agricoles, administratifs et commerciaux sur sol d'autrui ",
				"2833 --- Amortissements des ouvrages d'infrastructure ",
				"2834 --- Amortissements des installations techniques ",
				"2835 --- Amortissements des aménagements de bureaux ",
				"2837 --- Amortissements des bâtiments industriels, agricoles et commerciaux mis en concession ",
				"2838 --- Amortissements des autres installations et agencements ",
				"284 -- AMORTISSEMENTS DU MATÉRIEL",
				"2841 --- Amortissements du matériel et outillage industriel et commercial ",
				"2842 --- Amortissements du matériel et outillage agricole ",
				"2843 --- Amortissements du matériel d'emballage récupérable et identifiable ",
				"2844 --- Amortissements du matériel et mobilier ",
				"2845 --- Amortissements du matériel de transport",
				"2846 --- Amortissements des immobilisations animales et agricoles ",
				"2847 --- Amortissements des agencements etaménagements du matériel ",
"2848 --- Amortissements des autres matériels ",
"29 - PROVISIONS POUR DEPRECIATION ",
"291 -- PROVISIONS POUR DÉPRÉCIATION DES IMMOBILISATIONS INCORPORELLES",
"2912 --- Provisions pour dépréciation des brevets, licences, concessions et droits similaires ",
"2913 --- Provisions pour dépréciation des logiciels ",
"2914 --- Provisions pour dépréciation des marques ",
"2915 --- Provisions pour dépréciation du fonds commercial ",				
"2916 --- Provisions pour dépréciation du droit au bail ",
"2917 --- Provisions pour dépréciation des investissements de création ",
"2918 --- Provisions pour dépréciation des autres droits et valeurs incorporels ",
"2919 --- Provisions pour dépréciation des immobilisations incorporelles en cours ",
"292 -- PROVISIONS POUR DÉPRÉCIATION DES TERRAINS ",
"2921 --- Provisions pour dépréciation des terrains agricoles et forestiers ",
"2922 --- Provisions pour dépréciation des terrains nus ",
"2923 --- Provisions pour dépréciation des terrains bâtis ",
"2924 --- Provisions pour dépréciation des travaux de mise en valeur des terrains ",
"2925 --- Provisions pour dépréciation des terrains de gisement ",
"2926 --- Provisions pour dépréciation des terrains aménagés",
"2927 --- Provisions pour dépréciation des terrains mis en concession",
"2928 --- Provisions pour dépréciation des autres terrains",
"2929 --- Provisions pour dépréciation des aménagements de terrains en cours ",
"293 -- PROVISIONS POUR DÉPRÉCIATION DES BÂTIMENTS, INSTALLATIONS , TECHNIQUES ET AGENCEMENTS", 
"2931 --- Provisions pour dépréciation des bâtiments industriels, agricoles, administratif et commerciaux sur sol propre ",
"2932 --- Provisions pour dépréciation des bâtiments industriels, agricoles, administratif et commerciaux sur sol d'autrui",
"2933 --- Provisions pour dépréciation des ouvrages d'infrastructures", 
"2934 Provisions pour dépréciation des installations techniques", 
"2935 --- Provisions pour dépréciation des aménagements de bureaux ",
"2937 --- Provisions pour dépréciation des bâtiments industriels, agricoles et commerciaux mis en concession ",
"2938 --- Provisions pour dépréciation des autres installations et agencements ",
"2939 --- Provisions pour dépréciation des bâtiments et installations en cours" ,

"294 -- PROVISIONS POUR DÉPRÉCIATION DE MATÉRIEL ",
"2941 --- Provisions pour dépréciation du matériel et outillage industriel et commercial ",
"2942 --- Provisions pour dépréciation du matériel et outillage agricole ",
"2943 --- Provisions pour dépréciation du matériel d'emballage récupérable et identifiable ",
"2944 --- Provisions pour dépréciation du matériel et mobilier ",
"2945 --- Provisions pour dépréciation du matériel de transport ",
"2946 --- Provisions pour dépréciation des immobilisations animales et agricoles", 
"2947 --- Provisions pour dépréciation des agencements et aménagements du matériel ",
"2948 --- Provisions pour dépréciation des autres matériels  ",
"2949 --- Provisions pour dépréciation de matériel en cours ",
"295 -- PROVISIONS POUR DÉPRÉCIATION DES AVANCES ET ACOMPTES VERSÉS SUR IMMOBILISATIONS ",
"2951 --- Provisions pour dépréciation des avances et acomptes versés sur immobilisations incorporelles ",
"2952 --- Provisions pour dépréciation des avances et acomptes versés sur immobilisations corporelles ",
"296 -- PROVISIONS POUR DÉPRÉCIATION DES TITRES DE PARTICIPATION ",
"2961 --- Provisions pour dépréciation des titres de participation dans des sociétés sous contrôle exclusif ",
"2962 --- Provisions pour dépréciation des titres de participation dans les sociétés sous contrôle conjoint ",
"2963 --- Provisions pour dépréciation des titres de participation dans les sociétés conférant une influence notable ",
"2965 --- Provisions pour dépréciation des participations dans des organismes professionnels ",
"2966 --- Provisions pour dépréciation des parts dans des GIE ",
"2968 --- Provisions pour dépréciation des autres titres de participation",
"297 -- PROVISIONS POUR DÉPRÉCIATION DES AUTRES IMMOBILISATIONS FINANCIÈRES",
"2971 --- Provisions pour dépréciation des prêts et créances non commerciales ",
"2972 --- Provisions pour dépréciation des prêts au personnel ",
"2973 --- Provisions pour dépréciation des créances sur l'Etat ",
"2974 --- Provisions pour dépréciation des titres immobilisés ",
"2975 --- Provisions pour dépréciation des dépôts et cautionnements versés ",
"2977 --- Provisions pour dépréciation des créances rattachées à des participations et avances à des GIE ",
"2978 --- Provisions pour dépréciation des créances financières diverses ",
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
