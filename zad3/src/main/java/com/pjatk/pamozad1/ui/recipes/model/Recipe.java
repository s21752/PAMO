package com.pjatk.pamozad1.ui.recipes.model;

public class Recipe {

    String title, ingredients, details;

    public Recipe() {
    }

    public Recipe(String title, String ingredients, String details) {
        this.title = title;
        this.ingredients = ingredients;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
