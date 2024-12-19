package src.src.crackingTheCodingInterview.graphsAndTrees;

public class FirstCommonAncestor {

    TreeNode solution(TreeNode root, TreeNode a, TreeNode b) {
        return dfs(root, a, b);
    }

    TreeNode dfs(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b) {
            return root;
        }

        TreeNode left = dfs(root.left, a, b);
        TreeNode right = dfs(root.right, a, b);

        if (left == null) {
            return right;
        }else if (right == null) {
            return left;
        }else {
            return root;
        }


    }

    public static void main(String [] args) {

        TreeNode nodeA = new TreeNode(100);
        TreeNode nodeB = new TreeNode(200);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = nodeA;
        root.right.right.left = new TreeNode(8);
        root.right.right.right = nodeB;

        int a = -75;
        int b = a >> 1;
        System.out.println(b);

        TreeNode out = new FirstCommonAncestor().solution(root, nodeA, nodeB );




    }
}
