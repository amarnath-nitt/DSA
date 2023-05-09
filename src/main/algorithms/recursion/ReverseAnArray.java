package main.algorithms.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author amarnath-nitt
 * */
public class ReverseAnArray {
    public static void main(String[] args) {
        System.out.println("***** Welcome to reverse array service *****");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println("Output: ");
        System.out.println("Array: " + Arrays.toString(arr));
        arr = reverseArraySinglePointer(arr, 0);
        System.out.println("Reversed array: " + Arrays.toString(arr));
    }

    private static int[] reverseArraySinglePointer(int[] arr, int i) {
        if(i >= arr.length / 2){
            return arr;
        }
        swapElements(arr, i, arr.length - 1 - i);
        return reverseArraySinglePointer(arr, i+1);
    }

    private static int[] reverseArrayDoublePointer(int[] arr, int start, int end) {
        if(start > end){
            return arr;
        }
        swapElements(arr, start, end);
        return reverseArrayDoublePointer(arr, start+1, end-1);
    }

    private static void swapElements(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
