package src.src.leetCode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfIslands2 {
    /*
    * You are given an empty 2D binary grid grid of size m x n.
    * The grid represents a map where 0's represent water and 1's represent land.
    * Initially, all the cells of grid are water cells (i.e., all the cells are 0's).
    * We may perform an add land operation which turns the water at position into a land.
    * You are given an array positions where positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.
    * Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.
    * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    * You may assume all four edges of the grid are all surrounded by water.
    * */


    public static List<Integer> solution(int rows, int cols, int[][] operations) {

        int[][] matrix = new int[rows][cols];
        int islandCount = 0;
        List<Integer> result = new ArrayList<>();
        int[][] directions = new int[][]{
                {1,0}, // down
                {0,1}, // right
                {-1,0}, // up
                {0,-1} // left
        };
//        int[] parent = new int[rows*cols];
        HashMap<String, String> parents = new HashMap<>();
//        for(int i = 0; i < parent.length; i++){
//            parent[i] = i;
//        }
        // iterate over each operation , increment island count
        for(int[] operation: operations) {

            int row = operation[0];
            int col = operation[1];

            if (matrix[row][col] == 1){
                result.add(islandCount);
                continue;
            }
            matrix[row][col] = 1;
            islandCount++;
            parents.put(row+"_"+col, row+"_"+col);
            // check neighbours
            for (int[] direction: directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                // for each neighbour , do a union, if union is success then decrement island count
                if (isValid(nextRow, nextCol, rows, cols) && matrix[nextRow][nextCol] == 1) {
//                    int one = getIndex(row, col, cols);
//                    int two = getIndex(nextRow, nextCol, cols);

                    if (union(parents, row+"_"+col, nextRow+"_"+nextCol) == 1){
                        islandCount--;
                    }
                }
            }
            // add island count to result
            result.add(islandCount);
        }
        return result;
    }

    public static int union(int[] parents, int one, int two) {
        int parentOne = find(parents, one);
        int parentTwo = find(parents, two);
        if (parentOne != parentTwo) {
            parents[parentTwo] = parentOne;
            return 1;
        }else {
            return 0;
        }
    }

    public static int find(int[] parents, int one) {
        while (parents[one] != one) {
            one = parents[one];
        }
        return one;
    }

    public static String find(HashMap<String, String> parents, String one) {
        while (!parents.get(one).equals(one)) {
            one = parents.get(one);
        }
        return one;
    }

    public static int union(HashMap<String, String> parents, String one, String two) {
        String parentOne = find(parents, one);
        String parentTwo = find(parents, two);
        if (!parentOne.equals(parentTwo)) {
            parents.put(parentTwo, parentOne);
            return 1;
        }else {
            return 0;
        }
    }


    private static int getIndex(int row, int col, int cols) {
        return row*cols + col;
    }

    public static boolean isValid(int row, int col, int m, int n) {
        return row>=0 && col>=0 && row < m && col < n;
    }

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int[][] operations = new int[][]{
                {0,0},{0,1},{1,2},{1,2}
        };
        List<Integer> res = solution(rows, cols, operations);
    }

}
