package src.src.crackingTheCodingInterview.stacksAndQueues;

import java.util.*;

public class QueueViaStack {


    private Stack<Integer> current = new Stack<>();
    private Stack<Integer> storage = new Stack<>();




    void add(int input) {
        current.push(input);
    }

    boolean isEmpty() {
        return current.isEmpty() && storage.isEmpty();
    }

    int poll() {
        if (storage.isEmpty()) {
            while (!current.isEmpty()) {
                storage.push(current.pop());
            }
        }
        return storage.pop();
    }

    int peek() {
        if (storage.isEmpty()) {
            while (!current.isEmpty()) {
                storage.push(current.pop());
            }
        }
        return storage.peek();
    }


    public static void main(String[] args) {

        QueueViaStack test = new QueueViaStack();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.isEmpty());

    }


}
