package src.src.leetCode.easy;

import java.util.Arrays;

public class SquaresOfASortedArray {
//    Given an integer array nums sorted in non-decreasing order,
//    return an array of the squares of each number sorted in non-decreasing order.


    public static int[] sortedSquares(int[] nums) {
        if(nums.length<=1){
            return nums;
        }
        int indexLeftOfInflexion = -1;
        int indexRightOfInflexion = 1;
        int indexOfInflexion = 0;
        int [] result = new int[nums.length-1];



        return result;
    }

    public static void main(String[] args) {
        int [] input = new int[]{-4,-1,0,3,10};
        int [] output = sortedSquares(input);
        System.out.println(Arrays.toString(output));
    }
}
