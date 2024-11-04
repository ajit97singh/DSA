package src.src.leetCode.medium;

import src.src.leetCodeUtils.ListNode;

import java.util.Objects;

public class DeleteTheMiddleNodeOfLinkedList {
    /*
    You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
    The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
    where ⌊x⌋ denotes the largest integer less than or equal to x.
    For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
    */



    public static ListNode deleteMiddle(ListNode head) {
        if(!head.hasNext()){
            return new ListNode();
        }
        ListNode slow = head;
        ListNode fast = head;

        while (true){
            if(fast.hasNext()){
                fast = fast.next;
            }else {
                break;
            }
            if(fast.hasNext()){
                fast = fast.next;
            }else {
                break;
            }
            if(!fast.hasNext()){
                break;
            }
            slow = slow.next;
        }

        if(slow.next.hasNext()){
            slow.next = slow.next.next;
        }else {
            slow.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
//        [1,3,4,7,1,2,6]
//        ListNode input = new ListNode(1,
//                new ListNode(3,
//                        new ListNode(4,
//                                new ListNode(7,
//                                        new ListNode(1,
//                                                new ListNode(2,
//                                                        new ListNode(6, null)))))));
        ListNode input = new ListNode(1);
        ListNode output = deleteMiddle(input);
        System.out.println(output);
    }
}
