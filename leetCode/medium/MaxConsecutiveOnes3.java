package src.src.leetCode.medium;

public class MaxConsecutiveOnes3 {
    /*
    Given a binary array nums and an integer k, return the maximum number of
    consecutive 1's in the array if you can flip at most k 0's.
    */

    public static int longestOnes(int[] nums, int k) {


        int numberOfZeros = 0;
        int index = 0;
        while (numberOfZeros < k && index < nums.length){
            if(nums[index]==0){
                numberOfZeros++;
            }
            index++;
        }
        while(index < nums.length && nums[index]!=0){
            index++;
        }
        int leftZeroIndex = -1;
        int rightZeroIndex = index;

        int maxConsecutiveOnes = rightZeroIndex - leftZeroIndex - 1;

        while (rightZeroIndex <= nums.length){
            if(rightZeroIndex == nums.length){
                break;
            }

            for(int i = leftZeroIndex+1; i<=rightZeroIndex; i++){
                if(nums[i] == 0){
                    leftZeroIndex = i;
                    break;
                }
            }

            for(int i = rightZeroIndex+1; i<=nums.length; i++){
                if(i == nums.length || nums[i] == 0){
                    rightZeroIndex = i;
                    break;
                }
            }

            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, rightZeroIndex - leftZeroIndex - 1);

        }
        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        // expected 6
        System.out.println(longestOnes(new int[]{0,0,1,1,1,0,0}, 0));

    }
}
