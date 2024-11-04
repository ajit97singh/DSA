package src.src.leetCode.medium;

import src.src.leetCodeUtils.ListNode;

import java.util.HashSet;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {

        HashSet<Object> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head.val)) {
                return false;
            }else {
                set.add(head.val);
                head = head.next;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        boolean hasCycle = hasCycle(head);
        System.out.println(hasCycle);
    }


}
