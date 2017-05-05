package com.lsinf1225.ezmeal.ezmeal;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;

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

            CursorAdapter c = new CursorAdapter() {
                @Override
                public View newView(Context context, Cursor cursor, ViewGroup parent) {
                    return null;
                }

                @Override
                public void bindView(View view, Context context, Cursor cursor) {
                    super.bindView(view,context,cursor);
                }
            };

            ListView l = findViewById(R.id.listsearch);
            SQLiteManager db = new SQLiteManager(getApplicationContext());
            c.bindView(l,getApplicationContext(),db.research(query));
        }
    }
}
