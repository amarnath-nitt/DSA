package main.algorithms.sortings;

import java.util.Arrays;

/**
 * @author amarnath-nitt 07/05/23
 */
public class HeapSort {
    /**
     * Heap Sort is another efficient sorting algorithm that works by creating a binary heap from the array
     * or list to be sorted. Here are the steps to implement Heap Sort:
     *
     * Build a max heap from the array or list. This involves rearranging the elements in the array so that they form a binary heap with the largest element at the root.
     * Swap the root node with the last node in the heap and reduce the heap size by one.
     * Fix the heap property by sifting down the root node if necessary. This involves comparing the root node to its children and swapping it with the larger child if necessary. Repeat this process until the root node is in its correct position.
     * Repeat steps 2-3 until the entire heap is sorted.
     *
     * @TimeComplexity : O(nlog(n)) + O(n)
     * @AuxillarySpace : O(1)
     * */
    public static void main(String[] args) {
        int [] arr = {3,4,5,2,17,8,9,1};
        System.out.println("Array before sorting: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Array after sorting: "+ Arrays.toString(arr));
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify root element
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
