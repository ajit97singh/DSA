package src.src.crackingTheCodingInterview.graphsAndTrees;

import java.util.*;
// Given BST return all lists than can build the given BST


public class BSTSequences {

    List<List<Integer>> solution(TreeNode root) {
        // do a post order dfs
        // get List of List of integers from each child and interweave them and prepend the current node
        List<List<Integer>> res = new ArrayList<>();
        return getPostOrder(root, res);

    }

    List<List<Integer>> getPostOrder(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> left = getPostOrder(node.left, res);
        List<List<Integer>> right = getPostOrder(node.right, res);
        List<List<Integer>> currentSubtreeRes = new ArrayList<>();
        for(List<Integer> leftSeq: left) {
            for(List<Integer> rightSeq: right) {
                interWeave(leftSeq, rightSeq, 0,0, currentSubtreeRes, new ArrayList<>());
            }
        }
        if (currentSubtreeRes.isEmpty()) {
            currentSubtreeRes.add(new ArrayList<>());
        }
        for (List<Integer> list: currentSubtreeRes) {
            list.addFirst(node.value);
        }

        return currentSubtreeRes;
    }

    void interWeave(List<Integer> l1, List<Integer> l2, int l1Index, int l2Index, List<List<Integer>> result, List<Integer> current) {
        if (l1Index == l1.size() && l2Index == l2.size()) {
            result.add(current);
        }

        if (l1Index < l1.size()) {
            List<Integer> toAdd = new ArrayList<>(current);
            toAdd.add(l1.get(l1Index));
            interWeave(l1, l2, l1Index+1, l2Index, result, toAdd);
        }

        if (l2Index < l2.size()) {
            List<Integer> toAdd = new ArrayList<>(current);
            toAdd.add(l2.get(l2Index));
            interWeave(l1, l2, l1Index, l2Index+1, result, toAdd);
        }
    }





    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);
//        root.right.right.left = new TreeNode(8);
//        root.right.right.right = new TreeNode(10);

        List<List<Integer>> solution = new BSTSequences().solution(root);
        solution = null;
    }
}
