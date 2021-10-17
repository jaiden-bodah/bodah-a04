/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jaiden Bodah
 */

package baseline;

/*
Pulling data from a file into a complex data structure makes parsing much simpler.
Many programming languages support the JSON format, a popular way of representing data.
Create a program that takes a product name as input and retrieves the current price and quantity for that product.
The product data is in a data file in the JSON format
and looks like this (you will create this file as `exercise44_input.json`):
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;


public class Solution44 {
    public static void main(String[] args) {
        //To read json file, first you need to add one external library
        //This is the library json-simple-1.1.1.jar
        //Create one json parser object
        JSONParser parser = new JSONParser();
        try {
            //Read json file using parser and store it in obj
            Object obj = parser.parse(new FileReader("D:/exercise44_input.json"));
            //Create json object to read internal values
            JSONObject jsonObject = (JSONObject)obj;
            //Reading products array from  the file
            JSONArray subjects = (JSONArray)jsonObject.get("products");
            //Create buffered reader object to take user input
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //Create string variable
            String input;
            //Flag is used whether given string is present or not
            int flag = 0;
            System.out.print("What is the product name? ");
            input = bufferedReader.readLine();
            //Create iterator for products array
            Iterator iterator = subjects.iterator();
            //Loop through the iterator
            while (iterator.hasNext()) {
                //Create another json
                JSONObject json = (JSONObject) iterator.next();
                //Get the name value
                String name = (String)json.get("name");
                //Compare it with given input
                if(input.toLowerCase().equals(name.toLowerCase())){
                    System.out.println("Name: "+name);
                    System.out.println("Price: "+json.get("price"));
                    System.out.println("Quantity: "+json.get("quantity"));
                    flag = 1;
                }
            }
            //If flag value is zero, then value is not found
            if(flag == 0){
                System.out.println("Sorry, that product was not found in our inventory");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}