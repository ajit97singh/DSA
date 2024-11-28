package src.src.crackingTheCodingInterview.linkedLists;

import java.util.HashSet;

public class Intersection {
    /*
    * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
    *  Note that the intersection is defined based on reference, not value. That is, if the kth node of
    *  the first linked list is the exact same node (by reference) as the jth node of the second linked list,
    *  then they are intersecting.
    */


    boolean solution1(Node list1, Node list2) {
        HashSet<Object> l1 = new HashSet<>();
        while (list1 != null) {
            l1.add(list1);
            list1 = list1.next;
        }
        while (list2 != null) {
            if(l1.contains(list2)){
                return true;
            }
            list2 = list2.next;
        }
        return false;
    }


    boolean solution2(Node list1, Node list2) {

        // if there is an intersection the end node will also be same , imagine below
        //       2 -> \
        //             9 -> 10 -> 11
        // 5 -> 1 -> /
        // because if it's the same node then that common node will have just one next node like the rest
        // don't imagine it like two straight lines
        while( list1.next != null) {
            list1 = list1.next;
        }

        while( list2.next != null) {
            list2 = list2.next;
        }
        return list1 == list2;
    }


    // now a follow up, return value of the common node

    int solution3(Node list1, Node list2) {

        int list1Size = 0;
        int list2Size = 0;

        Node list1Tracker = list1;
        Node list2Tracker = list2;

        while(list1Tracker!=null) {
            list1Tracker = list1Tracker.next;
            list1Size++;
        }

        while(list2Tracker!=null) {
            list2Tracker = list2Tracker.next;
            list2Size++;
        }

        int diff = Math.abs(list1Size - list2Size);

        if (list1Size > list2Size) {
            while (diff>0) {
                list1 = list1.next;
                diff--;
            }
        } else if(list1Size < list2Size) {
            while (diff>0) {
                list2 = list2.next;
                diff--;
            }
        }

        while (list1 != null) {
            if (list1 == list2) {
                return list1.value;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        return -1;

    }


    public static void main(String [] args) {

        Node common = new Node(1);

        Node list1 = new Node(-3);
        list1.next = new Node(-1);
        list1.next.next = common;

        Node list2 = new Node(-3);
        list2.next = new Node(-1);
        list2.next.next = common;
        list2.next.next.next = new Node(3);

        System.out.println(new Intersection().solution3(list1, list2));



    }
}
