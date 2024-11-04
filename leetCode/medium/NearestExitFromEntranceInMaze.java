package src.src.leetCode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {

    /*
    * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
    *  You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol]
    * denotes the row and column of the cell you are initially standing at.
    * In one step, you can move one cell up, down, left, or right.
    * You cannot step into a cell with a wall, and you cannot step outside the maze.
    * Your goal is to find the nearest exit from the entrance.
    * An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
    * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
    */

    public static int nearestExit(char[][] maze, int[] entrance) {

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        maze[entrance[0]][entrance[1]] = '+';

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});
        int[] currPosition = new int[3];
        boolean exitFound = false;
        while (!queue.isEmpty()) {
            // get element
            currPosition = queue.poll();
            int row = currPosition[0];
            int col = currPosition[1];
            int depth = currPosition[2];
            char currState = maze[currPosition[0]][currPosition[1]];
            // process element
            if ((currPosition[0] == maze.length - 1 || currPosition[0] == 0 ||
                    currPosition[1] == maze[0].length - 1 || currPosition[1] == 0)
                    && currState == '.') {
                exitFound = true;
                break;
            }
            // update visited
            visited[currPosition[0]][currPosition[1]] = true;
            // add unvisited children to queue
            // left child
            if (col>0 && !visited[row][col-1] && maze[row][col-1] == '.') {
                queue.add(new int[]{row, col-1, depth+1});
            }
            // right child
            if (col< maze[0].length-1 && !visited[row][col+1] && maze[row][col+1] == '.') {
                queue.add(new int[]{row, col+1, depth+1});
            }
            // top child
            if (row>0 && !visited[row-1][col] && maze[row-1][col] == '.') {
                queue.add(new int[]{row-1, col, depth+1});
            }
            // bottom child
            if (row< maze.length-1 && !visited[row+1][col] && maze[row+1][col] == '.') {
                queue.add(new int[]{row+1, col, depth+1});
            }

        }

        return exitFound?currPosition[2]:-1;
    }

    public int nearestExit2(char[][] maze, int[] entrance) {

            int m = maze.length;
            int n = maze[0].length;

            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[] {entrance[0], entrance[1], 0});
            maze[entrance[0]][entrance[1]] = '+';

            while(! queue.isEmpty()) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int dist = curr[2];

                for(int i = 0; i < 4; i++) {
                    int x = r + dx[i];
                    int y = c + dy[i];

                    if(x == -1 || y == -1 || x == m || y == n) continue;
                    if(maze[x][y] == '+') continue;
                    if(x == 0 || y == 0 || x == m - 1 || y == n - 1) return dist + 1;
                    maze[x][y] = '+';
                    queue.add(new int[] {x, y, dist + 1});
                }
            }
            return -1;
        }

    public static void main(String[] args) {
        char[][] maze = {
                {'+'},
                {'.'}};
        int[] entrance = {1,0};
        int result = nearestExit(maze, entrance);
        System.out.println(result);
    }

}
