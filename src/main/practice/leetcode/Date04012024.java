package main.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amarnath-nitt 04/01/24
 */
public class Date04012024 {
    public static void main(String[] args) {
      int [] nums = {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12};
        System.out.println(minOperations(nums));
    }
    public static int minOperations(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int x : nums){
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }
        int count=0;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() % 2 != 0 && entry.getValue() % 3 != 0){
                return -1;
            }
            if (entry.getValue() % 3 == 1) {
                count += (entry.getValue() / 3) - 1;
                count += 2;
            }
            else {
                count += (entry.getValue() / 3);
                count += ((entry.getValue() % 3) / 2);
            }
        }
        return count;
    }
}
