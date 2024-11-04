package src.src.leetCode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LongestSubArrayOf1sAfterDeletingOneElement {
    /*
    * Given a binary array nums, you should delete one element from it.
    * Return the size of the longest non-empty subArray containing only 1's in the resulting array.
    * Return 0 if there is no such subArray.
    */
    public static int longestSubArray(int[] nums) {

        if(nums.length==0){
            return 0;
        }


        List<Integer> zeroIndices = new ArrayList<>();
        zeroIndices.add(-1);

        for(int index = 0; index < nums.length; index++){
            if(nums[index]==0){
                zeroIndices.add(index);
            }
        }
        zeroIndices.add(nums.length);
        if(zeroIndices.size()==2){
            return nums.length - 1;
        }
        int maxDiff = 0;
        for(int zeroIndex = 0; zeroIndex < zeroIndices.size() - 2; zeroIndex++){
            int leftBoundary = zeroIndices.get(zeroIndex);
            int rightBoundary = zeroIndices.get(zeroIndex+2);
            int diff = rightBoundary - leftBoundary;
            maxDiff = Math.max(diff, maxDiff);
        }
        return maxDiff - 2;
    }

    public static void main(String[] args) {
        // expected output --> 3

        System.out.println(longestSubArray(new int[]{1,1,0,1}));
    }

}
