package src.src.leetCode.easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindTheDifferenceOfTwoArrays {

    /*
       Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
       answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
       answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
       Note that the integers in the lists may be returned in any order.
    */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> nums1Elements = new HashSet<>();
        HashSet<Integer> nums2Elements = new HashSet<>();
        for(int x: nums1){
            nums1Elements.add(x);
        }
        for(int x: nums2){
            nums2Elements.add(x);
        }
        List<Integer> res1 = nums1Elements.stream().filter(x -> !nums2Elements.contains(x)).collect(Collectors.toList());
        List<Integer> res2 = nums2Elements.stream().filter(x -> !nums1Elements.contains(x)).collect(Collectors.toList());
        result.add(res1);
        result.add(res2);
        return result;

    }

}
