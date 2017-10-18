package com.company;

class ComputeFibonacci {

     static long fibonacci(long index) {
        if (index == 0) // Base case
            return 0;
        else if (index == 1) // Base case
            return 1;
        else  // Reduction and recursive calls
            return fibonacci(index - 1) + fibonacci(index - 2);
    }

    static long nFibonacci (long index){
         if (index <=0){
             return index ;
         }
         long fib = 1 ;
         long lastFib = 1;
         for (int i = 2 ; i < index ; ++i){
             long temp = fib;
             fib += lastFib;
             lastFib = temp ;
         }
         return fib ;
    }
}