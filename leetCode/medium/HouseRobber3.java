package src.src.leetCode.medium;

import src.src.leetCodeUtils.TreeNode;

public class HouseRobber3 {


    public int rob(TreeNode root) {
        int [] result = dfs(root);
        return Math.max(result[0], result[1]);
    }


    int [] dfs(TreeNode node) {
        if(node == null) {
            return new int[]{0,0};
        }
        int [] leftLoot = dfs(node.left);
        int [] rightLoot = dfs(node.right);

        int includingRoot = Math.max(node.val + leftLoot[1] + rightLoot[1], leftLoot[0] + rightLoot[0]);
        int excludingRoot = leftLoot[0] + rightLoot[0];
        return new int[]{includingRoot, excludingRoot};
    }

}
