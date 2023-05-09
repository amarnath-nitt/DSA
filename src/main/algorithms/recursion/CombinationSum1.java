package main.algorithms.recursion;

import java.util.*;

/**
 * @author amarnath-nitt
 * */
public class CombinationSum1 {
    /**
     * Print All Combination Of Given Sum;
     * */
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,1,3};
        int sum = 3;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        combinationSum1(0, arr, ds, res, sum);
        System.out.println("Output: ");
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    private static void combinationSum1(int ind, int[] arr, List<Integer> ds, List<List<Integer>> res, int sum) {
        if(ind >= arr.length ){
            if(sum == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind] <= sum){
            ds.add(arr[ind]);
            combinationSum1(ind, arr, ds, res, sum-arr[ind]);
            ds.remove(ds.size()-1);
        }
        combinationSum1(ind+1, arr, ds, res, sum);
    }
}
