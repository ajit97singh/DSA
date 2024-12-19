package src.src.crackingTheCodingInterview.recusrsionAndDP;

import java.util.*;
public class EightQueens {

    /* 8.12
    * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board
    * so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all
    * diagonals, not just the two that bisect the board.
    */

    static int GRID_SIZE = 8;

    // columns ->[] Integers represent a chessboard where index is row and index-values is column
    // [0,1,0,3] - > {
    //                {1 , 0 , 0, 0}
    //                {0 , 1 , 0, 0}
    //                {1 , 0 , 0, 0}
    //                {0 , 0 , 0, 1}
    //                }
    // we can start by adding a queen to (0,0), the check which points in next row are valid , since current row will
    // not be valid, we keep doing this till we exceed the row limit


    List<Integer[]> solution() {
        List<Integer[]> result = new ArrayList<>();
        Integer[] board =  new Integer[GRID_SIZE];
        Arrays.fill(board, 0);
        addQueens(result, board, 0);
        return result;
    }

    void addQueens(List<Integer[]> result, Integer[] board, int row) {
        if ( row == GRID_SIZE ) {
            result.add(board.clone());
            return;
        }

        for( int col = 0; col < GRID_SIZE; col++) {
            if (isValid(board, row, col)) {
                board[row] = col;
                addQueens(result, board.clone(), row+1);
            }
        }
    }

    boolean isValid(Integer[] board, int row, int col) {

        for( int row0 = 0; row0 < row; row0++) {
            int col0 = board[row0];

            if (col == col0){
                return false;
            }

            if (Math.abs(col - col0) == (row-row0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args)  {
        List<Integer[]> res = new EightQueens().solution();
        res = null;
    }

}
