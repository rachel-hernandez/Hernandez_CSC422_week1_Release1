/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hernandez.csc422week1;

//importing needed utilitis 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Rachel
 */
public class petDatabase {
    
    //creating 2D arrayList
    static ArrayList<ArrayList<String>> pets = new ArrayList<ArrayList<String>>();
    
    //int to store the users choice
    static int choice;
    
    //int to count the number of rows in the 2D arrayList
    static int row;
    
    //declaring a scanner
    static Scanner s = new Scanner (System.in);


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Pet Database Program.");
        
        //options menu
        //loop will break when user enters 3
        while(true && choice !=3){
            System.out.println("What would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add more pets");
            System.out.println("3) Exit program");
            System.out.println("Your choice: ");
            choice = s.nextInt();            
                
            //Switch statment to determine action based on users choice 
            switch(choice){
                //if user chooses 1 all pets will be displayed 
                case 1 -> {
                    //calling method to display all the pets 
                    viewPets();
                }

                //if user chooses 2 the user can add more pets
                case 2 -> {
                    //calling method to add more pets 
                    addPets();
                }

                //ending the program 
                case 3 -> exitProgram();
                    
                default -> exitProgram();
            }
        }
        
    }
    
    //method to display all the pets
    static boolean viewPets(){
        System.out.println(" ");
        System.out.printf("\n+-------------------+");
        System.out.printf("\n| %-3s| %-8s| %-3s|%n", "ID", "Name", "Age");
        System.out.printf("+-------------------+");
        int count = 0;
        int petCount = pets.size();
        //for loop to loop throudh all the rows of the 2D arrayList
        for (int i = 0; i < petCount; i++) {            
            Integer petID = i;
            String name = pets.get(i).get(0);
            String age = pets.get(i).get(1);
            //displaying the values in the arrayList
            System.out.printf("\n| %-3d| %-8s| %-3s|%n", petID, name, age);
            count++;
        }
        System.out.println("+-------------------+");
        System.out.println(count + " rows in set.");
        return true;
    }
    
    //method to add more pets
    static boolean addPets(){
        //value to keep the while loop going
        int keepLooping = 0;  
        
        //while loop to add pet info 
        while(keepLooping !=1){            
            System.out.println("add pet (name, age) or done to stop: ");
            String petName = s.next();            
            
            //loop will end when user enters "done"
            if(petName.equalsIgnoreCase("done")){
                keepLooping = 1;
                //break;
            }else{
                //adding pet into to the 2D arrayList
                String petAge = s.next();
                pets.add(row,new ArrayList<>(Arrays.asList(petName, petAge)));
                row++;
            }           
            
        }
        
        return true;
        
    }
    
   
    //method to end the program
    static boolean exitProgram(){
        System.out.println("Goodbye!");
        return false;       
    }
    
    
}
