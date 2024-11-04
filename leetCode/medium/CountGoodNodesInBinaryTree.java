package src.src.leetCode.medium;

import src.src.leetCodeUtils.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class CountGoodNodesInBinaryTree {
    //Unsolved
    /*
    Given a binary tree root, a node X in the tree is named good if in the path from root to X
    there are no nodes with a value greater than X.
    Return the number of good nodes in the binary tree.
    */

    public static int goodNodes(TreeNode root) {
        AtomicInteger result = new AtomicInteger(0);
        int maxSoFar = Integer.MIN_VALUE;
        // will do a dfs
        // along the path just check if the node val is >= max so far
        // increment the result if so, else go on
        dfs(root, maxSoFar, result);
        return result.get();
    }

    public static void dfs(TreeNode node, int maxSoFar, AtomicInteger result) {
        // process the current node
        if (node.getVal() >= maxSoFar) {
            result.incrementAndGet();
            maxSoFar = node.getVal();
        }
        // terminating condition
        if ( Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight()) ) {
            return;
        }
        // recursion
        if (Objects.nonNull(node.getLeft())) {
            dfs(node.getLeft(), maxSoFar, result);
        }
        if (Objects.nonNull(node.getRight())) {
            dfs(node.getRight(), maxSoFar, result);
        }
    }

    public static void main(String[] args) {
        TreeNode input = new TreeNode(3, new TreeNode(1), new TreeNode(4));
        input.getLeft().setLeft(new TreeNode(3));
        input.getRight().setLeft(new TreeNode(1));
        input.getRight().setRight(new TreeNode(5));
        int output = goodNodes(input);
        System.out.println(output);
    }

}
