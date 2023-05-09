package main.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author amarnath-nitt
 * */
public class CheckPalindromeString {
    public static void main(String[] args) throws IOException {
        System.out.println("***** Welcome to palindrome string service *****");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println("Output: ");
        if(checkPalindromeDoublePointer(str, 0, str.length()-1)){
            System.out.println(str + " is a palindrome string.");
        }
        else{
            System.out.println(str + " is not a palindrome string");
        }
    }

    private static boolean checkPalindromeDoublePointer(String str, int start, int end) {
        if(start >= end){
            return true;
        }
        if(str.charAt(start) != str.charAt(end)){
            return false;
        }
        return checkPalindromeDoublePointer(str, start+1, end-1);
    }

    private static boolean checkPalindromeSinglePointer(String str, int start) {
        if(start >= str.length()/2){
            return true;
        }
        if(str.charAt(start) != str.charAt(str.length()-1-start)){
            return false;
        }
        return checkPalindromeSinglePointer(str, start+1);
    }
}
