package src.src.leetCode.easy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NumberOfRecentCalls {
    /*
    * You have a NumberOfRecentCalls class which counts the number of recent requests within a certain time frame.
    * Implement the RecentCounter class:
    * RecentCounter() Initializes the counter with zero recent requests.
    * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
    * and returns the number of requests that has happened in the past 3000 milliseconds (including the new request).
    * Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
    * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
    */

    private final Stack<Integer> stack;

    public NumberOfRecentCalls() {
        stack = new Stack<>();
    }

    public int ping(int t) {
        this.stack.add(t);
        List<Integer> tempStack = new ArrayList<>();
        int ans = 0;
        while (!this.stack.isEmpty()){
            int callTime = this.stack.pop();
            tempStack.add(callTime);
            ans++;
            if(t - callTime > 3000){
                break;
            }
        }
        Collections.reverse(tempStack);
        this.stack.addAll(tempStack);
        return ans;
    }


    public static void main(String[] args) {
        System.out.println();
    }


//     Faster solution as this does not use more space
//    private Queue<Integer> requests;
//    public RecentCounter() {
//       this.requests = new LinkedList<>();
//    }
//
//    public int ping(int t) {
//        requests.add(t);
//        while (requests.peek() < t - 3000) {
//            requests.poll();
//        }
//        return requests.size();
//    }
}
