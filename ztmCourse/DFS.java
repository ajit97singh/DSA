package src.src.ztmCourse;

import src.src.leetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DFS {
//    9
//   4  20
// 1 6  15 170
//    inOrder = [1. 4. 6. 9. 15, 20, 170]
//    preOrder = [9, 4, 1, 6, 20, 15, 170]
//    postOrder = [1, 6, 4, 15 ,170, 20, 9]

    public static void inOrder(TreeNode node, List<Integer> list){
        if(Objects.nonNull(node.getLeft())){
            inOrder(node.getLeft(), list);
        }
        list.add(node.getVal());
        if(Objects.nonNull(node.getRight())){
            inOrder(node.getRight(), list);
        }
    }

    public static void preOrder(TreeNode node, List<Integer> list){
        list.add(node.getVal());
        if(Objects.nonNull(node.getLeft())){
            preOrder(node.getLeft(), list);
        }
        if(Objects.nonNull(node.getRight())){
            preOrder(node.getRight(), list);
        }
    }

    public static void postOrder(TreeNode node, List<Integer> list){
        if(Objects.nonNull(node.getLeft())){
            postOrder(node.getLeft(), list);
        }
        if(Objects.nonNull(node.getRight())){
            postOrder(node.getRight(), list);
        }
        list.add(node.getVal());
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.setLeft(new TreeNode(4));
        root.setRight(new TreeNode(20));
        root.getLeft().setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(6));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(200));

        List<Integer> lst = new ArrayList<>();

        inOrder(root, lst);
        System.out.println(lst);
        lst.clear();

        preOrder(root, lst);
        System.out.println(lst);
        lst.clear();

        postOrder(root, lst);
        System.out.println(lst);
    }

}
