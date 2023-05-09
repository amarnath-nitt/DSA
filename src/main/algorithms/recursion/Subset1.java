package main.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amarnath-nitt 06/05/23
 */
public class Subset1 {
    public static void main(String[] args) {
        int [] arr = new int[]{5,2,1};
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        subset1(0, arr, ds, res);
        System.out.println("Output: ");
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    private static void subset1(int ind, int[] arr, List<Integer> ds, List<List<Integer>> res) {
        if(ind >= arr.length ){
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[ind]);
        subset1(ind+1, arr, ds, res);
        ds.remove(ds.size()-1);
        subset1(ind+1, arr, ds, res);
    }

    private static void subsetSum1(int ind, int[] arr, int sum, List<Integer> res) {
        if(ind >= arr.length ){
            res.add(sum);
            return;
        }
        subsetSum1(ind+1, arr, sum+arr[ind], res);
        subsetSum1(ind+1, arr, sum, res);
    }
}
