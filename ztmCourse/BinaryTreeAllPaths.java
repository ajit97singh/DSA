package src.src.ztmCourse;

import src.src.leetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeAllPaths {
    public static List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> pathStack = new LinkedList<>();
        nodeStack.push(root);
        pathStack.push(root.getVal());
        while (!nodeStack.isEmpty()){

//            if ()
        }
        return result;
    }
}
