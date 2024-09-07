package main.algorithms.sortings;

import java.util.Arrays;

/**
 * @author amarnath-nitt 07/05/23
 */
public class InsertionSort {
    /**
     * Insertion sort is a simple sorting algorithm that works by repeatedly inserting elements from an unsorted list into a sorted sub-list,
     * until the entire list is sorted.
     * Here's how it works:
     * Divide the list into two sub-lists: sorted and unsorted.
     * Initially, the sorted sub-list contains only the first element of the list.
     * Iterate through the unsorted sub-list, comparing each element with the elements in the sorted sub-list.
     * Find the correct position for the current element in the sorted sub-list and shift the elements over to make room for the new element.
     * Insert the current element into the correct position in the sorted sub-list.
     * Repeat steps 3-5 until the entire list is sorted.
     * @TimeComplexity : O(n^2)
     * @AuxillarySpace : O(1)
     * */
    public static void main(String[] args) {
        int [] arr1 = {3,4,5,2,17,8,9,1};
        System.out.println("Array before sorting: " + Arrays.toString(arr1));
        leftInsertionSort(arr1);
        System.out.println("Array after sorting: "+ Arrays.toString(arr1));

        int [] arr2 = {3,4,5,2,17,8,9,1};
        System.out.println("Array before sorting: " + Arrays.toString(arr2));
        rightInsertionSort(arr2);
        System.out.println("Array after sorting: "+ Arrays.toString(arr2));
    }

    private static void rightInsertionSort(int[] arr) {
        int n = arr.length;
        for(int i=n-2; i>=0; i--){
            int temp = arr[i];
            int j=i;
            for(; j<n-1 && temp > arr[j+1]; j++){
                arr[j] =  arr[j+1];
            }
            arr[j] = temp;
        }
    }

    private static void leftInsertionSort(int[] arr) {
        int n = arr.length;
        for(int i=1; i<n; i++){
            int temp = arr[i];
            int j;
            for(j=i; j>0 && temp < arr[j-1]; j--){
                arr[j] =  arr[j-1];
            }
            arr[j] = temp;
        }
    }
}
