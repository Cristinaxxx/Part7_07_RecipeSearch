/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crist
 */

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class RecipesList {
    
    private ArrayList<Recipe> recipesList;
    
    public RecipesList() {
        this.recipesList = new ArrayList<>();
    }
    
    
    public void add(Recipe recipe) {
        this.recipesList.add(recipe);
    }
    
    public void printListOfRecipes() {
        for(Recipe recipe : this.recipesList) {
            System.out.println(recipe);
        }
    }
    
    public void readFromFile(String filename) {
        // Added a comment
        ArrayList<ArrayList<String>> collectionOfRecipes = new ArrayList<>();
        
        try (Scanner reader = new Scanner(Paths.get((filename)))){
            while(reader.hasNextLine()) {
                ArrayList<String> singleRecipe  = new ArrayList<>();
                while(true) {
                    String line = reader.nextLine();
                    if(line.isEmpty() || !reader.hasNextLine()) {
                        collectionOfRecipes.add(singleRecipe);
                        break;
                    }
                    singleRecipe.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        for (ArrayList<String> list : collectionOfRecipes) {
            Recipe recipe = new Recipe(list.get(0), Integer.valueOf(list.get(1)));
            for (int i = 2; i < list.size(); i++) {
                recipe.addIngredient(list.get(i));
            }
            recipesList.add(recipe);
        }
    }
    
    
       public void findByName(String word) {
        System.out.println("Recipes:");
        for(Recipe recipe : this.recipesList) {
            if(recipe.getName().contains(word)) {
                System.out.println(recipe);
            }
        }
    }
    
    public void findByCookingTime(int cookingTime) {
        System.out.println("Recipes:");
        for(Recipe recipe : this.recipesList) {
            if(recipe.getCookingTime() <= cookingTime) {
                System.out.println(recipe);
            }
        }
    }
    
    public void findByIngredient(String ingredient) {
        System.out.println("Recipes:");
        for(Recipe recipe : this.recipesList) {
            if(recipe.getIngredients().contains(ingredient)) {
                System.out.println(recipe);
            }
        }
    }
    
    
}
