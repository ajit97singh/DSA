package src.src.leetCode.easy;

import src.src.leetCodeUtils.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LeafSimilarTrees {
    /*
    Consider all the leaves of a binary tree,
    from left to right order, the values of those leaves form a leaf value sequence.

    For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
    Two binary trees are considered leaf-similar if their leaf value sequence is the same.
    Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
    */

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        dfs(root1, queue1);
        dfs(root2, queue2);

        if (queue1.size() != queue2.size()) {
            return false;
        }else {
            while (!queue1.isEmpty()) {
                int element1 = queue1.poll();
                int element2 = queue2.poll();
                if (element2 != element1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void dfs (TreeNode node, Queue<Integer> queue) {
        // process node
        // terminating condition
        if (Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())) {
            // this is a leaf node
            queue.add(node.getVal());
            return;
        }
        // recursion
        if (Objects.nonNull(node.getLeft())) {
            dfs(node.getLeft(), queue);
        }
        if (Objects.nonNull(node.getRight())) {
            dfs(node.getRight(), queue);
        }

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode();
        TreeNode root2 = new TreeNode();
        boolean output = leafSimilar(root1, root2);
        System.out.println(output);
    }
}
