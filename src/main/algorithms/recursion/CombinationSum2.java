package main.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author amarnath-nitt
 * */
public class CombinationSum2 {
    /**
     * Print All Unique Combination Of Given Sum;
     * Each number may only be used once in the combination
     * */
    public static void main(String[] args) {
        int [] arr = new int[]{10,1,2,7,6,1,5};
        int sum = 8;
        Arrays.sort(arr);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        combinationSum2(0, arr, ds, res, sum);
        System.out.println("Output: ");
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    private static void combinationSum2(int ind, int[] arr, List<Integer> ds, List<List<Integer>> res, int sum) {
        if(sum == 0){
            res.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=ind; i<arr.length; i++){
            if(i > ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > sum) break;
            ds.add(arr[i]);
            combinationSum2(i+1, arr, ds, res, sum-arr[i]);
            ds.remove(ds.size()-1);
        }
    }
}
