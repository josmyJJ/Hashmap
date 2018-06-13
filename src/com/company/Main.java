package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        HashMap<Integer, String> myMap = new HashMap<Integer, String>();
        myMap.put(10, "Ten");
        myMap.put(11, "Eleven");
        myMap.put(12, "Twelve");

        int userInput;
        String anotherNumber = "yes";

        while (anotherNumber.equalsIgnoreCase("yes")){
            System.out.print("Enter a number: ");
            userInput = input.nextInt();

            if(myMap.containsKey(userInput)){
                System.out.println("You entered " + myMap.get(userInput));
                System.out.print("Would you like to enter another number? ");
                input.nextLine();
                anotherNumber = input.nextLine();
            }else{
                anotherNumber = input.nextLine();
                System.out.print("Enter a value for " +userInput + ": ");
                anotherNumber = input.nextLine();
                myMap.put(userInput, anotherNumber);
                System.out.print("Would you like to enter another number? ");
                anotherNumber = input.nextLine();
            }
        } // End while

        PrintWriter writer;
        try{
            writer = new PrintWriter("file.txt");
            for (Integer key : myMap.keySet()) {
                writer.println(((key.compareTo(9) < 1) ? ("0" + key) : (key)) + " " + myMap.get(key));
            }
            writer.close();

            File file = new File("file.txt");
            Scanner scInput = new Scanner(file);

            ArrayList<String> lists = new ArrayList<String>();
            System.out.println();

            while(scInput.hasNextLine()){
                lists.add(scInput.nextLine());
            }

            Collections.sort(lists);

            for(String list: lists){
                System.out.println(list);
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
