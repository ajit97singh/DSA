package src.src.algoexpert.hard;

import java.util.*;

public class TopologicalSort {

    public static List<Integer> topologicalSort(
            List<Integer> jobs, List<Integer[]> deps
    ) {
        // Write your code here.
        HashMap<Integer, HashSet<Integer>> dependencies = new HashMap<>();
        for (Integer[] dep: deps) {
            if(!dependencies.containsKey(dep[0])){
                dependencies.put(dep[0], new HashSet<>());
            }
            dependencies.get(dep[0]).add(dep[1]);
        }
        for(Integer job: jobs) {
            if (!dependencies.containsKey(job)){
                dependencies.put(job, new HashSet<>());
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        int iterationsLeft = jobs.size();
        while(iterationsLeft > 0) {
            for(Integer job: jobs) {
                // extract a job id which has empty dependency set
                if (dependencies.containsKey(job) && dependencies.get(job).isEmpty()){
                    // add to result
                    dependencies.remove(job);
                    result.add(job);
                    for(HashSet<Integer> value: dependencies.values()){
                        if(value.contains(job)){
                            value.remove(job);
                        }
                    }
                }
            }
            iterationsLeft--;
        }
        if (dependencies.size()>0){
            return new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> jobs =List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[]{3, 1});
        deps.add(new Integer[]{8, 1});
        deps.add(new Integer[]{8, 7});
        deps.add(new Integer[]{5, 7});
        deps.add(new Integer[]{5, 2});
        deps.add(new Integer[]{1, 4});
        deps.add(new Integer[]{6, 7});
        deps.add(new Integer[]{1, 2});
        deps.add(new Integer[]{7, 6});
        List<Integer> sol = topologicalSort(jobs, deps);
        sol = null;
    }
}
