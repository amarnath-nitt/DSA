package main.algorithms.sortings;

import java.util.Arrays;

/**
 * @author amarnath-nitt 07/05/23
 */
public class MergeSort {
    /**
     * Merge Sort is a divide-and-conquer algorithm that works by recursively dividing an array or list into two halves, sorting the two halves independently, and then merging them back together.
     * Here are the steps to implement Merge Sort:
     * Divide the list into two halves.
     * Recursively sort the two halves separately using Merge Sort.
     * Merge the two sorted halves back together by comparing the elements of each half and placing them in the correct order.
     * Repeat steps 1-3 until the entire list is sorted.
     *
     * @TimeComplexity : O(nlog(n))
     * @AuxillarySpace : O(1)
     * */
    public static void main(String[] args) {
        int [] arr = {3,4,5,2,17,8,9,1};
        System.out.println("Array before sorting: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Array after sorting: "+ Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r) {
        int temp[] = new int[arr.length];
        if(l < r){
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r, temp);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r, int[] temp) {
        int i=l, j=mid+1, k=l;
        while(i <= mid && j <= r){
            if(arr[i] <= arr[j] ){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= r){
            temp[k++] = arr[j++];
        }
        while(l<=r){
            arr[l] = temp[l];
            l++;
        }
    }
}
