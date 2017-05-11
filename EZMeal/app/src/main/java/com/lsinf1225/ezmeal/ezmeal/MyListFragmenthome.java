package com.lsinf1225.ezmeal.ezmeal;
import android.content.Intent;
import android.support.v4.app.ListFragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by pat on 4/05/17.
 */


public class MyListFragmenthome extends ListFragment implements OnItemClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_acceuil, container, false);
        ImageButton ib = (ImageButton) view.findViewById(R.id.image_recipe);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Intent retour = new Intent(getActivity().getApplicationContext(), RecipeActivity.class);
              //  startActivity(retour);
                Toast.makeText(getActivity().getApplicationContext(),"WTF?" , 3000).show();
            }
        });
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getContext(),RecipeActivity.class);
        String usermail = intent.getStringExtra("usermail");
        intent.putExtra("usermail",usermail);
        Toast.makeText(getContext()," "+usermail+" " , 1000).show();
        startActivity(intent);

    }
}