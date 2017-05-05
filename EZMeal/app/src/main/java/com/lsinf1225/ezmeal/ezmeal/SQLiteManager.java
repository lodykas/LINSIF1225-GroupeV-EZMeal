package com.lsinf1225.ezmeal.ezmeal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.lsinf1225.ezmeal.ezmeal.R.string.usermail;


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
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Effectués\" (\"Recette\" NOT NULL, \"Username\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Consommés\" (\"Ingrédient\" NOT NULL, \"Username\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Allergène\" (\"Usermail\" NOT NULL,\"Allergène\" NOT NULL);");

        db.execSQL("CREATE TABLE IF NOT EXISTS \"Ingrédients\" (\"Libellé\" PRIMARY KEY, \"Allergène\", \"Unité\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Famille\" (\"Ingrédient\" NOT NULL, \"Famille\" NOT NULL);");
        db.execSQL("INSERT INTO \"Ingrédients\" VALUES (\"Carotte\",Null,'u');");
        db.execSQL("INSERT INTO \"Famille\" VALUES (\"Carotte\",\"Légume\");");


        db.execSQL("CREATE TABLE IF NOT EXISTS \"Recette\" ( _id INTEGER PRIMARY KEY AUTOINCREMENT,\"NomRecette\" NOT NULL,\"Image\" NOT NULL,\"Instructions\" NOT NULL,\"DateDAjout\" NOT NULL,\"Origine\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Catégories\" (\"NomRecette\" NOT NULL,\"Catégories\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Sous_catégorie\" (\"NomRecette\" NOT NULL,\"Sous_catégorie\" NOT NULL);");
        db.execSQL("INSERT INTO \"Recette\" VALUES (\"Soupe de carottes\",Null,'L');");



        db.execSQL("CREATE TABLE IF NOT EXISTS \"Liste\" (\"NomRecette\" NOT NULL,\"Ingrédient\" NOT NULL,\"Quantité\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Informations\" (\"NomRecette\" PRIMARY KEY,\"Description\" NOT NULL,\"Difficulté\" NOT NULL,\"TempsCuisson\" NOT NULL,\"TempsPreparation\" NOT NULL,\"NbrePersonnes\" NOT NULL);");

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

    public Cursor research(String query)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query("\"Recette\"",new String[]{"\"_id\"","\"NomRecette\""},null ,null,null,null,null);
        //Cursor c = db.query("\"Recette\"",new String[]{"\"_id\"","\"NomRecette\""},("\"NomRecette\" = \"" + query +"\"") ,null,null,null,null);
        return c;
    }
    public Recipe[] getRecipe(int tabSize){
        ArrayList<Recipe> res=new ArrayList<Recipe>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("\"Recommandations\"",new String[]{"\"Recette\""},("\"Usermail\" = \"" + usermail +"\"") ,null,null,null,null);
        if(c.moveToFirst()){
            for(int i = 0; i<tabSize; i++){
                String nom=c.getString(c.getColumnIndex("Recette"));
                Cursor c2= db.query("Recette", null, "NomRecette=\""+nom+"\"", null, null, null, null);
                if(c2.moveToFirst()){
                    for(int j=0;j<tabSize;j++){
                        String name=c2.getString(c2.getColumnIndex("NomRecette"));
                        String image=c2.getString(c2.getColumnIndex("Image"));
                        String instruc=c2.getString(c2.getColumnIndex("Instructions"));
                        String date=c2.getString(c2.getColumnIndex("DatedAjout"));
                        String sentence=c2.getString(c2.getColumnIndex(""));
                        res.add(new Recipe(name,image,instruc,date,sentence));
                        c2.moveToNext();
                    }
                }
                c2.close();

                c.moveToNext();
            }
        }
        c.close();
        Recipe[] rt = new Recipe[tabSize];
        return res.toArray(rt);
    }
}
