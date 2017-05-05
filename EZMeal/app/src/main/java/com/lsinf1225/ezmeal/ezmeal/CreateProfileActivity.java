package com.lsinf1225.ezmeal.ezmeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.attr.id;


/**
 * Created by Lodycas on 21-04-17.
 */

public class CreateProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);

        Button b = (Button) findViewById(R.id.button101);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //I get all the data the user entered
                String usermail = ((EditText) findViewById(R.id.usermailedit)).getText().toString();
                String password = ((EditText) findViewById(R.id.passwordedit)).getText().toString();
                String password2 = ((EditText) findViewById(R.id.passwordedit2)).getText().toString();
                RadioGroup sex = (RadioGroup) findViewById(R.id.sexSelect);
                RadioButton sexB = (RadioButton) findViewById(sex.getCheckedRadioButtonId());
                String birth = ((EditText) findViewById(R.id.birthedit)).getText().toString();
                String country = ((EditText) findViewById(R.id.countryedit)).getText().toString();
                String oriCountry = ((EditText) findViewById(R.id.origincountryedit)).getText().toString();

                if (usermail == " " || password == " " || password2 == " " || birth == " " || country == " " || oriCountry == " " || sexB == null){
                    Toast.makeText(getApplicationContext(), "All fields are mandatory!", 3000).show();
                } else if (!(password.equals(password2))) {
                    Toast.makeText(getApplicationContext(), "Password not match !", 3000).show();
                }
                else {//if everything's complete, I create the object and update the database
                    User user = new User(usermail, sexB.getText().charAt(0), password, birth, country, oriCountry);
                    SQLiteManager db = new SQLiteManager(getApplicationContext());
                    db.addUser(user);
                    CheckBox c = (CheckBox) findViewById(R.id.banana);
                    if(c.isChecked()){
                        db.addAllergen(usermail, c.getText().toString());
                    }
                    c = (CheckBox) findViewById(R.id.eggs);
                    if(c.isChecked()){
                        db.addAllergen(usermail, c.getText().toString());
                    }
                    c = (CheckBox) findViewById(R.id.gluten);
                    if(c.isChecked()){
                        db.addAllergen(usermail, c.getText().toString());
                    }
                    c = (CheckBox) findViewById(R.id.lactose);
                    if(c.isChecked()){
                        db.addAllergen(usermail, c.getText().toString());
                    }
                    c = (CheckBox) findViewById(R.id.peanuts);
                    if(c.isChecked()){
                        db.addAllergen(usermail, c.getText().toString());
                    }

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.createsuccess,usermail), 3000).show();
                    Intent retour = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(retour);
                }
            }
        });
    }


}
