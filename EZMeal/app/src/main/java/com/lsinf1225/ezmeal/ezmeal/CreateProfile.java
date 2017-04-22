package com.lsinf1225.ezmeal.ezmeal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Lodycas on 21-04-17.
 */

public class CreateProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);

        Button b = (Button) findViewById(R.id.button101);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usermail = (EditText) findViewById(R.id.usermailedit);
                EditText password = (EditText) findViewById(R.id.passwordedit);
                RadioGroup sex = (RadioGroup) findViewById(R.id.sexSelect);
                RadioButton sexB = (RadioButton) findViewById(sex.getCheckedRadioButtonId());
                EditText birth = (EditText) findViewById(R.id.birthedit);
                EditText country = (EditText) findViewById(R.id.countryedit);

                User user = new User(usermail.getText().toString(), sexB.getText().charAt(0), password.getText().toString(),birth.getText().toString(),country.getText().toString());
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.Toast1, user.getUser(),user.getSex()), 3000).show();
            }
        });
    }
}
