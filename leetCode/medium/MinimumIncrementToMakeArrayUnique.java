package src.src.leetCode.medium;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class MinimumIncrementToMakeArrayUnique {
    /*
    You are given an integer array nums.
    In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
    Return the minimum number of moves to make every value in nums unique.
    The test cases are generated so that the answer fits in a 32-bit integer.
    */


    public static int minIncrementForUnique(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        AtomicInteger moves = new AtomicInteger(0);
        for(int num: nums){
            if(set.contains(num)){
                while (set.contains(num)){
                    moves.getAndIncrement();
                    num++;
                }
            }
            set.add(num);
        }

        return moves.get();
    }

    public static void main(String[] args) {
        int [] input = new int[]{3,2,1,2,1,7};
        int output = minIncrementForUnique(input);
        //expected = 6
        System.out.println(output);

    }
}
