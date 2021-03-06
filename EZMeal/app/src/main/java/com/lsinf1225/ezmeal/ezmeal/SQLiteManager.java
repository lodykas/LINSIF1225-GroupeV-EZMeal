package com.lsinf1225.ezmeal.ezmeal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.lsinf1225.ezmeal.ezmeal.R.string.usermail;
import static java.lang.StrictMath.max;


public class SQLiteManager extends SQLiteOpenHelper {
    /**
     * Nom du fichier de la base de donnees.
     */
    private static final String DATABASE_NAME = "database.sqlite";

    /**
     * Version de la base de donnees (à  incrementer en cas de modification de celle-ci afin que la
     * methode onUpgrade soit appelee).
     *
     * @note Le numero de version doit changer de maniere monotone.
     */
    private static final int DATABASE_VERSION = 1;

    private Context context;
    /**
     * Constructeur. Instancie l'utilitaire de gestion de la base de donnees.
     *
     * @param context Contexte de l'application.
     */
    public SQLiteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    /**
     * Methode d'initialisation appelee lors de la creation de la base de donnees.
     * Ici on y cree les tables de la base de donnees et les remplit.
     *
     * @param db Base de donnees à  initialiser.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Utilisateur\" (\"Usermail\" PRIMARY KEY,\"Résidence\" NOT NULL,\"PaysDOrigine\" NOT NULL,\"MotDePasse\" NOT NULL,\"DateDeNaissance\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Recommandations\" (\"Usermail\" NOT NULL,\"Recette\" NOT NULL);");
        //SQLiteStatement s = db.compileStatement("INSERT INTO \"Recommandations\"(\"Usermail\",\"Recette\") VALUES(?,?)");
        //s.bindString(1,"blabla");
       // s.bindString(2,"Soupe à l'oignon");
       // s.execute();
        //s.bindString(1,"blabla");
       // s.bindString(2,"Macaroni au fromage");
       // s.execute();
       // s.bindString(1,"blabla");
       // s.bindString(2,"Spaghetti bolognaise");
       // s.execute();
       // s.bindString(1,"blabla");
       // s.bindString(2,"Salade césar");
       // s.execute();
        //s.bindString(1,"a");
       // s.bindString(2,"Soupe à l'oignon");
        //s.execute();
        //s.bindString(1,"a");
        //s.bindString(2,"Macaroni au fromage");
        //s.execute();
       // s.bindString(1,"a");
       // s.bindString(2,"Spaghetti bolognaise");
        //s.execute();
       // s.bindString(1,"usermail");
       // s.bindString(2,"foire de légumes");
       // s.execute();


        db.execSQL("CREATE TABLE IF NOT EXISTS \"Effectués\" (\"Recette\" NOT NULL, \"Username\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Consommés\" (\"Ingrédient\" NOT NULL, \"Username\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Allergène\" (\"Usermail\" NOT NULL,\"Allergène\" NOT NULL);");

        db.execSQL("CREATE TABLE IF NOT EXISTS \"Ingrédients\" (\"Libellé\" PRIMARY KEY, \"Allergène\", \"Unité\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Famille\" (\"Ingrédient\" NOT NULL, \"famille\" NOT NULL);");
         SQLiteStatement in=db.compileStatement("INSERT INTO\"Ingrédients\"(\"Libellé\",\"Allergène\",\"Unité\")VALUES(?,?,?)");
        in.bindString(1,"parmesan");
        in.bindString(2,"Lactose");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"fruits rouges congelés");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"creme liquide");
        in.bindString(2,"Lactose");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"céleri");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"carotte");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"pastèque");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"farine");
        in.bindString(2,"Gluten");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"beurre");
        in.bindString(2,"Lactose");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"oignon");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"lait d'amande");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"consommé de volaille");
        in.bindString(2,"Soy");
        in.bindString(3,"l");
        in.execute();
        in.bindString(1,"macaronis longs ou de pennes");
        in.bindString(2,"Gluten");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"poivre");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"sel");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"fromage à raclette sans croûte");
        in.bindString(2,"Lactose");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"noix de muscade");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"tomates");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"vin rouge");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"viande hachée");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"bouillon");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"huile");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"huile d'olive");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"huile d'arachide");
        in.bindString(2,"Peanuts");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"gousse d'ail");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"citron");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"chocolat");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"salade romaine");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"persil");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"sucre");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"sucre vanillé");
        in.bindString(2," ");
        in.bindString(3,"sachet");
        in.execute();
        in.bindString(1,"citron vert");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"sirop d'agave");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"rhum blanc");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"feuilles de menthe");
        in.bindString(2," ");
        in.bindString(3,"pièce");
        in.execute();
        in.bindString(1,"cannelle");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"lait");
        in.bindString(2,"Lactose");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"chantilly");
        in.bindString(2,"Lactose");
        in.bindString(3,"pompe");
        in.execute();
        in.bindString(1,"cacao");
        in.bindString(2," ");
        in.bindString(3,"cuillière à café");
        in.execute();
        in.bindString(1,"navets");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"pommes de terre");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"courgettes");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"curry japonais");
        in.bindString(2,"Soy");
        in.bindString(3,"paquet");
        in.execute();
        in.bindString(1,"cassonade");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"levure");
        in.bindString(2," ");
        in.bindString(3,"sachet");
        in.execute();
        in.bindString(1,"amande");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"flocons d'avoine");
        in.bindString(2,"Gluten");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"gin");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"noisette");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"noix");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"noix de cajou");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"lait concentré");
        in.bindString(2,"Lactose");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"miel");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"thé thaï");
        in.bindString(2," ");
        in.bindString(3,"cuillière à soupe");
        in.execute();
        in.bindString(1,"lait de soja");
        in.bindString(2,"Soy");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"sucre de canne");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"cognac");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"olive noires");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"herbes de provence");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"champignons");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"sauce");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"échalote");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"piment");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"poulet");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"sucre brun");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"paprika");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"coriandre");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"curcuma");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"bananes");
        in.bindString(2,"Banana");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"pâte de curry rouge");
        in.bindString(2,"Soy");
        in.bindString(3,"cuillière à soupe");
        in.execute();
        in.bindString(1,"cumin en poudre");
        in.bindString(2," ");
        in.bindString(3,"pincée");
        in.execute();
        in.bindString(1,"tapioca");
        in.bindString(2," ");
        in.bindString(3,"sachet");
        in.execute();
        in.bindString(1,"sucre semoule");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"eau");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"oeufs");
        in.bindString(2,"Eggs");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"tranches de pain gratinées au beurre");
        in.bindString(2,"Gluten");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"baguette");
        in.bindString(2,"Gluten");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"vanille");
        in.bindString(2," ");
        in.bindString(3,"batonnet");
        in.execute();
        in.bindString(1,"sucre glace");
        in.bindString(2," ");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"clous de girofle");
        in.bindString(2," ");
        in.bindString(3,"");
        in.execute();
        in.bindString(1,"perrier");
        in.bindString(2," ");
        in.bindString(3,"cl");
        in.execute();
        in.bindString(1,"jambon");
        in.bindString(2," ");
        in.bindString(3,"tranche");
        in.execute();
        in.bindString(1,"cacahuètes");
        in.bindString(2,"Peanuts");
        in.bindString(3,"gr");
        in.execute();
        in.bindString(1,"fromage blanc");
        in.bindString(2,"Lactose");
        in.bindString(3,"gr");
        in.execute();
        SQLiteStatement f=db.compileStatement("INSERT INTO\"Famille\"(\"Ingrédient\",\"famille\")VALUES (?,?)");
        f.bindString(1,"parmesan");
        f.bindString(2,"produit laitier");
        f.execute();
        f.bindString(1,"fromage blanc");
        f.bindString(2,"produit laitier");
        f.execute();
        f.bindString(1,"creme liquide");
        f.bindString(2,"produit laitier");
        f.execute();
        f.bindString(1,"céleri");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"carotte");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"pastèque");
        f.bindString(2,"fruit");
        f.execute();
        f.bindString(1,"beurre");
        f.bindString(2,"produit laitier");
        f.execute();
        f.bindString(1,"farine");
        f.bindString(2,"céréal");
        f.execute();
        f.bindString(1,"oignon");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"fruits rouges congelés");
        f.bindString(2,"fruit");
        f.execute();
        f.bindString(1,"lait d'amande");
        f.bindString(2,"lait");
        f.execute();
        f.bindString(1,"lait d'amande");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"creme liquide");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"consommé de volaille");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"porto rouge");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"tranches de pain gratinées au beurre");
        f.bindString(2,"féculents");
        f.execute();
        f.bindString(1,"oeufs");
        f.bindString(2,"protéines");
        f.execute();
        f.bindString(1,"macaronis longs ou de pennes");
        f.bindString(2,"féculents");
        f.execute();
        f.bindString(1,"poivre");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"sel");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"fromage à raclette sans croûte");
        f.bindString(2,"produit laitier");
        f.execute();
        f.bindString(1,"fromage à raclette sans croûte");
        f.bindString(2,"fromage");
        f.execute();
        f.bindString(1,"noix de muscade");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"tomates");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"vin rouge");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"viande hachée");
        f.bindString(2,"viande");
        f.execute();
        f.bindString(1,"bouillon");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"huile");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"salade romaine");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"persil");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"sucre");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"poivre");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"baguette");
        f.bindString(2,"féculents");
        f.execute();
        f.bindString(1,"huile d'olive");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"huile d'olive");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"gousses d'ail");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"citron");
        f.bindString(2,"fruit");
        f.execute();
        f.bindString(1,"chocolat");
        f.bindString(2,"confisserie");
        f.execute();
        f.bindString(1,"sucre vanillé");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"sirop d'agave");
        f.bindString(2,"confisserie");
        f.execute();
        f.bindString(1,"rhum blanc");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"citron vert");
        f.bindString(2,"fruit");
        f.execute();
        f.bindString(1,"feuilles de menthe");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"sucre vanillé");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"cannelle");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"sucre fin");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"vanille");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"sucre glace");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"lait");
        f.bindString(2,"produit laitier");
        f.execute();
        f.bindString(1,"lait");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"clous de girofle");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"chantilly");
        f.bindString(2,"produit laitier");
        f.execute();
        f.bindString(1,"cacao");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"navets");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"pommes de terre");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"pommes de terre");
        f.bindString(2,"féculents");
        f.execute();
        f.bindString(1,"courgettes");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"curry japonais");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"cassonade");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"levure");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"huile d'arachide");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"gin");
        f.bindString(2,"alcool");
        f.execute();
        f.bindString(1,"amande");
        f.bindString(2,"fruit sec");
        f.execute();
        f.bindString(1,"noisette");
        f.bindString(2,"fruit sec");
        f.execute();
        f.bindString(1,"flocons d'avoine");
        f.bindString(2,"cereal");
        f.execute();
        f.bindString(1,"noix");
        f.bindString(2,"fruit sec");
        f.execute();
        f.bindString(1,"noix de cajou");
        f.bindString(2,"fruit sec");
        f.execute();
        f.bindString(1,"miel");
        f.bindString(2,"confisserie");
        f.execute();
        f.bindString(1,"lait concentré");
        f.bindString(2,"confisserie");
        f.execute();
        f.bindString(1,"lait concentré");
        f.bindString(2,"produit laitier");
        f.execute();
        f.bindString(1,"thé thaï");
        f.bindString(2,"the");
        f.execute();
        f.bindString(1,"lait de soja");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"sucre de canne");
        f.bindString(2,"confisserie");
        f.execute();
        f.bindString(1,"cognac");
        f.bindString(2,"alcool");
        f.execute();
        f.bindString(1,"perrier");
        f.bindString(2,"liquide");
        f.execute();
        f.bindString(1,"jambon");
        f.bindString(2,"viande");
        f.execute();
        f.bindString(1,"champignons");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"olive noires");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"herbes de provence");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"sauce");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"échalote");
        f.bindString(2,"légumes");
        f.execute();
        f.bindString(1,"piment");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"paprika");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"poulet");
        f.bindString(2,"viande");
        f.execute();
        f.bindString(1,"sucre brun");
        f.bindString(2,"confisserie");
        f.execute();
        f.bindString(1,"coriandre");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"curcuma");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"cacahuètes");
        f.bindString(2,"fruit sec");
        f.execute();
        f.bindString(1,"bananes");
        f.bindString(2,"fruit");
        f.execute();
        f.bindString(1,"pâte de curry rouge");
        f.bindString(2,"pate");
        f.execute();
        f.bindString(1,"cumin en poudre");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"tapioca");
        f.bindString(2,"confisserie");
        f.execute();
        f.bindString(1,"sucre semoule");
        f.bindString(2,"condiment");
        f.execute();
        f.bindString(1,"eau");
        f.bindString(2,"liquide");
        f.execute();


        db.execSQL("CREATE TABLE IF NOT EXISTS \"Recette\" ( _id INTEGER PRIMARY KEY AUTOINCREMENT,\"NomRecette\" NOT NULL,\"Image\" NOT NULL,\"Instructions\" NOT NULL,\"DateDAjout\" NOT NULL,\"Origine\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Catégories\" (\"NomRecette\" NOT NULL,\"Catégorie\" NOT NULL);");
        SQLiteStatement d= db.compileStatement("INSERT INTO\"Catégories\"(\"NomRecette\",\"Catégorie\") VALUES(?,?)");
        d.bindString(1,"Milkshake berry");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"Mojito");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"Soupe oignon");
        d.bindString(2,"entree");
        d.execute();
        d.bindString(1,"Macaroni au fromage");
        d.bindString(2,"plat");
        d.execute();
        d.bindString(1,"Spaghetti bolognaise");
        d.bindString(2,"plat");
        d.execute();
        d.bindString(1,"Salade césar");
        d.bindString(2,"entree");
        d.execute();
        d.bindString(1,"Mousse au chocolat");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"Rhum citron miel");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"Gaufre Belge");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"Chocolat chaud de Noël");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"Curry japonais");
        d.bindString(2,"plat");
        d.execute();
        d.bindString(1,"Donut");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"Gin à la framboise");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"Granola maison");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"Thé glacé thaï");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"Crêpes sucrées");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"Boisson saine et sans allergènes");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"Mini pizza");
        d.bindString(2,"entree");
        d.execute();
        d.bindString(1,"Oignon rings");
        d.bindString(2,"entree");
        d.execute();
        d.bindString(1,"Fish and chips");
        d.bindString(2,"plat");
        d.execute();
        d.bindString(1,"Brochette satay");
        d.bindString(2,"entree");
        d.execute();
        d.bindString(1,"Cake au banane");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"Perle de coco");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"Meringue Italienne");
        d.bindString(2,"dessert");
        d.execute();


        db.execSQL("CREATE TABLE IF NOT EXISTS \"Sous_catégorie\" (\"NomRecette\" NOT NULL,\"sous_catégorie\" NOT NULL);");
        SQLiteStatement sc=db.compileStatement("INSERT INTO\"sous_catégorie\"(\"NomRecette\",\"sous_catégorie\")VALUES(?,?)");
        sc.bindString(1,"Soupe oignon");
        sc.bindString(2,"soups");
        sc.execute();
        sc.bindString(1,"Soupe oignon");
        sc.bindString(2,"hot");
        sc.execute();
        sc.bindString(1,"Soupe oignon");
        sc.bindString(2,"other origine");
        sc.execute();
        sc.bindString(1,"Macaroni au fromage");
        sc.bindString(2,"vegetarian");
        sc.execute();
        sc.bindString(1,"Macaroni au fromage");
        sc.bindString(2,"italian");
        sc.execute();
        sc.bindString(1,"Spaghetti bolognaise");
        sc.bindString(2,"meat");
        sc.execute();
        sc.bindString(1,"Spaghetti bolognaise");
        sc.bindString(2,"italian");
        sc.execute();
        sc.bindString(1,"Salade césar");
        sc.bindString(2,"cold");
        sc.execute();
        sc.bindString(1,"Mojito");
        sc.bindString(2,"alcool");
        sc.execute();
        sc.bindString(1,"Rhum miel citron");
        sc.bindString(2,"alcool");
        sc.execute();
        sc.bindString(1,"Gin à la framboise");
        sc.bindString(2,"alcool");
        sc.execute();
        sc.bindString(1,"Chocolat chaud de Noël");
        sc.bindString(2,"hot");
        sc.execute();
        sc.bindString(1,"Thé glacé thaï");
        sc.bindString(2,"cold");
        sc.execute();
        sc.bindString(1,"Milkshake berry");
        sc.bindString(2,"cold");
        sc.execute();
        sc.bindString(1,"Boisson saine et sans allergènes");
        sc.bindString(2,"cold");
        sc.execute();
        sc.bindString(1,"Mousse au chocolat");
        sc.bindString(2,"quick and easy");
        sc.execute();
        sc.bindString(1,"Mousse au chocolat");
        sc.bindString(2,"other country");
        sc.execute();
        sc.bindString(1,"Gaufre Belge");
        sc.bindString(2,"hot");
        sc.execute();
        sc.bindString(1,"Crêpes sucrées");
        sc.bindString(2,"hot");
        sc.execute();
        sc.bindString(1,"Crêpes sucrées");
        sc.bindString(2,"quick and easy");
        sc.execute();
        sc.bindString(1,"Gaufre Belge");
        sc.bindString(2,"other country");
        sc.execute();
        sc.bindString(1,"Meringue Italienne");
        sc.bindString(2,"italian");
        sc.execute();
        sc.bindString(1,"Perle de coco");
        sc.bindString(2,"asian");
        sc.execute();
        sc.bindString(1,"Donut de New York");
        sc.bindString(2,"american");
        sc.execute();
        sc.bindString(1,"Cake au banane");
        sc.bindString(2,"cake");
        sc.execute();
        sc.bindString(1,"Gaufre Belge");
        sc.bindString(2,"hot");
        sc.execute();
        sc.bindString(1,"Gaufre Belge");
        sc.bindString(2,"other country");
        sc.execute();
        sc.bindString(1,"Granola maison");
        sc.bindString(2,"other country");
        sc.execute();
        sc.bindString(1,"Mousse au chocolat");
        sc.bindString(2,"other country");
        sc.execute();
        sc.bindString(1,"Crêpes sucrées");
        sc.bindString(2,"other country");
        sc.execute();
        sc.bindString(1,"Cake au banane");
        sc.bindString(2,"other country");
        sc.execute();
        sc.bindString(1,"Curry japonais");
        sc.bindString(2,"asian");
        sc.execute();
        sc.bindString(1,"Curry japonais");
        sc.bindString(2,"meat");
        sc.execute();
        sc.bindString(1,"Fish and chips");
        sc.bindString(2,"fish");
        sc.execute();
        sc.bindString(1,"Fish and chips");
        sc.bindString(2,"other country");
        sc.execute();
        sc.bindString(1,"Mini pizza");
        sc.bindString(2,"hot");
        sc.execute();
        sc.bindString(1,"Oignon rings");
        sc.bindString(2,"hot");
        sc.execute();
        sc.bindString(1,"Mini pizza");
        sc.bindString(2,"italian");
        sc.execute();
        sc.bindString(1,"Oignon rings");
        sc.bindString(2,"american");
        sc.execute();
        sc.bindString(1,"Brochette satay");
        sc.bindString(2,"asian");
        sc.execute();









        SQLiteStatement r = db.compileStatement("INSERT INTO \"Recette\"(\"NomRecette\",\"Image\",\"Instructions\",\"DateDAjout\",\"Origine\") VALUES(?,?,?,?,?)");
        r.bindString(1,"Soupe oignon");
        r.bindString(2,"soupeoignon");
        r.bindString(3,"Dans une casserole à gros fond, faites fondre le beurre ou chauffer l'huile d'olive, dorer à petit feu les oignons finement émincés. Lorsqu'il est transparent, ajouter la farine en saupoudrant et en mélangeant sans cesse à la cuiller en bois. \n" +
                "Saler et poivrer au moulin. mouiller ensuite, toujours en remuant, avec le consommé et porter à ébullition.\n" +
                "Diminuer à petits frémissements et poursuivre la cuisson pendant 30 minutes. pendant ce temps, faire fondre un peu de beurre et d'huile d'olive dans un grand wok et frire les tranches de pain coupées à la dimension des bols à soupe.\n" +
                "Quelques minutes avant la fin de la cuisson, ajouter le porto (optionnel), mélanger bien et servir dans des bols individuels.\n" +
                "Placer les bols côte à côte sur une grille allant au four, couvrir le centre de chaque bol avec un morceau de pain frit, casser au milieu du pain un oeuf sans le blanc, saupoudrer avec le parmesan et hop, au grill maximum pendant quelques moments, histoire de faire prendre un peu de couleur à l'appareil.\n" +
                "Bon appétit.");
        r.bindString(4,"01/04/17");
        r.bindString(5,"Française");
        r.execute();
        r.bindString(1,"Macaroni au fromage");
        r.bindString(2,"macaronifromage");
        r.bindString(3,"Coupez les fromages en morceaux. Mettre la crème dans une casserole, la faire bouillir et réduire 3 mn à feu doux. Hors du feu, rajoutez les fromages mais seulement la moitié du parmesan en mélangeant vivement. \n" +
                "Remettez à feu doux jusqu'à ce que le mélange soit lisse. Poivrez et relevez de muscade. \n" +
                "Pendant ce temps, faîtes cuire les pâtes suivant le temps indiqué sur votre paquet (pâtes fraîches c'est encore meilleur). \n" +
                "Egouttez les pâtes, versez-les dans la casserole contenant la sauce aux trois fromages. Mélangez rapidement, parsemez du reste de parmesan et servez.");
        r.bindString(4,"02/04/17");
        r.bindString(5,"Italienne");
        r.execute();
        r.bindString(1,"Spaghetti bolognaise");
        r.bindString(2,"spaguettibolognaise");
        r.bindString(3,"Hachez l'ail, l'oignon, puis coupez la carotte et le céleri en petits dés (enlevez les principales nervures du céleri). \n" +
                "\n" +
                "Faites chauffer l'huile dans une casserole assez grande. Faites revenir l'ail, l'oignon, la carotte et le céleri à feu doux pendant 5 min en remuant.\n" +
                "\n" +
                "Augmenter la flamme, puis ajoutez le boeuf. faites brunir et remuez de façon à ce que la viande ne fasse pas de gros paquets. \n" +
                "\n" +
                "Ajoutez le bouillon, le vin rouge, les tomates préalablement coupées assez grossièrement, le sucre et le persil haché. Portez à ébullition.\n" +
                "\n" +
                "Baisser ensuite le feu et laissez mijoter à couvert 1h à 1h30, de façon à ce que le vin s'évapore. \n" +
                "\n" +
                "Faites cuire les spaghetti, puis mettez-les dans un plat. Ajoutez la sauce bolognaise.");
        r.bindString(4,"03/04/17");
        r.bindString(5,"Italienne");
        r.execute();
        r.bindString(1,"Salade césar");
        r.bindString(2,"saladecesar");
        r.bindString(3,"Préchauffez votre four à 210-220°C . \n" +
                "Détachez les feuilles de salade, lavez-les, découpez-les en lamelles, essorez-les. \n" +
                "Coupez le pain en dés. Faites-les griller au four en surveillant bien la cuisson car c'est très rapide (environ 1 à 2 mn). \n" +
                "Chauffez 4 cuillerées à soupe d'huile dans une poêle. Ajoutez l'ail écrasé. Faites rissoler les dés de pain en croûtons. Laissez-les refroidir. \n" +
                "Faites cuire les oeufs mollets : lorsque l'eau commence à bouillir, diminuez la source de chaleur et laissez cuire 2 mn. Rincez-les tout de suite à l'eau froide puis écalez-les. \n" +
                "Pressez les citrons et versez le jus dans un bol. Ajoutez l'huile d'olive goutte à goutte. Salez et poivrez. \n" +
                "Mettez la salade dans un saladier et versez dessus la sauce. Mélangez bien le tout et laissez de côté pendant une dizaine de minutes afin que la salade s'imprègne bien de la sauce. \n" +
                "Coupez les oeufs en 4, dans le sens de la longueur. Mélangez-les à la salade afin que le jaune se mêle à la sauce, puis ajoutez le parmesan râpé et les croûtons. \n" +
                "Servez aussitôt.\n");
        r.bindString(4,"04/04/17");
        r.bindString(5,"Grecque");
        r.execute();
        r.bindString(1,"Mousse au chocolat");
        r.bindString(2,"mac");
        r.bindString(3,"Séparer les blancs des jaunes d'oeufs.\n" +
                "\n" +
                "Faire ramollir le chocolat dans une casserole au bain-marie. \n" +
                "\n" +
                "Hors du feu, incorporer les jaunes et le sucre. \n" +
                "\n" +
                "Battre les blancs en neige ferme et les ajouter délicatement au mélange à l'aide d'une spatule. \n" +
                "\n" +
                "Verser dans une terrine ou des verrines et mettre au frais 1 heure ou 2 minimum.");
        r.bindString(4,"05/04/17");
        r.bindString(5,"Belge");
        r.execute();
        r.bindString(1,"Milkshake berry");
        r.bindString(2,"berryshake");
        r.bindString(3,"Versez le lait d'amande dans le blender, rajoutez le mélange de fruits rouges congelés, versez le sirop d'agave et mixez le tout. Servir dans un grand verre et parsemez de fruits rouges.");
        r.bindString(4,"06/04/17");
        r.bindString(5,"Espagnole");
        r.execute();
        r.bindString(1,"Rhum citron miel");
        r.bindString(2,"alcoolcitron");
        r.bindString(3,"Composer chacun des verres de la manière suivante :\n" +
                "Verser 2 cl de Rhum, saupoudrer d'une pincée de cannelle et bien mélanger pour éviter les grumeaux.\n" +
                "Couper les 2 feuilles de menthe en fines lanières et les écraser un peu dans le rhum avec un pilon.\n" +
                "Passez la boisson au tamis pour retirer les morceaux de menthe.\n" +
                "Couper une rondelle de citron de 5 mm d'épaisseur et la presser au-dessus du verre.\n" +
                "Vous pouvez ensuite mettre la rondelle dans le verre pour la presentation.\n" +
                "Ajouter 2 glaçons et bien remuer.");
        r.bindString(4,"07/04/17");
        r.bindString(5,"Mexicaine");
        r.execute();
        r.bindString(1,"Gaufre Belge");
        r.bindString(2,"belgianwaffle");
        r.bindString(3,"Tamiser la farine.\n" +
                "Séparer les jaunes et les blancs des oeufs en ne gardant que 4 blancs.\n" +
                "Faire fondre légèrement le beurre au bain-marie; il doit être liquide et à peine tiède.\n" +
                "Couper la gousse de vanille dans sa longueur et récupérer les graines.\n" +
                "Mélanger la farine, les cinq jaunes d'oeufs, le sucre fin, les graines de vanille, une pincée de sel, le lait et le beurre fondu.\n" +
                "Battre les 4 blancs d'oeufs en neige très ferme.\n" +
                "Incorporer les blancs en neige à la préparation. A faire très délicatement afin de ne pas briser la mousse.\n" +
                "Laisser reposer durant 45 minutes bien à couvert.\n" +
                "La pâte doit être un peu moins liquide qu'une pâte à crêpe.\n" +
                "Cuire les gaufres dans un fer bien chaud.\n" +
                "Dès que la ou les portions de pâte sont versées, il faut fermer le gaufrier et le renverser de suite pour avoir des gaufres régulières et gonflées.\n" +
                "Aussitôt que la gaufre est dorée sur les deux faces, la sortir du fer, la saupoudrer de sucre glace et servir très chaud.");
        r.bindString(4,"08/04/17");
        r.bindString(5,"Belge");
        r.execute();
        r.bindString(1,"Chocolat chaud de Noël");
        r.bindString(2,"chocochaud");
        r.bindString(3,"Dans une casserole chauffez le lait en surveillant la cuisson, lorsque le lait frémit doucement ajoutez y le chocolat noir concassé.\n"+" Mélangez bien et rajoutez à la préparation la cannelle, les clous de girofle ainsi qu'une c.à.c de muscade, sucrez à votre convenance.\n"+" Servez avec de la chantilly saupoudrée au cacao ");
        r.bindString(4,"09/04/17");
        r.bindString(5,"Russe");
        r.execute();
        r.bindString(1,"Curry japonais");
        r.bindString(2,"curryjapan");
        r.bindString(3,"Faire revenir les morceaux de porc dans un peu d'huile jusqu'à ce qu'ils soient bien grillés. Les retirer et faire un roux avec la graisse qu'il y a dans la casserole (en rajouter si nécessaire). Ajouter de l'eau (un litre à un litre et demi), ainsi que le curry. Faire bouillir. Ajouter les morceaux de viande, les carottes et les navets. Après 10 minutes de cuisson ajouter les pommes de terre et les courgettes et laisser cuire sur feu doux encore 20 à 25 minutes.\n" +
                "\n" +
                "Le plat doit ressembler à une soupe que l'on servira avec un bol de riz blanc. Saler à convenance. \n" +
                "On peut mettre aussi d'autres légumes comme haricots verts, poivrons…\n");
        r.bindString(4,"010/04/17");
        r.bindString(5,"Asiatique");
        r.execute();
        r.bindString(1,"Donut");
        r.bindString(2,"donut");
        r.bindString(3,"Prévoir 3 heures de repos de la pâte.\n" +
                "Faites tiédir le lait puis versez-le dans un grand verre.\n" +
                "Ajoutez une cuillère à café de sucre et mélangez afin que le sucre fonde.\n" +
                "Ajoutez ensuite la levure en pluie et mélangez.\n" +
                "Laissez reposer 10 min dans un endroit tiède, jusqu'à ce que la levure gonfle et atteigne le bord du verre.\n" +
                "Tamisez 100 g de farine dans une terrine, creusez un puits au centre et ajoutez-y le sel et la levure. Mélangez à la spatule puis du bout des doigts, en un mouvement tournant, jusqu’à obtention d'une boule souple et élastique. \n" +
                "Laissez-la reposer 30 min environ, toujours dans un endroit tiède, jusqu'à ce qu'elle double de volume.\n" +
                "Au bout de ce temps, faites fondre le beurre dans une petite casserole et laissez-le refroidir. Battez l'oeuf à la fourchette. \n" +
                "Lorsque la pâte a levé, mettez-la sur le plan de travail et écrasez-la d'un coup sec.\n" +
                "Travaillez-la en y incorporant le beurre, l'oeuf battu, la cannelle, le reste du sucre et de farine, en la tamisant.\n" +
                "Lorsque la pâte est à nouveau lisse et souple, couvrez-la d'un linge et laissez-la lever à nouveau pendant 3 h.\n" +
                "Au bout de ce temps, travaillez rapidement la pâte afin de le la faire retomber et divisez-la en 12 boules.\n" +
                "Prenez une boule dans la main gauche et trouez-la en son centre avec votre index droit. Faites tourner le beignet autour du doigt pendant 10 secondes environ. Procédez de même avec les autres boules de pâte.\n" +
                "Faites chauffer l'huile dans une bassine à friture et des qu'elle commence a frémir, plongez-y les donuts par 3 ou 4 : ils tombent au fond et remontent aussitôt.\n" +
                "Laissez-les cuire 2 min puis retournez-les et laissez-les cuire 1 min de l'autre côté. Retirez-les de la friture et égouttez-les sur du papier absorbant.\n" +
                "Poudrez-les de sucre en poudre et servez.");
        r.bindString(4,"11/04/17");
        r.bindString(5,"Américaine");
        r.execute();
        r.bindString(1,"Gin à la framboise");
        r.bindString(2,"ginframboise");
        r.bindString(3,"\n" +
                "Mélanger tous les ingrédients dans un shaker.\n" +
                "Ajouter des glaçons.\n" +
                "Agiter vigoureusement 10 secondes.\n" +
                "Servir dans un verre avec des framboises fraîches. \n" +
                "C'est prêt! Bonne dégustation.");
        r.bindString(4,"12/04/17");
        r.bindString(5,"Anglaise");
        r.execute();
        r.bindString(1,"Granola maison");
        r.bindString(2,"granola");
        r.bindString(3,"Préchauffer le four à 150°C.\n" +
                "Mélanger l'huile, le miel, le sirop d'érable et l'arôme de vanille au fond d'un grand saladier.\n" +
                "Concasser les fruits secs à l'aide d'un grand couteau.\n" +
                "Mélanger les flocons d'avoine et les fruits sec dans le saladier.\n" +
                "Etaler le mélange sur une plaque de cuisson et enfourner pendant 15 minutes.\n" +
                "Pendant la cuisson, couper le chocolat à dessert en morceaux (à l'aide d'un couteau).\n" +
                "Laisser refroidir le granola avant d'y ajouter le chocolat.\n" +
                "Conserver dans un bocal hermétique.");
        r.bindString(4,"13/04/17");
        r.bindString(5,"Suédoise");
        r.execute();
        r.bindString(1,"Thé glacé thaï");
        r.bindString(2,"icedtea");
        r.bindString(3,"Porter l'eau à ébullition. Mettre le thé dans le filtre d'une théière. verser l'eau sur le thé et laisser infuser jusqu'à ce que le thé soit très fort et prenne une couleur orange foncé.\n" +
                "ajouter le lait au thé, remuer et laisser refroidir. Ajouter des glaçons dans des verres long drink et verser le thé dans les verres de manière à les remplir à moitié. Compléter avec le lait de soja et servir immédiatement.\n");
        r.bindString(4,"14/04/17");
        r.bindString(5,"Asiatique");
        r.execute();
        r.bindString(1,"Crêpes sucrées");
        r.bindString(2,"crepes");
        r.bindString(3,"\n" +
                "Verser 250 g de farine, casser 4 œufs et mélanger bien à la farine.\n" +
                "Ajouter petit à petit le lait tout en mélangeant bien pour éviter les grumeaux.\n" +
                "Ajouter la pincée de sel.\n" +
                "Ajouter les 3 sucres (vanillé, de canne et en poudre).\n" +
                "Verser le Cognac toujours en mélangeant bien.\n" +
                "Ajouter les 50 g de beurre fondu.\n" +
                "Faire chauffer la poêle à feu vif en y ajoutant un peu d'huile dont vous essuyez l'excédent avec un papier absorbant.\n" +
                "Faire des crêpes fines si possible.");
        r.bindString(4,"15/04/17");
        r.bindString(5,"Française");
        r.execute();
        r.bindString(1,"Mojito");
        r.bindString(2,"mojito");
        r.bindString(3,"Ajouter le sucre dans le verre, puis le jus d'1/2 citron vert.\n" +
                "Ecraser 4 feuilles de menthe, ajouter le rhum et compléter avec l'eau gazeuse. \n" +
                "Remuer et ajouter 1 branche de menthe.");
        r.bindString(4,"16/04/17");
        r.bindString(5,"Cubaine");
        r.execute();
        r.bindString(1,"Boisson saine et sans allergènes");
        r.bindString(2,"pastequeboisson");
        r.bindString(3,"Congelez des morceau de chair de pastèque, une fois les morceaux dur comme des glacons, versez un verre remplis de pastèque congelés avec un verre d'eau et la menthe. Mixer le tout ");
        r.bindString(4,"17/04/17");
        r.bindString(5,"Africaine");
        r.execute();
        r.bindString(1,"Mini pizza");
        r.bindString(2,"minipizza");
        r.bindString(3,"Préchauffer le four à 220°C.\n" +
                "Disposez sous la grille du four une feuille de papier aluminium, afin de le préserver si l'huile ou le fromage coule...\n" +
                "Disposez sur cette même grille vos pains 'pitta', face lisse au-dessus.\n" +
                "Sur chaque pain, mettre une cuillère à soupe de chair de tomate, saler, poivrer (ajouter éventuellement les herbes de provence).\n" +
                "Ensuite, ajouter le jambon émincé, les champignons émincés et disposer quelques olives.\n" +
                "Recouvrir chaque pizza de fines tranches de mozzarella, y verser un filet d'huile d'olive.\n" +
                "Cuire à four chaud une petite demi-heure.\n" +
                "Vous pouvez bien entendu varier les garnitures à l'infini ! (poivrons, anchois, coeurs d'artichauts, saucisson,ananas...).");
        r.bindString(4,"18/04/2017");
        r.bindString(5,"Italienne");
        r.execute();
        r.bindString(1,"Oignon rings");
        r.bindString(2,"oignonrings");
        r.bindString(3,"Peler et trancher les oignons, séparer les rondelles d'oignons.\n" +
                "Pour la pâte à frire :\n" +
                "Mélanger la farine, le jaune d'œuf, le lait, l'huile et le sel jusqu'à obtenir une pâte homogène.\n" +
                "Incorporer délicatement le blanc d'œuf monté en neige. \n" +
                "Tremper les oignons dans la pâte de manière à bien les recouvrir.\n" +
                "Puis, les faire frire dans une friteuse ou une poêle remplie d'huile.\n" +
                "Déposer les onion rings sur du sopalin, pour enlever le trop plein d'huile.\n" +
                "Déguster, en trempant les onion rings dans la sauce choisie.\n");
        r.bindString(4,"19/04/2017");
        r.bindString(5,"Américaine");
        r.execute();
        r.bindString(1,"Fish and chips");
        r.bindString(2,"fishchips");
        r.bindString(3,"Faire chauffer votre friteuse/votre poêle avec l'huile (huile bien chaude).\n" +
                "Couper le poisson dans la largeur pour obtenir des minis pavés de poisson. Réserver au frais.\n" +
                "Ciseler du persil et l'échalote.\n" +
                "Ajouter dans la quantité désirée du fromage blanc dans un bol, incorporer le persil et l'échalote préalablement ciselée et ajouter le piment/paprika, le sel et le poivre.\n" +
                "Réserver au frais.\n" +
                "Battre l’œuf entier dans un récipient et mettre la farine dans un plat.\n" +
                "Tremper les tranches de poisson dans l’œuf battu et mettre dans la farine.\n" +
                "Faire frire le poisson jusqu'a obtenir coloration. Une fois cuit, enlever l’excès d'huile avec un essuie-tout.\n" +
                "Dresser.\n" +
                "Bon appétit.\n");
        r.bindString(5,"Anglaise");
        r.execute();
        r.bindString(1,"Brochette satay");
        r.bindString(2,"satay");
        r.bindString(3,"Mettre le poulet dans la marinade pendant au moins 2h.\n" +
                "Sauce : broyer les cacahuètes (du beurre d'arachide peut faire l'affaire).\n" +
                "Verser la moitié du lait dans une casserole, ajouter le curry, chauffer à feu doux pendant 3 min.\n" +
                "Ajouter la crème de cacahuète, le sucre, le jus de citron et le reste du lait de coco. Mélanger bien et laisser cuire 20 à 30 mn\n" +
                "Faire cuire vos brochettes de poulet. Servir avec la sauce et une salade de concombre.\n" +
                "On peut tout aussi bien utiliser du porc ou du boeuf en brochettes.");
        r.bindString(4,"21/04/2017");
        r.bindString(5,"Asiatique");
        r.execute();
        r.bindString(1,"Cake au banane");
        r.bindString(2,"cakebanane");
        r.bindString(3,"Beurrez un moule à cake avec un peu de beurre. \n" +
                "Préchauffez le four à 180°C (thermostat 6).\n" +
                "Râpez le zeste de citron, puis pressez-le pour en extraire le jus. \n" +
                "Ecrasez ensuite le beurre avec une fourchettte, puis ajoutez-lui au fur et à mesure, le sucre, le sucre vanillé, le zeste du citron et les oeufs battus en omelette.\n" +
                "Pelez les bananes, coupez-les en petites rondelles, et arrosez-les du jus du citron, puis écrasez-les à la fourchette. \n" +
                "Ajoutez la purée ainsi obtenue à la préparation aux oeufs, puis la farine et la levure; vous devez obtenir une pâte bien consistante. \n" +
                "Versez le tout dans le moule, et enfournez pendant 45 min.\n" +
                "Pour vérifier la cuisson du gâteau, piquez-le avec un couteau avant de le sortir du four : si la lame ressort bien sèche, c'est que le gâteau est cuit.\n" +
                "Laissez-le reposer 5 min dans le four éteint avant de le démouler. Dégustez-le froid.");
        r.bindString(4,"22/04/2017");
        r.bindString(5,"Française");
        r.execute();
        r.bindString(1,"Perle de coco");
        r.bindString(2,"boulecoco");
        r.bindString(3,"Verser le lait de coco et le verre d'eau dans une casserole et faire chauffer. Ecraser les bananes et mettre de côté. \n" +
                "Quand le mélange est chaud, versez environ la moitié du sachet de tapioca ainsi que les bananes écrasées. Mélanger sans cesser de remuer jusqu'à ce que le tapioca soit devenu transparent. \n" +
                "Truc : Si le tapioca à collé au fond de la casserole, mettre à tremper toute la nuit dans de l'eau bien chaude.\n" +
                "Confectionner des boules de la taille voulue. On peut les rouler dans de la noix de coco râpée ou du sucre glace.\n");
        r.bindString(5,"Asiatique");
        r.execute();
        r.bindString(1,"Meringue Italienne");
        r.bindString(2,"meringue");
        r.bindString(3,"Dans un saladier, monter les blancs en neige avec le sucre et le sel. \n" +
                "Réserver au frais 48 h.\n" +
                "Former des meringues avec une poche à douille.\n" +
                "Enfourner à 120°C (thermostat 4) pendant 30 min.\n");
        r.bindString(4,"24/04/2017");
        r.bindString(5,"Italienne");
        r.execute();



        db.execSQL("CREATE TABLE IF NOT EXISTS \"Liste\" (\"NomRecette\" NOT NULL,\"Ingrédient\" NOT NULL,\"Quantité\" NOT NULL);");
        SQLiteStatement l= db.compileStatement("INSERT INTO \"Liste\"(\"NomRecette\",\"Ingrédient\",\"Quantité\") VALUES(?,?,?) ");
        l.bindString(1,"Soupe oignon");
        l.bindString(2,"oignon");
        l.bindString(3,"250");
        l.execute();
        l.bindString(1,"Soupe oignon");
        l.bindString(2,"farine");
        l.bindString(3,"25");
        l.execute();
        l.bindString(1,"Soupe oignon");
        l.bindString(2,"beurre");
        l.bindString(3,"25");
        l.execute();
        l.bindString(1,"Soupe oignon");
        l.bindString(2,"consommé de volaille");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Soupe oignon");
        l.bindString(2,"porto rouge");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Soupe oignon");
        l.bindString(2,"tranches de pain gratinées au beurre");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Soupe oignon");
        l.bindString(2,"oeufs");
        l.bindString(3,"4");
        l.execute();
        l.bindString(1,"Soupe oignon");
        l.bindString(2,"parmesan");
        l.bindString(3,"30");
        l.execute();
        l.bindString(1,"Macaroni au fromage");
        l.bindString(2,"parmesan");
        l.bindString(3,"80");
        l.execute();
        l.bindString(1,"Macaroni au fromage");
        l.bindString(2,"macaronis longs ou de pennes");
        l.bindString(3,"500");
        l.execute();
        l.bindString(1,"Macaroni au fromage");
        l.bindString(2,"poivre");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Macaroni au fromage");
        l.bindString(2,"sel");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Macaroni au fromage");
        l.bindString(2,"fromage à raclette sans croûte");
        l.bindString(3,"120");
        l.execute();
        l.bindString(1,"Macaroni au fromage");
        l.bindString(2,"creme liquide");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Macaroni au fromage");
        l.bindString(2,"noix de muscade");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"pâte spaghetti");
        l.bindString(3,"500");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"oignon");
        l.bindString(3,"50");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"gousse d'ail");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"carotte");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"céleri");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"tomates");
        l.bindString(3,"5");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"vin rouge");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"viande hachée");
        l.bindString(3,"500");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"bouillon");
        l.bindString(3,"50");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"persil");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"sucre");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Spaghetti bolognaise");
        l.bindString(2,"huile");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Salade césar");
        l.bindString(2,"salade romaine");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Salade césar");
        l.bindString(2,"baguette");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Salade césar");
        l.bindString(2,"huile d'olive");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Salade césar");
        l.bindString(2,"gousses d'ail");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Salade césar");
        l.bindString(2,"citron");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Salade césar");
        l.bindString(2,"oeufs");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Salade césar");
        l.bindString(2,"parmesan");
        l.bindString(3,"50");
        l.execute();
        l.bindString(1,"Salade césar");
        l.bindString(2,"poivre");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Salade césar");
        l.bindString(2,"sel");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Mousse au chocolat");
        l.bindString(2,"oeufs");
        l.bindString(3,"3");
        l.execute();
        l.bindString(1,"Mousse au chocolat");
        l.bindString(2,"chocolat");
        l.bindString(3,"100");
        l.execute();
        l.bindString(1,"Mousse au chocolat");
        l.bindString(2,"sucre vanillé");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Milkshake berry");
        l.bindString(2,"lait d'amande");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Milkshake berry");
        l.bindString(2,"fruits rouges congelés");
        l.bindString(3,"150");
        l.execute();
        l.bindString(1,"Milkshake berry");
        l.bindString(2,"sirop d'agave");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Rhum citron miel");
        l.bindString(2,"rhum blanc");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Rhum citron miel");
        l.bindString(2,"feuilles de menthe");
        l.bindString(3,"8");
        l.execute();
        l.bindString(1,"Rhum citron miel");
        l.bindString(2,"citron vert");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Rhum citron miel");
        l.bindString(2,"cannelle");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Gaufre Belge");
        l.bindString(2,"farine");
        l.bindString(3,"125");
        l.execute();
        l.bindString(1,"Gaufre Belge");
        l.bindString(2,"oeufs");
        l.bindString(3,"5");
        l.execute();
        l.bindString(1,"Gaufre Belge");
        l.bindString(2,"sucre fin");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Gaufre Belge");
        l.bindString(2,"lait");
        l.bindString(3,"25");
        l.execute();
        l.bindString(1,"Gaufre Belge");
        l.bindString(2,"vanille");
        l.bindString(3,"1/2");
        l.execute();
        l.bindString(1,"Gaufre Belge");
        l.bindString(2,"beurre");
        l.bindString(3,"75");
        l.execute();
        l.bindString(1,"Gaufre Belge");
        l.bindString(2,"sel");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Gaufre Belge");
        l.bindString(2,"sucre glace");
        l.bindString(3,"100");
        l.execute();
        l.bindString(1,"Chocolat chaud de Noël");
        l.bindString(2,"cannelle");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Chocolat chaud de Noël");
        l.bindString(2,"lait");
        l.bindString(3,"30");
        l.execute();
        l.bindString(1,"Chocolat chaud de Noël");
        l.bindString(2,"clous de girofle");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Chocolat chaud de Noël");
        l.bindString(2,"chocolat");
        l.bindString(3,"50");
        l.execute();
        l.bindString(1,"Chocolat chaud de Noël");
        l.bindString(2,"chantilly");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Chocolat chaud de Noël");
        l.bindString(2,"cacao");
        l.bindString(3,"5");
        l.execute();
        l.bindString(1,"Curry japonais");
        l.bindString(2,"porc");
        l.bindString(3,"500");
        l.execute();
        l.bindString(1,"Curry japonais");
        l.bindString(2,"carottes");
        l.bindString(3,"4");
        l.execute();
        l.bindString(1,"Curry japonais");
        l.bindString(2,"navets");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Curry japonais");
        l.bindString(2,"pommes de terre");
        l.bindString(3,"4");
        l.execute();
        l.bindString(1,"Curry japonais");
        l.bindString(2,"courgettes");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Curry japonais");
        l.bindString(2,"Curry japonais");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Donut");
        l.bindString(2,"farine");
        l.bindString(3,"350");
        l.execute();
        l.bindString(1,"Donut");
        l.bindString(2,"lait");
        l.bindString(3,"15");
        l.execute();
        l.bindString(1,"Donut");
        l.bindString(2,"beurre");
        l.bindString(3,"25");
        l.execute();
        l.bindString(1,"Donut");
        l.bindString(2,"cassonade");
        l.bindString(3,"80");
        l.execute();
        l.bindString(1,"Donut");
        l.bindString(2,"oeufs");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Donut");
        l.bindString(2,"sel");
        l.bindString(3,"5");
        l.execute();
        l.bindString(1,"Donut");
        l.bindString(2,"levure");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Donut");
        l.bindString(2,"cannelle");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Donut");
        l.bindString(2,"huile d'arachide");
        l.bindString(3,"50");
        l.execute();
        l.bindString(1,"Donut");
        l.bindString(2,"sucre glace");
        l.bindString(3,"100");
        l.execute();
        l.bindString(1,"Gin à la framboise");
        l.bindString(2,"gin");
        l.bindString(3,"10");
        l.execute();
        l.bindString(1,"Gin à la framboise");
        l.bindString(2,"jus de citron");
        l.bindString(3,"10");
        l.execute();
        l.bindString(1,"Gin à la framboise");
        l.bindString(2,"eau gazeuse");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Gin à la framboise");
        l.bindString(2,"sucre de canne");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Granola maison");
        l.bindString(2,"flocons d'avoine");
        l.bindString(3,"100");
        l.execute();
        l.bindString(1,"Granola maison");
        l.bindString(2,"amande");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Granola maison");
        l.bindString(2,"noisette");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Granola maison");
        l.bindString(2,"noix");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Granola maison");
        l.bindString(2,"noix de cajou");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Granola maison");
        l.bindString(2,"miel");
        l.bindString(3,"50");
        l.execute();
        l.bindString(1,"Granola maison");
        l.bindString(2,"sirop d'érable");
        l.bindString(3,"50");
        l.execute();
        l.bindString(1,"Granola maison");
        l.bindString(2,"huile");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Granola maison");
        l.bindString(2,"vanille");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Thé glacé thaï");
        l.bindString(2,"lait concentré");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Thé glacé thaï");
        l.bindString(2,"lait de soja");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Thé glacé thaï");
        l.bindString(2,"thé thaï");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Crêpes sucrées");
        l.bindString(2,"farine");
        l.bindString(3,"250");
        l.execute();
        l.bindString(1,"Crêpes sucrées");
        l.bindString(2,"oeufs");
        l.bindString(3,"4");
        l.execute();
        l.bindString(1,"Crêpes sucrées");
        l.bindString(2,"lait");
        l.bindString(3,"50");
        l.execute();
        l.bindString(1,"Crêpes sucrées");
        l.bindString(2,"beurre");
        l.bindString(3,"50");
        l.execute();
        l.bindString(1,"Crêpes sucrées");
        l.bindString(2,"sucre glace");
        l.bindString(3,"85");
        l.execute();
        l.bindString(1,"Crêpes sucrées");
        l.bindString(2,"sucre de canne");
        l.bindString(3,"10");
        l.execute();
        l.bindString(1,"Crêpes sucrées");
        l.bindString(2,"sucre vanillé");
        l.bindString(3,"5");
        l.execute();
        l.bindString(1,"Crêpes sucrées");
        l.bindString(2,"cognac");
        l.bindString(3,"15");
        l.execute();
        l.bindString(1,"Crêpes sucrées");
        l.bindString(2,"sel");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Mojito");
        l.bindString(2,"sucre");
        l.bindString(3,"5");
        l.execute();
        l.bindString(1,"Mojito");
        l.bindString(2,"citron vert");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Mojito");
        l.bindString(2,"feuilles de menthe");
        l.bindString(3,"10");
        l.execute();
        l.bindString(1,"Mojito");
        l.bindString(2,"rhum");
        l.bindString(3,"5");
        l.execute();
        l.bindString(1,"Mojito");
        l.bindString(2,"perrier");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Boisson saine et sans allergènes");
        l.bindString(2,"pastèque");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Boisson saine et sans allergènes");
        l.bindString(2,"menthe");
        l.bindString(3,"5");
        l.execute();
        l.bindString(1,"Mini pizza");
        l.bindString(2,"pain pitta");
        l.bindString(3,"4");
        l.execute();
        l.bindString(1,"Mini pizza");
        l.bindString(2,"tomate");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Mini pizza");
        l.bindString(2,"jambon");
        l.bindString(3,"4");
        l.execute();
        l.bindString(1,"Mini pizza");
        l.bindString(2,"champignons");
        l.bindString(3,"4");
        l.execute();
        l.bindString(1,"Mini pizza");
        l.bindString(2,"olive noires");
        l.bindString(3,"416");
        l.execute();
        l.bindString(1,"Mini pizza");
        l.bindString(2,"mozarella");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Mini pizza");
        l.bindString(2,"huile d'olive");
        l.bindString(3,"10");
        l.execute();
        l.bindString(1,"Mini pizza");
        l.bindString(2,"sel");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Mini pizza");
        l.bindString(2,"poivre");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Mini pizza");
        l.bindString(2,"herbes de provence");
        l.bindString(3,"4");
        l.execute();
        l.bindString(1,"Oignon rings");
        l.bindString(2,"oignon");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Oignon rings");
        l.bindString(2,"farine");
        l.bindString(3,"100");
        l.execute();
        l.bindString(1,"Oignon rings");
        l.bindString(2,"oeufs");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Oignon rings");
        l.bindString(2,"sel");
        l.bindString(3, "1");
        l.execute();
        l.bindString(1,"Oignon rings");
        l.bindString(2,"lait");
        l.bindString(3,"10");
        l.execute();
        l.bindString(1,"Oignon rings");
        l.bindString(2,"huile");
        l.bindString(3,"10");
        l.execute();
        l.bindString(1,"Oignon rings");
        l.bindString(2,"sauce");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Fish and chips");
        l.bindString(2,"oeufs");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Fish and chips");
        l.bindString(2,"farine");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Fish and chips");
        l.bindString(2,"fromage blanc");
        l.bindString(3,"20");
        l.execute();
        l.bindString(1,"Fish and chips");
        l.bindString(2,"échalote");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Fish and chips");
        l.bindString(2,"piment");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Fish and chips");
        l.bindString(2,"paprika");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Fish and chips");
        l.bindString(2,"persil");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Fish and chips");
        l.bindString(2,"sel");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Fish and chips");
        l.bindString(2,"poivre");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Brochette satay");
        l.bindString(2,"poulet");
        l.bindString(3,"500");
        l.execute();
        l.bindString(1,"Brochette satay");
        l.bindString(2,"sucre brun");
        l.bindString(3,"10");
        l.execute();
        l.bindString(1,"Brochette satay");
        l.bindString(2,"coriandre");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Brochette satay");
        l.bindString(2,"curcuma");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Brochette satay");
        l.bindString(2,"cumin en poudre");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Brochette satay");
        l.bindString(2,"lait de coco");
        l.bindString(3,"18");
        l.execute();
        l.bindString(1,"Brochette satay");
        l.bindString(2,"cacahuètes");
        l.bindString(3,"50");
        l.execute();
        l.bindString(1,"Brochette satay");
        l.bindString(2,"sel");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Brochette satay");
        l.bindString(2,"pâte de curry rouge");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Brochette satay");
        l.bindString(2,"citron");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Cake au banane");
        l.bindString(2,"bananes");
        l.bindString(3,"3");
        l.execute();
        l.bindString(1,"Cake au banane");
        l.bindString(2,"farine");
        l.bindString(3,"200");
        l.execute();
        l.bindString(1,"Cake au banane");
        l.bindString(2,"sucre");
        l.bindString(3,"200");
        l.execute();
        l.bindString(1,"Cake au banane");
        l.bindString(2,"beurre");
        l.bindString(3,"100");
        l.execute();
        l.bindString(1,"Cake au banane");
        l.bindString(2,"oeufs");
        l.bindString(3,"3");
        l.execute();
        l.bindString(1,"Cake au banane");
        l.bindString(2,"sucre vanillé");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Cake au banane");
        l.bindString(2,"citron");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Perle de coco");
        l.bindString(2,"tapioca");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Perle de coco");
        l.bindString(2,"lait de coco");
        l.bindString(3,"1");
        l.execute();
        l.bindString(1,"Perle de coco");
        l.bindString(2,"bananes");
        l.bindString(3,"2");
        l.execute();
        l.bindString(1,"Perle de coco");
        l.bindString(2,"eau");
        l.bindString(3,"30");
        l.execute();
        l.bindString(1,"Perle de coco");
        l.bindString(2,"sucre glace");
        l.bindString(3,"30");
        l.execute();
        l.bindString(1,"Meringue Italienne");
        l.bindString(2,"sucre semoule");
        l.bindString(3,"150");
        l.execute();
        l.bindString(1,"Meringue Italienne");
        l.bindString(2,"sel");
        l.bindString(3,"1");
        l.execute();







        db.execSQL("CREATE TABLE IF NOT EXISTS \"Informations\" (\"NomRecette\" PRIMARY KEY,\"Description\" NOT NULL,\"Difficulté\" NOT NULL,\"TempsCuisson\" NOT NULL,\"TempsPreparation\" NOT NULL,\"NbrePersonnes\" NOT NULL);");
        //difficulte peu etre que facile, moyen et difficile
        SQLiteStatement i = db.compileStatement("INSERT INTO \"Informations\"(\"NomRecette\",\"Description\",\"Difficulté\",\"TempsCuisson\",\"TempsPreparation\",\"NbrePersonnes\") VALUES(?,?,?,?,?,?)");
        i.bindString(1,"Donut");
        i.bindString(2,"Colorons la vie de donut");
        i.bindString(3,"moyen");
        i.bindString(4,"60");
        i.bindString(5,"3");
        i.bindString(6,"6");
        i.execute();
        i.bindString(1,"Gaufre Belge");
        i.bindString(2,"La Belge chez vous");
        i.bindString(3,"facile");
        i.bindString(4,"15");
        i.bindString(5,"6");
        i.bindString(6,"5");
        i.execute();
        i.bindString(1,"Soupe oignon");
        i.bindString(2,"Réchauffez votre coeur");
        i.bindString(3,"moyen");
        i.bindString(4,"30");
        i.bindString(5,"40");
        i.bindString(6,"4");
        i.execute();
        i.bindString(1,"Macaroni au fromage");
        i.bindString(2,"Facile et délicieux");
        i.bindString(3,"facile");
        i.bindString(4,"20");
        i.bindString(5,"15");
        i.bindString(6,"6");
        i.execute();
        i.bindString(1,"Spaghetti bolognaise");
        i.bindString(2,"L'incontournable italien");
        i.bindString(3,"facile");
        i.bindString(4,"20");
        i.bindString(5,"60");
        i.bindString(6,"4");
        i.execute();
        i.bindString(1,"Mousse au chocolat");
        i.bindString(2,"Le meilleur du chocolat");
        i.bindString(3,"expert");
        i.bindString(4,"10");
        i.bindString(5,"0");
        i.bindString(6,"4");
        i.execute();
        i.bindString(1,"Chocolat chaud de Noël");
        i.bindString(2,"Ne prenez point froid");
        i.bindString(3,"moyen");
        i.bindString(4,"10");
        i.bindString(5,"10");
        i.bindString(6,"4");
        i.execute();
        i.bindString(1,"Rhum citron miel");
        i.bindString(2,"Dansez en couleurs");
        i.bindString(3,"facile");
        i.bindString(4,"5");
        i.bindString(5,"0");
        i.bindString(6,"4");
        i.execute();
        i.bindString(1,"Curry japonais");
        i.bindString(2,"Découvrez de nouveaux horizons");
        i.bindString(3,"expert");
        i.bindString(4,"20");
        i.bindString(5,"45");
        i.bindString(6,"6");
        i.execute();
        i.bindString(1,"Crêpes sucrées");
        i.bindString(2,"La chandeleur toute l'année");
        i.bindString(3,"moyen");
        i.bindString(4,"15");
        i.bindString(5,"20");
        i.bindString(6,"5");
        i.execute();
        i.bindString(1,"Mojito");
        i.bindString(2,"Temps de fête");
        i.bindString(3,"moyen");
        i.bindString(4,"5");
        i.bindString(5,"0");
        i.bindString(6,"1");
        i.execute();
        i.bindString(1,"Mini pizza");
        i.bindString(2,"Petits encas sans remords");
        i.bindString(3,"facile");
        i.bindString(4,"10");
        i.bindString(5,"20");
        i.bindString(6,"4");
        i.execute();
        i.bindString(1,"Oignon rings");
        i.bindString(2,"Crispy crispy");
        i.bindString(3,"moyen");
        i.bindString(4,"10");
        i.bindString(5,"5");
        i.bindString(6,"2");
        i.execute();
        i.bindString(1,"Fish and chips");
        i.bindString(2,"Sain, pas sain");
        i.bindString(3,"expert");
        i.bindString(4,"10");
        i.bindString(5,"5");
        i.bindString(6,"2");
        i.execute();
        i.bindString(1,"Brochette satay");
        i.bindString(2,"Délice d'arachides");
        i.bindString(3,"moyen");
        i.bindString(4,"20");
        i.bindString(5,"30");
        i.bindString(6,"4");
        i.execute();
        i.bindString(1,"Perle de coco");
        i.bindString(2,"L'été toute l'année");
        i.bindString(3,"moyen");
        i.bindString(4,"30");
        i.bindString(5,"20");
        i.bindString(6,"8");
        i.execute();
        i.bindString(1,"Cake au banane");
        i.bindString(2,"Savoureux saveur");
        i.bindString(3,"moyen");
        i.bindString(4,"30");
        i.bindString(5,"45");
        i.bindString(6,"4");
        i.execute();
        i.bindString(1,"Meringue Italienne");
        i.bindString(2,"Moeulleux, sucré");
        i.bindString(3,"expert");
        i.bindString(4,"10");
        i.bindString(5,"30");
        i.bindString(6,"3");
        i.execute();
        i.bindString(1,"Thé glacé thaï");
        i.bindString(2,"Rafraichissez vous");
        i.bindString(3,"moyen");
        i.bindString(4,"15");
        i.bindString(5,"0");
        i.bindString(6,"4");
        i.execute();
        i.bindString(1,"Boisson saine et sans allergènes");
        i.bindString(2,"Toujours sain");
        i.bindString(3,"facile");
        i.bindString(4,"5");
        i.bindString(5,"0");
        i.bindString(6,"2");
        i.execute();
        i.bindString(1,"Granola maison");
        i.bindString(2,"Commmencez la journée avec du tonus");
        i.bindString(3,"moyen");
        i.bindString(4,"10");
        i.bindString(5,"15");
        i.bindString(6,"4");
        i.execute();
        i.bindString(1,"Milkshake berry");
        i.bindString(2,"Profitez de l'été");
        i.bindString(3,"moyen");
        i.bindString(4,"10");
        i.bindString(5,"0");
        i.bindString(6,"1");
        i.execute();
        i.bindString(1,"Gin à la framboise");
        i.bindString(2,"Fruité, coloré");
        i.bindString(3,"moyen");
        i.bindString(4,"10");
        i.bindString(5,"0");
        i.bindString(6,"1");
        i.execute();
        i.bindString(1,"Salade césar");
        i.bindString(2,"Plus que croquant");
        i.bindString(3,"facile");
        i.bindString(4,"20");
        i.bindString(5,"0");
        i.bindString(6,"4");
        i.execute();






    }

    /**
     * Ouvre la base de donnees en ecriture
     */
    public boolean open() {
        try {
            getWritableDatabase();
            return true;
        } catch(Throwable t) {
            return false;
        }
    }

    /**
     * Supprime la table dans la base de donnees.
     *
     * @param db Base de donnees.
     *
     * @post La tables de la base de donnees passee en argument est effacee.
     */
    private void deleteDatabase(SQLiteDatabase db) {
        db.execSQL("DROP TABLE ;");
    }

    /**
     * Methode de mise à  jour lors du changement de version de la base de donnees.
     *
     * @param db         Base de donnees à  mettre à  jour.
     * @param oldVersion Numero de l'ancienne version.
     * @param newVersion Numero de la nouvelle version.
     * @pre La base de donnees est dans la version oldVersion.
     * @post La base de donnees a ete mise à  jour vers la version newVersion.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        deleteDatabase(db);
        onCreate(db);
    }

    /**
     *Adds a new User in the database
     */
    public void addUser(User user){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT OR IGNORE INTO \"Utilisateur\" VALUES (\""+user.getUser()+"\",\""+user.getCountry()+"\",\""+user.getOriginCountry()+"\",\""+user.getPassword()+"\",\""+user.getBirth()+"\");");
        close();
    }
    public void updateUser(String usermail, String password, String livingCountry){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE \"Utilisateur\" SET \"Résidence\"=\""+livingCountry+"\" WHERE \"Usermail\"=\""+usermail+"\";");
        db.execSQL("UPDATE \"Utilisateur\" SET \"MotDePasse\"=\""+password+"\" WHERE \"Usermail\"=\""+usermail+"\";");
        close();
    }
    public void addAllergen(String usermail, String allergen)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT OR IGNORE INTO \"Allergène\" VALUES (\""+usermail+"\",\""+allergen+"\")");
        close();
    }


    public List<String> getPassword(String usermail){
        List<String> res = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Utilisateur\"",new String[]{"\"MotDePasse\""},("\"Usermail\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("MotDePasse")));
                c.moveToNext();
            }
        }
        c.close();
        return res;
    }

    public List<String> getBirthdate(String usermail){
        List<String> res = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Utilisateur\"",new String[]{"\"DateDeNaissance\""},("\"Usermail\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("DateDeNaissance")));
                c.moveToNext();
            }
        }
        c.close();
        return res;
    }

    public List<String> getOrigin(String usermail){
        List<String> res = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Utilisateur\"",new String[]{"\"PaysDOrigine\""},("\"Usermail\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("PaysDOrigine")));
                c.moveToNext();
            }
        }
        c.close();
        return res;
    }

    public List<String> getAllergene(String usermail){
        List<String> res = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Allergène\"",new String[]{"\"Allergène\""},("\"Usermail\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Allergène")));
                c.moveToNext();
            }
        }
        c.close();
        return res;
    }

    public Cursor research(String query)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT DISTINCT * FROM Recette C WHERE NomRecette LIKE \"%"+query+"%\" OR Origine LIKE \"%"+query+"%\"",null);

        //Cursor c = db.rawQuery("SELECT R.NomRecette, Image, Instructions, DateDajout, Origine FROM Recette R, Categorie C WHERE R.NomRecette=C.NomRecette ",null);
        //Cursor c = db.query("\"Recette\"",new String[]{"*"},("instr(\"NomRecette\",\""+query+"\") > 0 ") ,null,null,null,null);

        return c;
    }
    public Recipe[] getRecipe(int tabSize, String usermail){
        ArrayList<Recipe> res=new ArrayList<Recipe>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("Recommandations",new String[]{"Recette"},("Usermail = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                String nom=c.getString(c.getColumnIndex("Recette"));
                Cursor c2= db.query("Recette", null, "NomRecette=\""+nom+"\"", null, null, null, null);
                if(c2.moveToFirst()){
                    for(int j=0;j<c2.getCount() && res.size()<tabSize; j++){
                        String name=c2.getString(c2.getColumnIndex("NomRecette"));
                        String image=c2.getString(c2.getColumnIndex("Image"));
                        String instruc=c2.getString(c2.getColumnIndex("Instructions"));
                        String date=c2.getString(c2.getColumnIndex("DateDAjout"));
                        String sentence=c2.getString(c2.getColumnIndex("Origine"));
                        res.add(new Recipe(name,image,instruc,date,sentence));
                        c2.moveToNext();
                    }
                }
                c2.close();

                c.moveToNext();
            }
        }
        c.close();
        Recipe[] rt = new Recipe[res.size()];
        return res.toArray(rt);
    }
    public Recipe[] getRecipe(int tabSize, String table,String[] element, String cond1, String cond2){
        ArrayList<Recipe> res=new ArrayList<Recipe>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query(table,element,(cond1+"= \"" +cond2 +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                String nom=c.getString(c.getColumnIndex("NomRecette"));
                Cursor c2= db.query("Recette", null, "NomRecette=\""+nom+"\"", null, null, null, null);
                if(c2.moveToFirst()){
                    for(int j=0; j< c2.getCount() && res.size() <= tabSize; j++){
                        String name=c2.getString(c2.getColumnIndex("NomRecette"));
                        String image=c2.getString(c2.getColumnIndex("Image"));
                        String instruc=c2.getString(c2.getColumnIndex("Instructions"));
                        String date=c2.getString(c2.getColumnIndex("DateDAjout"));
                        String sentence=c2.getString(c2.getColumnIndex("Origine"));
                        res.add(new Recipe(name,image,instruc,date,sentence));
                        c2.moveToNext();
                    }
                }
                c2.close();

                c.moveToNext();
            }
        }
        c.close();
        Recipe[] rt = new Recipe[res.size()];
        return res.toArray(rt);
    }
    public Recipe[] getRecipeDrink(){
        String boisson="beverage";
        ArrayList<Recipe> res=new ArrayList<Recipe>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("Catégories",new String[]{"NomRecette"},("Catégorie = \""+boisson+"\"") ,null,null,null,null);
        Log.wtf("wtf", ""+c.getCount());
        Log.wtf("test", "test0");
        if(c.moveToFirst()){
            Log.wtf("test", "test1");
            for(int i = 0; i<c.getCount(); i++){   // il devrait n'y avoir qu'une seule row
                Log.wtf("test", "test2");
                String nom=c.getString(c.getColumnIndex("NomRecette"));
                Cursor c2= db.query("Recette", null, "NomRecette=\""+nom+"\"", null, null, null, null);
                Log.wtf("wtf2",""+c2.getCount());
                if(c2.moveToFirst()){
                    Log.wtf("t",""+c2.getCount());
                    for(int j=0;j<c2.getCount();j++){
                        Log.wtf("test", "test3");
                        String name=c2.getString(c2.getColumnIndex("NomRecette"));
                        String image=c2.getString(c2.getColumnIndex("Image"));
                        String instruc=c2.getString(c2.getColumnIndex("Instructions"));
                        String date=c2.getString(c2.getColumnIndex("DateDAjout"));
                        String sentence=c2.getString(c2.getColumnIndex("Origine"));
                        res.add(new Recipe(name,image,instruc,date,sentence));
                        c2.moveToNext();
                    }
                }
                c2.close();

                c.moveToNext();
            }
        }
        c.close();
        Recipe[] rt = new Recipe[res.size()];
        return res.toArray(rt);
    }
    public Recipe[] getRecipeCat(String cat,String scat){

        ArrayList<Recipe> res=new ArrayList<Recipe>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT DISTINCT C.NomRecette FROM Catégories C, Sous_catégorie S WHERE C.NomRecette=S.NomRecette AND Catégorie = \""+cat+"\" AND sous_catégorie=\""+scat+"\"",null);

        if(c.moveToFirst()){

            for(int i = 0; i<c.getCount(); i++){

                String nom=c.getString(c.getColumnIndex("NomRecette"));
                Cursor c2= db.query("Recette", null, "NomRecette=\""+nom+"\"", null, null, null, null);

                if(c2.moveToFirst()){
                    for(int j=0;j<c2.getCount();j++){
                        String name=c2.getString(c2.getColumnIndex("NomRecette"));
                        String image=c2.getString(c2.getColumnIndex("Image"));
                        String instruc=c2.getString(c2.getColumnIndex("Instructions"));
                        String date=c2.getString(c2.getColumnIndex("DateDAjout"));
                        String sentence=c2.getString(c2.getColumnIndex("Origine"));
                        res.add(new Recipe(name,image,instruc,date,sentence));
                        c2.moveToNext();
                    }
                }
                c2.close();

                c.moveToNext();
            }
        }
        c.close();
        Recipe[] rt = new Recipe[res.size()];
        return res.toArray(rt);
    }
    public List<String> mostRecipe(String usermail){
        List<String> res = new ArrayList<String>();
        List<String> ret = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Effectués\"",new String[]{"\"Recette\""},("\"Username\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Recette")));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        int count=0;
        int comparateur=0;
        for (int i=0; i<res.size(); i++) {
            count=0;
            for (int j=0; j<res.size(); j++) {
                if(res.get(i).equals(res.get(j))) {
                    count++;
                }
            }
            if (count>comparateur) {
                ret.clear();
                ret.add(res.get(i));
                comparateur=count;
            }
        }
        return ret;
    }

    public List<String> mostIngredient(String usermail){
        List<String> res = new ArrayList<String>();
        List<String> ret = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Consommés\"",new String[]{"\"Ingrédient\""},("\"Username\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Ingrédient")));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        int count=0;
        int comparateur=0;
        for (int i=0; i<res.size(); i++) {
            count=0;
            for (int j=0; j<res.size(); j++) {
                if(res.get(i).equals(res.get(j))) {
                    count++;
                }
            }
            if (count>comparateur) {
                ret.clear();
                ret.add(res.get(i));
                comparateur=count;
            }
        }
        return ret;
    }

    public String getOriginRecipe(String recette) {
        String ret = "";
        List<String> res = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Recette\"",new String[]{"\"Origine\""},("\"NomRecette\" = \"" + recette +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Origine")));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        ret=res.get(0);
        return ret;
    }

    public List<String> mostOrigin(String usermail){
        List<String> res = new ArrayList<String>();
        List<String> ret = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Effectués\"",new String[]{"\"Recette\""},("\"Username\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Recette")));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        int count=0;
        int comparateur=0;
        for (int i=0; i<res.size(); i++) {
            count=0;
            for (int j=0; j<res.size(); j++) {
                if(getOriginRecipe(res.get(i)).equals(getOriginRecipe(res.get(j)))) {
                    count++;
                }
            }
            if (count>comparateur) {
                ret.clear();
                ret.add(getOriginRecipe(res.get(i)));
                comparateur=count;
            }
        }
        return ret;
    }

    public String getCategoryRecipe(String recette) {
        String ret = "";
        List<String> res = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Catégories\"",new String[]{"\"Catégorie\""},("\"NomRecette\" = \"" + recette +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Catégorie")));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        ret=res.get(0);
        return ret;
    }

    public List<String> mostCategory(String usermail){
        List<String> res = new ArrayList<String>();
        List<String> ret = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Effectués\"",new String[]{"\"Recette\""},("\"Username\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Recette")));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        int count=0;
        int comparateur=0;
        for (int i=0; i<res.size(); i++) {
            count=0;
            for (int j=0; j<res.size(); j++) {
                if(getCategoryRecipe(res.get(i)).equals(getCategoryRecipe(res.get(j)))) {
                    count++;
                }
            }
            if (count>comparateur) {
                ret.clear();
                ret.add(getCategoryRecipe(res.get(i)));
                comparateur=count;
            }
        }
        return ret;
    }

    public String getTimeRecipe(String recette) {
        String ret = "";
        List<String> res = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =getRecipeInfo(recette);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(Integer.toString(Integer.parseInt(c.getString(c.getColumnIndex("TempsCuisson")))+Integer.parseInt(c.getString(c.getColumnIndex("TempsPreparation")))));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        ret=res.get(0);
        return ret;
    }

    public int mostTime(String usermail){
        List<String> res = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Effectués\"",new String[]{"\"Recette\""},("\"Username\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Recette")));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        int countcourt=0;
        int countmoyen=0;
        int countlong=0;
        for (int i=0; i<res.size(); i++) {
                if (res.get(i)=="None") {
                    return 0;
                }
                if(Integer.parseInt(getTimeRecipe(res.get(i)))<20) {
                    countcourt++;
                } else if (Integer.parseInt(getTimeRecipe(res.get(i)))>60) {
                    countlong++;
                } else {
                    countmoyen++;
                }
        }
        if (countcourt>countmoyen) {
            if (countmoyen>countlong) {
                return 1;
            } else if (countcourt>countlong) {
                    return 1;
            } else {
                return 100;
            }
        } else if (countmoyen>countlong) {
            return 50;
        } else {
            return 100;
        }
    }

    public Cursor getRecipeInfo (String recipeName){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query("Informations",new String[]{"*"},("NomRecette=\""+recipeName+"\"") ,null,null,null,null);
        return c;
    }

    public String getAllerIngrédient(String ingrédient) {
        List<String> res = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Ingrédients\"",new String[]{"\"Allergène\""},("\"Libellé\" = \""+ingrédient+"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Allergène")));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        return res.get(0);
    }
    public List<String> ListeIngredients(String recette) {
        List<String> res = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Liste\"",new String[]{"\"Ingrédient\""},("\"NomRecette\" = \"" + recette +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Ingrédient")));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        return res;
    }

    public List<String> AllergenesConsomm(String usermail){
        List<String> res = new ArrayList<String>();
        List<String> ret = new ArrayList<>();
        List<String> allerUsr = getAllergene(usermail);
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT DISTINCT \"Recette\" FROM \"Effectués\" WHERE \"Username\" = \"" +usermail +"\"",null);
        //Cursor c =db.query("\"Effectués\"",new String[]{"\"Recette\""},("\"Username\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                res.add(c.getString(c.getColumnIndex("Recette")));
                c.moveToNext();
            }
        } else {
            res.add("None");
        }
        c.close();
        List<String> ingr;
        for (int i=0; i<res.size(); i++) {
            ingr = ListeIngredients(res.get(i));
            for (int j=0; j<ingr.size();j++) {
                for (int k = 0; k < allerUsr.size(); k++) {
                    if (getAllerIngrédient(ingr.get(j)).equals(allerUsr.get(k))) {
                        ret.add(res.get(i));
                    }
                }
            }
        }
        return ret;
    }

    public Recipe getRecipeName(String NomRecette){
        SQLiteDatabase db = getReadableDatabase();
        Recipe recipe=new Recipe("okok","","","","");
        String[] nom=new String[1];
        nom[0]=NomRecette;
        Cursor c= db.query("Recette", null, "NomRecette=?", nom, null, null, null);
        if(c.moveToFirst()) {
            for(int i = 0; i<c.getCount(); i++) {
                String image = c.getString(c.getColumnIndex("Image"));
                String instruc = c.getString(c.getColumnIndex("Instructions"));
                String date = c.getString(c.getColumnIndex("DateDAjout"));
                String sentence = c.getString(c.getColumnIndex("Origine"));
                recipe = new Recipe(NomRecette, image, instruc, date, sentence);
            }
        }
        c.close();
        return recipe;
    }

    public String[] getInformation (String NomRecette){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> ret=new ArrayList<String>();
        ret.add(0,"k");
        String[] nom=new String[1];
        nom[0]=NomRecette;
        String queryString="SELECT * FROM Informations WHERE \"NomRecette\" = \"" + NomRecette + "\"";
        Cursor c=db.rawQuery(queryString,null);
        //Cursor c= db.query("Informations", null, "NomRecette LIKE ?", nom, null, null, null);
        if(c.moveToFirst()) {
            //for (int i = 0; i < c.getCount(); i++) {
            Log.wtf("yoyo", "ici");
            String description = c.getString(c.getColumnIndex("Description"));
            ret.set(0, description);
            String difficulté = c.getString(c.getColumnIndex("Difficulté"));
            ret.add(1, difficulté);
            String tempsCuisson = c.getString(c.getColumnIndex("TempsCuisson"));
            ret.add(2, tempsCuisson);
            String tempsPreparation = c.getString(c.getColumnIndex("TempsPreparation"));
            ret.add(3, tempsPreparation);
            String nbrePersonnes = c.getString(c.getColumnIndex("NbrePersonnes"));
            ret.add(4, nbrePersonnes);
            //}
        }
        else ret.set(0,"passe le if");
        c.close();
        String[] rt = new String[ret.size()];

        return ret.toArray(rt);
    }

    public com.lsinf1225.ezmeal.ezmeal.Ingredient[] getIngredient(String NomRecette){
        ArrayList<Ingredient> res=new ArrayList<Ingredient>();
        //Ingredient ingr=new Ingredient("Carotte","kg","carotine",3);
        //res.add(0,ingr);
        SQLiteDatabase db = getReadableDatabase();
        Cursor c= db.query("Liste", null, "NomRecette=\""+NomRecette+"\"", null, null, null, null);
        if(c.moveToFirst()){
            for(int i = 0; i<c.getCount(); i++){
                int quantite=c.getInt(c.getColumnIndex("Quantité"));
                String ingredient=c.getString(c.getColumnIndex("Ingrédient"));
                Cursor c2= db.query("Ingrédients", null, "Libellé=\""+ingredient+"\"", null, null, null, null);
                if(c2.moveToFirst()){
                    for(int j=0;j<c2.getCount();j++){
                        String unite=c2.getString(c2.getColumnIndex("Unité"));
                        if(c2.isNull(c2.getColumnIndex("Allergène"))){
                            res.add(new Ingredient(ingredient,unite,quantite));
                        }
                        else{
                            String allergene=c2.getString(c2.getColumnIndex("Allergène"));
                            res.add(new Ingredient(ingredient,unite,allergene,quantite));
                        }
                        c2.moveToNext();
                    }
                }
                c2.close();

                c.moveToNext();
            }
        }
        c.close();

        Ingredient[] rt = new Ingredient[res.size()];
        return res.toArray(rt);
    }

    public void addEffectues(String usermail, String NomRecette){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO \"Effectués\" VALUES(\""+NomRecette+"\", \""+usermail+"\")");
        Cursor c= db.query("\"Liste\"",new String[]{"\"Ingrédient\""},("\"NomRecette\" = \"" + NomRecette +"\"") , null, null, null, null);
        if(c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                db.execSQL("INSERT INTO \"Consommés\" VALUES(\""+(c.getString(c.getColumnIndex("Ingrédient")))+"\", \""+usermail+"\")");
                c.moveToNext();
            }
        }
        c.close();
        close();
    }





}
