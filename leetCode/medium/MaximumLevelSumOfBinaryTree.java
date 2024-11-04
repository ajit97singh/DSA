package src.src.leetCode.medium;

import src.src.leetCodeUtils.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximumLevelSumOfBinaryTree {

    /*
    Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
    Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
    */

    public static int maxLevelSum(TreeNode root) {

        // do bfs but need a separate queue to keep track of the current level
        // so we will have two queues

        // main queue, this will be used to add children
        Queue<TreeNode> mainQueue = new LinkedList<>();
        // this will be used to make level wise calculation
        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);

        // variables to keep track of the process
        int level = 1;
        AtomicInteger maxSumLevel = new AtomicInteger(1);
        AtomicInteger maxSum = new AtomicInteger(Integer.MIN_VALUE);

        while (!mainQueue.isEmpty() || !currentLevel.isEmpty()) {

            // if main queue is empty, fill it with current level, and clear the current level
            if (mainQueue.isEmpty()) {
                mainQueue.addAll(currentLevel.stream().toList());
                processCurrentLevel(maxSumLevel, level, maxSum, currentLevel);
                currentLevel.clear();
                level++;
            }

            // process the main queue
            TreeNode element = mainQueue.poll();
//            if (Objects.isNull(element)) {
//                continue;
//            }
            if (Objects.nonNull(element.getLeft())) {
                currentLevel.add(element.getLeft());
            }
            if (Objects.nonNull(element.getRight())) {
                currentLevel.add(element.getRight());
            }

        }

        return maxSumLevel.get();
    }

    public static void processCurrentLevel (AtomicInteger maxSumLevel, int level,  AtomicInteger maxSum, Queue<TreeNode> currentLevel) {
        int currentSum = currentLevel.stream().map(TreeNode::getVal).reduce(0, Integer::sum);
        if (currentSum > maxSum.get()) {
            maxSum.set(currentSum);
            maxSumLevel.set(level);
        }
    }

    public static void main(String[] args) {

        //[1,1,0,7,-8,-7,9]
        /*
        *          1
        *     1         0
        * 7     -8   -7      9
        * */
        TreeNode input = new TreeNode(1);
        input.setLeft(new TreeNode(1));
        input.getLeft().setLeft(new TreeNode(7));
        input.getLeft().setRight(new TreeNode(-8));

        input.setRight(new TreeNode(0));
        input.getRight().setLeft(new TreeNode(7));
        input.getRight().setRight(new TreeNode(9));
        int output = maxLevelSum(input);
        System.out.println(output);
    }

}
