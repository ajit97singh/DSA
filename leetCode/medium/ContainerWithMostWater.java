package src.src.leetCode.medium;

public class ContainerWithMostWater{

    /*
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
    the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.
    */

    public static int maxArea(int[] height) {
        int leftBoundary = 0;
        int rightBoundary = height.length - 1;
        int maxArea = (rightBoundary - leftBoundary) * (Math.min(height[leftBoundary], height[rightBoundary]));

        while(leftBoundary != rightBoundary){
            if(height[leftBoundary] >= height[rightBoundary]){
                rightBoundary--;
            }else {
                leftBoundary++;
            }
            maxArea = Math.max(maxArea, (rightBoundary - leftBoundary) * (Math.min(height[leftBoundary], height[rightBoundary])));
        }
        return maxArea;
    }


    public static int maxArea2(int[] height) {
        int leftBoundary = 0;
        int rightBoundary = height.length - 1;
        int maxArea = 0;

        while (leftBoundary != rightBoundary){
            maxArea = Math.max(maxArea, (rightBoundary - leftBoundary) * (Math.min(height[leftBoundary], height[rightBoundary])));
            if (height[leftBoundary] >= height[rightBoundary]){
                rightBoundary--;
            }else {
                leftBoundary++;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
