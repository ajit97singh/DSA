package src.src.crackingTheCodingInterview.arraysAndStrings;

import java.util.Arrays;

public class RotateMatrix {
    /*
    Given an image represented by an NxN matrix, where each pixel in the image is 4
    bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
    */

//    1 2 3         7 4 1
//    4 5 6 -->     8 5 2
//    7 8 9         9 6 3

    //    assuming matrix is always square , we can do it in inplace ,
    void solution2(int [][] matrix) {
//        doing a layer wise rotation
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++ ) {

            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {

                int top = matrix[layer][i];
                int right = matrix[i][n - 1 - layer];
                int bottom = matrix[n - 1 - layer][n - 1 - i];
                int left = matrix[n - 1 - i][layer];

                matrix[layer][i] = left;
                matrix[n-1-i][layer] = bottom;
                matrix[n - 1-layer][n -1 - i] = right;
                matrix[i][n -1- layer] = top;

            }

        }


    }

// unless the matrix is always square we cannot do it in in-place and the row col length changes
    int [][] solution1(int [][] matrix) {
//        time -> O(N), space O(N)
        int [][] result = new int[matrix[0].length][matrix.length];
        int rowCount = matrix.length;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {

                int element = matrix[row][column];
//                1st row becomes last column, 2nd row becomes 2nd last column
                result[column][rowCount - row -1] = element;

            }
        }
        return result;
    }


    public static void main(String [] args) {

        int [][] input = new int [][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        for (int[] row: new RotateMatrix().solution1(input)) {
            System.out.println(Arrays.toString(row));
        }
        new RotateMatrix().solution2(input);

        for (int[] row: input) {
            System.out.println(Arrays.toString(row));
        }

    }
}
