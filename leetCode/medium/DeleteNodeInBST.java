package src.src.leetCode.medium;

public class DeleteNodeInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key){
            this.val = key;
        }

        public TreeNode(int key, TreeNode l, TreeNode r){
            this.val = key;
            this.left = l;
            this.right = r;
        }

        public TreeNode findNode(int keyToFind) {
            TreeNode current = this;
            while (current != null) {
                if(current.val == keyToFind){
                    return current;
                }else if(current.val > keyToFind) {
                    current = current.left;
                }else {
                    current = current.right;
                }
            }
            return null;
        }

        public TreeNode findParentNode(int keyToFind) {
            TreeNode parent = null;
            TreeNode current = this;
            while (current != null) {
                if(current.val == keyToFind){
                    return parent;
                }else if(current.val > keyToFind) {
                    parent = current;
                    current = current.left;
                }else {
                    parent = current;
                    current = current.right;
                }
            }
            return parent;
        }

        private TreeNode findLeftMost(){
            TreeNode current = this;
            while (current.left != null){
                current = current.left;
            }
            return current;
        }


        public void delete(int key) {
            TreeNode toDelete = findNode(key);
            TreeNode parent = findParentNode(key);
            boolean isLeftChild = parent.left == toDelete;
            if (toDelete == null){
                return;
            }
            // if node has no children
            if (toDelete.left == null && toDelete.right == null){
                if(isLeftChild){
                    parent.left = null;
                }else {
                    parent.right = null;
                }
            }else if (toDelete.left == null) {
                if(isLeftChild){
                    parent.left = toDelete.right;
                }else {
                    parent.right = toDelete.right;
                }
            }else if (toDelete.right == null) {
                if(isLeftChild){
                    parent.left = toDelete.left;
                }else {
                    parent.right = toDelete.left;
                }
            }else {
                // find left most of right subtree
                TreeNode leftMost = toDelete.right.findLeftMost();
                TreeNode parentLeftMost = findParentNode(leftMost.val);
                toDelete.val = leftMost.val;
                parentLeftMost.left = null;
            }

        }
    }


    /*
    * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
    * Return the root node reference (possibly updated) of the BST.
    * Basically, the deletion can be divided into two stages:
    * Search for a node to remove.
    * If the node is found, delete the node.
    * */

    public TreeNode deleteNode(TreeNode root, int key) {
        root.delete(key);
        return root;
    }

}
