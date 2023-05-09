package main.algorithms.searchs;

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
        int pos1 = linearSearch(arr, key1);
        if(pos1 == -1){
            System.out.println(key1 + " is not present in the given array: "+ Arrays.toString(arr));
        }
        else{
            System.out.println(key1 + " is present in the given array: " + Arrays.toString(arr) + " at position: "+ (pos1));
        }

        int key2 = 10;
        int pos2 = linearSearch(arr, key2);
        if(pos2 == -1){
            System.out.println(key2 + " is not present in the given array: "+ Arrays.toString(arr));
        }
        else{
            System.out.println(key2 + " is present in the given array: " + Arrays.toString(arr) + " at position: "+ (pos2));
        }
    }

    private static int linearSearch(int[] arr, int key) {
        for(int i=0; i<arr.length; i++){
            if(arr[i] == key){
                return i+1;
            }
        }
        return -1;
    }
}
