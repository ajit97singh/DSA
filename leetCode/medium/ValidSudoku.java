package src.src.leetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Map<String, HashSet<Character>> map = new HashMap<>();


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String rowKey = "row_" + j;
                HashSet<Character> row = map.getOrDefault(rowKey, new HashSet<>());
                String colKey = "col_" + i;
                HashSet<Character> column = map.getOrDefault(colKey, new HashSet<>());
                String boxNumber = "box_" + (i/3) + "_" + (j/3);
                HashSet<Character> box = map.getOrDefault(boxNumber, new HashSet<>());
                Character element = board[i][j];
                if (element == '.') {
                    continue;
                }
                if (!(row.add(element) && column.add(element) && box.add(element))) {
                    return false;
                }
                map.put(boxNumber, box);
                map.put(rowKey, row);
                map.put(colKey, column);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        boolean result = isValidSudoku(board);
        System.out.println(result);
    }
}
