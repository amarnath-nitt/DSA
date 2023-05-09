package main.algorithms.recursion;

import java.util.Arrays;

/**
 * @author amarnath-nitt 07/05/23
 */
public class LinearSearch {
    /**
     * Linear Search is a simple algorithm used to search for a particular element in a list or array of elements.
     * @TimeComplexity : O(n)
     * @AuxillarySpace : O(1)
     * */
    public static void main(String[] args) {
        int [] arr = {3,4,5,2,17,8,9,20};
        int key1 = 20;
        int pos1 = linearSearchRecursion(arr, 0, key1);
        if(pos1 == -1){
            System.out.println(key1 + " is not present in the given array: "+ Arrays.toString(arr));
        }
        else{
            System.out.println(key1 + " is present in the given array: " + Arrays.toString(arr) + " at position: "+ (pos1));
        }

        int key2 = 10;
        int pos2 = linearSearchRecursion(arr, 0, key2);
        if(pos2 == -1){
            System.out.println(key2 + " is not present in the given array: "+ Arrays.toString(arr));
        }
        else{
            System.out.println(key2 + " is present in the given array: " + Arrays.toString(arr) + " at position: "+ (pos2));
        }
    }

    private static int linearSearchRecursion(int[] arr, int ind, int key) {
        if(ind >= arr.length ){
            return -1;
        }
        if(arr[ind] == key) return ind+1;
        return linearSearchRecursion(arr, ind+1, key);
    }
}
