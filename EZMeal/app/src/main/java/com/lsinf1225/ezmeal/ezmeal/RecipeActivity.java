package com.lsinf1225.ezmeal.ezmeal;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebStorage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.widget.ArrayAdapter;

public class RecipeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        final String nom = getIntent().getStringExtra("NomRecette");
        SQLiteManager db = new SQLiteManager(getApplicationContext());

        Recipe recipe=db.getRecipeName(nom);

        TextView textView=(TextView) findViewById(R.id.title_recipe);
        String nom2=recipe.title;
        textView.setText(nom2);

        TextView textView2=(TextView) findViewById(R.id.origin);
        textView2.setText(recipe.sentence);
        ImageView ib=(ImageView) findViewById(R.id.image);
        String id=recipe.image;
        Context context=getApplicationContext();
        int resId = context.getResources().getIdentifier(id, "drawable", context.getPackageName());;
        Drawable d = context.getResources().getDrawable(resId);
        ib.setImageDrawable(d);



        TextView textView3=(TextView) findViewById(R.id.ajout);
        textView3.setText(recipe.date);

        TextView textView4=(TextView) findViewById(R.id.title_instruction);
        textView4.setText(recipe.portion);
        String[] information=new String[5];
        information=db.getInformation(nom);

        TextView textView5=(TextView) findViewById(R.id.description);
        String nom3=information[0];
        textView5.setText(nom3);

        TextView textView7=(TextView) findViewById(R.id.Difficulté);
        textView7.setText(information[1]);

        TextView textView6=(TextView) findViewById(R.id.TempsCuisson);
        textView6.setText(information[2]);

        TextView textView8=(TextView) findViewById(R.id.TempsPreparation);
        textView8.setText(information[3]);

        TextView textView9=(TextView) findViewById(R.id.NbrePersonnes);
        textView9.setText(information[4]);

        com.lsinf1225.ezmeal.ezmeal.Ingredient[] ingr=db.getIngredient(nom);
        ArrayList<String> res=new ArrayList<String>();
        com.lsinf1225.ezmeal.ezmeal.Ingredient ingredient;
        for (int i =0; i<ingr.length; i++) {
            ingredient = ingr[i];
            res.add(i,String.valueOf(ingredient.Quantite)+" "+ingredient.Unite+" de "+ingredient.NomIngrédient+" ("+ingredient.Allergene+")");

        }
        /*Ingredient ingredient2=new Ingredient("Fraise", "kg","f", 5);
        res.add(String.valueOf(ingredient2.Quantite)+" "+ingredient2.Unite+" de "+ingredient2.NomIngrédient+" ("+ingredient2.Allergene+")");*/
        String[] listItems = new String[res.size()];
        final ListView listView = (ListView) findViewById(R.id.list);
        /*String[] listItems = {String.valueOf(ingredient.Quantite)+" "+ingredient.Unite+" de "+ingredient.NomIngrédient};*/
        listView.setAdapter(new ArrayAdapter(this,  android.R.layout.simple_list_item_1, res.toArray(listItems)));

        Button b = (Button) findViewById(R.id.donebutton);
        ImageButton ib2=(ImageButton) findViewById(R.id.imagebutton);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour = new Intent(getApplicationContext(), Menuetage.class);
                startActivity(retour);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteManager db = new SQLiteManager(getApplicationContext());
                db.addEffectues(getIntent().getStringExtra("usermail"),nom);

                Intent retour = new Intent(getApplicationContext(), Menuetage.class);
                startActivity(retour);
            }
        });
    }
    /*
    @Override
    protected void onResume() {
        onCreate();
    }
    */
}


