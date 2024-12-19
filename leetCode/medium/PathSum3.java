package src.src.leetCode.medium;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
* Given the root of a binary tree and an integer targetSum,
* return the number of paths where the sum of the values along the path equals targetSum.
* The path does not need to start or end at the root or a leaf,
* but it must go downwards (i.e., traveling only from parent nodes to child nodes).
*/

import src.src.leetCodeUtils.TreeNode;

public class PathSum3 {

    int solution(TreeNode root, int targetSum) {
        AtomicInteger res = new AtomicInteger(0);
        dfs(root, new ArrayList<>(), targetSum, res);
        return res.get();
    }

    void dfs (TreeNode node, List<Integer> pathSoFar, int targetSum, AtomicInteger result) {
        if (node == null) {
            return;
        }
        // process
        for (int i = 0; i < pathSoFar.size(); i++) {
            pathSoFar.set(i, pathSoFar.get(i) + node.val);
        }
        pathSoFar.add(node.val);

        for(Integer pathSums: pathSoFar) {
            if(pathSums == targetSum) {
                result.getAndIncrement();
            }
        }
        // left
        dfs(node.left, pathSoFar, targetSum,result);
        //right
        dfs(node.right, pathSoFar, targetSum,result);
        //remove last
        for (int i = 0; i < pathSoFar.size(); i++) {
            pathSoFar.set(i, pathSoFar.get(i) - node.val);
        }
        pathSoFar.removeLast();
    }

    public static void main(String[] args) {
        //[10,5,-3,3,2,null,11,3,-2,null,1]
        //                 10
        //             5         -3
        //          3     2          11
        //        3  -2     1
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
//        [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
        TreeNode root2 = new TreeNode(1000000000);
        root2.left = new TreeNode(1000000000);
        root2.left.left = new TreeNode(294967296);
        root2.left.left.left = new TreeNode(1000000000);
        root2.left.left.left.left = new TreeNode(1000000000);
        root2.left.left.left.left.left = new TreeNode(1000000000);
        int res = new PathSum3().solution(root2, 0);
        res = 1;
    }
}
