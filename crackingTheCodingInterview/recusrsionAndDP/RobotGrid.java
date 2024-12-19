package src.src.crackingTheCodingInterview.recusrsionAndDP;

import java.util.*;

public class RobotGrid {

    ArrayList<Point> solution(boolean[][] maze) {
        ArrayList<Point> path = new ArrayList<>();
        HashSet<String> failedPaths = new HashSet<>();
        if (getPath(maze, 0, 0, path, failedPaths)) {
            return path;
        }
        return new ArrayList<>();
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<String> failedOrVisited) {
        Point currentPoint = new Point(row, col);

        if (row == maze.length-1 && col == maze[0].length-1) {
            path.add(currentPoint);
            return true;
        }

        if (row >= maze.length || col >= maze[0].length ||
                !maze[row][col] ||
                failedOrVisited.contains(row + "_" + col)) {
            return false;
        }
        failedOrVisited.add(row + "_" + col);
        path.add(currentPoint);
        return getPath(maze, row + 1, col, path, failedOrVisited) || getPath(maze, row, col + 1, path, failedOrVisited);
    }



    public static void main(String[] args) {
        boolean [][] maze = {
                {true, true, false, true},
                {true, true, true, false},
                {true, true, false, true},
                {true, true, true, true}
        };

        ArrayList<Point> res = new RobotGrid().solution(maze);
        System.out.println(res);
    }


}


class Point {
    int row;
    int col;

    Point(int r, int c) {
        this.row = r;
        this.col = c;
    }
}