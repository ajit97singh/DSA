package src.src.crackingTheCodingInterview.graphsAndTrees;

import java.util.*;


class Pair<A,B>{
    A level;
    B node;

    Pair(A a, B b){
        this.level = a;
        this.node = b;
    }

}

public class ListOfDepths {


    List<List<TreeNode>> solution(TreeNode root) {

        List<List<TreeNode>> result = new ArrayList<>();
        Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();

        q.add(new Pair<>(0, root));
        ArrayList<Pair<Integer, TreeNode>> currentRow = new ArrayList<>();
        while (!q.isEmpty()) {
            // get node
            Pair<Integer, TreeNode> data = q.poll();
            int level = data.level;
            TreeNode node = data.node;

            int rowLevel = !currentRow.isEmpty() ? currentRow.getFirst().level:0;
            if (level != rowLevel) {
                result.add(currentRow.stream().map(x -> x.node).toList());
                currentRow = new ArrayList<>();
            }
            currentRow.add(new Pair<>(level,node));

            if (node.left != null) {
                q.add(new Pair<>(level+1, node.left));
            }
            if (node.right != null) {
                q.add(new Pair<>(level+1, node.right));
            }
        }
        result.add(currentRow.stream().map(x -> x.node).toList());
        return result;
    }


    public static void main(String [] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(3);
        root.right.right.left.right = new TreeNode(4);

        List<List<TreeNode>> out = new ListOfDepths().solution(root);
        System.out.println(out);
    }



}
