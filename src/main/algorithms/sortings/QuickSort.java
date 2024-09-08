package main.algorithms.sortings;

import java.util.Arrays;

public class QuickSort {
    /**
     * QuickSort is a divide-and-conquer sorting algorithm. It works by:
     * Choosing a Pivot: Select an element from the array to act as a "pivot". The choice of pivot can vary (e.g., first element, last element, random element).
     * Partitioning: Rearrange the array so that all elements less than the pivot come before it, and all elements greater than the pivot come after it. The pivot is now in its final sorted position.
     * Recursively Applying: Recursively apply the same process to the sub-arrays formed by dividing the array at the pivot.
     * */
    public static void main(String[] args) {
        int [] arr = {3,4,5,2,17,8,9,1};
        System.out.println("Array before sorting: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("Array after sorting: "+ Arrays.toString(arr));
    }
    public static void quickSort(int [] arr){
        int n = arr.length;
        quickSort(arr, 0, n-1);
    }
    public static void quickSort(int [] arr, int low, int high){
        if(low < high){
            int pivot = partion(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
    public static int partion(int [] arr, int low, int high){
        int privot = arr[low];
        int left = low;
        int right = high;
        while(left < right){
            if(arr[left] <= privot){
                left++;
            }
            if(arr[right] > privot){
                right--;
            }
            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[low] = arr[right];
        arr[right] = privot;
        return right;
    }
}
