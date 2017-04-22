package com.lsinf1225.ezmeal.ezmeal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




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
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Sous_catégorie\" (\"NomRecette\" NOT NULL,\"Sous_catégorie\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Recommandations\" (\"Usermail\" NOT NULL,\"Recette\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Recette\" (\"NomRecette\" NOT NULL,\"Image\" NOT NULL,\"Instructions\" NOT NULL,\"DateDAjout\" NOT NULL,\"Origine\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Liste\" (\"NomRecette\" NOT NULL,\"Ingrédient\" NOT NULL,\"Quantité\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Ingrédients\" (\"Libellé\" PRIMARY KEY, \"Allergène\", \"Unité\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Informations\" (\"NomRecette\" PRIMARY KEY,\"Description\" NOT NULL,\"Difficulté\" NOT NULL,\"TempsCuisson\" NOT NULL,\"TempsPreparation\" NOT NULL,\"NbrePersonnes\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Famille\" (\"Ingrédient\" NOT NULL, \"Famille\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Effectués\" (\"Recette\" NOT NULL, \"Username\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Consommés\" (\"Ingrédient\" NOT NULL, \"Username\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Catégories\" (\"NomRecette\" NOT NULL,\"Catégories\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Allergène\" (\"Usermail\" NOT NULL,\"Allergène\" NOT NULL);");

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
}