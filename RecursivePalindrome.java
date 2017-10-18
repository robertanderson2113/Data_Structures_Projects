package com.company;

class RecursivePalindrome {
    static boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll("\\W","");
        return isPalindrome(s, 0, s.length() - 1);
    }

    static boolean isPalindrome(String s, int low, int high) {
        if (high <= low) // Base case
            return true;
        else if (s.charAt(low) != s.charAt(high)) // Base case
            return false;
        else
            return isPalindrome(s, low + 1, high - 1);
    } //end isPalindrome

    public static boolean nIsPalindrome(String s) {
        if (s == null) {
            return false;
        }
        s=s.toLowerCase().replaceAll("\\W","");
        String reversed = reverse(s);

        return s.equals(reversed);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

}