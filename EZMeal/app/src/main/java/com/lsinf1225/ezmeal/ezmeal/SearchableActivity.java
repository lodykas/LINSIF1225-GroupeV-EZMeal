package com.lsinf1225.ezmeal.ezmeal;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
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
                    return LayoutInflater.from(context).inflate(R.layout.search_item, parent, false);
                }

                @Override
                public void bindView(View view, Context context, Cursor cursor) {
                    // Find fields to populate in inflated template
                    TextView recipe = (TextView) view.findViewById(R.id.searchitem_name);
                    // Extract properties from cursor
                    String name = cursor.getString(cursor.getColumnIndexOrThrow("NomRecette"));
                    // Populate fields with extracted properties
                    recipe.setText(name);
                }
            };
        }
    }
}
