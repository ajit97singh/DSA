package src.src.leetCode.easy;

import java.util.*;

public class IslandPerimeter {
    /*
    You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
    and there is exactly one island (i.e., one or more connected land cells).
    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
    One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
    Determine the perimeter of the island.
    */
    public static int islandPerimeter(int[][] grid) {
        int initialRow = 0;
        int initialColumn = 0;
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        outerLoop:
        for(int i = 0; i<rowCount; i++){
            for(int j = 0; j<columnCount; j++){
                if(grid[i][j] == 1){
                    initialRow = i;
                    initialColumn = j;
                    break outerLoop;
                }
            }
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(initialRow,initialColumn));
        HashSet<String> visitedBlocks = new HashSet<>();
        int perimeter = 0;

        while (!queue.isEmpty()){
            List<Integer> rowColumn = queue.remove();
            int row = rowColumn.get(0);
            int column = rowColumn.get(1);

            if(visitedBlocks.contains(row+"-"+column)){
                continue;
            }
            int leftIsLand = 0;
            int rightIsLand  = 0;
            int topIsLand = 0;
            int bottomIsLand = 0;
            // Left Neighbour if exists
            if(column > 0){
                leftIsLand = grid[row][column - 1];
                if(leftIsLand==1){
                    queue.add(Arrays.asList(row, column - 1));
                }


            }
            // Right Neighbour if exists
            if(column < columnCount - 1){
                rightIsLand = grid[row][column + 1];
                if(rightIsLand == 1){
                    queue.add(Arrays.asList(row, column + 1));
                }
            }
            // Top Neighbour if exists
            if(row > 0){
                topIsLand = grid[row - 1][column];
                if(topIsLand == 1){
                    queue.add(Arrays.asList(row - 1, column));
                }
            }
            // Bottom Neighbour if exists
            if(row < rowCount - 1){
                bottomIsLand = grid[row + 1][column];
                if(bottomIsLand == 1){
                    queue.add(Arrays.asList(row + 1, column));
                }
            }
            visitedBlocks.add(row + "-" +column);
            perimeter += (4 - leftIsLand - rightIsLand - topIsLand - bottomIsLand);

        }

        return perimeter;
    }

    public static void main(String[] args) {
        int [][] grid = new int[][]{{0,1,0,0},
                                    {1,1,1,0},
                                    {0,1,0,0},
                                    {1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}
