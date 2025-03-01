package src.src.leetCode.medium;

import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int [] res = new int[temperatures.length];
        for(int i = temperatures.length-1; i>=0; i-- ) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.add(i);
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int [] input = new int[]{73,74,75,71,69,72,76,73};
        int [] out = dailyTemperatures(input);
        out = null;
    }
}
