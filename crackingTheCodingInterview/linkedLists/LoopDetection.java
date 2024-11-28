package src.src.crackingTheCodingInterview.linkedLists;

public class LoopDetection {
    /*
    * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
    * DEFINITION
    * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
    * to make a loop in the linked list
    * */
    Node solution1(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node common = new Node(22);
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = common;
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = common;

        System.out.println(new LoopDetection().solution1(head).value);

    }



}
