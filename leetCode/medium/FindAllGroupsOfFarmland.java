package src.src.leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class FindAllGroupsOfFarmland {
    /*
    * You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.
    * To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland.
    * These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group
    * is not four-directionally adjacent to another farmland in a different group.
    * land can be represented by a coordinate system where the top left corner of land is (0, 0) and
    * the bottom right corner of land is (m-1, n-1).
    * Find the coordinates of the top left and bottom right corner of each group of farmland.
    * A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented
    * by the 4-length array [r1, c1, r2, c2].
    * Return a 2D array containing the 4-length arrays described above for each group of farmland in land.
    * If there are no groups of farmland, return an empty array. You may return the answer in any order.
    */


    public static int[][] findFarmland(int[][] land) {

        List<int[]> result = new ArrayList<>();

        outerLoop:
        for(int row = 0; row < land.length; row++){
            for(int column = 0; column < land[0].length; column++){

                if(land[row][column] == 1 && !checkIfElementInExistingFarmland(result, row, column)){
                    int currentRow = row;
                    int currentColumn = column;
                    while (currentRow < land.length && land[currentRow][currentColumn]==1){
                        currentRow++;
                    }
                    currentRow--;
                    while (currentColumn < land[0].length && land[currentRow][currentColumn]==1){
                        currentColumn++;
                    }
                    currentColumn--;
                    result.add(new int[]{row, column, currentRow, currentColumn});
                    if(currentRow == land.length -1 && currentColumn == land[0].length-1){
                        break outerLoop;
                    }
                }
            }
        }
        return result.toArray(int[][]::new);
    }

    public static boolean checkIfElementInExistingFarmland(List<int []> foundFarmland, int row, int column){
        AtomicBoolean result = new AtomicBoolean(false);
        foundFarmland.parallelStream().forEach(block -> {
            if(row >= block[0] && column >= block[1] && row <= block[2] && column <= block[3]){
                result.set(true);
            }
        });
        return result.get();
    }

    public int[][] findFarmlandFast(int[][] land) {
        List<int[]> ans = new ArrayList<>();

        for (int row = 0; row < land.length; row++) {
            for (int column = 0; column < land[0].length; column++) {
                if (land[row][column] == 1) {
                    int currentRow = row;
                    int currentColumn = column;

                    for (currentRow = row; currentRow < land.length && land[currentRow][column] == 1; currentRow++) {
                        for (currentColumn = column; currentColumn < land[0].length && land[currentRow][currentColumn] == 1; currentColumn++) {
                            land[currentRow][currentColumn] = 0;
                        }
                    }

                    int[] arr = new int[] {row, column, currentRow - 1, currentColumn - 1};
                    ans.add(arr);
                }
            }
        }
        return ans.toArray(int[][]::new);
    }


    public static void main(String[] args) {
        // Expected : [[0,0,0,0],[1,1,2,2]]
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 1}
        })));
    }
}
