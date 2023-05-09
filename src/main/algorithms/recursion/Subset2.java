package main.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author amarnath-nitt 06/05/23
 */
public class Subset2 {
    public static void main(String[] args) {
        int [] arr = new int[]{5,2,1};
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        subset2(0, arr, ds, res);
        System.out.println("Output: ");
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    private static void subset2(int ind, int[] arr, List<Integer> ds, List<List<Integer>> res) {
        if(ind >= arr.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<arr.length; i++){
            if(i > ind && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            subset2(i+1, arr, ds, res);
            ds.remove(ds.size()-1);
        }
    }
}
