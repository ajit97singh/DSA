package src.src.crackingTheCodingInterview.linkedLists;

public class Node {
    Node next = null;
    int value;

    public Node(int val) {
        value = val;
    }

    public Node(int val, Node nextNode) {
        value = val;
        next = nextNode;
    }

    public void appendToTail(int val) {
        Node toAppend = new Node(val);
        Node currentNode = this;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = toAppend;
    }

    public void print() {
        Node head = this;
        while (head!=null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
