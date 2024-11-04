package src.src.leetCode.medium;

import java.util.*;

public class NumberOfIslands {
    /*
    Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.
    */
    public static int numIslands(char[][] grid) {

        HashSet<String> visitedBlocks = new HashSet<>();
        int islands = 0;

        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(String.valueOf(grid[row][column]).equalsIgnoreCase("1")){
                    if(visitedBlocks.contains(row + "-" + column)){
                        continue;
                    }else {
                        visitedBlocks.add(row + "-" + column);
                        Queue<List<Integer>> queue = new LinkedList<>();
                        queue.add(Arrays.asList(row,column));
                        while (!queue.isEmpty()){
                            List<Integer> rowCol = queue.remove();
                            int currentRow = rowCol.get(0);
                            int currentColumn = rowCol.get(1);
                            // check left element
                            if(currentColumn > 0 && !visitedBlocks.contains(currentRow + "-" + (currentColumn - 1))){
                                boolean leftIsLand = String.valueOf(grid[currentRow][currentColumn - 1]).equalsIgnoreCase("1");
                                if(leftIsLand){
                                    queue.add(Arrays.asList(currentRow, (currentColumn-1)));
                                }
                                visitedBlocks.add(currentRow + "-" + (currentColumn - 1));
                            }
                            // check right element
                            if(currentColumn < grid[0].length - 1 && !visitedBlocks.contains(currentRow + "-" + (currentColumn+1))){
                                boolean rightIsLand = String.valueOf(grid[currentRow][currentColumn + 1]).equalsIgnoreCase("1");
                                if(rightIsLand){
                                    queue.add(Arrays.asList(currentRow, (currentColumn+1)));
                                }
                                visitedBlocks.add(currentRow + "-" + (currentColumn + 1));
                            }
                            // check top element
                            if(currentRow > 0 && !visitedBlocks.contains((currentRow - 1) + "-" + currentColumn)){
                                boolean topIsLand = String.valueOf(grid[currentRow - 1][currentColumn]).equalsIgnoreCase("1");
                                if(topIsLand){
                                    queue.add(Arrays.asList((currentRow-1), currentColumn));
                                }
                                visitedBlocks.add((currentRow-1) + "-" + currentColumn);
                            }
                            // check bottom element
                            if(currentRow < grid.length - 1 && !visitedBlocks.contains((currentRow + 1) + "-" + currentColumn)){
                                boolean bottomIsLand = String.valueOf(grid[currentRow + 1][currentColumn]).equalsIgnoreCase("1");
                                if(bottomIsLand){
                                    queue.add(Arrays.asList((currentRow+1), currentColumn));
                                }
                                visitedBlocks.add((currentRow + 1) + "-" + currentColumn );
                            }
                        }
                        islands++;

                    }
                }


            }
        }
        return islands;
    }

    public static void main(String[] args) {
        // expected output : 1
        System.out.println(numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
    }
}
