package main.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amarnath-nitt
 * */
public class OneSubsequenceOfAnArrayOfGivenSum {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3};
        int sum = 3;
        List<List<Integer>> res = new ArrayList<>();
        oneSubsequenceOfAnArrayOfGivenSum(0, arr, new ArrayList<Integer>(), res, sum);
        System.out.println("Output: ");
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    private static boolean oneSubsequenceOfAnArrayOfGivenSum(int ind, int[] arr, ArrayList<Integer> ds, List<List<Integer>> res, int sum) {
        if(ind >= arr.length ){
            if(sum == 0){
                res.add(new ArrayList<>(ds));
                return true;
            }
            return false;
        }
        ds.add(arr[ind]);
        if(oneSubsequenceOfAnArrayOfGivenSum(ind+1, arr, ds, res, sum-arr[ind])){
            return true;
        }
        ds.remove(ds.size()-1);
        if(oneSubsequenceOfAnArrayOfGivenSum(ind+1, arr, ds, res, sum)){
            return true;
        }
        return false;
    }
}
