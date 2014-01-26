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
				"6011 --- dans la R�gion ",
				"6012 --- hors R�gion ", 
				"6013 --- aux entreprises du groupe dans la R�gion ",
				"6014 --- aux entreprises du groupe hors R�gion ",
				"6019 --- Rabais, Remises et Ristournes obtenus (non ventil�s) ",
				"602 -- ACHATS DE MATI�RES PREMI�RES ET FOURNITURES LI�ES ",
				"6021 --- dans la R�gion", 
				"6022 --- hors R�gion ", 
				"6023 --- aux entreprises du groupe dans la R�gion ",
				"6024 --- aux entreprises du groupe hors R�gion ",
				"6029 --- Rabais, Remises et Ristournes obtenus (non ventil�s) ",
				"603 -- VARIATIONS DES STOCKS DE BIENS ACHET�S ",
				"6031 --- Variations des stocks de marchandises ",
				"6032 --- Variations des stocks de mati�res premi�res et fournitures li�es  ",
				"6033 --- Variations des stocks d'autres approvisionnements ",
				"604 -- ACHATS STOCK�S DE MATI�RES ET FOURNITURES CONSOMMABLES ",
				"6041 --- Mati�res consommables ",
				"6042 --- Mati�res combustibles ",
				"6043 --- Produits d'entretien ",
				"6044 --- Fournitures d'atelier et d'usine ",
				"6046 --- Fournitures de magasin ",
				"6047 --- Fournitures de bureau ",
				"6049 --- Rabais, Remises et Ristournes obtenus (non ventil�s) ",
				"605 -- AUTRES ACHATS ",
				"6051 --- Fournitures non stockables -Eau ",
				"6052 --- Fournitures non stockables - Electricit� ",
				"6053 --- Fournitures non stockables � Autres �nergies ",
				"6054 --- Fournitures d'entretien non stockables ",
				"6055 --- Fournitures de bureau non stockables ",
				"6056 --- Achats de petit mat�riel et outillage ",
				"6057 --- Achats d'�tudes et prestations de services ",
				"6058 --- Achats de travaux, mat�riels et �quipements ",
				"6059 --- Rabais, Remises et Ristournes obtenus (non ventil�s) ",
				"608 -- ACHATS D'EMBALLAGES ",
				"6081 --- Emballages perdus ",
				"6082 --- Emballages r�cup�rables non identifiables ",
				"6083 --- Emballages � usage mixte ",
				"6089 --- Rabais, Remises et Ristournes obtenus (non ventil�s) ",
				"61 - TRANSPORTS ",
				"611 -- TRANSPORTS SUR ACHATS",
				"612 -- TRANSPORTS SUR VENTES ",
				"613 -- TRANSPORTS POUR LE COMPTE DE TIERS ",
				"614 -- TRANSPORTS DU PERSONNEL ",
				"616 -- TRANSPORTS DE PLIS ",
				"618 --- AUTRES FRAIS DE TRANSPORT ",
				"6181 --- Voyages et d�placements ",
				"6182 --- Transports entre �tablissements ou chantiers ",
				"6183 --- Transports administratifs  ",
				"62 - SERVICES EXT�RIEURS A ",
				"621 -- SOUS-TRAITANCE G�N�RALE ",
				"622 -- LOCATIONS ET CHARGES LOCATIVES ",
				"6221 --- Locations de terrains ",
				"6222 --- Locations de b�timents ",
				"6223 --- Locations de mat�riels et outillages ",
				"6224 --- Malis sur emballages ",
				"6225 --- Locations d'emballages ",
				"6228 --- Locations et charges locatives diverses ",
				"623 -- REDEVANCES DE CR�DIT-BAIL ET CONTRATS ASSIMIL�S ",
				"6232 --- Cr�dit-bail immobilier ",
				"6233 --- Cr�dit-bail mobilier ",
				"6235 --- Contrats assimil�s ",
				"624 -- ENTRETIEN, R�PARATIONS ET MAINTENANCE ",
				"6241 --- Entretien et r�parations des biens immobiliers ",
				"6242 --- Entretien et r�parations des biens mobiliers ",
				"6243 --- Maintenance ",
				"6248 --- Autres entretiens et r�parations ",
				"625 -- PRIMES D'ASSURANCE ",
				"6251 --- Assurances multirisques ",
				"6252 --- Assurances mat�riel de transport ",
				"6253 --- Assurances risques d'exploitation ",
				"6254 --- Assurances responsabilit� du producteur ",
				"6255 --- Assurances insolvabilit� clients ",
				"6256 --- Assurances transport sur achats", 
				"6257 --- Assurances transport sur ventes", 
				"6258 --- Autres primes d'assurances ",
				"626 --  �TUDES, RECHERCHES ET DOCUMENTATION ",
				"6261 --- �tudes et recherches ",
				"6265 --- Documentation g�n�rale ",
				"6266 --- Documentation technique ",
				"627 -- PUBLICIT�, PUBLICATIONS, RELATIONS PUBLIQUES ",
				"6271 --- Annonces, insertions ",
				"6272 --- Catalogues, imprim�s publicitaires  ",	
				"6273 --- �chantillons ",
				"6274 --- Foires et expositions", 
				"6275 --- Publications ",
				"6276 --- Cadeaux � la client�le ",
				"6277 --- Frais de colloques, s�minaires, conf�rences ",
				"6278 --- Autres charges de publicit� et relations publiques ",
				"628 -- FRAIS DE T�L�COMMUNICATIONS ",
				"6281 --- Frais de t�l�phone ",
				"6282 --- Frais de t�lex ",
				"6283 --- Frais de t�l�copie ",
				"6288 --- Autres frais de t�l�communications ",
				"63 - SERVICES EXT�RIEURS B ",
				"631 -- FRAIS BANCAIRES ",
				"6311 --- Frais sur titres (achat, vente, garde) ",
				"6312 --- Frais sur effets ",
				"6313 --- Location de coffres ",
				"6315 --- Commissions sur cartes de cr�dit ",
				"6316 --- Frais d'�mission d'emprunts", 
				"6318 --- Autres frais bancaires ",
				"632 -- R�MUN�RATIONS D'INTERM�DIAIRES ET DE CONSEILS ",
				"6321 --- Commissions et courtages sur achats ",
				"6322 --- Commissions et courtages sur ventes ",
				"6323 --- R�mun�rations des transitaires ",
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
				"637 -- R�MUN�RATIONS DE PERSONNEL EXT�RIEUR � L'ENTREPRISE ",
				"6371 --- Personnel int�rimaire ",
				"6372 --- Personnel d�tach� ou pr�t� � l'entreprise ",
				"638 -- AUTRES CHARGES EXTERNES ",
				"6381 --- Frais de recrutement du personnel ",
				"6382 --- Frais de d�m�nagement ",
				"6383 --- R�ceptions ",
				"6384 --- Missions ",
				"64 - IMP�TS ET TAXES ",
				"641 -- IMP�TS ET TAXES DIRECTS ",
				"6411 --- Imp�ts fonciers et taxes annexes ",
				"6412 --- Patentes, licences et taxes annexes ",
				"6413 --- Taxes sur appointements et salaires ",
				"6414 --- Taxes d'apprentissage ",
				"6415 --- Formation professionnelle continue ",
				"6418 --- Autres imp�ts et taxes directs ",
				"645 -- IMP�TS ET TAXES INDIRECTS ",
				"646 -- DROITS D'ENREGISTREMENT ",
				"6461 --- Droits de mutation ",
				"6462 --- Droits de timbre ",
				"6463 --- Taxes sur les v�hicules de soci�t� ",
				"6464 --- Vignettes ",
				"6468 --- Autres droits ",
				"647 -- P�NALIT�S ET AMENDES FISCALES ",
				"6471 --- P�nalit�s d'assiette, imp�ts directs ",
				"6472 --- P�nalit�s d'assiette, imp�ts indirects ",
				"6473 --- P�nalit�s de recouvrement, imp�ts directs ",
				"6474 --- P�nalit�s de recouvrement, imp�ts indirects ",
				"6478 --- Autres amendes p�nales et fiscales ",
				"648 -- AUTRES IMP�TS ET TAXES ",
				"65 - AUTRES CHARGES ",
				"651 -- PERTES SUR CR�ANCES CLIENTS ET AUTRES D�BITEURS ",
				"6511 --- Clients ",
				"6515 --- Autres d�biteurs  ",
				"652 -- QUOTE-PART DE R�SULTAT SUR OP�RATIONS FAITES EN COMMUN ",
				"6521 --- Quote-part transf�r�e de b�n�fices (comptabilit� du g�rant) ",
				"6525 --- Pertes imput�es par transfert (comptabilit� des associ�s non g�rants) ",
				"653 -- QUOTE-PART DE R�SULTAT ANNUL�E SUR EX�CUTION PARTIELLE DE CONTRATS PLURI-EXERCICES ",
				"654 -- VALEUR COMPTABLE DES CESSIONS COURANTES D'IMMOBILISATIONS ",
				"658 -- CHARGES DIVERSES ",
				"6581 --- Jetons de pr�sence et autres r�mun�rations d'administrateurs ",
				"6582 --- Dons ",
				"6583 --- M�c�nat ",
				"659 -- CHARGES PROVISIONN�ES D'EXPLOITATION ",
				"6591 --- sur risques � court terme ",
				"6593 --- sur stocks ",
				"6594 --- sur cr�ances ",
				"6598 --- Autres charges provisionn�es ",
				"66 - CHARGES DE PERSONNEL ",
				"661 -- R�MUN�RATIONS DIRECTES VERS�ES AU PERSONNEL NATIONAL", 
				"6611 --- Appointements salaires et commissions ",
				"6612 --- Primes et gratifications ",
				"6613 --- Cong�s pay�s ",
				"6614 --- Indemnit�s de pr�avis, de licenciement et de recherche d'embauche ",
				"6615 --- Indemnit�s de maladie vers�es aux travailleurs ",
				"6616 --- Suppl�ment familial ",
				"6617 --- Avantages en nature ",
				"6618 --- Autres r�mun�rations directes ",
				"662 -- R�MUN�RATIONS DIRECTES VERS�ES AU PERSONNEL NON NATIONAL ",
				"6621 --- Appointements salaires et commissions ",
				"6622 --- Primes et gratifications ",
				"6623 --- Cong�s pay�s ",
				"6624 --- Indemnit�s de pr�avis, de licenciement et de recherche d'embauche ",
				"6625 --- Indemnit�s de maladie vers�es aux travailleurs ",
				"6626 --- Suppl�ment familial ",
				"6627 --- Avantages en nature ",
				"6628 --- Autres r�mun�rations directes ",
				"663 -- INDEMNIT�S FORFAITAIRES VERS�ES AU PERSONNEL ",
				"6631 --- Indemnit�s de logement ",
				"6632 --- Indemnit�s de repr�sentation ",
				"6633 --- Indemnit�s d'expatriation ",
				"6638 --- Autres indemnit�s et avantages divers ",
				"664 -- CHARGES SOCIALES ",
				"6641 --- Charges sociales sur r�mun�ration du personnel national ",
				"6642 --- Charges sociales sur r�mun�ration du personnel non national ",
				"666 -- R�MUN�RATIONS ET CHARGES SOCIALES DE L'EXPLOITANT INDIVIDUEL ",
				"6661 --- R�mun�ration du travail de l'exploitant ",
				"6662 --- Charges sociales ",
				"667 -- R�MUN�RATION TRANSF�R�E DE PERSONNEL EXT�RIEUR ",
				"6671 --- Personnel int�rimaire ",
				"6672 --- Personnel d�tach� ou pr�t� � l�entreprise ",
				"668 -- AUTRES CHARGES SOCIALES ",
				"6681 --- Versements aux Syndicats et Comit�s d'entreprise, d'�tablissement ",
				"6682 --- Versements aux Comit�s d'hygi�ne et de s�curit� ",
				"6683 --- Versements aux autres oeuvres sociales ",
				"6684 --- M�decine du travail et pharmacie ",
				"67 - FRAIS FINANCIERS ET CHARGES ASSIMIL�ES ",
				"671 -- INT�R�TS DES EMPRUNTS ",
				"6711 --- Emprunts obligataires ",
				"6712 --- Emprunts aupr�s des �tablissements de cr�dit ",
				"6713 --- Dettes li�es � des participations ",
				"672 -- INT�R�TS DANS LOYERS DE CR�DIT-BAIL ET CONTRATS ASSIMIL�S ",
				"6721 --- Int�r�ts dans loyers de cr�dit-bail immobilier ",
				"6722 --- Int�r�ts dans loyers de cr�dit-bail mobilier ",
				"6723 --- Int�r�ts dans loyers des autres contrats ",
				"673 -- ESCOMPTES ACCORD�S ",
				"674 -- AUTRES INT�R�TS ",
				"6741 --- Avances re�ues et d�p�ts cr�diteurs ",
				"6742 --- Comptes courants bloqu�s ",
				"6743 --- Int�r�ts sur obligations cautionn�es  ",
				"6744 --- Int�r�ts sur dettes commerciales ",
				"6745 --- Int�r�ts bancaires et sur op�rations de tr�sorerie et d�escompte ",
				"6748 --- Int�r�ts sur dettes diverses ",
				"675 -- ESCOMPTES DES EFFETS DE COMMERCE ",
				"676 -- PERTES DE CHANGE ",
				"677 -- PERTES SUR CESSIONS DE TITRES DE PLACEMENT ",
				"678 -- PERTES SUR RISQUES FINANCIERS ",
				"6781 --- sur rentes viag�res ",
				"6782 --- sur op�rations financi�res ",
				"6784 --- sur instruments de tr�sorerie ",
				"679 -- CHARGES PROVISIONN�ES FINANCI�RES ",
				"6791 --- sur risques financiers ",
				"6795 --- sur titres de placement ",
				"6798 --- Autres charges provisionn�es financi�res ",
				"68 - DOTATIONS AUX AMORTISSEMENTS ",
				"681 -- DOTATIONS AUX AMORTISSEMENTS D'EXPLOITATION ",
				"6811 --- Dotations aux amortissements des charges immobilis�es ",
				"6812 --- Dotations aux amortissements des immobilisations incorporelles ",
				"6813 --- Dotations aux amortissements des immobilisations corporelles ",
				"687 -- DOTATIONS AUX AMORTISSEMENTS � CARACT�RE FINANCIER ",
				"6872 --- Dotations aux amortissements des primes de remboursement des obligations ",
				"6878 --- Autres dotations aux amortissements � caract�re financier ",
				"69 - DOTATIONS AUX PROVISIONS ",
				"691 -- DOTATIONS AUX PROVISIONS D'EXPLOITATION ",
				"6911 --- pour risques et charges ",
				"6912 --- pour grosses r�parations ",
				"6913 --- pour d�pr�ciation des immobilisations incorporelles ",
				"6914 --- pour d�pr�ciation des immobilisations corporelles ",
				"697 -- DOTATIONS AUX PROVISIONS FINANCI�RES ",
				"6971 --- pour risques et charges ",
				"6972 --- pour d�pr�ciation des immobilisations financi�res ",
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
