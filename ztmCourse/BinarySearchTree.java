package src.src.ztmCourse;

import src.src.leetCodeUtils.TreeNode;

import java.util.Objects;

public class BinarySearchTree {
    private TreeNode root;
    private TreeNode left;
    private TreeNode right;

    public BinarySearchTree(int value) {
        this.root = new TreeNode(value);
        this.left = null;
        this.right = null;
    }
    public BinarySearchTree insert(Integer value) {
        if(Objects.isNull(this.root)){
            this.root = new TreeNode(value);
        }else {
            TreeNode currentNode = this.root;
            while (true){
                if(value < currentNode.getVal()){
                    if (Objects.isNull(currentNode.getLeft())){
                        currentNode.setLeft(new TreeNode(value));
                        return this;
                    }
                    currentNode = currentNode.getLeft();
                }else {
                    if (Objects.isNull(currentNode.getRight())){
                        currentNode.setRight(new TreeNode(value));
                        return this;
                    }
                    currentNode = currentNode.getRight();
                }
            }
        }
        return this;
    }

}