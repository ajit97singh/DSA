package src.src.crackingTheCodingInterview.linkedLists;

public class SumLists {
    /*
    you have two numbers represented by a linked list, where each node contains a single
    digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
    Write a function that adds the two numbers and returns the sum as a linked list.
    */

    Node solution(Node list1, Node list2) {
        int depth = 0;
        int sum = 0;
        while (list1 != null || list2!=null) {
            int l1Element = 0;
            int l2Element = 0;

            if (list1 != null) {
                l1Element = list1.value;
                list1 = list1.next;
            }

            if (list2 != null) {
                l2Element = list2.value;
                list2 = list2.next;
            }
            sum += (int)Math.pow(10, depth) * (l1Element + l2Element);
            depth++;
        }

        Node result = new Node(0);
        Node currentNode = result;

        while (sum != 0) {
            int remainder = sum % 10;
            sum = sum/10;
            currentNode.next = new Node(remainder);
            currentNode = currentNode.next;
        }
        return result.next;
    }


    Node solution2(Node list1, Node list2) {

        Node result = new Node(0);
        Node res = result;
        int carryOver = 0;
        while (list1 != null || list2!=null) {

            int l1Element = 0;
            int l2Element = 0;

            if (list1!=null) {
                l1Element = list1.value;
                list1 = list1.next;
            }

            if (list2!=null) {
                l2Element = list2.value;
                list2 = list2.next;
            }

            int sum = l1Element + l2Element + carryOver;
            if (sum >=10) {
                carryOver = 1;
                sum -= 10;
            }else {
                carryOver = 0;
            }
            res.next = new Node(sum);
            res = res.next;
        }
        return result.next;
    }




    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2,null);

        Node tail = new Node(9, null);

        Node res = new SumLists().solution2(head, tail);
        res.print();

    }



}
