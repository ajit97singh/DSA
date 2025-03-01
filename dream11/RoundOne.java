package src.src.dream11;

public class RoundOne {
    // LeetCode 1011. Capacity To Ship Packages Within D Days

    //[3,2,2,4,1,4], days = 3

    public static int shipWithinDays(int[] weights, int days) {
        // find limits
        int low = 0;
        int high = 0;
        for (int weight: weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        // bin search
        while (low < high) {
            int mid = low + (high - low)/2;
            System.out.println("Checking --> " + mid);
            // find feasibility
            int numDays = findDays(weights, mid); // 7 days for
            if (numDays <= days) {
                // slow down
                high = mid;
            }else {
                // speed up
                low = mid+1;
            }

        }


        return low;
    }
    // fiunction to find days taken

    public static int findDays(int[] weights, int capacity) {

        int idx = 0;
        int wightSoFar = 0;
        int daysTaken = 0;
        while (idx < weights.length) {

            int weightToAdd = weights[idx];
            // cap 10, sofar 8, toadd 2, 4
            if (wightSoFar + weightToAdd > capacity) {
                // finish and move next
                wightSoFar = weightToAdd;
                daysTaken++;
            } else {
                // add it
                wightSoFar += weightToAdd;
            }
            idx++;
        }
        daysTaken++;
        return daysTaken;
    }

    // 1254. Number of Closed Islands


    public static int[][] directions = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    public int closedIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int closedIslands = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0 && !visited[row][col]) {
                    if (dfs(grid, visited, row, col, notOnBoundary(row, col, rows, cols))) {
                        closedIslands++;
                    }
                }

            }
        }
        return closedIslands;
    }

    public boolean isValid(int row, int col, int rows, int cols) {
        return row >=0 && col >=0 && row < rows && col < cols;
    }

    public boolean notOnBoundary(int row, int col, int rows, int cols) {
        return row >0 && col >0 && row < rows-1 && col < cols-1;
    }


    public boolean dfs(int[][] grid, boolean[][] visited, int row, int col, boolean bound) {
        boolean res = bound;
        int rows = grid.length;
        int cols = grid[0].length;
        if (visited[row][col]) {
            return bound;
        }
        visited[row][col] = true;

        for (int[] dir: directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (isValid(nextRow, nextCol, rows, cols) && 0 == grid[nextRow][nextCol]) {
                res = dfs(grid, visited, nextRow, nextCol, notOnBoundary(nextRow, nextCol, rows, cols)) && res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
//        int res = shipWithinDays(weights, days);
//        System.out.println(res);
        int[][] grid = new int[][] {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int closedIslandCount = new RoundOne().closedIsland(grid);
        System.out.println(closedIslandCount);
    }

}