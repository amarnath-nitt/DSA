package main.algorithms.recursion;

import java.util.Arrays;

/**
 * @author amarnath-nitt 07/05/23
 */
public class BinarySearch {
    /**
     * Binary search is a commonly used algorithm for searching for a specific element in a sorted array or list.
     * @TimeComplexity : O(log(n))
     * @AuxillarySpace : O(1)
     * */
    public static void main(String[] args) {
        int [] arr = {3,4,5,6,7,8,9,20};
        int key1 = 20;
        int pos1 = binarySearchRecursion(arr, 0, arr.length-1, key1);
        if(pos1 == -1){
            System.out.println(key1 + " is not present in the given array: "+ Arrays.toString(arr));
        }
        else{
            System.out.println(key1 + " is present in the given array: " + Arrays.toString(arr) + " at position: "+ (pos1));
        }

        int key2 = 10;
        int pos2 = binarySearchRecursion(arr, 0, arr.length-1, key2);
        if(pos2 == -1){
            System.out.println(key2 + " is not present in the given array: "+ Arrays.toString(arr));
        }
        else{
            System.out.println(key2 + " is present in the given array: " + Arrays.toString(arr) + " at position: "+ (pos2));
        }
    }

    private static int binarySearchRecursion(int[] arr, int low, int high, int key) {
        if(low > high){
            return -1;
        }
        int mid = (low + high)/2;
        if(arr[mid] == key) return mid+1;
        if(arr[mid] < key) return binarySearchRecursion(arr, mid+1, high, key);
        else if(arr[mid] > key) return binarySearchRecursion(arr, low, high-1, key);
        else return -1;
    }
}
