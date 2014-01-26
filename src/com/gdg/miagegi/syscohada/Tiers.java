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
				"40 - FOURNISSEURS ET COMPTES RATTACHÉS ",
				"401 -- FOURNISSEURS, DETTES EN COMPTE ",
				"4011 --- Fournisseurs ",
				"4012 --- Fournisseurs Groupe ",
				"4013 --- Fournisseurs sous-traitants ",
				"4017 --- Fournisseur, retenues de garantie ",
				"402 -- FOURNISSEURS, EFFETS À PAYER ",
				"4021 --- Fournisseurs, Effets à payer ",
				"4022 --- Fournisseurs - Groupe, Effets à payer ",
				"4023 --- Fournisseurs sous-traitants, Effets à payer ",
				"408 -- FOURNISSEURS, FACTURES NON PARVENUES ",
				"4081 --- Fournisseurs ",
				"4082 --- Fournisseurs - Groupe", 
				"4083 --- Fournisseurs sous-traitants ",
				"4086 --- Fournisseurs, intérêts courus", 
				"409 -- FOURNISSEURS DÉBITEURS ",
				"4091 --- Fournisseurs avances et acomptes versés ",
				"4092 --- Fournisseurs - Groupe avances et acomptes versés ",
				"4093 --- Fournisseurs sous-traitants avances et acomptes versés ",
				"4094 --- Fournisseurs créances pour emballages et matériels à rendre ",
				"4098 --- Rabais, Remises, Ristournes et autres avoirs à obtenir ",
				"41 - CLIENTS ET COMPTES RATTACHÉS",
				"411 -- CLIENTS ",
				"4111 --- Clients ",
				"4112 --- Clients - Groupe ",
				"4114 --- Clients, État et Collectivités publiques",
				"4115 --- Clients, organismes internationaux ",
				"4117 --- Client, retenues de garantie ",				
				"4118 --- Clients, dégrèvement de Taxes sur la Valeur Ajoutée (T.V.A.) ",
				"412 -- CLIENTS, ÉFFETS À RECEVOIR EN PORTEFEUILLE ",
				"4121 --- Clients, Effets à recevoir ",
				"4122 --- Clients - Groupe, Effets à recevoir ",
				"4124 --- État et Collectivités publiques, Effets à recevoir ",
				"4125 --- Organismes Internationaux, Effets à recevoir ",
				"414 -- CRÉANCES SUR CESSIONSD'IMMOBILISATIONS ",
				"4141 --- Créances en compte ",
				"4142 --- Effets à recevoir ",
				"415 -- CLIENTS, ÉFFETS ESCOMPTÉS NON ÉCHUS ",
				"416 -- CRÉANCES CLIENTS LITIGIEUSES OU DOUTEUSES ",
				"4161 --- Créances litigieuses ",
				"4162 --- Créances douteuses  ",
				"418 -- CLIENTS, PRODUITS À RECEVOIR ",
				"4181 --- Clients, factures à établir ",
				"4186 --- Clients, intérêts courus ",
				"419 -- CLIENTS CRÉDITEURS ",
				"4191 --- Clients, avances et acomptes reçus ",
				"4192 --- Clients - Groupe, avances et acomptes reçus ",
				"4194 --- Clients, dettes pour emballages et matériels consignés ",
				"4198 --- Rabais, Remises, Ristournes et autres avoirs à accorder", 
				"42 - PERSONNEL ",
				"421 -- PERSONNEL, AVANCES ET ACOMPTES ",
				"4211 --- Personnel, avances ",
				"4212 --- Personnel, acomptes ",
				"4213 --- Frais avancés et fournitures au personnel ",
				"422 -- PERSONNEL, RÉMUNÉRATIONS DUES ",
				"423 -- PERSONNEL, OPPOSITIONS, SAISIES-ARRÊTS ",
				"4231 --- Personnel, oppositions ",
				"4232 --- Personnel, saisies-arrêts ",
				"4233 --- Personnel, avis à tiers détenteur ",
				"424 -- PERSONNEL, OEUVRES SOCIALES INTERNES ",
				"4241 --- Assistance médicale ",
				"4242 --- Allocations familiales ",
				"4245 --- Organismes sociaux rattachés à l'entreprise ",
				"4248 --- Autres oeuvres sociales internes ",
				"425 -- REPRÉSENTANTS DU PERSONNEL ",
				"4251 --- Délégués du personnel ",
				"4252 --- Syndicats et Comités d'entreprises, d'Établissement ",
				"4258 --- Autres représentants du personnel ",
				"426 -- PERSONNEL, PARTICIPATION AUX BÉNÉFICES ",
				"427 -- PERSONNEL – DÉPÔTS ",
				"428 -- PERSONNEL, CHARGES À PAYER ET PRODUITS À RECEVOIR ",
				"4281 --- Dettes provisionnées pour congés à payer", 
				"4286 --- Autres Charges à payer ",
				"4287 --- Produits à recevoir ",
				"43 - ORGANISMES SOCIAUX ",
				"431 -- SÉCURITÉ SOCIALE ",
				"4311 --- Prestations familiales ",
				"4312 --- Accidents de travail ",
				"4313 --- Caisse de retraite obligatoire ",
				"4314 --- Caisse de retraite facultative ",
				"4318 --- Autres cotisations sociales ",
				"432 --- CAISSES DE RETRAITE COMPLÉMENTAIRE ",
				"433 -- AUTRES ORGANISMES SOCIAUX ",
				"4331 --- Mutuelle ",
				"438 -- ORGANISMES SOCIAUX, CHARGES À PAYER ET PRODUITS À RECEVOIR ",
				"4381 --- Charges sociales sur gratifications à payer ",
				"4382 --- Charges sociales sur congés à payer ",
				"4386 --- Autres charges à payer ",
				"4387 --- Produits à recevoir ",
				"44 - ÉTAT ET COLLECTIVITÉS PUBLIQUES ",
				"441 -- ÉTAT, IMPÔT SUR LES BÉNÉFICES ",
				"442 -- ÉTAT, AUTRES IMPÔTS ET TAXES ",
				"4421 --- Impôts et taxes d'Etat ",
				"4422 --- Impôts et taxes pour les collectivités publiques ",
				"4423 --- Impôts et taxes recouvrables sur des obligataires ", 
				"4424 --- Impôts et taxes recouvrables sur des associés ",
				"4426 --- Droits de douane ",
				"4428 --- Autres impôts et taxes ",
				"443 -- ÉTAT, T.V.A. FACTURÉE ",
				"4431 --- T.V.A. facturée sur ventes ",
				"4432 --- T.V.A. facturée sur prestations de services ",
				"4433 --- T.V.A. facturée sur travaux ",
				"4334 --- T.V.A. facturée sur production livrée à soi-même ",
				"4335 --- T.V.A. sur factures à établir ",
				"444 -- ÉTAT, T.V.A. DUE OU CRÉDIT DE T.V.A. ",
				"4441 --- État, T.V.A. due ",
				"4449 --- État, crédit de T.V.A. à reporter ",
				"445 -- ÉTAT, T.V.A. RÉCUPÉRABLE ", 
				"4451 --- T.V.A. récupérable sur immobilisations  ",
				"4452 --- T.V.A. récupérable sur achats ",
				"4453 --- T.V.A. récupérable sur transport ",
				"4454 --- T.V.A. récupérable sur services extérieurs et autres charges ",
				"4455 --- T.V.A. récupérable sur factures non parvenues ",
				"4456 --- T.V.A. transférée par d'autres entreprises ",
				"446 -- ÉTAT, AUTRES TAXES SUR LE CHIFFRE D'AFFAIRES ",
				"447 -- ÉTAT, IMPÔTS RETENUS À LA SOURCE ",
				"4471 --- Impôt Général sur le revenu ",
				"4472 --- Impôts sur salaires ",
				"4473 --- Contribution nationale ",
				"4474 --- Contribution nationale de solidarité ",
				"4478 --- Autres impôts et contributions ",
				"448 -- ÉTAT, CHARGES À PAYER ET PRODUITS À RECEVOIR ",
				"4486 --- Charges à payer ",
				"4487 --- Produits à recevoir ",
				"449 --- ÉTAT, CRÉANCES ET DETTES DIVERSES ",
				"4491 --- État, obligations cautionnées ",
				"4492 --- État, avances et acomptes versés sur impôts ",
				"4493 --- État, fonds de dotation à recevoir ",
				"4494 --- État, subventions d'équipement à recevoir ",
				"4495 --- État, subventions d'exploitation à recevoir", 
				"4496 --- État, subventions d'équilibre à recevoir ",
				"4499 --- État, fonds réglementé provisionné ",
				"45 - ORGANISMES INTERNATIONAUX ",
				"451 -- OPÉRATIONS AVEC LES ORGANISMES AFRICAINS ",
				"452 -- OPÉRATIONS AVEC LES AUTRES ORGANISMES INTERNATIONAUX ",
				"458 -- ORGANISMES INTERNATIONAUX, FONDS DE DOTATION ET SUBVENTIONS À RECEVOIR ",
				"4581 --- Organismes internationaux, fonds de dotation à recevoir ",
				"4582 --- Organismes internationaux, subventions à recevoir ", 
				"46 - ASSOCIÉS ET GROUPE ",
				"461 -- ASSOCIÉS, OPÉRATIONS SUR LE CAPITAL ",
				"4611 --- Associés apports en nature ",
				"4612 --- Associés apports en numéraire  ",
				"4613 --- Actionnaires, capital souscrit appelé non versé ",
				"4614 --- Associés, capital appelé non versé ",
				"4615 --- Associés, versements reçus sur augmentation de capital ",
				"4616 --- Associés, versements anticipés ",
				"4617 --- Actionnaires défaillants ",
				"4618 --- Associés, autres apports ",
				"4619 --- Associés, capital à rembourser ",
				"462 -- ASSOCIÉS, COMPTES COURANTS ",
				"4621 --- Principal ",
				"4626 --- Intérêts courus ",
				"463 -- ASSOCIÉS, OPÉRATIONS FAITES EN COMMUN ",
				"465 -- ASSOCIÉS, DIVIDENDES À PAYER ",
				"466 -- GROUPE, COMPTES COURANTS ",
				"467 -- ACTIONNAIRES, RESTANT DÛ SUR CAPITAL APPELÉ ",
				"47 - DÉBITEURS ET CRÉDITEURS DIVERS ",
				"471 -- COMPTES D'ATTENTE ",
				"4711 --- Débiteurs divers ",
				"4712 --- Créditeurs divers ",
				"472 -- VERSEMENTS RESTANT À EFFECTUER SUR TITRES NON LIBÉRÉS ",
				"4726 --- Titres de participation ",
				"4727 --- Titres immobilisés ",
				"4728 --- Titres de placement ",
				"474 -- RÉPARTITION PÉRIODIQUE DES CHARGES ET DES PRODUITS ",
				"4746 --- Charges ",
				"4747 --- Produits ",
				"475 -- CRÉANCES SUR TRAVAUX NON ENCORE FACTURABLES ",
				"476 -- CHARGES CONSTATÉES D'AVANCE ",
				"477 -- PRODUITS CONSTATÉS D'AVANCE ",
				"478 -- ÉCARTS DE CONVERSION - ACTIF ",
				"4781 --- Diminution des créances ",
				"4782 --- Augmentation des dettes ",
				"4788 --- Différences compensées par couverture de change ",
				"479 -- ÉCARTS DE CONVERSION - PASSIF ",
				"4791 --- Augmentation des créances  ",
				"4792 --- Diminution des dettes ",
				"4798 --- Différences compensées par couverture de change ",
				"48 - CRÉANCES ET DETTES HORS ACTIVITÉS ORDINAIRES (HAO)",
				"481 -- FOURNISSEURS D'INVESTISSEMENTS ",
				"4811 --- Immobilisations incorporelles ",
				"4812 --- Immobilisations corporelles ",
				"4817 --- Retenues de garantie ",
				"4818 --- Factures non parvenues ",
				"482 -- FOURNISSEURS D'INVESTISSEMENTS, EFFETS À PAYER ",
				"483 -- DETTES SUR ACQUISITION DE TITRES DE PLACEMENT ",
				"484 -- AUTRES DETTES HORS ACTIVITES ORDINAIRES (H.A.O.) ",
				"485 -- CRÉANCES SUR CESSIONSD'IMMOBILISATIONS ",
				"4851 --- En compte ",
				"4852 --- Effets à recevoir ",
				"4857 --- Retenues de garantie", 
				"4858 --- Factures à établir ",
				"486 -- CRÉANCES SUR CESSIONS DE TITRES DE PLACEMENT ",
				"488 -- AUTRES CRÉANCES HORS ACTIVITÉS ORDINAIRES (H.A.O.) ",
				"49 - DÉPRÉCIATIONS ET RISQUES PROVISIONNÉS (TIERS) ",
				"490 -- DÉPRÉCIATIONS DES COMPTES FOURNISSEURS ",
				"491 -- DÉPRÉCIATIONS DES COMPTES CLIENTS ",
				"4911 --- Créances litigieuses ",
				"4912 --- Créances douteuses ",
				"492 -- DÉPRÉCIATIONS DES COMPTES PERSONNEL ",
				"493 -- DÉPRÉCIATIONS DES COMPTES ORGANISMES SOCIAUX ",
				"494 -- DÉPRÉCIATIONS DES COMPTES ÉTAT ET COLLECTIVITÉS PUBLIQUES ",
				"495 -- DÉPRÉCIATIONS DES COMPTES ORGANISMES INTERNATIONAUX ",
				"496 -- DÉPRÉCIATIONS DES COMPTES ASSOCIÉS ET GROUPE ",
				"4962 --- Associés, comptes courants ",
				"4963 --- Associés, opérations faites en commun ",
				"4966 --- Groupe, comptes courants ",
				"497 -- DÉPRÉCIATIONS DES COMPTES DÉBITEURS DIVERS ",
				"498 -- DÉPRÉCIATIONS DES COMPTES DE CRÉANCES H.A.O. ",
				"4981 --- Créances sur cessions d'immobilisations  ",
				"4982 --- Créances sur cessions de titres de placement ",
				"4983 --- Autres créances H.A.O. ",
				"499 -- RISQUES PROVISIONNÉS ",
				"4991 --- Sur opérations d'exploitation ",
				"4998 --- Sur opérations H.A.O. ",
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
