package main.algorithms.searchs.binarySearch;

import java.util.Arrays;

/**
 * @author amarnath-nitt 24/05/23
 */
public class AggressiveCows {
    static boolean isPossible(int a[], int n, int cows, int minDist) {
        int cntCows = 1;
        int lastPlacedCow = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - lastPlacedCow >= minDist) {
                cntCows++;
                lastPlacedCow = a[i];
            }
        }
        if (cntCows >= cows) return true;
        return false;
    }
    public static void main(String args[]) {
        int n = 5, m = 3;
        int inp[] = {1,2,8,4,9};
        Arrays.sort(inp);
        int maxD = inp[n - 1] - inp[0];
        int ans = Integer.MIN_VALUE;
        for (int d = 1; d <= maxD; d++) {
            boolean possible = isPossible(inp, n, d, m);
            if (possible) {
                ans = Math.max(ans, d);
            }
        }
        System.out.println("The largest minimum distance is " + ans);
    }
}
