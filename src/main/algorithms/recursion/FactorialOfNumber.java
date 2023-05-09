package main.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author amarnath-nitt
 * */
public class FactorialOfNumber {
    public static void main(String[] args) throws IOException {
        System.out.println("***** Welcome to calculating factorial service *****");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("Output: ");
        int res = getFactorial(n);
        System.out.println("Factorial of number " + n + " is: " + res);
        BigInteger bigIntegerRes = getFactorialUsingBigInteger(n);
        System.out.println("Factorial of number " + n + " is: " + bigIntegerRes);
    }

    private static BigInteger getFactorialUsingBigInteger(int n) {
        if(n <= 0){
            return new BigInteger(String.valueOf(1));
        }
        return new BigInteger(String.valueOf(n)).multiply(getFactorialUsingBigInteger(n-1));
    }

    private static int getFactorial(int n) {
        if(n <= 0){
            return 1;
        }
        return n * getFactorial(n-1);
    }
}
