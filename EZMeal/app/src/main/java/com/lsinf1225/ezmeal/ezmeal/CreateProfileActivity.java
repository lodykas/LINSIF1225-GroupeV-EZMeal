package com.lsinf1225.ezmeal.ezmeal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * Created by Lodycas on 21-04-17.
 */

public class CreateProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);

        Spinner spinner = (Spinner) findViewById(R.id.allergenslist);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.allergens, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button b = (Button) findViewById(R.id.button101);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //I get all the data the user entered
                String usermail = ((EditText) findViewById(R.id.usermailedit)).getText().toString();
                String password = ((EditText) findViewById(R.id.passwordedit)).getText().toString();
                RadioGroup sex = (RadioGroup) findViewById(R.id.sexSelect);
                RadioButton sexB = (RadioButton) findViewById(sex.getCheckedRadioButtonId());
                String birth = ((EditText) findViewById(R.id.birthedit)).getText().toString();
                String country = ((EditText) findViewById(R.id.countryedit)).getText().toString();
                String oriCountry = ((EditText) findViewById(R.id.origincountryedit)).getText().toString();

                if (usermail == " " || password == " " || birth == " " || country == " " || oriCountry == " " || sexB == null){
                    Toast.makeText(getApplicationContext(), "All fields are mandatory!", 3000).show();
                }
                else {//if everything's complete, I create the object and update the database
                    User user = new User(usermail, sexB.getText().charAt(0), password, birth, country, oriCountry);
                    SQLiteManager db = new SQLiteManager(getApplicationContext());
                    db.addUser(user);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.createsuccess,usermail), 3000).show();

                }
            }
        });
    }
}
