package com.example.myapplication.Models;

public class Recipes {

    private String RecipeName;
    private String RecipeCalorie;
    private String RecipeIngredients;
    private String RecipeMethodTitle;
    private String Recipe;
    private int Thumbnail;

    // constructor defined
    public Recipes(String name, String calorie, String recipeIngredients, String recipeMethodTitle,String recipe, int thumbnail){

        RecipeName = name;
        RecipeCalorie = calorie;
        RecipeIngredients = recipeIngredients;
        RecipeMethodTitle = recipeMethodTitle;
        Recipe = recipe;
        Thumbnail = thumbnail;

    }

    // methods
    public  String getRecipeName(){
        return RecipeName;
    }
    public String getRecipeCalorie(){return RecipeCalorie;}
    public String getRecipeIngredients(){
        return RecipeIngredients;
    }

    public String getRecipeMethodTitle(){
        return RecipeMethodTitle;
    }

    public String getRecipe(){
        return Recipe;
    }

    public int getThumbnail(){
        return Thumbnail;
    }
}
