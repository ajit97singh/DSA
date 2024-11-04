package src.src.leetCode.easy;

import java.util.Objects;

public class AddingTwoNumbers {
    //TODO: NOT SOLVED
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode currentNode = result;

            boolean list1End = false;
            boolean list2End = false;

            ListNode list1Current = l1;
            ListNode list2Current = l2;
            int list1Value = 0;
            int list2Value = 0;
            int carryOver = 0;
            int currentPlace = 0;
            while(!list1End || !list2End || carryOver>0){
                if(!Objects.isNull(list1Current)){
                    list1Value = list1Current.val;
                    list1Current = list1Current.next;
                }else{
                    list1Value = 0;
                    list1End = true;
                }

                if(!Objects.isNull(list2Current)){
                    list2Value = list2Current.val;
                    list2Current = list2Current.next;
                }else{
                    list2Value = 0;
                    list2End = true;
                }
                currentPlace = list1Value+list2Value+currentNode.val;
                if(currentPlace>=10){
                    currentPlace -= 10;
                    carryOver = 1;
                }else{
                    carryOver = 0;
                }
                currentNode = new ListNode(currentPlace, new ListNode(carryOver));
                currentNode = currentNode.next;
            }
            return result;
        }

        public static void main(String [] args){
            ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
            ListNode l2 = new ListNode(5,new ListNode(6, new ListNode(4)));
            System.out.println(addTwoNumbers(l1, l2));

        }
}
