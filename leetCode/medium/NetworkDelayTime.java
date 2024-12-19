package src.src.leetCode.medium;

import java.util.*;

public class NetworkDelayTime {
    /*
    * You are given a network of n nodes, labeled from 1 to n.
    * You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
    * where ui is source, vi is target node, and wi is the time it takes for a signal to travel from source to target.
    * We will send a signal from a given node k.
    * Return the minimum time it takes for all the n nodes to receive the signal.
    * If it is impossible for all the n nodes to receive the signal, return -1.
    */

    // NOTE: This will be solved using Dijkstra's Algorithm
    // The essene of the algorithm is that we access the nodes with the least cost first

    public int solution(int[][] times, int n, int k) {
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int timeTaken = time[2];
            if (!map.containsKey(source)) {
                map.put(source, new ArrayList<>());
            }
            map.get(source).add(new Integer[]{dest, timeTaken});
        }


        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new Integer[]{k,0});
        HashSet<Integer> visited = new HashSet<>();
        int timeSpent = 0;
        while (!pq.isEmpty()) {
            Integer [] data = pq.poll();
            int dest = data[0];
            int timeToReach = data[1];

            if (visited.contains(dest)) {
                continue;
            }
            visited.add(dest);
            timeSpent = Math.max(timeToReach, timeSpent);

            List<Integer[]> neighbours = map.getOrDefault(dest, new ArrayList<>());
            for(Integer[] neighbour: neighbours) {
                if (!visited.contains(neighbour[0])) {
                    pq.add(new Integer[]{neighbour[0], neighbour[1] + timeToReach});
                }
            }
        }
        return visited.size() == n ? timeSpent:-1;
    }

    public static void main(String[] args) {
        int[][] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };
        int res = new NetworkDelayTime().solution(times, 4,2);
        res  = 1;

    }
}
