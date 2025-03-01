package src.src.walmart;

import java.util.TreeSet;

public class RoundOne {
    // given array if int find max peak sum

    public static int solutions(int[] heights) {

        int maxPeakSum = 0;
        for (int i = 1; i < heights.length-1; i++) {

            int currentHeight = heights[i];
            // go left
            int leftHeight = 0;
            int leftIdx = i-1;
            while (leftIdx >= 0) {
                if (heights[leftIdx] < currentHeight) {
                    leftHeight = Math.max(leftHeight, heights[leftIdx]);
                }
                leftIdx--;
            }
            // go right
            int rightHeight = 0;
            int rightIdx = i+1;
            while (rightIdx < heights.length) {
                if (heights[rightIdx] < currentHeight) {
                    rightHeight = Math.max(rightHeight, heights[rightIdx]);
                }
                rightIdx++;
            }

            if (rightHeight > 0 && leftHeight > 0) {
                maxPeakSum = Math.max(maxPeakSum, currentHeight + leftHeight + rightHeight);
            }
        }


        return maxPeakSum;
    }

    public static int findMaxTripletSum(int[] heights) {
        int n = heights.length;
        if (n < 3) return 0;

        int maxSum = 0;

        int[] rightMax = new int[n];
        rightMax[n - 1] = heights[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        int maxLeft = heights[0];

        for (int i = 1; i < n - 1; i++) {
            if (maxLeft < heights[i] && rightMax[i + 1] < heights[i]) {
                maxSum = Math.max(maxSum, maxLeft + heights[i] + rightMax[i + 1]);
            }

            // Update maxLeft for the next iteration
            maxLeft = Math.max(maxLeft, heights[i]);
        }

        return maxSum;
    }

    // given a string , find longest substring such that each char has k freq
        //z, A,a,b,h,a,b,b, c,c    and k = 3
    // z -> 0, a -> 1,2,5, b -> 3,6,7 c-> 8,9, h-> 4
    //


    // double for loop -> O(N^2), O(1) brute force
//    public static String solutionTwo(String input, int k) {
//
//    }






    public static void main(String[] args) {
//        int[] input = new int[] {8,6,1,5,3};
        int [] input = new int[]{5,4,8,7,12,11,2}; // 19, 13, 20,
        //ex -> 20
        int result = findMaxTripletSum(input);
        // expected -> 9
        System.out.println(result);
    }
}
