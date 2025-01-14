package src.src.leetCode.medium;

import java.util.*;

public class KnightProbabilityInChessboard {

    public double knightProbability(int n, int k, int row, int column) {
        Map<String, Integer> map = new HashMap<>();
        map.put("on", 0);
        map.put("off", 0);
        dfs(n, 0, k, row, column, map);
        return (double) map.get("on") / (map.get("on") + map.get("off"));
    }

    public int[][] nextPositions(int row, int col) {
        int[][] res = new int[8][2];
        int[][] directions = new int[][]{
                {1, 2}, {2, 1},
                {1, -2}, {-2, 1},
                {-1, 2}, {2, -1},
                {-1, -2}, {-2, -1}
        };
        for (int i = 0; i < 8; i++) {
            res[i] = new int[]{row + directions[i][0], col + directions[i][1]};
        }
        return res;
    }


    public void dfs(int n, int movesMade, int maxMoves, int row, int col, Map<String, Integer> map) {

        if (row < 0 || row >= n || col < 0 || col >= n) {
            map.put("off", map.get("off") + 1);
            return;
        }

        if (movesMade == maxMoves) {
            map.put("on", map.get("on") + 1);
            return;
        }
        for (int[] nextPosition : nextPositions(row, col)) {
            dfs(n, movesMade + 1, maxMoves, nextPosition[0], nextPosition[1], map);
        }

    }

    public static void main(String[] args) {
        double res = new KnightProbabilityInChessboard().knightProbability(3, 2, 0, 0);
        res = 12;
    }
}