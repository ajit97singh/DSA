package src.src.leetCode.medium;

import src.src.leetCodeUtils.Pair;
import src.src.leetCodeUtils.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {
    /*
    * Given the root of a binary tree, imagine yourself standing on the right side of it,
    * return the values of the nodes you can see ordered from top to bottom.
    */

    public static List<Integer> rightSideView(TreeNode root) {
        if (Objects.isNull(root)){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> rightSideView = new ArrayList<>();
        Queue<TreeNode> currentLevelQueue = new LinkedList<>();
        currentLevelQueue.add(root);

        while (!currentLevelQueue.isEmpty()){
            // get element
            TreeNode currentNode = currentLevelQueue.remove();

            if (Objects.nonNull(currentNode.getLeft())){
                queue.add(currentNode.getLeft());
            }
            if (Objects.nonNull(currentNode.getRight())){
                queue.add(currentNode.getRight());
            }

            // process element
            if(currentLevelQueue.isEmpty()){
                rightSideView.add(currentNode.getVal());
                currentLevelQueue.addAll(queue);
                queue.clear();
            }
            //add children


        }

        return rightSideView;

    }

    // Another solution could be to traverse from right to left, keep track of level and use to map to store the right most
    // of each level, in a map check if the level already exists the skip over it

    public static List<Integer> rightSideViewNew(TreeNode root){
        if (Objects.isNull(root)){
            return new ArrayList<>();
        }
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, root));
        HashMap<Integer, Integer> map = new HashMap<>();

        while (!queue.isEmpty()){
            Pair<Integer, TreeNode> element = queue.remove();
            int level = element.getA();
            TreeNode node = element.getB();

            if(!map.containsKey(level)){
                map.put(level, node.getVal());
            }
            if(Objects.nonNull(node.getRight())){
                queue.add(new Pair<>(level+1, node.getRight()));
            }
            if(Objects.nonNull(node.getLeft())){
                queue.add(new Pair<>(level+1, node.getLeft()));
            }
        }
        return map.values().stream().toList();

    }

    public static void main(String[] args) {
        //input
//        1 <--
//      2   3 <--
//       5    4 <--
        // output -> [1, 3, 4]

        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setRight(new TreeNode(4));
        System.out.println(rightSideViewNew(root));
    }
}
