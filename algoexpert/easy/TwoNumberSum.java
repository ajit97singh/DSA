package src.src.algoexpert.easy;

import java.util.HashSet;

public class TwoNumberSum {

//    Write a function that takes in a non-empty array of distinct integers and an integer representing  a target sum.
//    If any two numbers in the array sum up to the target sum, the function should return them in an array, in any
//    order. If no two numbers sum up to target the function should return an empty array.

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashSet<Integer> set = new HashSet<>();

        for(int element: array) {
            int complement = targetSum - element;
            if (set.contains(element)){
                return new int[]{element, complement};
            } else {
                set.add(complement);
            }
        }
        return new int[0];
    }
}
