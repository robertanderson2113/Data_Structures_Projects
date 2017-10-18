package com.company;

import static com.company.ComputeFactorial.nFactorial;
import static com.company.ComputeFibonacci.fibonacci;
import static com.company.ComputeFibonacci.nFibonacci;
import static com.company.RecursivePalindrome.*;


public class p5Recursion {

    public static void main(String[] args) {
        //start test RecursiveFactorial
        long[] testNumbers = new long[20]; //setup the array for testNumbers
        String[] testStrings =//contains 10 palindromes[2, 4, 5, 6, 10, 11, 12, 13, 15, 18]
                {"palindrome", "recursion", "aba", "abacus", "noon",
                        "246191642", "Star for a jar of rats", "not a palindrome", "12345", "01110111",
                        "NEVER ODD OR EVEN", "never odd?, or even?", "Nev3r 0Dd 0R 3vEn", "never ODD OR EVen", "neither odd nor even",
                        "13331", "abcde1234", "factorial!?", "789878987", "877789"};
        long n = 0;
        for (int i = 0; i < testNumbers.length; i++) {
            n = n + 1;
            testNumbers[i] = n;
            //System.out.println(testNumbers[i]);
        }
        System.out.println(String.format("%-5s\t%-30s\t%-10s\t%s", "Index", "Factorial", "Rec Time", "(RECURSIVE FACTORIAL)"));
        long startTimeRFacRecur = System.nanoTime();//start timing the recursiveFactorial method
        long endTimeRFacRecur;
        for (long testNumber : testNumbers) {
            endTimeRFacRecur = System.nanoTime() - startTimeRFacRecur;
            System.out.println(String.format("%-5s\t%-30s\t%-10s", testNumber, ComputeFactorial.factorial(testNumber), (endTimeRFacRecur)));
        }
        //end test RecursiveFactorial
        System.out.println("\n");
        System.out.println(String.format("%-5s\t%-30s\t%-10s\t%s", "Index", "Factorial", "Rec Time", "(NON-RECURSIVE FACTORIAL)"));
        long startTimeRFac = System.nanoTime();//start timing the recursiveFactorial method
        long endTimeRFac;
        for (long testNumber : testNumbers) {
            endTimeRFac = System.nanoTime() - startTimeRFac;
            System.out.println(String.format("%-5s\t%-30s\t%-10s", testNumber, nFactorial(testNumber), (endTimeRFac)));
        }
        //end test nonRecursiveFactorial
        //--------------------------------------------------------------------------------------//

        System.out.println("\n");

        System.out.println(String.format("%-5s\t%-15s\t%-10s\t%s", "Index", "Fib Number", "Rec Time", "(RECURSIVE FIBONACCI)"));
        long startTimeRFibRecur = System.nanoTime();//start timing the recursiveFactorial method
        long endTimeRFibRecur;
        for (long testNumber : testNumbers) {
            endTimeRFibRecur = System.nanoTime() - startTimeRFibRecur;
            System.out.println(String.format("%-5s\t%-15s\t%-10s", testNumber, fibonacci(testNumber), (endTimeRFibRecur)));

        }
        //end test RecursiveFibonacci
        System.out.println("\n");

        System.out.println(String.format("%-5s\t%-15s\t%-10s\t%s", "Index", "Fib Number", "Rec Time", "(NON-RECURSIVE FIBONACCI)"));
        long startTimeRFib = System.nanoTime();//start timing the recursiveFactorial method
        long endTimeRFib;
        for (long testNumber : testNumbers) {
            endTimeRFib = System.nanoTime() - startTimeRFib;
            System.out.println(String.format("%-5s\t%-15s\t%-10s", testNumber, nFibonacci(testNumber), (endTimeRFib)));

        }
        //end test nonRecursiveFibonacci
        System.out.println("\n");

        System.out.println("\n");
        System.out.println(String.format("%-25s\t%-20s\t%-10s\t%s", "Index", "Palindrome?", "Ex Time", "(RECURSIVE PALINDROME)"));
        long startTimeRPal = System.nanoTime();//start timing the recursiveFactorial method
        long endTimeRPal;
        for (String testString : testStrings) {
            endTimeRPal = System.nanoTime() - startTimeRPal;
            System.out.println(String.format("%-25s\t%-20s\t%-10s", testString, isPalindrome(testString), endTimeRPal));
        }

        System.out.println("\n");

        System.out.println("\n");
        System.out.println(String.format("%-25s\t%-20s\t%-10s\t%s", "Index", "Palindrome?", "Ex Time", "(NON-RECURSIVE PALINDROME)"));
        long startTimePal = System.nanoTime();//start timing the recursiveFactorial method
        long endTimePal;
        for (String testString : testStrings) {
            endTimePal = System.nanoTime() - startTimePal;
            System.out.println(String.format("%-25s\t%-20s\t%-10s", testString, nIsPalindrome(testString), endTimePal));
        }
    }
}


