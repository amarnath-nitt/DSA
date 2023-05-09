package main.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amarnath-nitt
 * */
public class CountOfSubsequenceOfAnArrayOfGivenSum {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3};
        int sum = 3;
        int count = countOfSubsequenceOfAnArrayOfGivenSum(0, arr, sum);
        System.out.println("Output: ");
        System.out.println("Count of subsequence: " + count);
    }

    private static int countOfSubsequenceOfAnArrayOfGivenSum(int ind, int[] arr, int sum) {
        if(ind >= arr.length ){
            if(sum == 0){
                return 1;
            }
            return 0;
        }
       int l = countOfSubsequenceOfAnArrayOfGivenSum(ind+1, arr, sum-arr[ind]);
       int r = countOfSubsequenceOfAnArrayOfGivenSum(ind+1, arr, sum);
       return (l+r);
    }

    private static void countOfSubsequenceOfAnArrayOfGivenSumWithMoreExtraSpace(int ind, int[] arr, ArrayList<Integer> ds, List<List<Integer>> res, int sum) {
        if(ind >= arr.length ){
            if(sum == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        ds.add(arr[ind]);
        countOfSubsequenceOfAnArrayOfGivenSumWithMoreExtraSpace(ind+1, arr, ds, res, sum-arr[ind]);
        ds.remove(ds.size()-1);
        countOfSubsequenceOfAnArrayOfGivenSumWithMoreExtraSpace(ind+1, arr, ds, res, sum);
    }
}
