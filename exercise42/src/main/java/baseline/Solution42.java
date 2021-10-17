/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jaiden Bodah
 */

package baseline;

/*
Sometimes data comes in as a structured format that you have to break down and turn into records
so you can process them.
CSV, or comma-separated values, is a common standard for doing this.
Construct a program that reads in the following data file
(you will need to create this data file yourself; name it `exercise42_input.txt`):
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution42 {

    // Method to print the details in tabular format.
    // It takes the name of the filename as its parameter
    public void printDetails(String filename) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] temp = s.split(",");
                System.out.printf("%-17s%-17s%-17s\n", temp[0], temp[1], temp[2]);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found!!");
        }
    }

    // Driver method to test the code
    public static void main(String[] args) {

        Solution42 emp = new Solution42();
        System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary");
        System.out.println("----------------------------------------");
        emp.printDetails("exercise42_input.txt");
    }
}
