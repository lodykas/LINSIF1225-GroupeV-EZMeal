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
        s.bindString(2,"spaghetti bolognaise");
        s.execute();
        s.bindString(1,"blabla");
        s.bindString(2,"salade césar");
        s.execute();
        s.bindString(1,"a");
        s.bindString(2,"soupe à l'oignon");
        s.execute();
        s.bindString(1,"a");
        s.bindString(2,"macaroni au fromage");
        s.execute();
        s.bindString(1,"a");
        s.bindString(2,"spaghetti bolognaise");
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
        d.bindString(1,"soupe à l'oignon");
        d.bindString(2,"entree");
        d.execute();
        d.bindString(1,"macaroni au fromage");
        d.bindString(2,"plat");
        d.execute();
        d.bindString(1,"spahetti bolognaise");
        d.bindString(2,"plat");
        d.execute();
        d.bindString(1,"salade césar");
        d.bindString(2,"entree");
        d.execute();
        d.bindString(1,"salade césar");
        d.bindString(2,"plat");
        d.execute();
        d.bindString(1,"mousse au chocolat");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"rhum citron miel");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"gaufre belge");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"chocolat chaud");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"curry japonais");
        d.bindString(2,"plat");
        d.execute();
        d.bindString(1,"donut new yorkais");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"gin tonic à la framboise");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"granola maison");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"thai glacé thaï");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"crepe sucree");
        d.bindString(2,"dessert");
        d.execute();
        d.bindString(1,"mojito");
        d.bindString(2,"beverage");
        d.execute();
        d.bindString(1,"boisson saine et sans allergènes");
        d.bindString(2,"bevrage");
        d.execute();


        db.execSQL("CREATE TABLE IF NOT EXISTS \"Sous_catégorie\" (\"NomRecette\" NOT NULL,\"Sous_catégorie\" NOT NULL);");

        SQLiteStatement r = db.compileStatement("INSERT INTO \"Recette\"(\"NomRecette\",\"Image\",\"Instructions\",\"DateDAjout\",\"Origine\") VALUES(?,?,?,?,?)");
        r.bindString(1,"soupe à l'oignon");
        r.bindString(2,"soupeoignon");
        r.bindString(3,"dans une casserole à gros fond, faites fondre le beurre ou chauffer l'huile d'olive, dorer à petit feu les oignons finement émincés. lorsqu'il est transparent, ajouter la farine en saupoudrant et en mélangeant sans cesse à la cuiller en bois. \n" +
                "saler et poivrer au moulin. mouiller ensuite, toujours en remuant, avec le consommé et porter à ébullition.\n" +
                "diminuer à petits frémissements et poursuivre la cuisson pendant 30 minutes. pendant ce temps, faire fondre un peu de beurre et d'huile d'olive dans un grand wok et frire les tranches de pain coupées à la dimension des bols à soupe.\n" +
                "quelques minutes avant la fin de la cuisson, ajouter le porto (optionnel), mélanger bien et servir dans des bols individuels.\n" +
                "placer les bols côte à côte sur une grille allant au four, couvrir le centre de chaque bol avec un morceau de pain frit, casser au milieu du pain un oeuf sans le blanc, saupoudrer avec le parmesan et hop, au grill maximum pendant quelques moments, histoire de faire prendre un peu de couleur à l'appareil.\n" +
                "bon appétit.");
        r.bindString(4,"01/04/17");
        r.bindString(5,"occidentale");
        r.execute();
        r.bindString(1,"macaroni au fromage");
        r.bindString(2,"macaronifromage");
        r.bindString(3,"coupez les fromages en morceaux. mettre la crème dans une casserole, la faire bouillir et réduire 3 mn à feu doux. hors du feu, rajoutez les fromages mais seulement la moitié du parmesan en mélangeant vivement. \n" +
                "remettez à feu doux jusqu'à ce que le mélange soit lisse. poivrez et relevez de muscade. \n" +
                "pendant ce temps, faîtes cuire les pâtes suivant le temps indiqué sur votre paquet (pâtes fraîches c'est encore meilleur). \n" +
                "egouttez les pâtes, versez-les dans la casserole contenant la sauce aux trois fromages. mélangez rapidement, parsemez du reste de parmesan et servez.");
        r.bindString(4,"02/04/17");
        r.bindString(5,"italienne");
        r.execute();
        r.bindString(1,"spaghetti bolognaise");
        r.bindString(2,"spaguettibolognaise");
        r.bindString(3,"hachez l'ail, l'oignon, puis coupez la carotte et le céleri en petits dés (enlevez les principales nervures du céleri). \n" +
                "\n" +
                "faites chauffer l'huile dans une casserole assez grande. faites revenir l'ail, l'oignon, la carotte et le céleri à feu doux pendant 5 min en remuant.\n" +
                "\n" +
                "augmenter la flamme, puis ajoutez le boeuf. faites brunir et remuez de façon à ce que la viande ne fasse pas de gros paquets. \n" +
                "\n" +
                "ajoutez le bouillon, le vin rouge, les tomates préalablement coupées assez grossièrement, le sucre et le persil haché. portez à ébullition.\n" +
                "\n" +
                "baisser ensuite le feu et laissez mijoter à couvert 1h à 1h30, de façon à ce que le vin s'évapore. \n" +
                "\n" +
                "faites cuire les spaghetti, puis mettez-les dans un plat. ajoutez la sauce bolognaise.");
        r.bindString(4,"03/04/17");
        r.bindString(5,"italienne");
        r.execute();
        r.bindString(1,"salade césar");
        r.bindString(2,"soupeoignon");
        r.bindString(3,"préchauffez votre four à 210-220°C . \n" +
                "détachez les feuilles de salade, lavez-les, découpez-les en lamelles, essorez-les. \n" +
                "coupez le pain en dés. Faites-les griller au four en surveillant bien la cuisson car c'est très rapide (environ 1 à 2 mn). \n" +
                "chauffez 4 cuillerées à soupe d'huile dans une poêle. ajoutez l'ail écrasé. faites rissoler les dés de pain en croûtons. Laissez-les refroidir. \n" +
                "faites cuire les oeufs mollets : lorsque l'eau commence à bouillir, diminuez la source de chaleur et laissez cuire 2 mn. rincez-les tout de suite à l'eau froide puis écalez-les. \n" +
                "pressez les citrons et versez le jus dans un bol. ajoutez l'huile d'olive goutte à goutte. Salez et poivrez. \n" +
                "mettez la salade dans un saladier et versez dessus la sauce. mélangez bien le tout et laissez de côté pendant une dizaine de minutes afin que la salade s'imprègne bien de la sauce. \n" +
                "coupez les oeufs en 4, dans le sens de la longueur. mélangez-les à la salade afin que le jaune se mêle à la sauce, puis ajoutez le parmesan râpé et les croûtons. \n" +
                "servez aussitôt.");
        r.bindString(4,"04/04/17");
        r.bindString(5,"grecque");
        r.execute();
        r.bindString(1,"mousse au chocolat");
        r.bindString(2,"moussechocolat");
        r.bindString(3,"séparer les blancs des jaunes d'oeufs.\n" +
                "\n" +
                "faire ramollir le chocolat dans une casserole au bain-marie. \n" +
                "\n" +
                "hors du feu, incorporer les jaunes et le sucre. \n" +
                "\n" +
                "battre les blancs en neige ferme et les ajouter délicatement au mélange à l'aide d'une spatule. \n" +
                "\n" +
                "verser dans une terrine ou des verrines et mettre au frais 1 heure ou 2 minimum.\n");
        r.bindString(4,"05/04/17");
        r.bindString(5,"belge");
        r.execute();
        r.bindString(1,"milshake au fruit rouges");
        r.bindString(2,"berryshake");
        r.bindString(3,"versez le lait d'amande dans le blender, rajoutez le mélange de fruits rouges congelés, versez un dilet de sirop d'agave et mixez le tout. servir dans un grand verre et parsemez de fruits rouges frais");
        r.bindString(4,"06/04/17");
        r.bindString(5,"espagnole");
        r.execute();
        r.bindString(1,"rhum citron miel");
        r.bindString(2,"alcoolcitron");
        r.bindString(3,"composer chacun des verres de la manière suivante :\n" +
                "verser 2 cl de Rhum, saupoudrer d'une pincée de cannelle et bien mélanger pour éviter les grumeaux.\n" +
                "Couper les 2 feuilles de menthe en fines lanières et les écraser un peu dans le rhum avec un pilon.\n" +
                "passez la boisson au tamis pour retirer les morceaux de menthe.\n" +
                "couper une rondelle de citron de 5 mm d'épaisseur et la presser au-dessus du verre.\n" +
                "vous pouvez ensuite mettre la rondelle dans le verre pour la presentation.\n" +
                "ajouter 2 glaçons et bien remuer.");
        r.bindString(4,"07/04/17");
        r.bindString(5,"mexicaine");
        r.execute();
        r.bindString(1,"gaufre belge");
        r.bindString(2,"belgianwaffle");
        r.bindString(3,"tamiser la farine.\n" +
                "séparer les jaunes et les blancs des oeufs en ne gardant que 4 blancs.\n" +
                "faire fondre légèrement le beurre au bain-marie; il doit être liquide et à peine tiède.\n" +
                "couper la gousse de vanille dans sa longueur et récupérer les graines.\n" +
                "mélanger la farine, les cinq jaunes d'oeufs, le sucre fin, les graines de vanille, une pincée de sel, le lait et le beurre fondu.\n" +
                "battre les 4 blancs d'oeufs en neige très ferme.\n" +
                "incorporer les blancs en neige à la préparation. A faire très délicatement afin de ne pas briser la mousse.\n" +
                "laisser reposer durant 45 minutes bien à couvert.\n" +
                "la pâte doit être un peu moins liquide qu'une pâte à crêpe.\n" +
                "cuire les gaufres dans un fer bien chaud.\n" +
                "dès que la ou les portions de pâte sont versées, il faut fermer le gaufrier et le renverser de suite pour avoir des gaufres régulières et gonflées.\n" +
                "aussitôt que la gaufre est dorée sur les deux faces, la sortir du fer, la saupoudrer de sucre glace et servir très chaud.");
        r.bindString(4,"08/04/17");
        r.bindString(5,"belge");
        r.execute();
        r.bindString(1,"chocolat chaud de noel");
        r.bindString(2,"chocochaud");
        r.bindString(3,"dans une casserole chauffez un verre de lait en surveillant la cuisson du lait, lorsque le lait frémit doucement ajoutez y 4 barres de choclat noir concassé, mélangez bien et rajoutez à la préparation un baton de canelle, 2 clous de girofle ainsi qu'une c.à.c de muscade, sucrez à votre convenance. servez avec de la chantilly saupoudrée au cacao ");
        r.bindString(4,"09/04/17");
        r.bindString(5,"russie");
        r.execute();
        r.bindString(1,"curry japonais");
        r.bindString(2,"curryjapan");
        r.bindString(3,"faire revenir les morceaux de porc dans un peu d'huile jusqu'à ce qu'ils soient bien grillés. Les retirer et faire un roux avec la graisse qu'il y a dans la casserole (en rajouter si nécessaire). ajouter de l'eau (un litre à un litre et demi), ainsi que le curry. Faire bouillir. ajouter les morceaux de viande, les carottes et les navets. après 10 minutes de cuisson ajouter les pommes de terre et les courgettes et laisser cuire sur feu doux encore 20 à 25 minutes.\n" +
                "\n" +
                "le plat doit ressembler à une soupe que l'on servira avec un bol de riz blanc. saler à convenance. \n" +
                "on peut mettre aussi d'autres légumes comme haricots verts, poivrons…\n");
        r.bindString(4,"010/04/17");
        r.bindString(5,"japonaise");
        r.execute();
        r.bindString(1,"donut new yorkais");
        r.bindString(2,"donut");
        r.bindString(3,"mélanger la farine, la levure, le sel, la cannelle et la muscade. \n" +
                "dans un autre bol, mélanger les oeufs (battus), le sucre et la vanille. mélanger jusqu'à ce que le mélange soit épais.\n" +
                "mélanger le lait et le beurre fondu, y ajouter le mélange de farine et battre jusqu'à ce que le mélange soit homogène.\n" +
                "couvrir et mettre au réfrigérateur pendant 2 heures.\n" +
                "sur une planche farinée, étaler la pâte sur une épaisseur de 1 cm environ. découper les donuts à l'aide d'un bol ou autre.\n" +
                "mettre à frire pendant une minute ou jusqu'à ce soit légerement doré puis retourner a l'aide d'un écumoire de l'autre coté et laisser cuire à nouveau une minute.\n" +
                "retirer de la friteuse et poser sur un papier absorbant.garnissez avec du sucre, du choclat fondu...");
        r.bindString(4,"11/04/17");
        r.bindString(5,"américaine");
        r.execute();
        r.bindString(1,"gin tonic à la framboise");
        r.bindString(2,"ginframboise");
        r.bindString(3,"\n" +
                "Mélanger tous les ingrédients dans un shaker.\n" +
                "Ajouter des glaçons.\n" +
                "Agiter vigoureusement 10 secondes.\n" +
                "Servir dans un verre avec des framboises fraîches. \n" +
                "C'est prêt! Bonne dégustation.");
        r.bindString(4,"12/04/17");
        r.bindString(5,"anglaise");
        r.execute();
        r.bindString(1,"granola maison");
        r.bindString(2,"granola");
        r.bindString(3,"préchauffer le four à 150°C.\n" +
                "mélanger l'huile, le miel, le sirop d'érable et l'arôme de vanille au fond d'un grand saladier.\n" +
                "concasser les fruits secs à l'aide d'un grand couteau.\n" +
                "mélanger les flocons d'avoine et les fruits sec dans le saladier.\n" +
                "etaler le mélange sur une plaque de cuisson et enfourner pendant 15 minutes.\n" +
                "pendant la cuisson, couper le chocolat à dessert en morceaux (à l'aide d'un couteau).\n" +
                "laisser refroidir le granola avant d'y ajouter le chocolat.\n" +
                "conserver dans un bocal hermétique.");
        r.bindString(4,"13/04/17");
        r.bindString(5,"suèdoise");
        r.execute();
        r.bindString(1,"thai glacé thaï");
        r.bindString(2,"icedtea");
        r.bindString(3,"porter l'eau à ébullition. Mettre le thé dans le filtre d'une théière. verser doucement l'eau sur le thé et laisser infuser jusqu'à ce que le thé soit très fort et prenne une couleur orange foncé.\n" +
                "ajouter le lait concentré sucré au thé, remuer et laisser refroidir. ajouter des glaçons dans 4 verres long drink et verser le thé dans les verres de manière à les remplir à moitié. compléter avec le lait et servir immédiatement.\n");
        r.bindString(4,"14/04/17");
        r.bindString(5,"thaïlandaise");
        r.execute();
        r.bindString(1,"crepes sucree");
        r.bindString(2,"crepes");
        r.bindString(3,"\n" +
                "verser 250 g de farine, casser 4 œufs et mélanger bien à la farine.\n" +
                "ajouter petit à petit le lait tout en mélangeant bien pour éviter les grumeaux.\n" +
                "ajouter la pincée de sel.\n" +
                "ajouter les 3 sucres (vanillé, de canne et en poudre).\n" +
                "verser le Cognac toujours en mélangeant bien.\n" +
                "ajouter les 50 g de beurre fondu.\n" +
                "faire chauffer la poêle à feu vif en y ajoutant un peu d'huile dont vous essuyez l'excédent avec un papier absorbant.\n" +
                "faire des crêpes fines si possible.");
        r.bindString(4,"15/04/17");
        r.bindString(5,"française");
        r.execute();
        r.bindString(1,"mojito");
        r.bindString(2,"mojito");
        r.bindString(3,"ajouter le sucre en poudre dans le verre, puis le jus d'1/2 citron vert.\n" +
                "ecraser 4 feuilles de menthe, ajouter le rhum et compléter avec l'eau gazeuse. \n" +
                "remuer et ajouter 1 branche de menthe.");
        r.bindString(4,"16/04/17");
        r.bindString(5,"cubaine");
        r.execute();
        r.bindString(1,"boisson saine et sans allergènes");
        r.bindString(2,"pastequeboisson");
        r.bindString(3,"congelez des morceau de chair de pastèque, une fois les morceaux dur comme des glacons, versez un verre remplis de pastèque congelés avec un verre d'eau et une poignée de menthe. mixer le tout ");
        r.bindString(4,"17/04/17");
        r.bindString(5,"africaine");
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
    public Cursor getRecipeInfo (String recipeName){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query("Informations",new String[]{"*"},("NomRecette=\""+recipeName+"\"") ,null,null,null,null);
        return c;
    }
}
