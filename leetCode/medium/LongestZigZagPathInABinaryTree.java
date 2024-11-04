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

    public static int longestZigZag(TreeNode root) {

        // maintain a stack of zig and zag
        // maintain an int max Size of stack
        // do a dfs
        // return int

        Stack<Character> stack = new Stack<>();
        AtomicInteger max = new AtomicInteger(0);
        dfs(root, stack, max);
        return max.get();
    }

    private static void dfs(TreeNode root, Stack<Character> stack, AtomicInteger max) {
        // left is zig
        // right is zag
        max.set(Math.max(max.get(), stack.size()));
        if (root == null) {
            stack.pop();
            return;
        }
        char c = stack.empty() ? '0' : stack.peek();
        // if node has left
        if (Objects.nonNull(root.getLeft())) {
            if (c == 'l'|| c =='0') {
                dfs(root.getLeft(), new Stack<>(), max);
            } else {
                stack.push('l');
                dfs(root.getLeft(), stack, max);
            }
        }

        // if node has right
        if (Objects.nonNull(root.getRight())) {
            if (c == 'l'|| c =='0' ) {
                stack.push('r');
                dfs(root.getRight(), stack, max);
            } else {
                dfs(root.getRight(), new Stack<>(), max);
            }
        }
    }

    public static void main(String[] args) {
        // [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
        // [1,1,1,null,1,null,null,1,1,null,1]
        // [1]
        TreeNode root = new TreeNode(1,
                null, new TreeNode(1,
                new TreeNode(1), new TreeNode(1,
                            new TreeNode(1), new TreeNode(1))));
        int res = longestZigZag(root);
        System.out.println(res);
    }
}
