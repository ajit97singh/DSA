package src.src.leetCode.medium;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int resIdx = 0;
        int row = 0;
        int col = 0;
        int rowMin = 0;
        int rowMax = rows-1;
        int colMin = 0;
        int colMax = cols-1;

        while (res.size() < rows*cols) {

            // process top - row
            while(col <= colMax && col >=colMin){
                res.add( matrix[row][col]);
                col++;
                // resIdx++;
            }
            row++;
            col--;
            rowMin += 1;

            // process right - col
            while(row <= rowMax && row >= rowMin){
                res.add(matrix[row][col]);
                row++;
                // resIdx++;
            }
            row--;
            col--;
            colMax -= 1;


            // process bottom - row
            while(col >= colMin && col <= colMax){
                res.add(matrix[row][col]);
                col--;
                // resIdx++;
            }
            row--;
            col++;
            rowMax -= 1;


            // process left - col
            while(row >= rowMin && row <= rowMax){
                res.add(matrix[row][col]);
                row--;
                // resIdx++;
            }
            row++;
            col++;
            colMin += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        };
        List<Integer> integers = spiralOrder(matrix);
        integers = null;
    }
}
