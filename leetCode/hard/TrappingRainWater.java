package src.src.leetCode.hard;

public class TrappingRainWater {
    /*
    * Given n non-negative integers representing an elevation map where the width of each bar is 1,
    * compute how much water it can trap after raining.
    */

    public static int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int totalWaterTrapped = 0;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex != rightIndex) {
            int maxHeight = Math.min(maxLeft, maxRight);
            if (maxLeft <= maxRight) {
                // move left pointer
                leftIndex++;
                if (height[leftIndex] >= maxLeft) {
                    maxLeft = height[leftIndex];
                } else {
                    totalWaterTrapped += Math.max(0, maxHeight - height[leftIndex]);
                }

            }else {
                // move right pointer
                rightIndex--;
                if (height[rightIndex] >= maxRight) {
                    maxRight = height[rightIndex];
                } else {
                    totalWaterTrapped += Math.max(0, maxHeight - height[rightIndex]);
                }
            }
        }
        return totalWaterTrapped;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = new int[]{5,5,1,7,1,1,5,2,7,6};
        int result = trap(height2);
        System.out.println(result);
    }

}
