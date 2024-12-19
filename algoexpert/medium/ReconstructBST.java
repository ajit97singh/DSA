package src.src.algoexpert.medium;

import java.util.*;

public class ReconstructBST {

    // given a pre-order traversal of a BST construct a BST and return it's head

    public BST solution(ArrayList<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues == null || preOrderTraversalValues.isEmpty()){
            return null;
        }
        BST res = new BST(preOrderTraversalValues.getFirst());
        for(int i = 1; i < preOrderTraversalValues.size(); i++) {
            insert(res, preOrderTraversalValues.get(i));
        }
        return res;
    }

    void insert(BST node, int val) {
        while(true) {
            if (val >= node.value) {
                if (node.right == null) {
                    node.right = new BST(val);
                    return;
                }else {
                    node = node.right;
                }
            }else {
                if (node.left == null) {
                    node.left = new BST(val);
                    return;
                }else {
                    node = node.left;
                }
            }
        }
    }
}
