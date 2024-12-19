package src.src.algoexpert.hard;

import java.util.*;

public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        Arrays.sort(array);
        int leftOut = 0;
        int rightOut = array.length - 1;

        boolean moveLeft = true;

        while (rightOut - leftOut >=3) {
            int leftIn = leftOut+1;
            int rightIn = rightOut-1;
            int sum = 0;
            while (leftIn < rightIn) {
                sum = array[leftOut] + array[leftIn] + array[rightIn] + array[rightOut];
                if(sum < targetSum) {
                    leftIn++;
                }else if(sum > targetSum) {
                    rightIn--;
                }else {
                    Integer[] res = new Integer[]{array[leftOut], array[leftIn], array[rightIn], array[rightOut]};
                    result.add(res);
                    leftIn++;
                }
            }
            System.out.println(result);
            if(sum < targetSum) {
                leftOut++;
                moveLeft = false;
            }else {
                rightOut--;
                moveLeft = true;
            }

        }


        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int target = 10;
        List<Integer[]> res = fourNumberSum(input , target);
        res = null;
    }
}
