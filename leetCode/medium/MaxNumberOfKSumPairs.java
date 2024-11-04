package src.src.leetCode.medium;

import java.util.HashMap;
import java.util.Objects;

public class MaxNumberOfKSumPairs {
    /*
    You are given an integer array nums and an integer k.
    In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
    Return the maximum number of operations you can perform on the array.
    */

    public static int maxOperations(int[] nums, int k) {

        HashMap<Integer, Integer> complimentTracker = new HashMap<>();
        int maxOperations = 0;

        for (int number: nums) {
            int compliment = k - number;
            if(Objects.nonNull(complimentTracker.get(compliment))){
                maxOperations++;
                int newComplimentCount = complimentTracker.get(compliment) - 1;
                if(newComplimentCount==0){
                    complimentTracker.put(compliment, null);
                }else {
                    complimentTracker.put(compliment, newComplimentCount);
                }

            }else {
                complimentTracker.compute(number, (key, v) -> v == null ? 1 : v + 1);
            }
        }

        return maxOperations;
    }


    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}
