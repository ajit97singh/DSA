package src.src.algoexpert.medium;

public class SplitBinaryTree {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public int sum;
        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static int splitBinaryTree(BinaryTree tree) {
        // Write your code here.
        int totalSum = initializeSum(tree);

        return findSplit(tree, totalSum);
    }

    public static int initializeSum(BinaryTree node) {
        if (node == null){
            return 0;
        }
        int left = initializeSum(node.left);
        int right = initializeSum(node.right);
        node.sum = node.value + left + right;
        return node.sum;
    }

    public static int findSplit(BinaryTree node, int totalSum) {
        if (node == null){
            return 0;
        }
        if (node.sum == totalSum - node.sum){
            return node.sum;
        }

        int left = findSplit(node.left, totalSum);
        int right = findSplit(node.right, totalSum);
        if (left + right >= 0){
            return left + right;
        }

        return 0;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(-2);
        root.right = new BinaryTree(-2);
        int res = splitBinaryTree(root);
        res = 1;
    }
}
