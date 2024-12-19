package src.src.algoexpert.medium;

public class BST {
    int value;
    BST left;
    BST right;

    public BST(int val){
        this.value = val;
    }
    public BST insert(int value) {
        // Write your code here.
        BST nodeToInsert = new BST(value);
        BST currentNode = this;
        while (true) {

            if (value >= currentNode.value) {
                if (currentNode.right == null) {
                    currentNode.right = nodeToInsert;
                    break;
                }else {
                    currentNode = currentNode.right;
                }
            } else {
                if (currentNode.left == null) {
                    currentNode.left = nodeToInsert;
                    break;
                }else {
                    currentNode = currentNode.left;
                }
            }

        }
        return this;
    }

    public boolean contains(int value) {
        // Write your code here.
        BST current = this;

        while (current != null) {

            if (current.value == value) {
                return true;
            }else if (current.value > value) {
                current = current.left;
            } else {
                current = current.right;
            }

        }
        return false;
    }

    private BST get(int value) {
        // Write your code here.
        BST current = this;

        while (current != null) {

            if (current.value == value) {
                return current;
            }else if (current.value > value) {
                current = current.left;
            } else {
                current = current.right;
            }

        }
        return null;
    }

    private BST getParent(int value) {
        BST current = this;
        BST parent = null;
        while (current != null) {
            if (current.value == value) {
                return parent;
            }else if (current.value > value) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        return parent;
    }

    public BST remove(int value) {
        // find node to remove
        BST nodeToRemove = this.get(value);
        if (nodeToRemove == null) {
            return this;
        }
        BST parent = getParent(value);
        boolean deletingRoot = false;
        if (parent == null) {
            // root node
            deletingRoot = true;
            parent = new BST(-1);
            parent.left = nodeToRemove;
        }
        if (nodeToRemove == null) {
            System.out.println("Node does not exist in the tree");
            return this;
        }
        // either it has both child
        if (nodeToRemove.left != null && nodeToRemove.right != null) {
            // find left most child of right subtree
            BST leftMost = nodeToRemove.right;
            while(leftMost.left != null) {
                leftMost = leftMost.left;
            }
            int valueToInsert = leftMost.value;
            this.remove(valueToInsert);
            nodeToRemove.value = valueToInsert;
        } else if (nodeToRemove.left != null || nodeToRemove.right != null){
            // it has one child
            if (parent.left != null && parent.left.value == value) {
                if (nodeToRemove.left == null) {
                    parent.left = nodeToRemove.right;
                }else {
                    parent.left = nodeToRemove.left;
                }
            } else if (parent.right != null && parent.right.value == value) {
                if (nodeToRemove.left == null) {
                    parent.right = nodeToRemove.right;
                }else {
                    parent.right = nodeToRemove.left;
                }
            }
        } else {
            // it has no child
            // find parent node
            if (parent.left!=null && parent.left.value == value) {
                parent.left = null;
            }else if (parent.right!=null && parent.right.value == value) {
                parent.right = null;
            }
        }
        if (deletingRoot) {
            return parent.left;
        }
        return this;
    }



    public static void main(String[] args) {

        BST root = new BST(5);//
        root.insert(15);
        root.insert(2);
        root.insert(5);//
        root.insert(13);//
        root.insert(22);//
        root.insert(1);
        root.insert(14);//
        root.insert(12);//

        root.remove(10);
//        root.remove(5);
//        root.remove(12);
//        root.remove(13);
//        root.remove(14);
//        root.remove(22);
//        root.remove(2);
//        root.remove(1);

        System.out.println(root.contains(15));




    }

}
