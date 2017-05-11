/**
 * Created by pat on 5/05/17.
 */


package com.lsinf1225.ezmeal.ezmeal;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebStorage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class RecipeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final String NomRecette = getIntent().getStringExtra("NomRecette");
        TextView textView=(TextView) findViewById(R.id.title_recipe);
        textView.setText(NomRecette);

        String Origin=getIntent().getStringExtra("Origine");
        TextView textView2=(TextView) findViewById(R.id.origin);
        textView2.setText(Origin);

        //ImageView imgView=(ImageView) findViewById(R.id.image);

        Button b = (Button) findViewById(R.id.donebutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteManager db = new SQLiteManager(getApplicationContext());
              //  db.addEffectues(getIntent().getStringExtra("usermail"),NomRecette);
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