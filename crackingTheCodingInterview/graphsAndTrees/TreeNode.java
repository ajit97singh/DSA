package src.src.crackingTheCodingInterview.graphsAndTrees;

public class TreeNode {


    int value;
    public TreeNode left;
    public TreeNode right;
    TreeNode parent;



    public TreeNode(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }



    TreeNode(int val, TreeNode l, TreeNode r) {
        this.value = val;
        this.left = l;
        this.right = r;
    }



}
