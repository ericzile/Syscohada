package com.gdg.miagegi.syscohada;

import java.util.ArrayList;
import java.util.HashMap;

import com.gdg.miagegi.syscohada.Charges;
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

public class Charges extends Activity {

	private ListView lv;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<	String, String>> productList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charges);
		String liste_charges[] = {
				"60 - ACHATS ET VARIATIONS DE STOCKS ",
				"601 -- ACHATS DE MARCHANDISES ",
				"6011 --- dans la Région ",
				"6012 --- hors Région ", 
				"6013 --- aux entreprises du groupe dans la Région ",
				"6014 --- aux entreprises du groupe hors Région ",
				"6019 --- Rabais, Remises et Ristournes obtenus (non ventilés) ",
				"602 -- ACHATS DE MATIÈRES PREMIÈRES ET FOURNITURES LIÉES ",
				"6021 --- dans la Région", 
				"6022 --- hors Région ", 
				"6023 --- aux entreprises du groupe dans la Région ",
				"6024 --- aux entreprises du groupe hors Région ",
				"6029 --- Rabais, Remises et Ristournes obtenus (non ventilés) ",
				"603 -- VARIATIONS DES STOCKS DE BIENS ACHETÉS ",
				"6031 --- Variations des stocks de marchandises ",
				"6032 --- Variations des stocks de matières premières et fournitures liées  ",
				"6033 --- Variations des stocks d'autres approvisionnements ",
				"604 -- ACHATS STOCKÉS DE MATIÈRES ET FOURNITURES CONSOMMABLES ",
				"6041 --- Matières consommables ",
				"6042 --- Matières combustibles ",
				"6043 --- Produits d'entretien ",
				"6044 --- Fournitures d'atelier et d'usine ",
				"6046 --- Fournitures de magasin ",
				"6047 --- Fournitures de bureau ",
				"6049 --- Rabais, Remises et Ristournes obtenus (non ventilés) ",
				"605 -- AUTRES ACHATS ",
				"6051 --- Fournitures non stockables -Eau ",
				"6052 --- Fournitures non stockables - Electricité ",
				"6053 --- Fournitures non stockables – Autres énergies ",
				"6054 --- Fournitures d'entretien non stockables ",
				"6055 --- Fournitures de bureau non stockables ",
				"6056 --- Achats de petit matériel et outillage ",
				"6057 --- Achats d'études et prestations de services ",
				"6058 --- Achats de travaux, matériels et équipements ",
				"6059 --- Rabais, Remises et Ristournes obtenus (non ventilés) ",
				"608 -- ACHATS D'EMBALLAGES ",
				"6081 --- Emballages perdus ",
				"6082 --- Emballages récupérables non identifiables ",
				"6083 --- Emballages à usage mixte ",
				"6089 --- Rabais, Remises et Ristournes obtenus (non ventilés) ",
				"61 - TRANSPORTS ",
				"611 -- TRANSPORTS SUR ACHATS",
				"612 -- TRANSPORTS SUR VENTES ",
				"613 -- TRANSPORTS POUR LE COMPTE DE TIERS ",
				"614 -- TRANSPORTS DU PERSONNEL ",
				"616 -- TRANSPORTS DE PLIS ",
				"618 --- AUTRES FRAIS DE TRANSPORT ",
				"6181 --- Voyages et déplacements ",
				"6182 --- Transports entre établissements ou chantiers ",
				"6183 --- Transports administratifs  ",
				"62 - SERVICES EXTÉRIEURS A ",
				"621 -- SOUS-TRAITANCE GÉNÉRALE ",
				"622 -- LOCATIONS ET CHARGES LOCATIVES ",
				"6221 --- Locations de terrains ",
				"6222 --- Locations de bâtiments ",
				"6223 --- Locations de matériels et outillages ",
				"6224 --- Malis sur emballages ",
				"6225 --- Locations d'emballages ",
				"6228 --- Locations et charges locatives diverses ",
				"623 -- REDEVANCES DE CRÉDIT-BAIL ET CONTRATS ASSIMILÉS ",
				"6232 --- Crédit-bail immobilier ",
				"6233 --- Crédit-bail mobilier ",
				"6235 --- Contrats assimilés ",
				"624 -- ENTRETIEN, RÉPARATIONS ET MAINTENANCE ",
				"6241 --- Entretien et réparations des biens immobiliers ",
				"6242 --- Entretien et réparations des biens mobiliers ",
				"6243 --- Maintenance ",
				"6248 --- Autres entretiens et réparations ",
				"625 -- PRIMES D'ASSURANCE ",
				"6251 --- Assurances multirisques ",
				"6252 --- Assurances matériel de transport ",
				"6253 --- Assurances risques d'exploitation ",
				"6254 --- Assurances responsabilité du producteur ",
				"6255 --- Assurances insolvabilité clients ",
				"6256 --- Assurances transport sur achats", 
				"6257 --- Assurances transport sur ventes", 
				"6258 --- Autres primes d'assurances ",
				"626 --  ÉTUDES, RECHERCHES ET DOCUMENTATION ",
				"6261 --- Études et recherches ",
				"6265 --- Documentation générale ",
				"6266 --- Documentation technique ",
				"627 -- PUBLICITÉ, PUBLICATIONS, RELATIONS PUBLIQUES ",
				"6271 --- Annonces, insertions ",
				"6272 --- Catalogues, imprimés publicitaires  ",	
				"6273 --- Échantillons ",
				"6274 --- Foires et expositions", 
				"6275 --- Publications ",
				"6276 --- Cadeaux à la clientèle ",
				"6277 --- Frais de colloques, séminaires, conférences ",
				"6278 --- Autres charges de publicité et relations publiques ",
				"628 -- FRAIS DE TÉLÉCOMMUNICATIONS ",
				"6281 --- Frais de téléphone ",
				"6282 --- Frais de télex ",
				"6283 --- Frais de télécopie ",
				"6288 --- Autres frais de télécommunications ",
				"63 - SERVICES EXTÉRIEURS B ",
				"631 -- FRAIS BANCAIRES ",
				"6311 --- Frais sur titres (achat, vente, garde) ",
				"6312 --- Frais sur effets ",
				"6313 --- Location de coffres ",
				"6315 --- Commissions sur cartes de crédit ",
				"6316 --- Frais d'émission d'emprunts", 
				"6318 --- Autres frais bancaires ",
				"632 -- RÉMUNÉRATIONS D'INTERMÉDIAIRES ET DE CONSEILS ",
				"6321 --- Commissions et courtages sur achats ",
				"6322 --- Commissions et courtages sur ventes ",
				"6323 --- Rémunérations des transitaires ",
				"6324 --- Honoraires ",
				"6325 --- Frais d'actes et de contentieux ",
				"6328 --- Divers frais ",
				"633 -- FRAIS DE FORMATION DU PERSONNEL ",
				"634 -- REDEVANCES POUR BREVETS, LICENCES, LOGICIELS ET DROITS SIMILAIRES ",
				"6342 --- Redevances pour brevets, licences, concessions et droits similaires ",
				"6343 --- Redevances pour logiciels ",
				"6344 --- Redevances pour marques ",
				"635 -- COTISATIONS ",
				"6351 --- Cotisations ",
				"6358 --- Concours divers  ",
				"637 -- RÉMUNÉRATIONS DE PERSONNEL EXTÉRIEUR À L'ENTREPRISE ",
				"6371 --- Personnel intérimaire ",
				"6372 --- Personnel détaché ou prêté à l'entreprise ",
				"638 -- AUTRES CHARGES EXTERNES ",
				"6381 --- Frais de recrutement du personnel ",
				"6382 --- Frais de déménagement ",
				"6383 --- Réceptions ",
				"6384 --- Missions ",
				"64 - IMPÔTS ET TAXES ",
				"641 -- IMPÔTS ET TAXES DIRECTS ",
				"6411 --- Impôts fonciers et taxes annexes ",
				"6412 --- Patentes, licences et taxes annexes ",
				"6413 --- Taxes sur appointements et salaires ",
				"6414 --- Taxes d'apprentissage ",
				"6415 --- Formation professionnelle continue ",
				"6418 --- Autres impôts et taxes directs ",
				"645 -- IMPÔTS ET TAXES INDIRECTS ",
				"646 -- DROITS D'ENREGISTREMENT ",
				"6461 --- Droits de mutation ",
				"6462 --- Droits de timbre ",
				"6463 --- Taxes sur les véhicules de société ",
				"6464 --- Vignettes ",
				"6468 --- Autres droits ",
				"647 -- PÉNALITÉS ET AMENDES FISCALES ",
				"6471 --- Pénalités d'assiette, impôts directs ",
				"6472 --- Pénalités d'assiette, impôts indirects ",
				"6473 --- Pénalités de recouvrement, impôts directs ",
				"6474 --- Pénalités de recouvrement, impôts indirects ",
				"6478 --- Autres amendes pénales et fiscales ",
				"648 -- AUTRES IMPÔTS ET TAXES ",
				"65 - AUTRES CHARGES ",
				"651 -- PERTES SUR CRÉANCES CLIENTS ET AUTRES DÉBITEURS ",
				"6511 --- Clients ",
				"6515 --- Autres débiteurs  ",
				"652 -- QUOTE-PART DE RÉSULTAT SUR OPÉRATIONS FAITES EN COMMUN ",
				"6521 --- Quote-part transférée de bénéfices (comptabilité du gérant) ",
				"6525 --- Pertes imputées par transfert (comptabilité des associés non gérants) ",
				"653 -- QUOTE-PART DE RÉSULTAT ANNULÉE SUR EXÉCUTION PARTIELLE DE CONTRATS PLURI-EXERCICES ",
				"654 -- VALEUR COMPTABLE DES CESSIONS COURANTES D'IMMOBILISATIONS ",
				"658 -- CHARGES DIVERSES ",
				"6581 --- Jetons de présence et autres rémunérations d'administrateurs ",
				"6582 --- Dons ",
				"6583 --- Mécénat ",
				"659 -- CHARGES PROVISIONNÉES D'EXPLOITATION ",
				"6591 --- sur risques à court terme ",
				"6593 --- sur stocks ",
				"6594 --- sur créances ",
				"6598 --- Autres charges provisionnées ",
				"66 - CHARGES DE PERSONNEL ",
				"661 -- RÉMUNÉRATIONS DIRECTES VERSÉES AU PERSONNEL NATIONAL", 
				"6611 --- Appointements salaires et commissions ",
				"6612 --- Primes et gratifications ",
				"6613 --- Congés payés ",
				"6614 --- Indemnités de préavis, de licenciement et de recherche d'embauche ",
				"6615 --- Indemnités de maladie versées aux travailleurs ",
				"6616 --- Supplément familial ",
				"6617 --- Avantages en nature ",
				"6618 --- Autres rémunérations directes ",
				"662 -- RÉMUNÉRATIONS DIRECTES VERSÉES AU PERSONNEL NON NATIONAL ",
				"6621 --- Appointements salaires et commissions ",
				"6622 --- Primes et gratifications ",
				"6623 --- Congés payés ",
				"6624 --- Indemnités de préavis, de licenciement et de recherche d'embauche ",
				"6625 --- Indemnités de maladie versées aux travailleurs ",
				"6626 --- Supplément familial ",
				"6627 --- Avantages en nature ",
				"6628 --- Autres rémunérations directes ",
				"663 -- INDEMNITÉS FORFAITAIRES VERSÉES AU PERSONNEL ",
				"6631 --- Indemnités de logement ",
				"6632 --- Indemnités de représentation ",
				"6633 --- Indemnités d'expatriation ",
				"6638 --- Autres indemnités et avantages divers ",
				"664 -- CHARGES SOCIALES ",
				"6641 --- Charges sociales sur rémunération du personnel national ",
				"6642 --- Charges sociales sur rémunération du personnel non national ",
				"666 -- RÉMUNÉRATIONS ET CHARGES SOCIALES DE L'EXPLOITANT INDIVIDUEL ",
				"6661 --- Rémunération du travail de l'exploitant ",
				"6662 --- Charges sociales ",
				"667 -- RÉMUNÉRATION TRANSFÉRÉE DE PERSONNEL EXTÉRIEUR ",
				"6671 --- Personnel intérimaire ",
				"6672 --- Personnel détaché ou prêté à l’entreprise ",
				"668 -- AUTRES CHARGES SOCIALES ",
				"6681 --- Versements aux Syndicats et Comités d'entreprise, d'établissement ",
				"6682 --- Versements aux Comités d'hygiène et de sécurité ",
				"6683 --- Versements aux autres oeuvres sociales ",
				"6684 --- Médecine du travail et pharmacie ",
				"67 - FRAIS FINANCIERS ET CHARGES ASSIMILÉES ",
				"671 -- INTÉRÊTS DES EMPRUNTS ",
				"6711 --- Emprunts obligataires ",
				"6712 --- Emprunts auprès des établissements de crédit ",
				"6713 --- Dettes liées à des participations ",
				"672 -- INTÉRÊTS DANS LOYERS DE CRÉDIT-BAIL ET CONTRATS ASSIMILÉS ",
				"6721 --- Intérêts dans loyers de crédit-bail immobilier ",
				"6722 --- Intérêts dans loyers de crédit-bail mobilier ",
				"6723 --- Intérêts dans loyers des autres contrats ",
				"673 -- ESCOMPTES ACCORDÉS ",
				"674 -- AUTRES INTÉRÊTS ",
				"6741 --- Avances reçues et dépôts créditeurs ",
				"6742 --- Comptes courants bloqués ",
				"6743 --- Intérêts sur obligations cautionnées  ",
				"6744 --- Intérêts sur dettes commerciales ",
				"6745 --- Intérêts bancaires et sur opérations de trésorerie et d’escompte ",
				"6748 --- Intérêts sur dettes diverses ",
				"675 -- ESCOMPTES DES EFFETS DE COMMERCE ",
				"676 -- PERTES DE CHANGE ",
				"677 -- PERTES SUR CESSIONS DE TITRES DE PLACEMENT ",
				"678 -- PERTES SUR RISQUES FINANCIERS ",
				"6781 --- sur rentes viagères ",
				"6782 --- sur opérations financières ",
				"6784 --- sur instruments de trésorerie ",
				"679 -- CHARGES PROVISIONNÉES FINANCIÈRES ",
				"6791 --- sur risques financiers ",
				"6795 --- sur titres de placement ",
				"6798 --- Autres charges provisionnées financières ",
				"68 - DOTATIONS AUX AMORTISSEMENTS ",
				"681 -- DOTATIONS AUX AMORTISSEMENTS D'EXPLOITATION ",
				"6811 --- Dotations aux amortissements des charges immobilisées ",
				"6812 --- Dotations aux amortissements des immobilisations incorporelles ",
				"6813 --- Dotations aux amortissements des immobilisations corporelles ",
				"687 -- DOTATIONS AUX AMORTISSEMENTS À CARACTÈRE FINANCIER ",
				"6872 --- Dotations aux amortissements des primes de remboursement des obligations ",
				"6878 --- Autres dotations aux amortissements à caractère financier ",
				"69 - DOTATIONS AUX PROVISIONS ",
				"691 -- DOTATIONS AUX PROVISIONS D'EXPLOITATION ",
				"6911 --- pour risques et charges ",
				"6912 --- pour grosses réparations ",
				"6913 --- pour dépréciation des immobilisations incorporelles ",
				"6914 --- pour dépréciation des immobilisations corporelles ",
				"697 -- DOTATIONS AUX PROVISIONS FINANCIÈRES ",
				"6971 --- pour risques et charges ",
				"6972 --- pour dépréciation des immobilisations financières ",
		};
		lv = (ListView) findViewById(R.id.liste_comptes_charges);
        inputSearch = (EditText) findViewById(R.id.Recherche_charges);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nom_compte, liste_charges);
        lv.setAdapter(adapter);
        
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                Charges.this.adapter.getFilter().filter(cs);  
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
		getMenuInflater().inflate(R.menu.charges, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		
		
		if (item.getItemId() == R.id.action_settings) {
       	startActivity(new Intent(this, About.class));
         }
		
		return super.onOptionsItemSelected(item);
		
	}
}
