package main.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author amarnath-nitt
 * */
public class PrintNumberFrom1ToN {
    public static void main(String[] args) throws IOException {
        System.out.println("***** Welcome to number printing service from 1 to n *****");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Output: ");
        int i=1;
        printNumberFrom1ToN(i, n);
        printNumberFrom1ToNBacktrackMethod(n);
    }

    private static void printNumberFrom1ToN(int i, int n) {
        if(i > n){
            return;
        }
        System.out.print(i + " ");
        printNumberFrom1ToN(i+1, n);
    }

    private static void printNumberFrom1ToNBacktrackMethod(int n) {
        if(n <= 0){
            return;
        }
        printNumberFrom1ToNBacktrackMethod(n-1);
        System.out.print(n + " ");
    }
}
