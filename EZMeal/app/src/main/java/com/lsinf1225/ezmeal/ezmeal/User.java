package com.lsinf1225.ezmeal.ezmeal;

/**
 * Created by Lodycas on 21-04-17.
 */
import java.lang.String;

public class User {
    private String usermail;
    private char sex;
    private String password;
    private String birthdate;
    private String country;
    private String oriCountry;

    User(String usermail, char sex, String password, String birthdate, String country, String oriCountry){
        this.usermail = usermail;
        this.sex = sex;
        this.password = password;
        this.birthdate = birthdate;
        this.country = country;
        this.oriCountry = oriCountry;
    }

    String getUser(){return usermail;}
    char getSex(){return sex;}
    String getPassword(){return password;}
    String getBirth(){return birthdate;}
    String getCountry(){return country;}
    String getOriginCountry(){return oriCountry;}

}
