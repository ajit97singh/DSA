package src.src.crackingTheCodingInterview.stacksAndQueues;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();



    void push(int i) {

        if(minStack.isEmpty()) {
            minStack.push(i);
        }else {
            if (i <= minStack.peek()){
                minStack.push(i);
            }
        }
        stack.push(i);
    }


    int pop() {

        int i = stack.pop();
        if (i == minStack.peek()){
            minStack.pop();
        }
        return i;
    }

    int min(){
        return minStack.peek();
    }



}
