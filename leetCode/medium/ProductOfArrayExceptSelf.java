package src.src.leetCode.medium;

import java.util.Arrays;
import java.util.Collections;

public class ProductOfArrayExceptSelf {

    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all
    the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.
     */
    public static int[] productExceptSelf(int[] nums) {

        int [] preProduct = new int[nums.length];
        int [] postProduct = new int[nums.length];
        Arrays.fill(preProduct, 1);
        Arrays.fill(postProduct, 1);

        int numZeros = 0;

        if(nums.length == 1){
            return nums;
        }
        preProduct[0] = 1;
        postProduct[nums.length-1] = 1;

        for(int i = 1; i <= nums.length - 1; i++){
            preProduct[i] = preProduct[i - 1] * nums[i - 1];
            postProduct[nums.length - 1 - i] = postProduct[nums.length - i] * nums[nums.length - i];
        }

        int [] answer = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            answer[i] = preProduct[i] * postProduct[i];
        }

        return answer;

    }

    public static void main(String[] args) {
        int [] test = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(test)));
    }

}
