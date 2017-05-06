package com.lsinf1225.ezmeal.ezmeal;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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
            String query = intent.getStringExtra(SearchManager.QUERY);

            ListView l = (ListView) findViewById(R.id.listsearch);
            SQLiteManager db = new SQLiteManager(getApplicationContext());

            CursorAdapter c = new CursorAdapter(getApplicationContext(),db.research(query)) {
                @Override
                public View newView(Context context, Cursor cursor, ViewGroup parent) {
                    return LayoutInflater.from(context).inflate(R.layout.list_fragment_item, parent, false);
                }

                @Override
                public void bindView(View view, Context context, Cursor cursor) {
                    TextView recipe = (TextView) view.findViewById(R.id.title_recipe);
                    recipe.setText(cursor.getString(cursor.getColumnIndexOrThrow("NomRecette")));
                    ImageButton im = (ImageButton) view.findViewById(R.id.image_recipe);
                    Resources r = getResources();
                    int id = r.getIdentifier(cursor.getString(cursor.getColumnIndexOrThrow("Image")).split("\\.")[0], "drawable", getPackageName());
                    im.setImageDrawable(r.getDrawable(id));

                }
            };

            l.setAdapter(c);
        }
    }
}
