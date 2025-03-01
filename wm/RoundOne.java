package src.src.wm;

public class RoundOne {
    // {3,4,5,3,6,2,3,5,5}
    // 2d plane -> walls, val is height of walls
    // raining -> water is stored in between walls
    // -> {3, 4, 5, 5, 5, 5, 5, 5} -> 37

    // O(N2) // O(1)

    // O(N) // O (N) >> using arrays to store max heights on both sides
    // left to right ->

    public static int waterSolution(int[] heights) {

        if (heights == null || heights.length <= 1) {
            return 0;
        }

        int leftMax = heights[0];
        int[] rightMaxes = new int[heights.length-1]; // [] length - > 0
        rightMaxes[rightMaxes.length-1] = heights[heights.length-1]; // 1
        int result = 0;

        for(int i = heights.length-2; i > 0; i--) {
            rightMaxes[i-1] = Math.max(rightMaxes[i], heights[i]);
        }

        for(int i = 0; i < heights.length - 1; i++) {
            leftMax = Math.max(leftMax, heights[i]);
            int height = Math.min(leftMax, rightMaxes[i]);
            result+= height;
        }

        return result;
    }

    public static void main(String[] args) {
        int [] heights = new int[] {};

        // --> { 10, 7,5,7 , 10 } --> 10 + 10 + 10+10 --> 40
        // --> {1,2,3,4,5,6} --> 1, 2, 3,4, 5 --> 15
        // --> {1,2,3,10,3,2,1} --> 1,2,3,3,2,1 --> 12
        // --> {10} --> 0
        // --> {10, 10} --> 10
        // -- {9,10} -- > 9
        // --> {} --> 0
        // --> {}
        int result = waterSolution(heights);
        System.out.println(result);
    }

}
