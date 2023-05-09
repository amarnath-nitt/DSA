package main.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author amarnath-nitt
 * */
public class FibonacciNumber {
    public static void main(String[] args) throws IOException {
        System.out.println("***** Welcome to fibonacci number service *****");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Output: ");
        for(int i=0; i<=n; i++){
            System.out.println(printNFibonacciNumber(i));
        }
    }

    private static int printNFibonacciNumber(int n) {
        if(n <= 1){
            return n;
        }
        return printNFibonacciNumber(n-1) + printNFibonacciNumber(n-2);
    }
}
