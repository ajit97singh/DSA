package src.src.ztmCourse;

import src.src.leetCodeUtils.TreeNode;

import java.util.*;
import java.util.LinkedList;

public class BFS {

    public static List<Integer> solution(TreeNode root){
        List<Integer> lst = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            lst.add(currentNode.getVal());
            if(Objects.nonNull(currentNode.getLeft())){
                queue.add(currentNode.getLeft());
            }
            if(Objects.nonNull(currentNode.getRight())){
                queue.add(currentNode.getRight());
            }
        }
        return lst;
    }

    public static List<Integer> solutionR(Queue<TreeNode> queue, List<Integer> result){
        if(queue.isEmpty()){
           return result;
        }
        TreeNode currentNode = queue.poll();
        result.add(currentNode.getVal());
        if(Objects.nonNull(currentNode.getLeft())){
            queue.add(currentNode.getLeft());
        }
        if (Objects.nonNull(currentNode.getRight())){
            queue.add(currentNode.getRight());
        }
        return solutionR(queue, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.setLeft(new TreeNode(4));
        root.setRight(new TreeNode(20));
        root.getLeft().setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(6));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(200));

        System.out.println(solution(root));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.println(solutionR(queue, new ArrayList<>()));
    }

}
