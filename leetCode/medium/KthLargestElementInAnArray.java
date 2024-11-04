package src.src.leetCode.medium;

import java.util.SortedSet;
import java.util.TreeSet;

public class KthLargestElementInAnArray {

    /*
    Given an integer array nums and an integer k, return the kth largest element in the array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.
    Can you solve it without sorting?
    */

    public static int findKthLargest(int[] nums, int k) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i: nums) {
            set.add(i);
        }

        return set.stream().toList().get(nums.length - k + 1);
    }

    public static void main(String[] args) {
        int [] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        int output = findKthLargest(nums, k); // 5
        System.out.println(output);
    }

}
