package com.lsinf1225.ezmeal.ezmeal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

/**
 * Created by Lodycas on 23-04-17.
 */

public class LoginActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        Button b = (Button) findViewById(R.id.logbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usermail = ((EditText) findViewById(R.id.usermaillog)).getText().toString();
                String password = ((EditText) findViewById(R.id.passwordlog)).getText().toString();

                SQLiteManager db =new SQLiteManager(getApplicationContext());
                if(usermail == " "){return;}
                List<String> res = db.getPassword(usermail);
                db.close();

                if(res.size()==0){
                    Toast.makeText(getApplicationContext(), "No user "+usermail+" found.", 1000).show();
                    return;
                }

                if(res.get(0).equals(password))
                {
                    Intent menu= new Intent(getApplicationContext(),Menuetage.class);
                    menu.putExtra("usermail",usermail);
                    startActivity(menu);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password invalid", 1000).show();
                    return;
                }
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        ((EditText) findViewById(R.id.usermaillog)).setText(null);
        ((EditText) findViewById(R.id.passwordlog)).setText(null);
    }

    //on clique sur "new account" ==> on lance createProfileActivity
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), CreateProfileActivity.class);
        startActivity(intent);

    }


}
