package src.src.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<Integer>();

        int count = 0;
        int rows = array.length;
        int cols = array[0].length;
        int currentRow = 0;
        int currentCol = 0;
        int rowProcssedTop = -1;
        int rowProcssedBottom = array.length;
        int colProcssedLeft = -1;
        int colProcssedRight = array[0].length;

        while (count < rows*cols) {

            // process top
            while ( currentCol > colProcssedLeft && currentCol < colProcssedRight) {
                result.add(array[currentRow][currentCol]);
                currentCol++;
                count++;
            }
            // prepare to process right
            rowProcssedTop++;
            currentRow++;
            currentCol--;
            // process right
            while ( currentRow > rowProcssedTop && currentRow < rowProcssedBottom) {
                result.add(array[currentRow][currentCol]);
                currentRow++;
                count++;
            }
            // prepare to process bottom
            colProcssedRight--;
            currentRow--;
            currentCol--;
            // process bottom
            while ( currentCol > colProcssedLeft && currentCol < colProcssedRight) {
                result.add(array[currentRow][currentCol]);
                currentCol--;
                count++;
            }
            // prepare to process left
            rowProcssedBottom--;
            currentRow--;
            currentCol++;
            // process left
            while ( currentRow > rowProcssedTop && currentRow < rowProcssedBottom) {
                result.add(array[currentRow][currentCol]);
                currentRow--;
                count++;
            }
            // prepare to process top
            colProcssedLeft++;
            currentRow++;
            currentCol++;
        }


        return result;
    }

    public static void main(String [] args) {
        int[][] input = {
                {1,2,3,4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        };



        spiralTraverse(input);
    }
}
