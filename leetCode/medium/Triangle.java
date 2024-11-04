package src.src.leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    /*
    * Given a triangle array, return the minimum path sum from top to bottom.
    * For each step, you may move to an adjacent number of the row below.
    * More formally, if you are on index i on the current row,
    * you may move to either index i or index i + 1 on the next row.
    */

    public static int minimumTotal(List<List<Integer>> triangle) {

        int currentIndex = 0;
        int [] dp = new int[triangle.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for (int i = 0; i < triangle.size()-1; i++) {
            dp[i + 1] = dp[i] + Math.min(triangle.get(i+1).get(currentIndex), triangle.get(i+1).get(currentIndex+1));
        }
        return dp[triangle.size()-1];
    }

    public static void main(String[] args) {
        //[[-1],[2,3],[1,-1,-3]]

        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(-1));
        input.add(List.of(2,3));
        input.add(List.of(1,-1,-3));
//        input.add(List.of(4,1,8,3));
        int output = minimumTotal(input);
        System.out.println(output);
    }
}
