package com.lsinf1225.ezmeal.ezmeal;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lodycas on 04-05-17.
 */

public class SearchableActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY).toLowerCase();

            ListView l = (ListView) findViewById(R.id.listsearch);
            SQLiteManager db = new SQLiteManager(getApplicationContext());
            if (db.research(query).getCount() > 0 && db.research(query) != null) {
                CursorAdapter c = new CursorAdapter(getApplicationContext(), db.research(query)) {
                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        return LayoutInflater.from(context).inflate(R.layout.list_acceuil_recette, parent, false);
                    }

                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        TextView recipe = (TextView) view.findViewById(R.id.title_recipe);
                        recipe.setText(cursor.getString(cursor.getColumnIndexOrThrow("NomRecette")));
                        ImageButton im = (ImageButton) view.findViewById(R.id.image_recipe);
                        Resources r = getResources();
                        int id = r.getIdentifier(cursor.getString(cursor.getColumnIndex("Image")).split("\\.")[0], "drawable", getPackageName());
                        im.setImageDrawable(r.getDrawable(id));

                        SQLiteManager db = new SQLiteManager(getApplicationContext());

                    /*((TextView) view.findViewById(R.id.sentence_recipes)).setText(cursor.getString(cursor.getColumnIndex("Origine")));
                    Cursor c = db.getRecipeInfo(cursor.getString(cursor.getColumnIndexOrThrow("NomRecette")));
                    ((TextView) view.findViewById(R.id.details_recipes)).setText(c.getString(c.getColumnIndex("Difficulté")));*/


                    }
                };

                l.setAdapter(c);
            }
            else{
                Toast.makeText(getApplicationContext(), "Recipe not found", 3000).show();
                Intent menu= new Intent(getApplicationContext(),Menuetage.class);
                startActivity(menu);
            }
        }
    }
}
