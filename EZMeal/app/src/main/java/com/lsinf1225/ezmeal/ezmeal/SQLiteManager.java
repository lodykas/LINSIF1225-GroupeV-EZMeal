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
        SQLiteStatement s = db.compileStatement("INSERT INTO \"Recommandations\"(\"Usermail\",\"Recette\") VALUES(?,?)");
        s.bindString(1,"blabla");
        s.bindString(2,"soupe à l'oignon");
        s.execute();
        s.bindString(1,"blabla");
        s.bindString(2,"macaroni au fromage");
        s.execute();
        s.bindString(1,"blabla");
        s.bindString(2,"spaguetti bolognaise");
        s.execute();
        s.bindString(1,"blabla");
        s.bindString(2,"foire de légumes");
        s.execute();
        s.bindString(1,"a");
        s.bindString(2,"soupe à l'oignon");
        s.execute();
        s.bindString(1,"a");
        s.bindString(2,"macaroni au fromage");
        s.execute();
        s.bindString(1,"a");
        s.bindString(2,"spaguetti bolognaise");
        s.execute();
        s.bindString(1,"usermail");
        s.bindString(2,"foire de légumes");
        s.execute();


        db.execSQL("CREATE TABLE IF NOT EXISTS \"Effectués\" (\"Recette\" NOT NULL, \"Username\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Consommés\" (\"Ingrédient\" NOT NULL, \"Username\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Allergène\" (\"Usermail\" NOT NULL,\"Allergène\" NOT NULL);");

        db.execSQL("CREATE TABLE IF NOT EXISTS \"Ingrédients\" (\"Libellé\" PRIMARY KEY, \"Allergène\", \"Unité\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Famille\" (\"Ingrédient\" NOT NULL, \"Famille\" NOT NULL);");
        db.execSQL("INSERT INTO \"Ingrédients\" VALUES (\"Carotte\",Null,'u');");
        db.execSQL("INSERT INTO \"Famille\" VALUES (\"Carotte\",\"Légume\");");


        db.execSQL("CREATE TABLE IF NOT EXISTS \"Recette\" ( _id INTEGER PRIMARY KEY AUTOINCREMENT,\"NomRecette\" NOT NULL,\"Image\" NOT NULL,\"Instructions\" NOT NULL,\"DateDAjout\" NOT NULL,\"Origine\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Catégories\" (\"NomRecette\" NOT NULL,\"Catégorie\" NOT NULL);");
        SQLiteStatement d= db.compileStatement("INSERT INTO\"Catégories\"(\"NomRecette\",\"Catégorie\") VALUES(?,?)");
        d.bindString(1,"milshake au fruit rouges");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"mojito");
        d.bindString(2,"beverage");
        d.execute();

        db.execSQL("CREATE TABLE IF NOT EXISTS \"Sous_catégorie\" (\"NomRecette\" NOT NULL,\"Sous_catégorie\" NOT NULL);");

        SQLiteStatement r = db.compileStatement("INSERT INTO \"Recette\"(\"NomRecette\",\"Image\",\"Instructions\",\"DateDAjout\",\"Origine\") VALUES(?,?,?,?,?)");
        r.bindString(1,"soupe à l'oignon");
        r.bindString(2,"soupeoignon");
        r.bindString(3,"mixer les oignons");
        r.bindString(4,"05/05/17");
        r.bindString(5,"occidentale");
        r.execute();
        r.bindString(1,"macaroni au fromage");
        r.bindString(2,"macaronifromage");
        r.bindString(3,"cuire les pâtes");
        r.bindString(4,"05/05/17");
        r.bindString(5,"italienne");
        r.execute();
        r.bindString(1,"spaguetti bolognaise");
        r.bindString(2,"spaguettibolognaise");
        r.bindString(3,"cuire les pâtes, faites revenir le steak haché, ajouter les tomates");
        r.bindString(4,"06/05/17");
        r.bindString(5,"italienne");
        r.execute();
        r.bindString(1,"foire de légumes");
        r.bindString(2,"soupeoignon");
        r.bindString(3,"préparez tout les légumes separément.");
        r.bindString(4,"06/05/17");
        r.bindString(5,"occidentale");
        r.execute();
        r.bindString(1,"mousse au chocolat");
        r.bindString(2,"moussechocolat");
        r.bindString(3,"battre les blancs d'oeufs en neige, incorporez-y le mélange du chocolat, beurre et jaune d'oeuf.");
        r.bindString(4,"06/05/17");
        r.bindString(5,"occidentale");
        r.execute();
        r.bindString(1,"milshake au fruit rouges");
        r.bindString(2,"berryshake");
        r.bindString(3,"versez le lait d'amande dans le blender, rajoutez le mélange de fruits rouges congelés, versez un dilet de sirop d'agave et mixez le tout. servir dans un grand verre et parsemez de fruits rouges frais");
        r.bindString(4,"06/05/17");
        r.bindString(5,"us");
        r.execute();
        r.bindString(1,"Rhum citon miel");
        r.bindString(2,"alcoolcitron");
        r.bindString(3,"dans un verre à alcool, ajoutez 3 c.à.s de rhum ainsi que de miel, remplisez le reste du verre en thé de citron froid. servez avec des tranches de citron");
        r.bindString(4,"06/05/17");
        r.bindString(5,"tex-mex");
        r.execute();
        r.bindString(1,"gauffre belge");
        r.bindString(2,"belgianwaffle");
        r.bindString(3,"préparez la pâte à gaufre");
        r.bindString(4,"06/05/17");
        r.bindString(5,"europe");
        r.execute();
        r.bindString(1,"chocolat chaud de noel");
        r.bindString(2,"chocochaud");
        r.bindString(3,"dans une casserole chauffez un verre de lait en surveillant la cuisson du lait, lorsque le lait frémit doucement ajoutez y 4 barres de choclat noir concassé, mélangez bien et rajoutez à la préparation un baton de canelle, 2 clous de girofle ainsi qu'une c.à.c de muscade, sucrez à votre convenance. servez avec de la chantilly saupoudrée au cacao ");
        r.bindString(4,"06/05/17");
        r.bindString(5,"russie");
        r.execute();
        r.bindString(1,"curry japonais");
        r.bindString(2,"curryjapan");
        r.bindString(3,"blabla");
        r.bindString(4,"06/05/17");
        r.bindString(5,"asie");
        r.execute();
        r.bindString(1,"donut new yorkais");
        r.bindString(2,"donut");
        r.bindString(3,"blabla");
        r.bindString(4,"06/05/17");
        r.bindString(5,"us");
        r.execute();
        r.bindString(1,"gin tonic à la framboise");
        r.bindString(2,"ginframboise");
        r.bindString(3,"blabla");
        r.bindString(4,"06/05/17");
        r.bindString(5,"espagne");
        r.execute();
        r.bindString(1,"granola maison");
        r.bindString(2,"granola");
        r.bindString(3,"dans un bol melangez le musli avec du miel, etalez ensuite sur une plaque et enfournez 30 min à 180 degré, sortez la plaque et mélangez le tout, ajoutez des nox, noisettes et raison sec");
        r.bindString(4,"06/05/17");
        r.bindString(5,"suède");
        r.execute();
        r.bindString(1,"thai glacé thaï");
        r.bindString(2,"icedtea");
        r.bindString(3,"demandez à pat");
        r.bindString(4,"06/05/17");
        r.bindString(5,"thaïlande");
        r.execute();
        r.bindString(1,"macaron");
        r.bindString(2,"macaron");
        r.bindString(3,"paul vous servira");
        r.bindString(4,"06/05/17");
        r.bindString(5,"france");
        r.execute();
        r.bindString(1,"mojito");
        r.bindString(2,"mojito");
        r.bindString(3,"bjbzfz");
        r.bindString(4,"06/05/17");
        r.bindString(5,"cuba");
        r.execute();
        r.bindString(1,"boisson saine et sans allergènes");
        r.bindString(2,"pastequeboisson");
        r.bindString(3,"congelez des morceau de chair de pastèque, une fois les morceaux dur comme des glacons, versez un verre remplis de pastèque congelés avec un verre d'eau et une poignée de menthe. mixer le tout ");
        r.bindString(4,"06/05/17");
        r.bindString(5,"afrique");
        r.execute();


        db.execSQL("CREATE TABLE IF NOT EXISTS \"Liste\" (\"NomRecette\" NOT NULL,\"Ingrédient\" NOT NULL,\"Quantité\" NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"Informations\" (\"NomRecette\" PRIMARY KEY,\"Description\" NOT NULL,\"Difficulté\" NOT NULL,\"TempsCuisson\" NOT NULL,\"TempsPreparation\" NOT NULL,\"NbrePersonnes\" NOT NULL);");
        //difficulte peu etre que facile, moyen et difficile
        SQLiteStatement i = db.compileStatement("INSERT INTO \"Informations\"(\"NomRecette\",\"Description\",\"Difficulté\",\"TempsCuisson\",\"TempsPreparation\",\"NbrePersonnes\") VALUES(?,?,?,?,?,?)");
        i.bindString(1,"donut");
        i.bindString(2,"colorons la vie de donut");
        i.bindString(3,"moyen");
        i.bindString(4,"15 min");
        i.bindString(5,"1 h");
        i.bindString(6,"6 personnes");





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
        Cursor c = db.query("\"Recette\"",new String[]{"*"},("instr(\"NomRecette\",\""+query+"\") > 0") ,null,null,null,null);
        return c;
    }
    public Recipe[] getRecipe(int tabSize, String usermail){
        ArrayList<Recipe> res=new ArrayList<Recipe>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.query("Recommandations",new String[]{"Recette"},("Usermail = \"" + usermail +"\"") ,null,null,null,null);
        //Log.wtf("wtf", usermail);
        //Log.wtf("test", "test0");
        if(c.moveToFirst()){
            //Log.wtf("test", "test1");
            for(int i = 0; i<c.getCount(); i++){   // il devrait n'y avoir qu'une seule row
                //Log.wtf("test", "test2");
                String nom=c.getString(c.getColumnIndex("Recette"));
                Cursor c2= db.query("Recette", null, "NomRecette=\""+nom+"\"", null, null, null, null);
                if(c2.moveToFirst()){
                    for(int j=0;j<c2.getCount();j++){
                       // Log.wtf("test", "test3");
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
}
