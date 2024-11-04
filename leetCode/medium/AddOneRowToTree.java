package src.src.leetCode.medium;


import src.src.leetCodeUtils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

    /*
    Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth.
    Note that the root node is at depth 1.
     */

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth <= 0 || root == null){
            return null;
        }

        int currentDepth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

//        while (!queue.isEmpty()){
            // process elements in queue and remove them
            // add children to queue
            // increase depth

//        }
        return root;
    }


    public static void emptyCurrentQueueAndAddChildren(Queue<TreeNode> currentDeptNodes, Queue<TreeNode> childrenNodes){

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(6));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().setRight(new TreeNode(1));
        root.getRight().setLeft(new TreeNode(5));

        TreeNode altered = addOneRow(root, 1, 2);
        System.out.println(altered.toString());
    }

}
