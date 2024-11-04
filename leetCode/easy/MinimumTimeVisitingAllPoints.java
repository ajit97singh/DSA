package src.src.leetCode.easy;

import java.util.Arrays;

public class MinimumTimeVisitingAllPoints {
    public static int minTimeToVisitAllPoints(int[][] points) {
        int steps = 0;
        for(int pointIndex = 0; pointIndex < points.length - 1; pointIndex++){
            int [] currentPoint = points[pointIndex];
            int [] nextPoint = points[pointIndex + 1];
            int stepsBetweenCurrentPoints = countSteps(currentPoint, nextPoint);
            steps += stepsBetweenCurrentPoints;
        }
        return steps;
    }

    public static double getDistance(int[] start, int[] finish){
        double dis = Math.pow(start[0]-finish[0], 2) +  Math.pow(start[1]-finish[1], 2);
        return Math.sqrt(dis);
    }

    public static int [] closestPoint(int[] start, int[] finish){
        int [] newPoint = start;
        double originalDistance = getDistance(start, finish);
        double newYDistance = originalDistance;
        double newXDistance = originalDistance;

        // check y-axis
        newPoint[1] += 1;
        newYDistance = getDistance(newPoint, finish);
        if(newYDistance<originalDistance){
            // go in +ve y direction
        }else if(newYDistance == originalDistance){
            // purely in x axis
            newPoint[1] -= 1;
        }else{
            // check in -ve y direction
            newPoint[1] -= 2;
            newYDistance = getDistance(newPoint, finish);
            if(newYDistance>originalDistance){
                newPoint[1] += 1;
            }
        }

        // check x-axis
        newPoint[0] += 1;
        newXDistance = getDistance(newPoint, finish);
        if(newXDistance<newYDistance){
            // go in +ve x direction
        }else if(newXDistance == newYDistance){
            // purely in y axis
            newPoint[0] -= 1;
        }else{
            // check in -ve y direction
            newPoint[0] -= 2;
            newXDistance = getDistance(newPoint, finish);
            if(newXDistance>newYDistance){
                newPoint[0] += 1;
            }
        }
        return newPoint;

    }

    public static int countSteps(int[] start, int[] finish){
        int steps = 0;
        int [] nextPoint = start;

        while(!Arrays.equals(nextPoint, finish)){
            nextPoint = closestPoint(nextPoint, finish);
            steps += 1;
        }
        return steps;
    }

    public static void main(String[] args) {
        int [][] points = new int[][]{{1,1}, {3,4}, {-1,0}};
        System.out.println(minTimeToVisitAllPoints(points));
    }
}
