package com.lsinf1225.ezmeal.ezmeal;

import com.lsinf1225.ezmeal.ezmeal.SQLiteManager;

import java.sql.Blob;
import java.sql.Date;

/**
 * Created by pat on 5/05/17.
 */

public class Recipe {
    String title;
    String image;
    String portion;
    String date;
    String sentence;
    public Recipe(String title, String image, String portion, String date, String sentence){
        this.title=title;
        this.image=image;
        this.portion=portion;
        this.date=date;
        this.sentence=sentence;

    }


}

