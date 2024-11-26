package src.src.crackingTheCodingInterview.arraysAndStrings;

import java.util.HashSet;
import java.util.Arrays;

public class ZeroMatrix {
    /*
    Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
    */

    void solution(int[][] matrix) {
        HashSet<Integer> rowsToSkip = new HashSet<>();
        HashSet<Integer> columnsToSkip = new HashSet<>();

        outer:
        for (int row = 0; row < matrix.length; row++) {
            if (rowsToSkip.contains(row)) {
                continue;
            }
            inner:
            for (int column = 0; column < matrix[0].length; column++) {
                if (columnsToSkip.contains(column)) {
                    continue;
                }

                int element = matrix[row][column];

                if (element == 0) {
                    rowsToSkip.add(row);
                    columnsToSkip.add(column);
                    makeColumnZero(matrix, column);
                    makeRowZero(matrix, row);
                    break inner;
                }


            }
        }

    }

    void makeColumnZero(int[][] matrix, int columnIndex) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][columnIndex] = 0;
        }
    }

    void makeRowZero(int[][] matrix, int rowIndex) {
        matrix[rowIndex] = new int[matrix[0].length];
    }

    public static void main(String[] args) {
        int[][] matrix = new int [][]{
                {1,1,0},
                {0,1,1},
                {1,1,1}
        };
        new ZeroMatrix().solution(matrix);

        for(int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
    }


}
