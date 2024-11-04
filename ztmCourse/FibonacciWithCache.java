package src.src.ztmCourse;

import java.util.HashMap;

public class FibonacciWithCache {

    public static int solution(int input, HashMap<Integer, Integer> cache){
        if(input <= 1){
            cache.put(input, input);
            return input;
        }
        if(cache.containsKey(input)){
            return cache.get(input);
        }
        System.out.println("Operation");
        int result = solution(input - 1, cache) + solution(input - 2, cache);
        cache.put(input, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(50, new HashMap<>()));
    }


}
