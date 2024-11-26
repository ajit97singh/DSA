package src.src.crackingTheCodingInterview.linkedLists;

public class DeleteMiddleNode {
    /*
    * Implement an algorithm to delete a node in the middle (i.e., any node but
    * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
    * EXAMPLE
    * input: the node c from the linked list a->b->c->d->e->f
    * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
    */


    void solution(Node head, Node toDelete) {
        Node current = head;
        while (current.next.next != null) {
            if (current.next == toDelete) {
                current.next = current.next.next;
                break;
            }else {
                current = current.next;
            }
        }
    }

    public static void main(String [] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);

        head.print();

        new DeleteMiddleNode().solution(head, head.next);
        head.print();

    }

}
