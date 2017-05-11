package com.lsinf1225.ezmeal.ezmeal;

/**
 * Created by quentin on 09/05/2017.
 */

public class Ingredient {
    String NomIngrédient;
    String Unite;
    String Allergene;
    int Quantite;

    public Ingredient(String NomIngredient, String Unite, String Allergene, int Quantite){
        this.NomIngrédient=NomIngredient;
        this.Unite=Unite;
        this.Allergene=Allergene;
        this.Quantite=Quantite;
    }


    public Ingredient(String NomIngredient, String Unite,  int Quantite) {
        this.NomIngrédient=NomIngredient;
        this.Unite=Unite;
        this.Quantite=Quantite;
    }

}