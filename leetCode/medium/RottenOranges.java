package src.src.leetCode.medium;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

// 994
public class RottenOranges {
    public static int orangesRotting(int[][] grid) {
        AtomicInteger maxTime = new AtomicInteger(0);
        HashSet<String> visited = new HashSet<>();
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == 2){
                    AtomicInteger timer = new AtomicInteger(0);
                    infect(grid, row, column, timer, maxTime, visited);
                }
            }
        }
        return maxTime.get();
    }

    public static void infect(int[][] grid, int row, int column, AtomicInteger timeCounter, AtomicInteger maxTime, HashSet<String> visited){
        if(visited.contains(row + "," + column)){
            return;
        }
        if(row < grid.length && row >=0 && column < grid[0].length && column >=0){
            visited.add(row + "," + column);
            if(grid[row][column] == 1) {
                timeCounter.getAndIncrement();
                maxTime.set(Math.max(timeCounter.get(), maxTime.get()));
                grid[row][column] = 2;
            }
            if (grid[row][column] == 2) {
                infect(grid, row + 1, column, timeCounter, maxTime, visited);
                infect(grid, row - 1 , column, timeCounter, maxTime, visited);
                infect(grid, row , column + 1, timeCounter, maxTime, visited);
                infect(grid, row , column - 1, timeCounter, maxTime, visited);
            }
        }else{
            return;
        }
    }

    public static void main(String[] args) {
        int [][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }
}
