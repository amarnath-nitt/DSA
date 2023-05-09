package main.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amarnath-nitt 08/05/23
 */
public class PermutationOfAnArray {
    public static void main(String[] args) {
        int [] arr = {2,3,4};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean [] vis = new boolean[arr.length];

        System.out.println("Output: ");
        permutationOfAnArray(arr, ds, res, vis);
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
        System.out.println("\nOutput using backtrack: ");
        res.clear();
        ds.clear();
        permutationOfAnArrayBacktrack(0, arr, res);
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
        int k = 5;
        System.out.print("\n"+k+"th permutation is: ");
        String resStr = kthPermutation(arr, k);
        System.out.println(resStr);
    }

    private static String kthPermutation(int[] arr, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<arr.length; i++){
            fact = fact * i;
            nums.add(arr[i-1]);
        }
        nums.add(arr[arr.length-1]);

        k = k-1;
        String res = "";
        while(true){
            res += nums.get(k/fact);
            nums.remove(k/fact);
            if(nums.size() == 0) break;
            k = k % fact;
            fact = fact / nums.size();
        }
        return res;
    }

    private static void permutationOfAnArray(int[] arr, List<Integer> ds, List<List<Integer>> res, boolean[] vis) {
        /**
         * @TimeComplexity : O(n*!n)
         * @AuxillarySpace : O(n)
         * */
        if(ds.size() == arr.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!vis[i]){
                vis[i] = true;
                ds.add(arr[i]);
                permutationOfAnArray(arr, ds, res, vis);
                ds.remove(ds.size()-1);
                vis[i] = false;
            }
        }
    }

    private static void permutationOfAnArrayBacktrack(int ind, int [] arr, List<List<Integer>> res) {
        /**
         * @TimeComplexity : O(n*!n)
         * @AuxillarySpace : O(n)
         * */
        if(ind >= arr.length){
            List<Integer> ds = new ArrayList<>();
            for(int x: arr){
                ds.add(x);
            }
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<arr.length; i++){
            swap(i, ind, arr);
            permutationOfAnArrayBacktrack(ind+1, arr, res);
            swap(i, ind, arr);
        }
    }

    private static void swap(int i, int ind, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[ind];
        arr[ind] = temp;
    }
}
