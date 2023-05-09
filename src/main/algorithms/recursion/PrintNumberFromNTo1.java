package main.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author amarnath-nitt
 * */
public class PrintNumberFromNTo1 {
    public static void main(String[] args) throws IOException {
        System.out.println("***** Welcome to number printing service from n to 1 *****");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Output: ");
        int i=1;
        System.out.println("RecursionMethod: ");
        printNumberFromNTo1(n);
        System.out.println("\nRecursion + BackTrackMethod: ");
        printNumberFromNTo1BacktrackMethod(i, n);
    }

    private static void printNumberFromNTo1BacktrackMethod(int i, int n) {
        if(i > n){
            return;
        }
        printNumberFromNTo1BacktrackMethod(i+1, n);
        System.out.print(i + " ");
    }

    private static void printNumberFromNTo1(int n) {
        if(n <= 0){
            return;
        }
        System.out.print(n + " ");
        printNumberFromNTo1(n-1);
    }
}
