package src.src.leetCode.hard;

import java.util.*;

class MinimumTimeToVisitACellInAGrid {

    int solution(int[][] matrix) {

        if (matrix[0][1] > 1 && matrix[1][0]>1) {
            return -1;
        }
        boolean[][]visited = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, 0, 0});


        // directions
        int [][] directions = new int[][] {
                {1,0},      // down
                {-1,0},     // up
                {0,1},      // right
                {0,-1},     // left
        };


        while (!pq.isEmpty()) {
            int [] info = pq.poll();
            int time = info[0];
            int row = info[1];
            int col = info[2];

            if ( row ==  matrix.length -1 && col == matrix[0].length-1) {
                return time;
            }
            visited[row][col] = true;

            for (int[] direction: directions) {
                int newRow = row+direction[0];
                int newCol = col+direction[1];

                if(!isValid (matrix, newRow, newCol, visited)){
                    continue;
                }
                // Calculate the wait time needed to move to next cell

                int diff = matrix[newRow][newCol] - time;
                int nextTime = time + diff + (diff%2==0?1:0);
                pq.add(new int[] { nextTime, newRow, newCol });
            }


        }
        return -1;
    }

    boolean isValid(int[][] matrix, int row, int col, boolean[][]visited) {
        return (
                row>=0 && row < matrix.length &&
                col>=0 && col <matrix[0].length &&
                        !visited[row][col]
        );
    }




    public static void main(String [] args) {

        int [][]matrix = new int[][]{
                {0,1,3,2},
                {5,1,2,5},
                {4,3,8,6}
        };
        int solution = new MinimumTimeToVisitACellInAGrid().solution(matrix);
        System.out.println(solution);
    }



}
