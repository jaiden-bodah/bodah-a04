/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jaiden Bodah
 */

package baseline;

/*
Programming languages can create files and folders too.

Create a program that generates a website skeleton with the following specifications:

Prompt for the name of the site.
Prompt for the author of the site.
Ask if the user wants a folder for JavaScript files.
Ask if the user wants a folder for CSS files.
Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution43 {

    public static void main(String[] args)
    {
        Scanner SC = new Scanner(System.in);
        String currentPath, author, siteName;
        char js = 'N';
        char css = 'N';
        System.out.print("Site name: ");
        siteName = SC.nextLine();
        System.out.print("Author: ");
        author = SC.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        js = SC.next().charAt(0);
        System.out.print("Do you want a folder for CSS? ");
        css = SC.next().charAt(0);
        currentPath = System.getProperty("user.dir");
        currentPath += "\\"+siteName;
        File website = new File(currentPath);
        boolean websiteCreated = website.mkdir();
        if(websiteCreated)
        {
            System.out.println("Created " + currentPath);
            try
            {
                FileWriter skeletonWriter = new FileWriter(new File(currentPath+"\\index.html"));
                skeletonWriter.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                skeletonWriter.write("\t<meta author=\""+author+"\">\n");
                skeletonWriter.write("\t<title>"+siteName+"</title>\n");
                skeletonWriter.write("</head>\n<body>\n\n</body>\n</html>");
                skeletonWriter.close();
                System.out.println("Created " + currentPath+"\\index.html");
                if(js == 'y' || js == 'Y')
                {
                    File jsFolder = new File(currentPath+"\\js");
                    boolean jsCreated = jsFolder.mkdir();
                    if(jsCreated)
                    {
                        System.out.println("Created " + jsFolder+"\\");
                    }
                    else
                    {
                        System.out.println("Js folder not created!!");
                    }
                }
                if(css == 'y' || css == 'Y')
                {
                    File cssFolder = new File(currentPath+"\\css");
                    boolean cssCreated = cssFolder.mkdir();
                    if(cssCreated)
                    {
                        System.out.println("Created " + cssFolder+"\\");
                    }
                    else
                    {
                        System.out.println("CSS folder not created!!");
                    }
                }
            }
            catch(IOException e)
            {
                System.out.println("index.html not created as required!!");
            }
        }
        else
        {
            System.out.println("Website folder not created!!");
        }
        SC.close();
    }
}
