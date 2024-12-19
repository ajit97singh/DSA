package src.src.algoexpert.medium;

import java.util.*;

public class KthLargestElementOfBST {

    int solution(BST tree, int k) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        dfs(tree, k, stack);
        return stack.pop();
    }

    void dfs(BST node, int k, Stack<Integer> stack) {
        if (node == null) {
            return;
        }
        // go right
        dfs(node.right, k, stack);
        // process current
        if (stack.size()==k){
            return;
        }else{
            stack.push(node.value);
        }

        // go left
        dfs(node.left, k, stack);
    }

    public static void main(String[] args) {
        BST root = new BST(5);
        root.insert(10);
        root.insert(2);
        root.insert(17);
        root.insert(16);
        root.insert(19);
        root.insert(22);

        int res = new KthLargestElementOfBST().solution(root, 3);
        res = 12;

    }

}
