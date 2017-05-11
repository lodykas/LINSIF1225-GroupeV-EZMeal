package com.lsinf1225.ezmeal.ezmeal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Lodycas on 11-05-17.
 */

public class MyCursorAdapter extends CursorAdapter {
    private final Context mycontext;
    private LayoutInflater cursorInflater;

    public MyCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        this.mycontext = context;
        cursorInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        TextView recipe = (TextView) view.findViewById(R.id.title_recipe);

        TextView time = (TextView) view.findViewById(R.id.details_recipes);
        TextView sentence = (TextView) view.findViewById(R.id.sentence_recipes);
        String recipename = cursor.getString(cursor.getColumnIndexOrThrow("NomRecette"));
        recipe.setText(recipename);
        String origin = cursor.getString(cursor.getColumnIndexOrThrow("Origine"));
        sentence.setText(origin);
        ImageButton im = (ImageButton) view.findViewById(R.id.image_recipe);
        SQLiteManager db = new SQLiteManager(context);
        time.setText("Temps total : " + db.getTimeRecipe(cursor.getString(cursor.getColumnIndexOrThrow("NomRecette"))) + " minutes");

        Resources r = context.getResources();
        int id = r.getIdentifier(cursor.getString(cursor.getColumnIndex("Image")).split("\\.")[0], "drawable", context.getPackageName());
        im.setImageDrawable(r.getDrawable(id));

        im.setTag(new String[]{recipename, origin});
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(mycontext.getApplicationContext(), RecipeActivity.class);
                menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                String[] info = (String[]) v.getTag();
                menu.putExtra("NomRecette", info[0]);
                menu.putExtra("Origine", info[1]);
                mycontext.getApplicationContext().startActivity(menu);


            }
        });
        //((TextView) view.findViewById(R.id.sentence_recipes)).setText(cursor.getString(cursor.getColumnIndex("Origine")));
        //Cursor c = db.getRecipeInfo(cursor.getString(cursor.getColumnIndexOrThrow("NomRecette")));
        //String s = c.getString(0);
        //((TextView) view.findViewById(R.id.details_recipes)).setText(s);//c.getColumnIndex("NbrePersonnes")
        //c.close();
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_acceuil_recette, parent, false);
    }
}
