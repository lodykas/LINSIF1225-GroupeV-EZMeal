package com.lsinf1225.ezmeal.ezmeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lodycas on 23-04-17.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //on clique sur "new account" ==> on lance createProfileActivity
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), CreateProfileActivity.class);
        startActivity(intent);
    }
}
