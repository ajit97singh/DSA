package src.src.leetCode.easy;

import src.src.leetCodeUtils.TreeNode;

public class PathSum {


    public boolean solution(TreeNode root, int target) {
        return dfs(root, target, 0);
    }
    public boolean dfs(TreeNode node, int target, int sumSoFar) {
        if (node == null) {
            return false;
        }

        // go left
        if (dfs(node.left, target, sumSoFar + node.val)){
            return true;
        }
        // process
        if (sumSoFar+node.val == target && node.left == null && node.right == null){
            return true;
        }
        // go right
        return dfs(node.right, target, sumSoFar + node.val);
    }
}
