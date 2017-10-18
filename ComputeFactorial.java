package com.company;

class ComputeFactorial {


     static long factorial(long n) {
        if (n == 0) // Base case
            return 1;
        else
            return n * factorial(n - 1); // Recursive call
    }

    static long nFactorial(long n){
         long fac = 1 ;
         if (n == 0){
             return 1 ;
         }
         else {
             for (int i = 2; i <= n; i++) {
                 fac *= i;
             }

             return fac;
         }
    }
}
