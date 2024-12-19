package src.src.leetCode.medium;

import src.src.leetCodeUtils.TreeNode;

import java.util.*;

public class PathSum2 {

    /*
    * Given the root of a binary tree and an integer targetSum,
    * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
    * Each path should be returned as a list of the node values, not node references.
    * A root-to-leaf path is a path starting from the root and ending at any leaf node.
    * A leaf is a node with no children.
    */

    List<List<Integer>> solution(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,target, 0, new Stack<>(), res);
        return res;
    }

    void dfs(TreeNode node,int target, int sumSoFar, Stack<Integer> pathSoFar, List<List<Integer>> result) {

        if (node == null) {
            return;
        }

        // process
        int sum = sumSoFar + node.val;
        pathSoFar.push(node.val);

        if (node.left == null && node.right == null) {
            if (sum == target) {
                result.add(new ArrayList<>(pathSoFar));
            }
        }
        // go left
        dfs(node.left, target, sum, pathSoFar, result);

        // go right
        dfs(node.right, target, sum, pathSoFar, result);
        pathSoFar.pop();

    }

}
