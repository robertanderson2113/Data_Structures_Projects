package com.company ;

import java.io.*;
import java.util.Scanner;

import static com.company.Postfix.*;


public class Driver
{
    public static void main(String[] args) throws IOException
    {
        PrintWriter toFile1 = createTextFile("C:\\Users\\Robert Anderson\\IdeaProjects\\Project4\\src\\com\\company\\p4out.txt");

        Scanner inFile1 = new Scanner(new File("C:\\Users\\Robert Anderson\\IdeaProjects\\Project4\\src\\com\\company\\p4in.txt"));

try
        {
            char x = 'a';
            String[] equations = new String[12];
            String myInfix;
            toFile1.printf(String.format("%10s%20s%10s\n%5s%-20s%5s%5s%-20s%5s\n\n","","Symbol Table","","", "Variable","","", "Value","" ));
            for (int i = 0 ; i < 8 ; i++) {
                String y = Postfix.replaceChar(x);
                toFile1.printf(String.format("%10s%-2s%14s%10s%-2s%10s\n", "",x,"","",y,""));
                x++;
            }
            toFile1.println();

            toFile1.printf(String.format("%-35s\t %-35s\t\t %-25s\t\t %-25s\n","Input","Infix","Postfix","Result"));

            while(inFile1.hasNext())
            {
                for (int i = 0; i < 12; i++)
                {
                    equations[i] = inFile1.nextLine();
                    myInfix = equations[i];
                    myInfix = myInfix.replace('2','a');
                    myInfix = myInfix.replace('3','b');
                    myInfix = myInfix.replace('4','c');
                    myInfix = myInfix.replace('5','d');
                    myInfix = myInfix.replace('6','e');
                    myInfix = myInfix.replace('8','h');
                    myInfix = myInfix.replace('0','f');
                    myInfix = myInfix.replace('1','g');
                    toFile1.printf(String.format("%-35s\t %-35s\t\t %-25s\t\t %.2f\n", equations[i], myInfix, convertToPostfix(myInfix), evaluatePostfix(convertToPostfix(myInfix))));
                }
            }
            toFile1.close();
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        toFile1.close();
}  // end main


    public static void testPostfix(String infixExpression)
    {
        System.out.println("Infix:   " + infixExpression);
        String postfixExpression =  convertToPostfix(infixExpression);
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