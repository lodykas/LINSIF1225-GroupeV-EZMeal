package com.lsinf1225.ezmeal.ezmeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_profile);

        Button b = (Button) findViewById(R.id.button201);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = ((EditText) findViewById(R.id.passwordedit2)).getText().toString();
                String country = ((EditText) findViewById(R.id.countryedit2)).getText().toString();
                SQLiteManager db = new SQLiteManager(getApplicationContext());
                db.updateUser(getIntent().getStringExtra("usermail"),password,country);
                Toast.makeText(getApplicationContext()," Data updated "+getIntent().getStringExtra("usermail"), 1000).show();
            }
        });
    }
}
