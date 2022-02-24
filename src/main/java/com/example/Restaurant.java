package com.example;

import java.util.*;

public class Restaurant {   
    //Fase 1

    int fiveEuro = 5;
    int tenEuro = 10;
    int twentyEuro = 20;
    int fiftyEuro = 50;
    int thousandEuro = 100;
    int twothousandEuro = 200;
    int fiveThousandEuro = 500;

    static HashMap<String,Integer> menuNamePrice = new HashMap<String,Integer>(); 
    static ArrayList<String> commandArrayList = new ArrayList<String>();

    /*Parameter = menu to create, asks the size of the menu, then loops
    the amount of times equals for the size, asking for name and price of
    the dishes and appends both on a HashMap. Returns menu as a HashMap. 
    */

    public static HashMap<String,Integer> menuCreator(HashMap<String,Integer> menu) {
        
        Scanner scn = new Scanner(System.in);
        Scanner scnName = new Scanner(System.in);
        Scanner scnPrice = new Scanner(System.in);

        System.out.println("How many dishes will the menu have?: ");
        int menuSize = scn.nextInt();

        for(int i = 0; i < menuSize; i++){
            
            System.out.println("Write down the name of the dish to add: ");
            String dishName = scnName.nextLine();
            
            System.out.println("Now set a price for this dish: ");
            int dishPrice = scnPrice.nextInt();

            menu.put(dishName, dishPrice);
            System.out.println("Dish added to the menu!\n");
     
        }
        return menu;  
    }
    
    //Fase 2

    /* Paramater = menu created, Prints the menu on console and then asks for the name
    of the dish, checks whether that dish exists and stores it on an ArrayList<String>.
    It keeps going until the user inputs to end the loop and prints the final price which
    is assigned in the value of the HashMap which is compared to. 
    */

    public static void orderTaker(HashMap<String,Integer> menu) {
        
        Scanner userInput = new Scanner(System.in);
        Scanner whileLoopChecker = new Scanner(System.in);
        
        int commandFinisher = 1;
        int numberOfDish = 0;
        int orderPrice = 0;

        System.out.println("Here you have the menu, please enter the name of the dishes you want to have served: \n");

        for (var entry: menu.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() +"€");
        }   
        
        while(commandFinisher == 1){
            System.out.println("Enter the name of dish number " +(numberOfDish+1)+" that you wish to order:");
            String dishName = userInput.nextLine();
            
            if(menu.containsKey(dishName)){
                commandArrayList.add(dishName);
                numberOfDish += 1;
                
                while(true){
                    try{
                        System.out.println("Do you want to continue ordering? (Yes = 1 / No = 0) ");
                        commandFinisher = whileLoopChecker.nextInt();
                        break;

                    } catch (NoSuchElementException e){
                        System.out.println("\nPlease input 1 for 'Yes' and 0 for 'No' \n");
                        whileLoopChecker.next();
                    }
                }

            }else{
                System.out.println("This dish is not in the menu.");
            }
        }
        
        for(String dishKey: commandArrayList){
            int dishPrice = menu.get(dishKey);
            orderPrice += dishPrice;
        }
        
        System.out.println("Your order has " +(numberOfDish)+ " dishes. The price for all of them is " +(orderPrice)+"€.");
    }
    public static void main( String[] args )
    {
        //menuCreator(menuNamePrice);
        //orderTaker(menuCreator(menuNamePrice));
    }
}
