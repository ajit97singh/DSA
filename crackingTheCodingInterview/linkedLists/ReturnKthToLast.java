package src.src.crackingTheCodingInterview.linkedLists;

import java.util.concurrent.atomic.AtomicInteger;

public class ReturnKthToLast {

    // Implement an algorithm to find the kth to last element of a singly linked list.

    int solution(Node head, int k) {

        if (head == null) {
            return -1;
        }

        int size = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            size++;
        }
        int stepsToGo = size - k -1;
        // edge cases
        if (stepsToGo == 0) {
            return head.value;
        }else if (stepsToGo < 0 || stepsToGo > size) {
            return -1;
        }
        current = head;
        while (stepsToGo>0) {
            current = current.next;
            stepsToGo--;
        }
        return current.value;
    }

    int solution2(Node head, int k) {
        AtomicInteger val = new AtomicInteger(0);
        recursive(head, k, val);
        return val.get();

    }

    int recursive(Node node, int k, AtomicInteger val) {
        if (node == null) {
            return 0;
        }
        int index = recursive(node.next, k, val) + 1;
        if (index - 1 == k) {
            val.set(node.value);
//            System.out.println(node.value);
        }
        return index;
    }



    public static void main(String [] args) {

        Node head = new Node(5);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);

        int res = new ReturnKthToLast().solution2(head, 0);

        head.print();
        System.out.println(res);

    }


}
