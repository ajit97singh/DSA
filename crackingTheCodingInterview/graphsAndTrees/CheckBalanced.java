package src.src.crackingTheCodingInterview.graphsAndTrees;


public class CheckBalanced {

    static boolean balanced = true;

    boolean solution(TreeNode root) {
        dfs(root);
        return balanced;
    }


    int dfs(TreeNode root) {
        if (!balanced) {
            return 0;
        }

        if(root.left == null && root.right==null) {
            return 1;
        }

        int leftDepth = 0;
        int rightDepth = 0;

        if ( root.left != null ) {
            leftDepth = 1 + dfs(root.left);
        }

        if ( root.right != null ) {
            rightDepth = 1 + dfs(root.right);
        }

        if (Math.abs(leftDepth - rightDepth) > 1 && balanced) {
            balanced = false;
        }

        return Math.max(leftDepth, rightDepth);
    }


    public static void main(String [] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(1);
//        root.right.right = new TreeNode(1);
//        root.right.right.left = new TreeNode(1);
//        root.right.right.right = new TreeNode(1);
//        root.right.right.left.right = new TreeNode(1);

        boolean out = new CheckBalanced().solution(root);

        System.out.println(out);

    }

}
