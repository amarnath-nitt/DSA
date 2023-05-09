package main.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amarnath-nitt 09/05/23
 */
public class RatInMaze {
    public static void main(String[] args) {
        int [][] arr = {{1,0,0,0}, {1,1,0,1}, {1,1,0,0},{0,1,1,1}};
        int [][] vis = new int[arr.length][arr[0].length];
        for(int i=0; i<vis.length; i++){
            for(int j=0; j<vis[0].length; j++){
                vis[i][j] = 0;
            }
        }
        List<String> res = new ArrayList<>();
        if(arr[0][0] == 1) findPathsInMaze(0,0,arr, "", res, vis);
        System.out.println("Output: ");
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    private static void findPathsInMaze(int i, int j, int [][] arr, String ds, List<String> res, int [][] vis) {
        if(i == arr.length-1 && j == arr[0].length-1){
            res.add(ds);
            return;
        }
        /**
         * Down
         * */
        if(i+1 < arr.length && vis[i+1][j] == 0 && arr[i+1][j] == 1){
            vis[i][j] = 1;
            findPathsInMaze(i+1, j, arr, ds+"D", res, vis);
            vis[i][j] = 0;
        }
        /**
         * Left
         * */
        if(j-1 >= 0 && vis[i][j-1] == 0 && arr[i][j-1] == 1){
            vis[i][j] = 1;
            findPathsInMaze(i, j-1, arr, ds+"L", res, vis);
            vis[i][j] = 0;
        }
        /**
         * Right
         * */
        if(j+1 < arr.length && vis[i][j+1] == 0 && arr[i][j+1] == 1){
            vis[i][j] = 1;
            findPathsInMaze(i, j+1, arr, ds+"R", res, vis);
            vis[i][j] = 0;
        }
        /**
         * Up
         * */
        if(i-1 >= 0 && vis[i-1][j] == 0 && arr[i-1][j] == 1){
            vis[i][j] = 1;
            findPathsInMaze(i-1, j, arr, ds+"U", res, vis);
            vis[i][j] = 0;
        }
    }
}
