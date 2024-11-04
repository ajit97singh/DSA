package src.src.leetCode.medium;

import src.src.leetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /*
    * Given an array of distinct integers candidates and a target integer,
    * return a list of all unique combinations of candidates where the chosen numbers sum to target.
    * You may return the combinations in any order.
    * The same number may be chosen from candidates an unlimited number of times.
    * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
    */



    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
        }else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(list, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        // out - [[2,2,3],[7]]
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }
}
