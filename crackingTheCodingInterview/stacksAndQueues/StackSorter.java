package src.src.crackingTheCodingInterview.stacksAndQueues;

import java.util.*;

public class StackSorter {




    void sort(Stack<Integer> input) {


        Stack<Integer> temp = new Stack<>();


        while (!input.isEmpty()) {

            int element = input.pop();

            if (temp.isEmpty() || element >= temp.peek()) {
                temp.push(element);
            }else {

                while (!temp.isEmpty() && element < temp.peek()) {
                    input.push(temp.pop());
                }
                temp.push(element);

            }
        }
        while (!temp.isEmpty()) {
            input.push(temp.pop());
        }
    }


    public static void main(String[] args) {

        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(10);
        test.push(8);
        test.push(12);
        test.push(7);
        test.push(5);

        new StackSorter().sort(test);

        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }


    }



}
