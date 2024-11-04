package src.src.leetCode.medium;

import java.util.Arrays;

public class SortColors {

    /*
    Given an array nums with n objects colored red, white, or blue,
    sort them in-place so that objects of the same color are adjacent,
    with the colors in the order red, white, and blue.
    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    You must solve this problem without using the library's sort function.
    */

    public static void sortColors(int[] nums) {
        int length = nums.length;
        if(length <=1){
            return;
        }
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for (int num : nums) {
            switch (num) {
                case 0: {
                    redCount++;
                    break;
                }
                case 1: {
                    whiteCount++;
                    break;
                }
                case 2: {
                    blueCount++;
                    break;
                }
            }
        }
        for (int i = 0; i < length; i++){
            if(redCount > 0){
                nums[i] = 0;
                redCount--;
            } else if (whiteCount > 0) {
                nums[i] = 1;
                whiteCount--;
            } else if (blueCount > 0) {
                nums[i] = 2;
                blueCount--;
            }
        }
    }


    public static void main(String[] args) {
        int [] input = new int[]{2,0,2,1,1,0};
        sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}