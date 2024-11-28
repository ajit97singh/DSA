package src.src.crackingTheCodingInterview.linkedLists;

import java.util.Stack;

public class Partition {
    /*
    * Write code to partition a linked list around a value x, such that all nodes less than x come
    * before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
    * to be after the elements less than x (see below). The partition element x can appear anywhere in the
    * "right partition"; it does not need to appear between the left and right partitions.
    * */

    Node solution1 (Node head, int target) {

        Stack<Integer> lesser = new Stack<>();
        Stack<Integer> greater = new Stack<>();

        while (head!=null) {
            int currentValue = head.value;
            if (currentValue>=target) {
                greater.add(currentValue);
            }else {
                lesser.add(currentValue);
            }
            head = head.next;
        }
        Node resultHead;
        if (lesser.isEmpty()) {
            resultHead = new Node(greater.pop());
        }else {
            resultHead = new Node(lesser.pop());
        }

        Node currentNode = resultHead;
        while (!lesser.isEmpty()) {
            currentNode.next = new Node(lesser.pop());
            currentNode = currentNode.next;
        }
        while (!greater.isEmpty()) {
            currentNode.next = new Node(greater.pop());
            currentNode = currentNode.next;
        }
        return resultHead;
    }

    Node solution2 (Node head, int target) {
        Node lesserStart = new Node(0);
        Node lesserEnd = lesserStart;
        Node greaterStart = new Node(0);
        Node greaterEnd = greaterStart;

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.value >= target) {
                greaterEnd = currentNode;
                greaterEnd = greaterEnd.next;
            } else {
                lesserEnd = currentNode;
                lesserEnd = lesserEnd.next;
            }
            currentNode = currentNode.next;
        }

        lesserEnd.next = greaterStart.next;
        return lesserStart;
    }



    public static void main(String [] args) {

        Node head = new Node(11);
        head.next = new Node(12);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(7, null);

        head.print();
        head = new Partition().solution2(head, 7);
        head.print();
    }

}
