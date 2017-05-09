package com.lsinf1225.ezmeal.ezmeal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class MyListAdapterhome extends BaseAdapter {
    private final Context context;
    private Recipe[] r;

    public MyListAdapterhome(Context context, String usermail) {

        this.context = context;
        SQLiteManager h=new SQLiteManager(context);
        r=h.getRecipe(6, usermail);
        if(r.length == 0){
            r = new Recipe[6];
            Recipe[] temp = h.getRecipe(2,"Catégories",new String[]{"NomRecette"},"Catégorie","beverage");
            r[0] = temp[0];
            temp = h.getRecipe(2,"Catégories",new String[]{"NomRecette"},"Catégorie","entree");
            r[1] = temp[0];
            temp = h.getRecipe(2,"Catégories",new String[]{"NomRecette"},"Catégorie","plat");
            r[2] = temp[0];
            temp = h.getRecipe(2,"Catégories",new String[]{"NomRecette"},"Catégorie","dessert");
            r[3] = temp[0];
            temp = h.getRecipe(1,"Recette",new String[]{"NomRecette"},"NomRecette","Boisson saine et sans allergènes");
            r[4] = temp[0];
            temp = h.getRecipe(1,"Recette",new String[]{"NomRecette"},"NomRecette","Granola maison");
            r[5] = temp[0];
        }
    }
    public MyListAdapterhome(Context context) {

        this.context = context;
        SQLiteManager h=new SQLiteManager(context);
        r=h.getRecipeDrink();
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
        View rowView = inflater.inflate(R.layout.list_acceuil_recette, parent, false);
        //emplacements
        ImageButton ib=(ImageButton) rowView.findViewById(R.id.image_recipe);
        TextView tv=(TextView) rowView.findViewById(R.id.title_recipe);
        TextView phrase=(TextView) rowView.findViewById(R.id.sentence_recipes);
        Recipe rec= r[position];
        String titre=rec.title;
        tv.setText(titre);
        String tt=rec.sentence;
        phrase.setText(tt);
        String id=rec.image;
        int resId = context.getResources().getIdentifier(id, "drawable", context.getPackageName());
        //Log.wtf("erreur nom recette ?", "nom = " + id + " resource id = " + resId);
        Drawable d = context.getResources().getDrawable(resId);
        ib.setImageDrawable(d);
        //donnees recup

        //String image=r.;



        return rowView;
    }
}