package com.lsinf1225.ezmeal.ezmeal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Menuetage extends AppCompatActivity

        //Note : OnFragmentInteractionListener of all the fragments
        implements
        Fragment1.OnFragmentInteractionListener,
        Fragment2.OnFragmentInteractionListener,
        Fragment3.OnFragmentInteractionListener,
        Fragment4.OnFragmentInteractionListener,
        PlusFrag2.OnFragmentInteractionListener,

        NavigationView.OnNavigationItemSelectedListener {
         public static  boolean doubletap=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuetage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSearchRequested();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //NOTE:  Checks first item in the navigation drawer initially
        navigationView.setCheckedItem(R.id.nav_frag1);

        //NOTE:  Open fragment1 initially.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        String myMessage = getIntent().getStringExtra("usermail");
        Bundle bundle = new Bundle();
        bundle.putString("usermail", myMessage );
        Fragment f = new Fragment1();
        f.setArguments(bundle);
        ft.replace(R.id.mainFrame, f);
        ft.commit();
    }

   // @Override
   // public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //if (drawer.isDrawerOpen(GravityCompat.START)) {
           // drawer.closeDrawer(GravityCompat.START);
       // } else {
            //super.onBackPressed();
     //   }
   // }
   boolean doubleBackToExitPressedOnce = false;
   @Override
   public void onBackPressed() {

           if (doubleBackToExitPressedOnce) {
               super.onBackPressed();
               return;
           }
       if(doubletap){
           this.doubleBackToExitPressedOnce = true;
           Toast.makeText(this, R.string.signout, Toast.LENGTH_SHORT).show();

           new Handler().postDelayed(new Runnable() {

               @Override
               public void run() {
                   doubleBackToExitPressedOnce = false;}}, 2000);

       }
       else{
           super.onBackPressed();
           doubletap=true;
       }
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuetage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.modifyprofil) {
            Intent modify = new Intent(getApplicationContext(),ModifyProfileActivity.class);
            modify.putExtra("usermail",getIntent().getStringExtra("usermail"));
            startActivity(modify);
        }

        return super.onOptionsItemSelected(item);
    }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            int id = item.getItemId();

            //NOTE: creating fragment object

            Fragment fragment = null;

            if (id == R.id.nav_frag1) {
                Bundle bundle = new Bundle();
                String myMessage = getIntent().getStringExtra("usermail");
                bundle.putString("usermail", myMessage );
                fragment = new Fragment1();
                fragment.setArguments(bundle);
            } else if (id == R.id.nav_frag2) {
                fragment = new Fragment2();
            } else if (id == R.id.nav_frag3) {
                Bundle bundle = new Bundle();
                String myMessage = getIntent().getStringExtra("usermail");
                bundle.putString("usermail", myMessage );
                fragment = new Fragment3();
                fragment.setArguments(bundle);
            }else if (id == R.id.nav_frag4) {
                fragment = new Fragment4();
            }


            //NOTE: Fragment changing code
            if (fragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainFrame, fragment);
                ft.commit();
            }

            //NOTE:  Closing the drawer after selecting
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout); //Ya you can also globalize this variable :P
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }




    @Override
    public void onFragmentInteraction(String title) {
        // NOTE:  Code to replace the toolbar title based current visible fragment
        getSupportActionBar().setTitle(title);
    }


}
