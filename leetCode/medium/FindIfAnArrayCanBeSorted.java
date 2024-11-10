package src.src.leetCode.medium;

public class FindIfAnArrayCanBeSorted {
    /*
    * You are given a 0-indexed array of positive integers nums.
    * In one operation, you can swap any two adjacent elements if they have the same number of set bits.
    * You are allowed to do this operation any number of times (including zero).
    * Return true if you can sort the array, else return false.
    * */

    public static boolean canSortArray(int[] nums) {

        if (nums == null || nums.length == 0){
            return true;
        }

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int prev = nums[i - 1];

            if (prev > current && Integer.bitCount(prev) == Integer.bitCount(current)) {
                nums[i] = prev;
                nums[i - 1] = current;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSortArray(new int[]{1,2,3}));
    }
}
