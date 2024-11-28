package src.src.crackingTheCodingInterview.linkedLists;

import java.util.Stack;

public class Palindrome {
    /*
    *  Implement a function to check if a linked list is a palindrome.
    */

    boolean solution1(Node head) {

        Node fast = head;
        Stack<Integer> stack = new Stack<>();
        int size = 0;

        while (fast != null) {
            // move fast
            fast = fast.next;
            size++;
            if (fast!=null) {
                fast = fast.next;
                stack.add(head.value);
                head = head.next;
                size++;
            }
        }

        if (size%2 != 0) {
            head = head.next;
        }

        while (!stack.isEmpty()) {
            int first = stack.pop();
            int second = head.value;
            head = head.next;
            if (first != second) {
                return false;
            }
        }
        return true;
    }

    public static void main(String [] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1, null);
        boolean x = new Palindrome().solution1(head);
        System.out.println(x);
    }
}
