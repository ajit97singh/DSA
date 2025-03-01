package src.src.leetCode.medium;

public class DetonateMaximumBombs {
    /*
    * 2101. Detonate the Maximum Bombs
    * You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt.
    * This area is in the shape of a circle with the center as the location of the bomb.
    * The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri].
    * xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.
    * You may choose to detonate a single bomb.
    * When a bomb is detonated, it will detonate all bombs that lie in its range.
    * These bombs will further detonate the bombs that lie in their ranges.
    * Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.
    * */

    public static int solution(int[][] bombs) {
        int[] parents = new int[bombs.length];
        for(int i = 0; i < bombs.length; i++) {
            parents[i] = i;
        }
        int[] ranks = new int[bombs.length];
        for(int i = 0; i < bombs.length; i++) {
            ranks[i] = 1;
        }
        int maxRank = 1;

        for(int i = 0; i < bombs.length; i++) {
            int[] bomb = bombs[i];

            for(int j = i+1; j < bombs.length; j++) {
                if (i == j) {
                    continue;
                }
                int [] otherBomb = bombs[j];
                double dist = distance(bomb[0], bomb[1], otherBomb[0], otherBomb[1]);

                if (dist <= Math.max(bomb[2], otherBomb[2])) {
                    // merge
                    union(parents, i, j, ranks);
                    maxRank = Math.max(maxRank, ranks[j]);
                    break;
                }
            }
        }
        return maxRank;
    }

    public static int find(int[] parents, int target) {
        int temp = target;
        while(temp != parents[temp]) {
            temp = parents[temp];
        }

        while(target != parents[target]) {
            target = parents[target];
            parents[target] = temp;
        }
        return temp;
    }

    public static void union(int [] parents, int one, int two, int[] ranks) {
        int parentOne = find(parents, one);
        int parentTwo = find(parents, two);
        if (parentOne != parentTwo) {
            parents[parentOne] = parentTwo;
            ranks[parentTwo] += ranks[parentOne];
        }
    }


    public static double distance(int x1, int y1, int x2, int y2) {
        long a = (long) (x1 - x2) * (x1-x2);
        long b = (long) (y1 - y2) * (y1-y2);
        return Math.sqrt(a+b);
    }

    public static void main(String[] args) {
        int[][] bombs = {
                {656,619,56},{189,402,178},{513,373,276},
                {900,510,14},{188,173,129},{512,178,251},
                {145,685,47},{504,355,500},{554,131,214},
                {596,1,98},{358,230,197},{88,758,155},
                {72,340,419},{818,708,222}};

        int res = solution(bombs);
        res = 0;
    }
}
