package src.src.crackingTheCodingInterview.linkedLists;

import java.util.HashSet;
public class RemoveDups {
    /*
    * Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?
    * */

//    Q : Should i keep the first occurrence and remove the rest ?


    void solution(Node head) {

        Node current = head;
        HashSet<Integer> existingValues = new HashSet<>();
        existingValues.add(head.value);

        while (current.next != null) {
            // inspect next node, if its a dupe remove it else add its value to set
            if(existingValues.contains(current.next.value)) {
                current.next = current.next.next;
            }else {
                existingValues.add(current.next.value);
                current = current.next;
            }
        }
    }
    // follow up solutions with O(1) space , increases time complexity

    void solution2(Node head) {

        Node current = head;
        while (current != null) {
            int currentVal = current.value;

            Node runner = current;
            while (runner != null && runner.next != null) {
                if (runner.next.value == currentVal) {
                    runner.next = runner.next.next;
                }
                runner = runner.next;
            }
            current = current.next;

        }


    }


    public static void main(String [] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(7, null);
        new RemoveDups().solution2(head);
//        while (head!=null) {
//            System.out.println(head.value);
//            head = head.next;
//        }
        head.print();
    }

}
