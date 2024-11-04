package src.src.leetCode.medium;

import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZeroes {

    // Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

    public static void setZeroes(int[][] matrix) {

        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        outer:
        for (int row = 0; row < matrix.length; row++) {
            inner:
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    colSet.add(col);
                    rowSet.add(row);
                }
            }
        }
        for (Integer col : colSet) {
            setColumn(matrix, col);
        }
        for (Integer row : rowSet) {
            matrix[row] = new int[matrix[0].length];
        }


    }

    public static void setColumn(int[][] matrix, int columnNumber) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][columnNumber] = 0;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1}, {1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
