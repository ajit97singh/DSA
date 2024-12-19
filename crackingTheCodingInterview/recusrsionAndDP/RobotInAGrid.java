package src.src.crackingTheCodingInterview.recusrsionAndDP;

public class RobotInAGrid {
    // if just size of maze is give and no restriction on cells being accessible
    // to go from top left to bottom right using only right and down moves we cal solve it using combination
    // the paths are just (matrix height times) down moves + (matrix width times) right moves
    // so there will be matrix.length + matrix[0].length moves with matrix.length down moves and matrix[0].length right moves in
    // any order so imagine placing matrix.length count of Red identical balls in array size of matrix.length + matrix[0].length
    // and fill remaining empty space with Black identical balls since balls are identical the problem just redices to finding combinations
    // for placing a identical balls in a+b space


    long mathematicalSolution(int destRow, int destCol) {
        // (destRow+destCol) C destRow
        // (destRow+destCol)! / ((destRow)! * (destCol)!)
        long numerator = 1;
        long denominator = 1;
        destRow--;
        destCol--;
        int maxMoves = destRow+destCol;
        int big = Math.max(destRow, destCol);
        int small = maxMoves - big;

        for (int i = big+small; i > big; i--) {
            numerator *= i;
        }
        for(int i = small; i > 1; i--) {
            denominator *= i;
        }
        return numerator / denominator;
    }


    // but if there are cells we cannot visit we will use DP go backwards
    int solution(boolean[][] maze) {

        // assume we are at destination call, where would we be in previous step
        int [][] waysToReachDest = new int[maze.length][maze[0].length];
        waysToReachDest[maze.length-1][ maze[0].length-1] = 1;
        helper(maze, waysToReachDest);
        return waysToReachDest[0][0];
    }

    void helper(boolean[][] maze, int[][] waysToReachDest) {
        for(int row = maze.length-1; row >=0; row-- ){
            for(int col = maze[0].length-1; col >=0; col-- ){
                if (!maze[row][col] || (row == maze.length-1 && col == maze[0].length-1)) {
                    continue;
                }
                int waysFromHere = 0;
                // can go right?
                if(col < maze[0].length-1) {
                    waysFromHere += waysToReachDest[row][col+1];
                }
                // can go down?
                if(row < maze.length-1) {
                    waysFromHere += waysToReachDest[row+1][col];
                }
                waysToReachDest[row][col] = waysFromHere;
            }
        }
    }


    public static void main(String[] args) {

        boolean [][] matrix = {
                {true, true, true, true},
                {true, true, true, true},
                {true, true, false, true},
                {true, false, true, true},
        };

        long mathSol = new RobotInAGrid().mathematicalSolution(2,2);
        int sol = new RobotInAGrid().solution(matrix);
        int x = 12;

    }



}
