package src.src.algoexpert.hard;

import java.util.*;

public class FindNodesKDistance {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class Pair {
        public int depth = 0;
        public BinaryTree node = null;

        public Pair(int dep, BinaryTree nod) {
            this.depth = dep;
            this.node = nod;
        }
    }

    public boolean foundTarget = false;

    public ArrayList<Integer> findNodesDistanceK(
            BinaryTree tree, int target, int k
    ) {
        // Write your code here.
        List<BinaryTree> path = new ArrayList<>();
        findPath(tree, target, path);
        ArrayList<Integer> depthLimits = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < path.size(); i++) {
            depthLimits.add(k-path.size()+i+1);
            visited.add(path.get(i).value);
        }

        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < depthLimits.size(); i++) {
            int maxDepth = depthLimits.get(i);
            if (maxDepth < 0){
                continue;
            }

            BinaryTree root = path.get(i);
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(0, root));

            while (!q.isEmpty()) {
                Pair pair = q.poll();
                int depth = pair.depth;
                BinaryTree node = pair.node;
                if (depth == maxDepth) {
                    result.add(node.value);
                }

                if (depth < maxDepth) {
                    if (node.left != null && !visited.contains(node.left.value)) {
                        q.add(new Pair(depth+1, node.left));
                    }
                    if (node.right != null && !visited.contains(node.right.value)) {
                        q.add(new Pair(depth+1, node.right));
                    }
                }
            }
        }
        return result;
    }

    public void findPath(BinaryTree node, int target, List<BinaryTree> path) {
        if (node == null || foundTarget) {
            return;
        }
        path.add(node);
        if (node.value == target){
            foundTarget = true;
            return;
        }
        findPath(node.left, target, path);
        findPath(node.right, target, path);
        if (foundTarget){
            return;
        }
        path.remove(path.size()-1);
    }

    public static void main(String [] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right = new BinaryTree(3);
        tree.right.right = new BinaryTree(6);
        tree.right.right.left = new BinaryTree(7);
        tree.right.right.right = new BinaryTree(8);
        ArrayList<Integer> res = new FindNodesKDistance().findNodesDistanceK(tree, 3,2);
        res = null;
    }

}
