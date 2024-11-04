package src.src.leetCode.medium;

public class SubrectangleQueries {

    /*
    Implement the class SubrectangleQueries
    which receives a rows x cols rectangle as a matrix of integers in the constructor and supports two methods:

        1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
        Updates all values with newValue in the subrectangle whose upper left coordinate is
         (row1,col1) and bottom right coordinate is (row2,col2).

        2. getValue(int row, int col)
        Returns the current value of the coordinate (row,col) from the rectangle.
    */

    private int [][] matrix;
    int rows;
    int columns;

    public SubrectangleQueries(int[][] rectangle) {
        this.matrix = rectangle;
        this.rows = rectangle.length;
        if (rectangle.length > 0){
            this.columns = rectangle[0].length;
        }
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {

        if ( (row1 < 0) || (row2 >= this.rows) || (col1 < 0) || (col2 >= this.columns) ) {
            throw new RuntimeException("Out of bound Parameter");
        }

        for (int rowIndex = row1; rowIndex <= row2; rowIndex++) {

            for (int columnIndex = col1; columnIndex <= col2; columnIndex++) {

                this.matrix[rowIndex][columnIndex] = newValue;

            }

        }
    }

    public int getValue(int row, int col) {
        return this.matrix[row][col];
    }

}
