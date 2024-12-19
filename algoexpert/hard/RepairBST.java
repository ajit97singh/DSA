package src.src.algoexpert.hard;

public class RepairBST {

    public static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST repairBst(BST tree) {
        // Write your code here.
        BST one = invalidValues(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        BST two = find(tree, one.value);
        int oneVAl = one.value;
        one.value = two.value;
        two.value = oneVAl;
        return tree;
    }

    public static BST invalidValues(BST node, int min, int max) {
        if (node == null) {
            return null;
        }
        if (node.value > max || node.value < min) {
            return node;
        }
        BST left = invalidValues(node.left, min, node.value-1);
        BST right = invalidValues(node.right, node.value+1, max);

        if (left != null) {
            return left;
        }
        return right;
    }


    public static BST find(BST node, int val) {
        while (node != null) {
            if (val > node.value) {
                if ((node.left == null || node.value >= node.left.value) && (node.right == null || node.value < node.right.value)) {
                    node = node.right;
                } else {
                    return node;
                }
            } else {
                if ((node.left == null || node.value > node.left.value) && (node.right == null || node.value < node.right.value)) {
                    node = node.left;
                } else {
                    return node;
                }
            }
        }
        return null;
    }


    public static void main(String [] args){
        BST root = new BST(10);
        root.left = new BST(7);
        root.right = new BST(20);
        root.right.right = new BST(22);
        root.right.left = new BST(8);
        root.right.left.right = new BST(14);
        root.left.left = new BST(3);
        root.left.right = new BST(12);
        root.left.left.left = new BST(2);

        BST res = repairBst(root);
        res = null;
    }


}
