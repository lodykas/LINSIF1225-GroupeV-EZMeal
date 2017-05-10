package com.lsinf1225.ezmeal.ezmeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ModifyProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_profile);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        SQLiteManager db = new SQLiteManager(getApplicationContext());

        String usermail = getIntent().getStringExtra("usermail");
        TextView usermailShow = (TextView)findViewById(R.id.usermailshow);
        usermailShow.setText(usermail.toString());
        TextView originShow = (TextView)findViewById(R.id.countryoriginshow);
        List<String> origins = db.getOrigin(usermail);
        String origin = origins.get(0).toString();
        originShow.setText(origin);
        TextView birthShow = (TextView)findViewById(R.id.birthdayshow);
        List<String> birthdates = db.getBirthdate(usermail);
        String birthdate = birthdates.get(0).toString();
        birthShow.setText(birthdate);
        TextView allergenesShow = (TextView)findViewById(R.id.allergenesshow);
        List<String> allergene = db.getAllergene(usermail);
        if (allergene.size()==0) {
            allergenesShow.setText("none");
        } else {
            String allergenes = "";
            for (int i = 0; i < allergene.size(); i++) {
                allergenes += allergene.get(i).toString() + " ";
            }
            allergenesShow.setText(allergenes);
        }
        Button b = (Button) findViewById(R.id.button201);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = ((EditText) findViewById(R.id.passwordedit2)).getText().toString();
                String password2 = ((EditText) findViewById(R.id.passwordedit)).getText().toString();
                Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
                String country = spinner1.getSelectedItem().toString();
                //String country = ((EditText) findViewById(R.id.countryedit2)).getText().toString();
                if (password.equals("") || password2.equals("")) {
                    Toast.makeText(getApplicationContext(), "All fields are mandatory", Toast.LENGTH_LONG).show();
                }else if (password.equals(password2)) {
                    SQLiteManager db2 = new SQLiteManager(getApplicationContext());
                    db2.updateUser(getIntent().getStringExtra("usermail"), password, country);
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
