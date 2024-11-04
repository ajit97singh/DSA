package src.src.leetCode.easy;

import java.util.Arrays;

public class IntersectionOfTwoArrays2 {
    /*
    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must appear as many times as it shows in both arrays,
    and you may return the result in any order.
    */

    // Unsolved

    /*
    Follow up:
        - What if the given array is already sorted? How would you optimize your algorithm?
        - What if nums1's size is small compared to nums2's size? Which algorithm is better?
        - What if elements of nums2 are stored on disk,
          and the memory is limited such that you cannot load all elements into the memory at once?
    */

    public static int[] intersect(int[] nums1, int[] nums2) {

        return new int[]{1,2};
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};

        int[] output = intersect(nums1, nums2);
        System.out.println(Arrays.toString(output));
    }
}
