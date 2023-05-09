package main.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author amarnath-nitt
 * */
public class PrintNameNTimes {
    public static void main(String[] args) throws IOException {
        System.out.println("***** Welcome to name printing service *****");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name: ");
        String name = br.readLine();
        System.out.println("Enter number: ");
        int n = Integer.parseInt(br.readLine());
        printNameNTimes(name, n);
    }

    private static void printNameNTimes(String name, int n) {
        if(n <= 0){
            return;
        }
        System.out.print(name + " ");
        printNameNTimes(name, n-1);
    }
}
