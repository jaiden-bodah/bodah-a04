/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jaiden Bodah
 */

package baseline;

/*
There will be times when you'll need to read in one file, modify it,
and then write a modified version of that file to a new file.
Given an input file named `exercise45_input.txt`, read the file and look for all occurrences of the word utilize.
Replace each occurrence with use. Write the modified file to a new file.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution45 {

    // main method that throws IOException

    public static void main(String[] args) throws IOException {

        // create a object of Scanner class

        Scanner s = new Scanner(System.in);

        // prompt the name of output file from user

        System.out.print("\nEnter the output file : ");

        String outputfile = s.next();

        // create a object of ReadFile class

        ReadFile rf = new ReadFile();

        // read file

        rf.readfile();

        // get the list contains data of file

        ArrayList<String> list = rf.getdata();

        // create a object of WriteFile
//       and passing output file name and list contains data

        WriteFile wr = new WriteFile(outputfile, list);

        // write file

        wr.writefile();

        // and print the Number of Modifications on console

        System.out.println("\nThe Number of Modifications are : "+wr.getModification());


    }

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////


// class named ReadFile

class ReadFile{

    // instance variable

    private ArrayList<String> list;
    private Scanner sc;

    // constructor

    public ReadFile() throws FileNotFoundException {

        list = new ArrayList<String>();

        // initialize instance variable

        // pass the path to the file as a parameter
        File file = new File("C:\\Users\\jaide\\Desktop\\exercise45_input.txt");
        sc = new Scanner(file);

    }

    public void readfile() {

        // use try and finally to avoid exceptions

        try
        {
            int i=0;

            while( sc.hasNext() )
            {

                // read file line by line and store it into list

                String filedata = sc.nextLine();

                list.add(filedata);


            }
        }
        finally
        {
            sc.close();
        }

    }

    //return the list

    public ArrayList<String> getdata() {

        return list;

    }

}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////

// class for Write into File

class WriteFile{

    // instance variable

    private FileWriter writer;
    private int count_Modification;
    private ArrayList<String> list;

    // constructor

    public WriteFile(String name, ArrayList<String> list) throws IOException {

        // initialize variables

        writer = new FileWriter("C:\\Users\\jaide\\Desktop\\"+name);
        this.list = list;


    }

    // write into file

    public void writefile() throws IOException {

        // using for loop till size of list

        for(int i=0;i<list.size();i++) {

            String temp = list.get(i);

            String str = "utilize";

            int index = 0;

            // count the modifications

            while (true)
            {
                index = temp.indexOf(str, index);
                if (index != -1)
                {
                    count_Modification ++;
                    index += str.length();
                }
                else {
                    break;
                }
            }

            // modification

            temp = temp.replaceAll("utilize", "use");

            // and write into file

            writer.write(temp+"\n");


        }

        // close the writer object

        writer.close();

    }


    // method that returns the count of modifications

    public int getModification() {

        return count_Modification;

    }


}
