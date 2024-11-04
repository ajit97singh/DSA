package src.src.leetCode.easy;

import java.util.Objects;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();
        ListNode l1Current = list1;
        ListNode l2Current = list2;
        while(l1Current!=null || l2Current!=null){
            int value = 0;
            int l1Value;
            int l2Value;
            if(!Objects.isNull(l1Current)){
                l1Value = l1Current.val;
            }else{
                l1Value = 101;
            }

            if(!Objects.isNull(l2Current)){
                l2Value = l2Current.val;
            }else{
                l2Value = 101;
            }

            if(l1Value >= l2Value){
                value = l2Value;
                l2Current = l2Current.next;
            }else{
                value = l1Value;
                l1Current = l1Current.next;
            }
            result.val = value;
            result = result.next;
        }
        return result;
    }
}
