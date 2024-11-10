package src.src.leetCode.medium;

import src.src.leetCodeUtils.TreeNode;

import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestZigZagPathInABinaryTree {
    
    /*
    * You are given the root of a binary tree.
    * A ZigZag path for a binary tree is defined as follow:
    * Choose any node in the binary tree and a direction (right or left).
    * If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
    * Change the direction from right to left or from left to right.
    * Repeat the second and third steps until you can't move in the tree.
    * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
    * Return the longest ZigZag path contained in that tree.
    */

    static int pathLength = 0;
    public static int longestZigZag(TreeNode root) {
        dfs(root, false, 0);
        dfs(root, true, 0);
        return pathLength;
    }

    private static void dfs(TreeNode node, boolean goLeft, int steps) {
        if (node == null) {
            return;
        }
        pathLength = Math.max(pathLength, steps);
        if (goLeft) {
            dfs(node.getLeft(), false, steps + 1);
            dfs(node.getRight(), true, 1);
        } else {
            dfs(node.getLeft(), false, 1);
            dfs(node.getRight(), true, steps + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null, new TreeNode(1,
                new TreeNode(1), new TreeNode(1,
                            new TreeNode(1), new TreeNode(1))));
        int res = longestZigZag(root);
        System.out.println(res);
    }
}
