package src.src.leetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EqualRowAndColumnPairs {
    /*
    Given a 0-indexed n x n integer matrix grid,
    return the number of pairs (ri, cj) such that row ri and column cj are equal.
    A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
    */
    public static int equalPairs(int[][] grid) {

        HashMap<List<Integer>, Integer> mp = new HashMap<>();
        int n=grid.length;
        for(int i=0;i<n;i++){
            List<Integer> li=new ArrayList<>();
            for(int j=0;j<n;j++){
                li.add(grid[i][j]);
            }
            mp.put(li, mp.getOrDefault(li, 0) + 1);
        }
        int count=0;
        for(int i=0;i<n;i++){
            List<Integer> li=new ArrayList<>();
            for(int j=0;j<n;j++){
                li.add(grid[j][i]);
            }
            if (mp.containsKey(li)){
                count+=mp.get(li);
            }
        }
        return count;

    }

    public static void main(String[] args) {

        // Output : 1
        System.out.println(equalPairs(new int[][]{
                {3,2,1},
                {1,7,6},
                {2,7,7}
        }));
    }
}

