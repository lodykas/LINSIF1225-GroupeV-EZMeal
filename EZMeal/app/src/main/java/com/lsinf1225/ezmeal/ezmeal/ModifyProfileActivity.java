package com.lsinf1225.ezmeal.ezmeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ModifyProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_profile);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button b = (Button) findViewById(R.id.button201);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = ((EditText) findViewById(R.id.passwordedit2)).getText().toString();
                String password2 = ((EditText) findViewById(R.id.passwordedit)).getText().toString();
                Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
                String country = spinner1.getSelectedItem().toString();
                //String country = ((EditText) findViewById(R.id.countryedit2)).getText().toString();
                if (password.equals(password2)) {
                    SQLiteManager db = new SQLiteManager(getApplicationContext());
                    db.updateUser(getIntent().getStringExtra("usermail"), password, country);
                    Toast.makeText(getApplicationContext(), " Data updated " + getIntent().getStringExtra("usermail"), Toast.LENGTH_LONG).show();
                    Intent retour = new Intent(getApplicationContext(), Menuetage.class);
                    retour.putExtra("usermail",getIntent().getStringExtra("usermail"));
                    startActivity(retour);
                } else {
                    Toast.makeText(getApplicationContext(), "Password not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
