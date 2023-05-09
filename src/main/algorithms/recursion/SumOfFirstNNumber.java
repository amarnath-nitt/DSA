package main.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author amarnath-nitt
 * */
public class SumOfFirstNNumber {
    public static void main(String[] args) throws IOException {
        System.out.println("***** Welcome to calculating sum service *****");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Output: ");
        int sum = 0;
        sum = getSum(n);
        System.out.println("Recursion: ");
        System.out.println("Sum : " + sum);
        sum = getSumParameterizedMethod(n, 0);
        System.out.println("Recursion with parameter: ");
        System.out.println("Sum : " + sum);
    }

    private static int getSumParameterizedMethod(int n, int sum) {
        if(n <= 0){
            return sum;
        }
        return getSumParameterizedMethod(n-1, sum+n);
    }

    private static int getSum(int n) {
        if(n <= 0){
            return 0;
        }
        return n + getSum(n-1);
    }
}
