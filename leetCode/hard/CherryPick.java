package src.src.leetCode.hard;

public class CherryPick {
    public static int cherryPickup(int[][] grid) {
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col]==-1){
                    continue;
                }
                int elementFromAbove = 0;
                if(row>0){
                    elementFromAbove = grid[row-1][col];
                }
                int elementFromLeft = 0;
                if(col>0){
                    elementFromLeft = grid[row][col-1];
                }
                if (elementFromAbove >= elementFromLeft && elementFromAbove > 0) {
                    grid[row-1][col] = 0;
                }else if (elementFromLeft > 0){
                    grid[row][col-1] = 0;
                }
                grid[row][col] += Math.max(elementFromAbove, elementFromLeft);

            }
        }

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col]==-1){
                    continue;
                }
                int elementFromAbove = 0;
                if(row>0){
                    elementFromAbove = grid[row-1][col];
                }
                int elementFromLeft = 0;
                if(col>0){
                    elementFromLeft = grid[row][col-1];
                }
                if (elementFromAbove >= elementFromLeft && elementFromAbove > 0) {
                    grid[row-1][col] = 0;
                }else if (elementFromLeft > 0){
                    grid[row][col-1] = 0;
                }
                grid[row][col] += Math.max(elementFromAbove, elementFromLeft);

            }
        }


        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0},
                {-1,-1,0},
                {0,1,1}
        };
        int res = cherryPickup(grid);
    }
}
