package com.lsinf1225.ezmeal.ezmeal;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pat on 7/05/17.
 */

public class MyListAdapterdrink extends BaseAdapter {
    private final Context context;
    private Recipe[] r;

    public MyListAdapterdrink(Context context) {

        this.context = context;
        SQLiteManager h=new SQLiteManager(context);
        r=h.getRecipeDrink();
        Log.wtf("taille",""+r.length);
    }

    @Override
    public int getCount() {
       // Log.wtf("wtf", ""+r.length);
        return r.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_drink_recette, parent, false);
        //emplacements
        TextView tv=(TextView) rowView.findViewById(R.id.title_recipe);
        TextView phrase=(TextView) rowView.findViewById(R.id.sentence_recipes);
        TextView time = (TextView) rowView.findViewById(R.id.details_recipes);
        Recipe rec= r[position];

        ImageButton ib=(ImageButton) rowView.findViewById(R.id.image_recipe);
        ib.setTag(new String[]{rec.title,rec.sentence});
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu= new Intent(context,RecipeActivity.class);
                String[] info = (String [])v.getTag();
                menu.putExtra("NomRecette",info[0]);
                menu.putExtra("Origine",info[1]);
                context.startActivity(menu);
            }
        });

        String titre=rec.title;
        tv.setText(titre);
        String tt=rec.sentence;
        phrase.setText(tt);
        String id=rec.image;
        SQLiteManager db = new SQLiteManager(context);
        time.setText("Temps total : "+db.getTimeRecipe(titre)+" minutes");
        int resId = context.getResources().getIdentifier(id, "drawable", context.getPackageName());
        //Log.wtf("erreur nom recette ?", "nom = " + id + " resource id = " + resId);
        Drawable d = context.getResources().getDrawable(resId);
        ib.setImageDrawable(d);
        //donnees recup

        //String image=r.;



        return rowView;
    }
}