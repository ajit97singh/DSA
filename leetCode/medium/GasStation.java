package src.src.leetCode.medium;

public class GasStation {
    /*
    * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
    * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
    * You begin the journey with an empty tank at one of the gas stations.
    * Given two integer arrays gas and cost, return the starting gas station's index
    * if you can travel around the circuit once in the clockwise direction,
    * otherwise return -1. If there exists a solution, it is guaranteed to be unique.
    */

    public int solution(int[] gas, int[] cost) {
        outer:
        for (int starting = 0; starting < gas.length; starting++) {
            int remainingFuel = 0;
            inner:
            for(int i = 0; i <=gas.length; i++) {
                int idx = (starting + i) % gas.length;
                if (remainingFuel < 0) {
                    continue outer;
                }else {
                    remainingFuel += gas[idx];
                    remainingFuel -= cost[idx];
                }
            }

            return starting;
        }
        return -1;
    }

    public int solution2(int[] gas, int[]costs) {
        int fuel = 0;
        int start = 0;
        int currentFuel = 0;
        for (int i = 0; i < gas.length; i++) {
            fuel += gas[i]-costs[i];
            currentFuel += gas[i]-costs[i];
            if (currentFuel < 0) {
                currentFuel = 0;
                start = i+1;
            }

        }
        if (fuel < 0) {
            return -1;
        } else {
            return start;
        }

    }

    public static void main(String[] args) {
        int [] gas = {1,2,3,4,5};
        int [] costs = {3,4,5,1,2};

        int res = new GasStation().solution(gas, costs);
        res = 1;
    }
}
