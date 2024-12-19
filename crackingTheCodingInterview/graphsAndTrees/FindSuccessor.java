package src.src.crackingTheCodingInterview.graphsAndTrees;

public class FindSuccessor {


    TreeNode solution( TreeNode node ) {

        if ( node.right != null ) {
              return findLeftMost(node.right);
        }

//        if (node.parent != null && node.parent.value >= node.value) {
//            return node.parent;
//        }
//        return null;

        TreeNode q = node;
        TreeNode x = q.parent;
        // Go up until we're on left instead of right
         while (x != null && x.left != q) {
             q = x;
             x = x.parent;
         }
         return x;

    }

    TreeNode findLeftMost(TreeNode n) {
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }




}
