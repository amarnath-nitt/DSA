package main.algorithms.sortings;

import java.util.Arrays;

/**
 * @author amarnath-nitt 07/05/23
 */
public class BubbleSort {
    /**
     * Bubble sort is a simple sorting algorithm that works by repeatedly swapping adjacent elements in a list or array if they are in the wrong order, until the list is sorted.
     * Here's how it works:
     * Compare the first and second elements of the list.
     * If the first element is greater than the second element, swap them.
     * Move to the next pair of elements, i.e., the second and third elements, and compare them.
     * Continue this process until the end of the list is reached.
     * At this point, the largest element is guaranteed to be at the end of the list.
     * Repeat the above steps for all elements in the list except the last one, which is already sorted.
     * After each pass, the last element of the list is sorted, so we can reduce the number of elements to be compared by one.
     * Continue this process until the entire list is sorted.
     *
     * @TimeComplexity : O(n^2)
     * @AuxillarySpace : O(1)
     * */
    public static void main(String[] args) {
        int [] arr = {3,4,5,2,17,8,9,1};
        System.out.println("Array before sorting: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Array after sorting: "+ Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        /**
         * If there are n elements then number of pass will be (n-1). And in each pass of i number of iteration will be (n-i);
         * */
        for(int i=1; i<n; i++){
            for(int j=0; j<(n-i); j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
