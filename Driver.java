package com.company ;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 A driver that demonstrates the class Postfix.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 4.1
 */
public class Driver
{
    public static void main(String[] args) throws IOException
    {
        PrintWriter toFile1 = createTextFile("C:\\Users\\Robert Anderson\\IdeaProjects\\Project4\\src\\com\\company\\p4out.txt");
        Scanner inFile1 = new Scanner(new File("C:\\Users\\Robert Anderson\\IdeaProjects\\Project4\\src\\com\\company\\p4in.txt")).useDelimiter("\t");

        String[] strings = new String[12];
        ArrayList<String> testStrings = new ArrayList<>();

        while (inFile1.hasNextLine()) {
            for (int i = 0; i < strings.length; i++) {
                String[] line = inFile1.nextLine().split("\\ ");
                strings[i] = line[0] + line[1] + line[2];
                testStrings.add(strings[i]);

            }
        }
        // System.out.println("Test of Input File 1");
        System.out.println(testStrings.toString() +"\n");

        System.out.println("Testing postfix expressions with\n" +
               "a = 2, b = 3, c = 4, d = 5, e = 6\n\n");

        testPostfix("a+b");
        testPostfix("(a + b) * c");
        testPostfix("a * b / (c - d)");
        testPostfix("a / b + (c - d)");
        testPostfix("a / b + c - d");
        testPostfix("a^b^c");
        testPostfix("(a^b)^c");
        testPostfix("a*(b/c+d)");

        System.out.println("Testing Question 6, Chapter 5:\n");
    testPostfix("(a+b)/(c-d)");         // Question 6a, Chapter 5
    testPostfix("a/(b-c)*d");           // Question 6b
    testPostfix("a-(b/(c-d)*e+f)^g");   // Question 6c
    testPostfix("(a-b*c)/(d*e^f*g+h)"); // Question 6d

        System.out.println("Testing Question 7, Chapter 5:\n");
        System.out.println("TEST: ab+ : " + Postfix.evaluatePostfix("ab+")+"\n");
        System.out.println("TEST: ab+c* : " + Postfix.evaluatePostfix("ab+c*")+"\n");
        System.out.println("Q7a: ae+bd-/ : "   + Postfix.evaluatePostfix("ae+bd-/") + "\n");
        System.out.println("Q7b: abc*d*- : "   + Postfix.evaluatePostfix("abc*d*-") + "\n");
        System.out.println("Q7c: abc-/d* : "   + Postfix.evaluatePostfix("abc-/d*") + "\n");
        System.out.println("Q7d: ebca^*+d- : " + Postfix.evaluatePostfix("ebca^*+d-") + "\n");
        System.out.println("\n\nDone.");
}  // end main

    public static void testPostfix(String infixExpression)
    {
        System.out.println("Infix:   " + infixExpression);
        String postfixExpression =  Postfix.convertToPostfix(infixExpression);
        System.out.println("Postfix: " + postfixExpression);
        System.out.println("\n");
    } // end testPostfix

    private static PrintWriter createTextFile(String fileName) {
        boolean fileOpened = true;
        PrintWriter toFile = null;
        try {
            toFile = new PrintWriter(fileName);
            System.out.println("File " + fileName + " created successfully");
        } catch (FileNotFoundException e) {
            fileOpened = false;
            System.out.println("File not created");
        }


        if (fileOpened) {
            Scanner inFile = new Scanner(fileName);
            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
            }

        }//end createTextFile
        return toFile;

    }

}  // end Driver

/*
 Testing postfix expressions with
 a = 2, b = 3, c = 4, d = 5, e = 6
 
 
 Infix:   a+b
 Postfix: ab+
 
 
 Infix:   (a + b) * c
 Postfix: ab+c*
 
 
 Infix:   a * b / (c - d)
 Postfix: ab*cd-/
 
 
 Infix:   a / b + (c - d)
 Postfix: ab/cd-+
 
 
 Infix:   a / b + c - d
 Postfix: ab/c+d-
 
 
 Infix:   a^b^c
 Postfix: abc^^
 
 
 Infix:   (a^b)^c
 Postfix: ab^c^
 
 
 Infix:   a*(b/c+d)
 Postfix: abc/d+*
 
 
 Testing Question 6, Chapter 5:
 
 Infix:   (a+b)/(c-d)
 Postfix: ab+cd-/
 
 
 Infix:   a/(b-c)*d
 Postfix: abc-/d*
 
 
 Infix:   a-(b/(c-d)*e+f)^g
 Postfix: abcd-/e*f+g^-
 
 
 Infix:   (a-b*c)/(d*e^f*g+h)
 Postfix: abc*-def^*g*h+/
 
 
 Testing Question 7, Chapter 5:
 
 Q7a: ae+bd-/ : -4.0
 
 Q7b: abc*d*- : -58.0
 
 Q7c: abc-/d* : -10.0
 
 Q7d: ebca^*+d- : 49.0
 
 
 
 Done.
 */