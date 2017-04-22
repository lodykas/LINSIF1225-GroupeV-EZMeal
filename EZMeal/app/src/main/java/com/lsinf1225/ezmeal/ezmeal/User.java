package com.lsinf1225.ezmeal.ezmeal;

/**
 * Created by Lodycas on 21-04-17.
 */
import java.lang.String;

public class User {
    private String usermail;
    private char sex;
    private String password;
    private String date;
    private String country;

    User(String usermail, char sex, String password, String date, String country){
        this.usermail = usermail;
        this.sex = sex;
        this.password = password;
        this.date = date;
        this.country = country;
    }

    String getUser(){return usermail;}
    char getSex(){return sex;}
    String getPassword(){return password;}
    String getDate(){return date;}
    String getCountry(){return country;}

}
