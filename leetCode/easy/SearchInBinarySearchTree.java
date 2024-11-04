package src.src.leetCode.easy;

import src.src.leetCodeUtils.TreeNode;

public class SearchInBinarySearchTree {

    /*
    * You are given the root of a binary search tree (BST) and an integer val.
    * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
    * If such a node does not exist, return null.
    */

    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (val == currentNode.getVal()) {
                return currentNode;
            } else if (val < currentNode.getVal()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7));
        root.getLeft().setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(3));
        TreeNode result = searchBST(root, 2);
        System.out.println(result);
    }
}
