package src.src.leetCode.medium;

import src.src.leetCodeUtils.TreeNode;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

// TODO: UNSOLVED, find by binary search and delete by dfs, doing opposite here

public class DeleteNodeInABST {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.getLeft() == null && root.getRight() == null) {
            if (root.getVal() == key) {
                return null;
            } else {
                return root;
            }
        }

        TreeNode nodeToDelete = dfs(root, key, new AtomicBoolean(false));

        if (nodeToDelete == null) {
            return root;
        }

        while (nodeToDelete.getLeft() != null || nodeToDelete.getRight() != null) {
            TreeNode leftNode = nodeToDelete.getLeft();
            TreeNode rightNode = nodeToDelete.getRight();
            if ((Objects.nonNull(leftNode) && key < leftNode.getVal()) || Objects.isNull(rightNode)) {
                int tempVal = leftNode.getVal();
                nodeToDelete.setVal(tempVal);
                leftNode.setVal(key);
                nodeToDelete = leftNode;
            } else if ((Objects.nonNull(rightNode) && key > rightNode.getVal()) || Objects.isNull(leftNode)) {
                int tempVal = rightNode.getVal();
                nodeToDelete.setVal(tempVal);
                rightNode.setVal(key);
                nodeToDelete = rightNode;
            } else {
                // initiate swap
                if(Objects.nonNull(leftNode)) {
                    int tempVal = leftNode.getVal();
                    nodeToDelete.setVal(tempVal);
                    leftNode.setVal(key);
                    nodeToDelete = leftNode;
                } else {
                    int tempVal = rightNode.getVal();
                    nodeToDelete.setVal(tempVal);
                    rightNode.setVal(key);
                    nodeToDelete = rightNode;
                }
            }
        }
        TreeNode currentNode = root;
        while (currentNode.getVal() != key) {
            TreeNode left = currentNode.getLeft();
            TreeNode right = currentNode.getRight();
            if (Objects.nonNull(left) && key < currentNode.getVal()) {
                if (currentNode.getLeft().getVal() == key) {
                    currentNode.setLeft(null);
                    break;
                }
                currentNode = currentNode.getLeft();
            }else {
                if (Objects.nonNull(right) && key > currentNode.getVal()) {
                    if (currentNode.getRight().getVal() == key) {
                        currentNode.setRight(null);
                        break;
                    }
                    currentNode = currentNode.getRight();
                }
            }
        }

        return root;
    }


    public static TreeNode dfs(TreeNode root, int key, AtomicBoolean keyFound) {
        TreeNode result = null;
        if (root == null) {
            return null;
        }
        if (root.getVal() == key) {
            keyFound.set(true);
            result = root;
        }
        // go left
        if (Objects.nonNull(root.getLeft()) && !keyFound.get()) {
            result = dfs(root.getLeft(), key, keyFound);
        }
        // go right
        if (Objects.nonNull(root.getRight()) && !keyFound.get()) {
            result = dfs(root.getRight(), key, keyFound);
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode input = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)) , new TreeNode(6, null, new TreeNode(7)));
        /*
        *           5
        *       3       6
        *     2   4        7
        *
        *           5
        *       3       6
        *         4         7
        *
        * */

        System.out.println(input);
        TreeNode output = deleteNode(input, 3);
        System.out.println(output);
    }
}
