package main.algorithms.sortings;

import java.util.Arrays;

/**
 * @author amarnath-nitt 07/05/23
 */
public class SelectionSort {
    /**
     * Selection sort is a simple sorting algorithm that works by repeatedly finding the minimum element from an unsorted part of the array
     * and putting it at the beginning of the array.
     * Here's how it works:
     * Find the minimum element in the unsorted part of the array
     * Swap the minimum element with the first element of the unsorted part of the array
     * Repeat steps 1 and 2 for the remaining unsorted part of the array
     *
     * @TimeComplexity : O(n^2)
     * @AuxillarySpace : O(1)
     * */
    public static void main(String[] args) {
        int [] arr1 = {3,4,5,2,17,8,9,1};
        System.out.println("Array before sorting: " + Arrays.toString(arr1));
        selectionSort(arr1);
        System.out.println("Array after sorting: "+ Arrays.toString(arr1));
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
             arr[min] = arr[i];
             arr[i] = temp;
        }
    }
}
