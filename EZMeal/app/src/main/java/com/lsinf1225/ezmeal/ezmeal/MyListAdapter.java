package com.lsinf1225.ezmeal.ezmeal;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Blob;

public class MyListAdapter extends BaseAdapter {
    private final Context context;
    private Recipe[] r;

    public MyListAdapter(Context context) {

        this.context = context;
        SQLiteManager h=new SQLiteManager(context);
        r=h.getRecipe(10);
    }

    @Override
    public int getCount() {
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
        View rowView = inflater.inflate(R.layout.list_fragment_item, parent, false);
        ImageButton ib=(ImageButton) convertView.findViewById(R.id.image_recipe);
        //ib.setImageDrawable();
        TextView tv=(TextView) convertView.findViewById(R.id.details_recipes);
        TextView phrase=(TextView) convertView.findViewById(R.id.sentence_recipes);



        return rowView;
    }
}