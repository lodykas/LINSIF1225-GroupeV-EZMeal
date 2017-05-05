package com.lsinf1225.ezmeal.ezmeal;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
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

    public MyListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
   // @Override
   // public void bindView(View view, Context context, Cursor cursor) {
        //Find fields to populate in inflated template
       //ImageButton im = (ImageButton) view.findViewById(R.id.image_recipe);
       // TextView title = (TextView) view.findViewById(R.id.title_recipe);
       // TextView ins = (TextView) view.findViewById(R.id.title_instruction);
        // Extract properties from cursor
      // Blob body = cursor.getBlob(cursor.getColumnIndexOrThrow("Recette"));
       // String titre = cursor.getString(cursor.getColumnIndexOrThrow("Recette"));
         //Populate fields with extracted properties
        //im.setBlob(body);
       // title.setText(String.valueOf(titre));
  // }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_fragment_item, parent, false);
        SQLiteManager db= new SQLiteManager(context);


       // SQLiteManager db =new SQLiteManager;

//        TextView textView = (TextView) rowView.findViewById(R.id.label);
//        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
//        textView.setText(values[position]);
//        // change the icon for Windows and iPhone
//        String s = values[position];
//        if (s.startsWith("iPhone")) {
//            imageView.setImageResource(R.drawable.no);
//        } else {
//            imageView.setImageResource(R.drawable.ok);
//        }

        return rowView;
    }
}