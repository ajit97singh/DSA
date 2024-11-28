package src.src.crackingTheCodingInterview.stacksAndQueues;

import java.util.Stack;


class Node {

    Node next = null;
    Stack<Integer> value = null;
    int stackSize = 0;


    Node(Stack<Integer> val) {
        this.value = val;
    }

    Node(Stack<Integer> val, Node node) {
        this.value = val;
        this.next = node;
    }


}


public class SetOfStacks {


    Node setOfStacks = new Node(new Stack<Integer>());
    int threshold;



    SetOfStacks(int thres) {
        this.threshold = thres;
    }


    void push(int input) {

        Stack<Integer> currentStack = setOfStacks.value;
        int currentStackSize = setOfStacks.stackSize;
        if (currentStackSize < threshold) {
            currentStack.push(input);
            setOfStacks.stackSize++;
        }else {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(input);
            Node temp = new Node(newStack);
            temp.next = setOfStacks;
            temp.stackSize = 1;
            setOfStacks = temp;
        }

    }


    int pop(){

        Stack<Integer> currentStack = setOfStacks.value;
        if (!currentStack.isEmpty()) {
            setOfStacks.stackSize--;
            return currentStack.pop();
        }else {
            if (setOfStacks.next != null) {
                setOfStacks = setOfStacks.next;
                setOfStacks.stackSize--;
                return setOfStacks.value.pop();
            }else{
                currentStack.pop(); // automatically throws an exception
            }

        }
        return 0;
    }

    int popAt(int index) {
        Node currentStack = setOfStacks;
        int distanceRemaining = index;
        while (distanceRemaining !=0) {
            if(currentStack == null) {
                throw new RuntimeException();
            }
            currentStack = currentStack.next;
            distanceRemaining--;
        }
        currentStack.stackSize--;
        return currentStack.value.pop();
    }


    public static void main(String [] args) {
        SetOfStacks set = new SetOfStacks(3);
        set.push(1);
        set.push(2);
        set.push(3);
        set.push(4);
        set.push(5);
        set.push(6);
        set.push(7);
        set.push(8);
        set.push(9);

        System.out.println(set.pop());

        set.popAt(1);

        set.popAt(4);
    }


}
