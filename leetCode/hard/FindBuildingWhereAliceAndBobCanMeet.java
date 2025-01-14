package src.src.leetCode.hard;

import java.util.*;

public class FindBuildingWhereAliceAndBobCanMeet {
    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

        int [] closestBiggerBuilding = new int[heights.length];
        Arrays.fill(closestBiggerBuilding, -1);
        outer:
        for (int i = 0; i < closestBiggerBuilding.length-1; i++) {
            inner:
            for(int j = i; j < closestBiggerBuilding.length; j++) {
                System.out.println(j);
                if (heights[j] > heights[i]){
                    closestBiggerBuilding[i] = j;
                    break inner;
                }
            }

        }
        System.out.println(Arrays.toString(closestBiggerBuilding));

        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int buildingOne = query[0];
            int buildingTwo = query[1];
            if (buildingOne == buildingTwo){
                result[i] = buildingOne;
            }else if ( (buildingOne < buildingTwo ) && heights[buildingOne] < heights[buildingTwo]) {
                result[i] = buildingTwo;
            } else if ( (buildingOne > buildingTwo ) && heights[buildingOne] > heights[buildingTwo]) {
                result[i] = buildingOne;
            }else {
                // int buildingHeightToFind = Math.max(heights[buildingOne], heights[buildingTwo]);
                int indexToStartFrom = Math.max(buildingOne, buildingTwo);
                result[i] = closestBiggerBuilding[indexToStartFrom];
                // while(indexToStartFrom < heights.length) {
                //     if (heights[indexToStartFrom] > buildingHeightToFind) {
                //         break;
                //     }
                //     indexToStartFrom++;
                // }
                // if (indexToStartFrom == heights.length){
                //     result[i] = -1;
                // }else {
                //     result[i] = indexToStartFrom;
                // }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{6,4,8,5,2,7};
        int[][] queries = new int[][]{
                {0,1},
                {0,3},
                {2,4},
                {3,4},
                {2,3}
        };
        int[] res = leftmostBuildingQueries(heights, queries);
    }
}
