package main.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amarnath-nitt
 * */
public class SubsequencesOfAnArray {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        subsequenceOfAnArray(0, arr, new ArrayList<Integer>(), res);
        System.out.println("Output: ");
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    private static void subsequenceOfAnArray(int ind, int[] arr, ArrayList<Integer> ds, List<List<Integer>> res) {
        if(ind >= arr.length ){
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[ind]);
        subsequenceOfAnArray(ind+1, arr, ds, res);
        ds.remove(ds.size()-1);
        subsequenceOfAnArray(ind+1, arr, ds, res);
    }
}
