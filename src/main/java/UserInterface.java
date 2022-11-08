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
import java.util.Scanner;


public class UserInterface {
    
    private Scanner scanner;
    
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void start() {
        
        System.out.println("File to read:");
        String fileName = scanner.nextLine();
        
        RecipeSearch recipeSearch = new RecipeSearch();   
        RecipesList recipesList = new RecipesList();
        
        recipesList.readFromFile(fileName);
        
        printCommands();
        
         while(true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();
            if(command.equals("stop")) {
                break;
                
            } else if(command.equals("list")) {
                recipesList.printListOfRecipes();    
                
            } else if(command.equals("find name")) {
                System.out.println("Searched word:");
                String word = scanner.nextLine(); 
                recipesList.findByName(word);
                
            } else if(command.equals("find cooking time")) {
                System.out.println("Max cooking time:");
                int cookingTime = Integer.valueOf(scanner.nextLine());
                recipesList.findByCookingTime(cookingTime);
                
            } else if(command.equals("find ingredient")) {
                System.out.println("Ingredient:");
                String ingredient = scanner.nextLine();
                recipesList.findByIngredient(ingredient);
            }          
        }

        
    }
    
    public void printCommands() {
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
    }
    
}
