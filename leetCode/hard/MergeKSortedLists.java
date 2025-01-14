package src.src.leetCode.hard;

import src.src.leetCodeUtils.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }else if (lists.length == 1){
            return lists[0];
        }

        ListNode result = new ListNode(-1);
        ListNode current = result;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode node: lists) {
            while(node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }
        while(!pq.isEmpty()) {
            current.next = new ListNode(pq.poll());
            current = current.next;
        }
        return result.next;
    }

    public static void main(String[] args) {

    }
}
