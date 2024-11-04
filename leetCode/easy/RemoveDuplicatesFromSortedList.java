package src.src.leetCode.easy;

import java.util.Objects;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(Objects.isNull(head) || Objects.isNull(head.next)){
            return head;
        }

        ListNode result = new ListNode(head.val);
        ListNode currentNode = head;
        ListNode currentResult = result;

        while(!Objects.isNull(currentNode)){
            if(currentNode.val != currentResult.val){
                currentResult.next = new ListNode(currentNode.val);
                currentResult = currentResult.next;
            }
            currentNode = currentNode.next;
        }
        return result;
    }
}
