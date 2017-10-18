package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static com.company.ComputeFactorial.factorial;
import static com.company.ComputeFactorial.nFactorial;
import static com.company.ComputeFibonacci.fibonacci;
import static com.company.ComputeFibonacci.nFibonacci;
import static com.company.RecursiveBinarySearch.binarySearch;
import static com.company.RecursiveBinarySearch.nBinarySearch;
import static com.company.RecursivePalindrome.isPalindrome;
import static com.company.RecursivePalindrome.nIsPalindrome;


public class p5Recursion {

    public static void main(String[] args) {
        //create output file
        PrintWriter toFile1 = createTextFile("C:\\Users\\Robert Anderson\\IdeaProjects\\Project5\\src\\com\\company\\p5out.txt");

        long[] testNumbers = new long[20]; //setup the array for testNumbers, used by Factorial and Fibonacci
        long[] testNumbers2 = new long[20];
        String[] testStrings =//contains 10 palindromes[2, 4, 5, 6, 10, 11, 12, 13, 15, 18]
                {"palindrome", "recursion", "aba", "abacus", "noon",
                        "246191642", "Star for a jar of rats", "not a palindrome", "12345", "01110111",
                        "NEVER ODD OR EVEN", "never odd?, or even?", "Nev3r 0Dd 0R 3vEn", "never ODD OR EVen", "neither odd nor even",
                        "13331", "abcde1234", "factorial!?", "789878987", "877789"};
        long n = 0; //fill the array with numbers from 1 to 20, can be changed
        long o = 0;
        for (int i = 0; i < testNumbers.length; i++) {
            n = n + 1;
            o = o + 2;
            testNumbers[i] = n;
            testNumbers2[i] = o;
        }

        int[] multiples = new int[1000];
        int m = 0;
        for (int i = 0; i < multiples.length; i++) {
            m = m + 3;
            multiples[i] = m;
        }
        int[] randNumbers = new int[20]; //setup the array of randNumbers, used by binarySearch
        Random randomKey = new Random();
        int key = randomKey.nextInt(3000) + 1;

        int r; //fill the array with random numbers from 1 to 3000
        for (int i = 0; i < randNumbers.length; i++) {
            Random rand = new Random();
            r = rand.nextInt(3000) + 1;
            randNumbers[i] = r;
            //System.out.println(randNumbers[i]);
        }
        //Arrays.sort(randNumbers);
        // begin test of factorial()
        toFile1.write("TEST FACTORIAL METHODS\n");
        toFile1.write(String.format("%-10s\t%-30s\t%-10s\t%s\n", "Test Value", "Factorial", "Ex Time", "(RECURSIVE FACTORIAL)"));
        for (long testNumber : testNumbers) {
            long startTimeRFacRecur = System.nanoTime();//start timing the recursiveFactorial method
            long result = factorial(testNumber);
            long endTimeRFacRecur = System.nanoTime() - startTimeRFacRecur;
            toFile1.write(String.format("%-10s\t%-30s\t%-10s\n", testNumber, result, (endTimeRFacRecur)));


        }//end test factorial()
        //--------------------------------------------------------------------------------------//

        toFile1.write("\n");
        //start test nFactorial()
        toFile1.write(String.format("%-10s\t%-30s\t%-10s\t%s\n", "Test Value", "Factorial", "Ex Time", "(NON-RECURSIVE FACTORIAL)"));

        for (long testNumber : testNumbers) {
            long startTimeRFac = System.nanoTime(); //start timing
            long result = nFactorial(testNumber);
            long endTimeRFac = System.nanoTime() - startTimeRFac;
            toFile1.write(String.format("%-10s\t%-30s\t%-10s\n", testNumber, result, (endTimeRFac)));
        }//end test nFactorial()
        //--------------------------------------------------------------------------------------//
        toFile1.write("\n");
        toFile1.write("TEST FIBONACCI METHODS\n");
        //start test fibonacci()
        toFile1.write(String.format("%-10s\t%-15s\t%-10s\t%s\n", "Test Value", "Fib Number", "Ex Time", "(RECURSIVE FIBONACCI)"));
        for (long testNumber : testNumbers2) {
            long startTimeRFibRecur = System.nanoTime();//start timing
            long result = fibonacci(testNumber);
            long endTimeRFibRecur = System.nanoTime() - startTimeRFibRecur;
            toFile1.write(String.format("%-10s\t%-15s\t%-10s\n", testNumber, result, (endTimeRFibRecur)));

        }
        //end test fibonacci()
        //--------------------------------------------------------------------------------------//
        toFile1.write("\n");
        //start test nFibonacci()
        toFile1.write(String.format("%-10s\t%-15s\t%-10s\t%s\n", "Test Value", "Fib Number", "Ex Time", "(NON-RECURSIVE FIBONACCI)"));
        for (long testNumber : testNumbers2) {
            long startTimeRFib = System.nanoTime();//start timing
            long result = nFibonacci(testNumber);
            long endTimeRFib = System.nanoTime() - startTimeRFib;
            toFile1.write(String.format("%-10s\t%-15s\t%-10s\n", testNumber, result, (endTimeRFib)));
        }
        //end test nFibonacci()
        //--------------------------------------------------------------------------------------//
        toFile1.write("\n");
        toFile1.write("TEST PALINDROME METHODS\n");
        //start test isPalindrome()
        toFile1.write(String.format("%-25s\t%-20s\t%-10s\t%s\n", "Test Value", "Palindrome?", "Ex Time", "(RECURSIVE PALINDROME)"));
        for (String testString : testStrings) {
            long startTimeRPal = System.nanoTime();//start timing
            boolean result = isPalindrome(testString);
            long endTimeRPal = System.nanoTime() - startTimeRPal;
            toFile1.write(String.format("%-25s\t%-20s\t%-10s\n", testString, result, endTimeRPal));
        }//end test isPalindrome()
        //--------------------------------------------------------------------------------------//
        toFile1.write("\n");
        // start test nIsPalindrome()
        toFile1.write(String.format("%-25s\t%-20s\t%-10s\t%s\n", "Test Value", "Palindrome?", "Ex Time", "(NON-RECURSIVE PALINDROME)"));
        for (String testString : testStrings) {
            long startTimePal = System.nanoTime();//start timing
            boolean result = nIsPalindrome(testString);
            long endTimePal = System.nanoTime() - startTimePal;
            toFile1.write(String.format("%-25s\t%-20s\t%-10s\n", testString, result, endTimePal));
        }//end test nIsPalindrome()
        toFile1.write("\n");
        //--------------------------------------------------------------------------------------//
        toFile1.write("TEST BINARY METHODS\n");
        //start test binarySearch() with multiples[]
        toFile1.write(String.format("%-25s\t%-20s\t%-10s\t%s\n", "Key", "Index", "Ex Time", "(RECURSIVE BINARY WITH MULTIPLES OF 3)"));
        long startTimeRBin3 = System.nanoTime();//start timing
        int result = binarySearch(multiples, key);
        long endTimeRBin3 = System.nanoTime() - startTimeRBin3;
        toFile1.write(String.format("%-25s\t%-20s\t%-10s\n", key, result, endTimeRBin3));
        //end test binarySearch() with multiples[]
        //--------------------------------------------------------------------------------------//
        //start test binarySearch() with randNumbers[]
        toFile1.write("\n");
        toFile1.write(String.format("%-25s\t%-20s\t%-10s\t%s\n", "Key", "Index", "Ex Time", "(RECURSIVE BINARY WITH RANDOMS)"));
        for (int each : randNumbers) {
            key = each;
            long startTimeRBin = System.nanoTime();//start timing
            int result1 = binarySearch(randNumbers, key);
            long endTimeRBin = System.nanoTime() - startTimeRBin;
            toFile1.write(String.format("%-25s\t%-20s\t%-10s\n", key, result1, endTimeRBin));
        }
        //end test binarySearch() with randNumbers[]
        //--------------------------------------------------------------------------------------//
        toFile1.write("\n");
        //start test nBinarySearch() with multiples[]
        toFile1.write(String.format("%-25s\t%-20s\t%-10s\t%s\n", "Key", "Index", "Ex Time", "(NON RECURSIVE BINARY WITH MULTIPLES OF 3)"));
        long startTimeBin3 = System.nanoTime();//start timing
        int result2 = nBinarySearch(multiples, key);
        long endTimeBin3 = System.nanoTime() - startTimeBin3;
        toFile1.write(String.format("%-25s\t%-20s\t%-10s\n", key, result2, endTimeBin3));
        //end test nBinarySearch() with multiples[]
        //--------------------------------------------------------------------------------------//
        //start test nBinarySearch() with randNumbers[]
        toFile1.write("\n");
        toFile1.write(String.format("%-25s\t%-20s\t%-10s\t%s\n", "Key", "Index", "Ex Time", "(NON RECURSIVE BINARY WITH RANDOMS)"));

        for (int each : randNumbers) {
            key = each;
            long startTimeBin = System.nanoTime();//start timing
            int result3 = nBinarySearch(randNumbers, key);
            long endTimeBin = System.nanoTime() - startTimeBin;
            toFile1.write(String.format("%-25s\t%-20s\t%-10s\n", key, result3, endTimeBin));
        }
        //end test binarySearch() with randNumbers[]
        toFile1.close();
    }

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
}

/*    Test Value	    Factorial                     	Ex Time   	(RECURSIVE FACTORIAL)
        1    	1                             	427
        2    	2                             	1663150
        3    	6                             	1802243
        4    	24                            	2330031
        5    	120                           	2464005
        6    	720                           	2588592
        7    	5040                          	2708912
        8    	40320                         	2815579
        9    	362880                        	2970459
        10   	3628800                       	3087792
        11   	39916800                      	3227739
        12   	479001600                     	3381340
        13   	6227020800                    	3525126
        14   	87178291200                   	3692807
        15   	1307674368000                 	3811420
        16   	20922789888000                	3964594
        17   	355687428096000               	4089181
        18   	6402373705728000              	4251314
        19   	121645100408832000            	4362248
        20   	2432902008176640000           	4480008

        Test Value	Factorial                     	Ex Time   	(NON-RECURSIVE FACTORIAL)
        1    	1                             	427
        2    	2                             	107094
        3    	6                             	248747
        4    	24                            	369068
        5    	120                           	507308
        6    	720                           	613121
        7    	5040                          	735575
        8    	40320                         	859308
        9    	362880                        	961709
        10   	3628800                       	1061549
        11   	39916800                      	1158829
        12   	479001600                     	1285549
        13   	6227020800                    	1391789
        14   	87178291200                   	1493336
        15   	1307674368000                 	1593176
        16   	20922789888000                	1700697
        17   	355687428096000               	1797977
        18   	6402373705728000              	1892270
        19   	121645100408832000            	1989550
        20   	2432902008176640000           	2100057

        Test Value	Fib Number     	Ex Time   	(RECURSIVE FIBONACCI)
        1    	1              	854
        2    	1              	1019309
        3    	2              	1080749
        4    	3              	1189549
        5    	5              	1283416
        6    	8              	1368749
        7    	13             	1451950
        8    	21             	1604696
        9    	34             	1705390
        10   	55             	1819310
        11   	89             	1936644
        12   	144            	2057817
        13   	233            	2166617
        14   	377            	2341551
        15   	610            	2437978
        16   	987            	2536538
        17   	1597           	2664965
        18   	2584           	2820272
        19   	4181           	2994352
        20   	6765           	3229446

        Test Value	Fib Number     	Ex Time   	(NON-RECURSIVE FIBONACCI)
        1    	1              	426
        2    	1              	96426
        3    	2              	166826
        4    	3              	241067
        5    	5              	326400
        6    	8              	427094
        7    	13             	518400
        8    	21             	778241
        9    	34             	858028
        10   	55             	960428
        11   	89             	1041495
        12   	144            	1131948
        13   	233            	1221975
        14   	377            	1291948
        15   	610            	1364482
        16   	987            	1431042
        17   	1597           	1510402
        18   	2584           	1585922
        19   	4181           	1652482
        20   	6765           	1741229


        Test Value                    	Palindrome?         	Ex Time   	(RECURSIVE PALINDROME)
        palindrome               	false               	427
        recursion                	false               	1279149
        aba                      	true                	1371736
        abacus                   	false               	1450243
        noon                     	true                	1536856
        246191642                	true                	1612377
        Star for a jar of rats   	true                	1696003
        not a palindrome         	false               	1914457
        12345                    	false               	2009604
        01110111                 	false               	2098351
        NEVER ODD OR EVEN        	true                	2181124
        never odd?, or even?     	true                	2276698
        Nev3r 0Dd 0R 3vEn        	true                	2375258
        never ODD OR EVen        	true                	2464431
        neither odd nor even     	false               	2553178
        13331                    	true                	2640218
        abcde1234                	false               	2711898
        factorial!?              	false               	2791259
        789878987                	true                	2878725
        877789                   	false               	2956805


        Test Value                    	Palindrome?         	Ex Time   	(NON-RECURSIVE PALINDROME)
        palindrome               	false               	426
        recursion                	false               	134827
        aba                      	true                	221013
        abacus                   	false               	293120
        noon                     	true                	384000
        246191642                	true                	466347
        Star for a jar of rats   	true                	551681
        not a palindrome         	false               	658774
        12345                    	false               	755201
        01110111                 	false               	830295
        NEVER ODD OR EVEN        	true                	906668
        never odd?, or even?     	true                	1003521
        Nev3r 0Dd 0R 3vEn        	true                	1114882
        never ODD OR EVen        	true                	1213868
        neither odd nor even     	false               	1311149
        13331                    	true                	1409709
        abcde1234                	false               	1482242
        factorial!?              	false               	1556056
        789878987                	true                	1646936
        877789                   	false               	1730563   */


