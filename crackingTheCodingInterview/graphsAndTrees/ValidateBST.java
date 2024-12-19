package src.src.crackingTheCodingInterview.graphsAndTrees;

public class ValidateBST {

    int previousVal = Integer.MIN_VALUE;

    // do in inorder traversal and check if current value is greater than previous val
    boolean solution1(TreeNode node) {

        // base case
        if (node == null) {
            return true;
        }

        // go left
        if (!solution1(node.left)) {
            return false;
        }

        // process current
        if (previousVal > node.value ) {
            return false;
        }else {
            previousVal = node.value;
        }

        // go right
        return solution1(node.right);
    }

    boolean solution2(TreeNode root) {

        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    boolean checkBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        // go left
        if (!checkBST(node.left, min, node.value )){
            return false;
        }

        // process current
        if (node.value >= max || node.value < min) {
            return false;
        }

        // process right
        return checkBST(node.right, node.value, max);
    }

//                      5
//                  2       7
//                1   3    6  9
//                           8  10



    public static void main(String [] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(10);

        boolean out = new ValidateBST().solution2(root);
        System.out.println(out);
    }



}
