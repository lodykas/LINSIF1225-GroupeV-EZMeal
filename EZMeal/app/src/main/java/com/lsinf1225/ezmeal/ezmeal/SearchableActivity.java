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
            String query = intent.getStringExtra(SearchManager.QUERY);

            ListView l = (ListView) findViewById(R.id.listsearch);
            SQLiteManager db = new SQLiteManager(getBaseContext());
            Cursor cu = db.research(query);
            if( cu.getCount() > 0) {
                MyCursorAdapter c = new MyCursorAdapter(getApplicationContext(), cu);

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
