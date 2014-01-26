package com.gdg.miagegi.syscohada;

import java.util.ArrayList;
import java.util.HashMap;

import com.gdg.miagegi.syscohada.R;
import com.gdg.miagegi.syscohada.Tiers;

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

public class Tiers extends Activity {

	private ListView lv;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<	String, String>> productList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tiers);
		String liste_tiers[] = {
				"40 - FOURNISSEURS ET COMPTES RATTACH�S ",
				"401 -- FOURNISSEURS, DETTES EN COMPTE ",
				"4011 --- Fournisseurs ",
				"4012 --- Fournisseurs Groupe ",
				"4013 --- Fournisseurs sous-traitants ",
				"4017 --- Fournisseur, retenues de garantie ",
				"402 -- FOURNISSEURS, EFFETS � PAYER ",
				"4021 --- Fournisseurs, Effets � payer ",
				"4022 --- Fournisseurs - Groupe, Effets � payer ",
				"4023 --- Fournisseurs sous-traitants, Effets � payer ",
				"408 -- FOURNISSEURS, FACTURES NON PARVENUES ",
				"4081 --- Fournisseurs ",
				"4082 --- Fournisseurs - Groupe", 
				"4083 --- Fournisseurs sous-traitants ",
				"4086 --- Fournisseurs, int�r�ts courus", 
				"409 -- FOURNISSEURS D�BITEURS ",
				"4091 --- Fournisseurs avances et acomptes vers�s ",
				"4092 --- Fournisseurs - Groupe avances et acomptes vers�s ",
				"4093 --- Fournisseurs sous-traitants avances et acomptes vers�s ",
				"4094 --- Fournisseurs cr�ances pour emballages et mat�riels � rendre ",
				"4098 --- Rabais, Remises, Ristournes et autres avoirs � obtenir ",
				"41 - CLIENTS ET COMPTES RATTACH�S",
				"411 -- CLIENTS ",
				"4111 --- Clients ",
				"4112 --- Clients - Groupe ",
				"4114 --- Clients, �tat et Collectivit�s publiques",
				"4115 --- Clients, organismes internationaux ",
				"4117 --- Client, retenues de garantie ",				
				"4118 --- Clients, d�gr�vement de Taxes sur la Valeur Ajout�e (T.V.A.) ",
				"412 -- CLIENTS, �FFETS � RECEVOIR EN PORTEFEUILLE ",
				"4121 --- Clients, Effets � recevoir ",
				"4122 --- Clients - Groupe, Effets � recevoir ",
				"4124 --- �tat et Collectivit�s publiques, Effets � recevoir ",
				"4125 --- Organismes Internationaux, Effets � recevoir ",
				"414 -- CR�ANCES SUR CESSIONSD'IMMOBILISATIONS ",
				"4141 --- Cr�ances en compte ",
				"4142 --- Effets � recevoir ",
				"415 -- CLIENTS, �FFETS ESCOMPT�S NON �CHUS ",
				"416 -- CR�ANCES CLIENTS LITIGIEUSES OU DOUTEUSES ",
				"4161 --- Cr�ances litigieuses ",
				"4162 --- Cr�ances douteuses  ",
				"418 -- CLIENTS, PRODUITS � RECEVOIR ",
				"4181 --- Clients, factures � �tablir ",
				"4186 --- Clients, int�r�ts courus ",
				"419 -- CLIENTS CR�DITEURS ",
				"4191 --- Clients, avances et acomptes re�us ",
				"4192 --- Clients - Groupe, avances et acomptes re�us ",
				"4194 --- Clients, dettes pour emballages et mat�riels consign�s ",
				"4198 --- Rabais, Remises, Ristournes et autres avoirs � accorder", 
				"42 - PERSONNEL ",
				"421 -- PERSONNEL, AVANCES ET ACOMPTES ",
				"4211 --- Personnel, avances ",
				"4212 --- Personnel, acomptes ",
				"4213 --- Frais avanc�s et fournitures au personnel ",
				"422 -- PERSONNEL, R�MUN�RATIONS DUES ",
				"423 -- PERSONNEL, OPPOSITIONS, SAISIES-ARR�TS ",
				"4231 --- Personnel, oppositions ",
				"4232 --- Personnel, saisies-arr�ts ",
				"4233 --- Personnel, avis � tiers d�tenteur ",
				"424 -- PERSONNEL, OEUVRES SOCIALES INTERNES ",
				"4241 --- Assistance m�dicale ",
				"4242 --- Allocations familiales ",
				"4245 --- Organismes sociaux rattach�s � l'entreprise ",
				"4248 --- Autres oeuvres sociales internes ",
				"425 -- REPR�SENTANTS DU PERSONNEL ",
				"4251 --- D�l�gu�s du personnel ",
				"4252 --- Syndicats et Comit�s d'entreprises, d'�tablissement ",
				"4258 --- Autres repr�sentants du personnel ",
				"426 -- PERSONNEL, PARTICIPATION AUX B�N�FICES ",
				"427 -- PERSONNEL � D�P�TS ",
				"428 -- PERSONNEL, CHARGES � PAYER ET PRODUITS � RECEVOIR ",
				"4281 --- Dettes provisionn�es pour cong�s � payer", 
				"4286 --- Autres Charges � payer ",
				"4287 --- Produits � recevoir ",
				"43 - ORGANISMES SOCIAUX ",
				"431 -- S�CURIT� SOCIALE ",
				"4311 --- Prestations familiales ",
				"4312 --- Accidents de travail ",
				"4313 --- Caisse de retraite obligatoire ",
				"4314 --- Caisse de retraite facultative ",
				"4318 --- Autres cotisations sociales ",
				"432 --- CAISSES DE RETRAITE COMPL�MENTAIRE ",
				"433 -- AUTRES ORGANISMES SOCIAUX ",
				"4331 --- Mutuelle ",
				"438 -- ORGANISMES SOCIAUX, CHARGES � PAYER ET PRODUITS � RECEVOIR ",
				"4381 --- Charges sociales sur gratifications � payer ",
				"4382 --- Charges sociales sur cong�s � payer ",
				"4386 --- Autres charges � payer ",
				"4387 --- Produits � recevoir ",
				"44 - �TAT ET COLLECTIVIT�S PUBLIQUES ",
				"441 -- �TAT, IMP�T SUR LES B�N�FICES ",
				"442 -- �TAT, AUTRES IMP�TS ET TAXES ",
				"4421 --- Imp�ts et taxes d'Etat ",
				"4422 --- Imp�ts et taxes pour les collectivit�s publiques ",
				"4423 --- Imp�ts et taxes recouvrables sur des obligataires ", 
				"4424 --- Imp�ts et taxes recouvrables sur des associ�s ",
				"4426 --- Droits de douane ",
				"4428 --- Autres imp�ts et taxes ",
				"443 -- �TAT, T.V.A. FACTUR�E ",
				"4431 --- T.V.A. factur�e sur ventes ",
				"4432 --- T.V.A. factur�e sur prestations de services ",
				"4433 --- T.V.A. factur�e sur travaux ",
				"4334 --- T.V.A. factur�e sur production livr�e � soi-m�me ",
				"4335 --- T.V.A. sur factures � �tablir ",
				"444 -- �TAT, T.V.A. DUE OU CR�DIT DE T.V.A. ",
				"4441 --- �tat, T.V.A. due ",
				"4449 --- �tat, cr�dit de T.V.A. � reporter ",
				"445 -- �TAT, T.V.A. R�CUP�RABLE ", 
				"4451 --- T.V.A. r�cup�rable sur immobilisations  ",
				"4452 --- T.V.A. r�cup�rable sur achats ",
				"4453 --- T.V.A. r�cup�rable sur transport ",
				"4454 --- T.V.A. r�cup�rable sur services ext�rieurs et autres charges ",
				"4455 --- T.V.A. r�cup�rable sur factures non parvenues ",
				"4456 --- T.V.A. transf�r�e par d'autres entreprises ",
				"446 -- �TAT, AUTRES TAXES SUR LE CHIFFRE D'AFFAIRES ",
				"447 -- �TAT, IMP�TS RETENUS � LA SOURCE ",
				"4471 --- Imp�t G�n�ral sur le revenu ",
				"4472 --- Imp�ts sur salaires ",
				"4473 --- Contribution nationale ",
				"4474 --- Contribution nationale de solidarit� ",
				"4478 --- Autres imp�ts et contributions ",
				"448 -- �TAT, CHARGES � PAYER ET PRODUITS � RECEVOIR ",
				"4486 --- Charges � payer ",
				"4487 --- Produits � recevoir ",
				"449 --- �TAT, CR�ANCES ET DETTES DIVERSES ",
				"4491 --- �tat, obligations cautionn�es ",
				"4492 --- �tat, avances et acomptes vers�s sur imp�ts ",
				"4493 --- �tat, fonds de dotation � recevoir ",
				"4494 --- �tat, subventions d'�quipement � recevoir ",
				"4495 --- �tat, subventions d'exploitation � recevoir", 
				"4496 --- �tat, subventions d'�quilibre � recevoir ",
				"4499 --- �tat, fonds r�glement� provisionn� ",
				"45 - ORGANISMES INTERNATIONAUX ",
				"451 -- OP�RATIONS AVEC LES ORGANISMES AFRICAINS ",
				"452 -- OP�RATIONS AVEC LES AUTRES ORGANISMES INTERNATIONAUX ",
				"458 -- ORGANISMES INTERNATIONAUX, FONDS DE DOTATION ET SUBVENTIONS � RECEVOIR ",
				"4581 --- Organismes internationaux, fonds de dotation � recevoir ",
				"4582 --- Organismes internationaux, subventions � recevoir ", 
				"46 - ASSOCI�S ET GROUPE ",
				"461 -- ASSOCI�S, OP�RATIONS SUR LE CAPITAL ",
				"4611 --- Associ�s apports en nature ",
				"4612 --- Associ�s apports en num�raire  ",
				"4613 --- Actionnaires, capital souscrit appel� non vers� ",
				"4614 --- Associ�s, capital appel� non vers� ",
				"4615 --- Associ�s, versements re�us sur augmentation de capital ",
				"4616 --- Associ�s, versements anticip�s ",
				"4617 --- Actionnaires d�faillants ",
				"4618 --- Associ�s, autres apports ",
				"4619 --- Associ�s, capital � rembourser ",
				"462 -- ASSOCI�S, COMPTES COURANTS ",
				"4621 --- Principal ",
				"4626 --- Int�r�ts courus ",
				"463 -- ASSOCI�S, OP�RATIONS FAITES EN COMMUN ",
				"465 -- ASSOCI�S, DIVIDENDES � PAYER ",
				"466 -- GROUPE, COMPTES COURANTS ",
				"467 -- ACTIONNAIRES, RESTANT D� SUR CAPITAL APPEL� ",
				"47 - D�BITEURS ET CR�DITEURS DIVERS ",
				"471 -- COMPTES D'ATTENTE ",
				"4711 --- D�biteurs divers ",
				"4712 --- Cr�diteurs divers ",
				"472 -- VERSEMENTS RESTANT � EFFECTUER SUR TITRES NON LIB�R�S ",
				"4726 --- Titres de participation ",
				"4727 --- Titres immobilis�s ",
				"4728 --- Titres de placement ",
				"474 -- R�PARTITION P�RIODIQUE DES CHARGES ET DES PRODUITS ",
				"4746 --- Charges ",
				"4747 --- Produits ",
				"475 -- CR�ANCES SUR TRAVAUX NON ENCORE FACTURABLES ",
				"476 -- CHARGES CONSTAT�ES D'AVANCE ",
				"477 -- PRODUITS CONSTAT�S D'AVANCE ",
				"478 -- �CARTS DE CONVERSION - ACTIF ",
				"4781 --- Diminution des cr�ances ",
				"4782 --- Augmentation des dettes ",
				"4788 --- Diff�rences compens�es par couverture de change ",
				"479 -- �CARTS DE CONVERSION - PASSIF ",
				"4791 --- Augmentation des cr�ances  ",
				"4792 --- Diminution des dettes ",
				"4798 --- Diff�rences compens�es par couverture de change ",
				"48 - CR�ANCES ET DETTES HORS ACTIVIT�S ORDINAIRES (HAO)",
				"481 -- FOURNISSEURS D'INVESTISSEMENTS ",
				"4811 --- Immobilisations incorporelles ",
				"4812 --- Immobilisations corporelles ",
				"4817 --- Retenues de garantie ",
				"4818 --- Factures non parvenues ",
				"482 -- FOURNISSEURS D'INVESTISSEMENTS, EFFETS � PAYER ",
				"483 -- DETTES SUR ACQUISITION DE TITRES DE PLACEMENT ",
				"484 -- AUTRES DETTES HORS ACTIVITES ORDINAIRES (H.A.O.) ",
				"485 -- CR�ANCES SUR CESSIONSD'IMMOBILISATIONS ",
				"4851 --- En compte ",
				"4852 --- Effets � recevoir ",
				"4857 --- Retenues de garantie", 
				"4858 --- Factures � �tablir ",
				"486 -- CR�ANCES SUR CESSIONS DE TITRES DE PLACEMENT ",
				"488 -- AUTRES CR�ANCES HORS ACTIVIT�S ORDINAIRES (H.A.O.) ",
				"49 - D�PR�CIATIONS ET RISQUES PROVISIONN�S (TIERS) ",
				"490 -- D�PR�CIATIONS DES COMPTES FOURNISSEURS ",
				"491 -- D�PR�CIATIONS DES COMPTES CLIENTS ",
				"4911 --- Cr�ances litigieuses ",
				"4912 --- Cr�ances douteuses ",
				"492 -- D�PR�CIATIONS DES COMPTES PERSONNEL ",
				"493 -- D�PR�CIATIONS DES COMPTES ORGANISMES SOCIAUX ",
				"494 -- D�PR�CIATIONS DES COMPTES �TAT ET COLLECTIVIT�S PUBLIQUES ",
				"495 -- D�PR�CIATIONS DES COMPTES ORGANISMES INTERNATIONAUX ",
				"496 -- D�PR�CIATIONS DES COMPTES ASSOCI�S ET GROUPE ",
				"4962 --- Associ�s, comptes courants ",
				"4963 --- Associ�s, op�rations faites en commun ",
				"4966 --- Groupe, comptes courants ",
				"497 -- D�PR�CIATIONS DES COMPTES D�BITEURS DIVERS ",
				"498 -- D�PR�CIATIONS DES COMPTES DE CR�ANCES H.A.O. ",
				"4981 --- Cr�ances sur cessions d'immobilisations  ",
				"4982 --- Cr�ances sur cessions de titres de placement ",
				"4983 --- Autres cr�ances H.A.O. ",
				"499 -- RISQUES PROVISIONN�S ",
				"4991 --- Sur op�rations d'exploitation ",
				"4998 --- Sur op�rations H.A.O. ",
		};
		lv = (ListView) findViewById(R.id.liste_comptes_tiers);
        inputSearch = (EditText) findViewById(R.id.Recherche_tiers);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nom_compte, liste_tiers);
        lv.setAdapter(adapter);
        
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                Tiers.this.adapter.getFilter().filter(cs);  
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
		getMenuInflater().inflate(R.menu.tiers, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		
		
		if (item.getItemId() == R.id.action_settings) {
       	startActivity(new Intent(this, About.class));
         }
		
		return super.onOptionsItemSelected(item);
		
	}

}
