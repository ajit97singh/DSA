package src.src.leetCode.easy;

import src.src.leetCodeUtils.TreeNode;
import java.util.Objects;


public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        int rightDepth = 0;
        int leftDepth = 0;
        if (Objects.isNull(root.getLeft()) && Objects.isNull(root.getRight())){
            return 1;
        }
        if(!Objects.isNull(root.getLeft())){
            leftDepth = 1 + maxDepth(root.getLeft());
        }
        if(!Objects.isNull(root.getRight())){
            rightDepth = 1 + maxDepth(root.getRight());
        }
        return Math.max(1, Math.max(leftDepth, rightDepth));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.builder()
                .val(3)
                .left(new TreeNode(9))
                .right(new TreeNode(20, new TreeNode(15), new TreeNode(7)))
                .build();
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth(node));
    }


}
