package src.src.leetCode.medium;

import src.src.leetCodeUtils.TreeNode;
import src.src.ztmCourse.Node;

import java.util.Objects;

public class SumRootToLeafNumbers {
    /*
    You are given the root of a binary tree containing digits from 0 to 9 only.
    Each root-to-leaf path in the tree represents a number.
    For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
    Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
    A leaf node is a node with no children.
    */

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode node, String numberString, Integer sum){
        if(Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())){
            sum = sum + Integer.parseInt(numberString + node.getVal());
            return sum;
        }
        numberString = numberString + node.getVal();
        sum = dfs(node.getLeft(), numberString, sum);
        sum = dfs(node.getRight(), numberString, sum);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        int result  = sumNumbers(root);
        System.out.println(result);
    }

    // faster approach without using extra-space of string
    public static int dfs(TreeNode node, int sum){
        if(Objects.isNull(node.getVal())){
            return 0;
        }
        sum = sum*10 + node.getVal();
        if(Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())){
            return sum;
        }
        return dfs(node.getLeft(), sum) + dfs(node.getRight(), sum);
    }

}
