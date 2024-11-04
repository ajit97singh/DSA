package src.src.leetCode.medium;

import src.src.leetCodeUtils.ListNode;

import java.util.Objects;

public class MergeNodesInBetweenZeros {

    /*
    You are given the head of a linked list, which contains a series of integers separated by 0's.
    The beginning and end of the linked list will have Node.val == 0.
    For every two consecutive 0's, merge all the nodes lying in between them into a single node,
    whose value is the sum of all the merged nodes. The modified list should not contain any 0's.
    Return the head of the modified linked list.
    */


    public static ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode(0);
        int sum = 0;
        ListNode currentNodeOfInput = head.next;
        ListNode currentNodeOfResult = result;

        while (Objects.nonNull(currentNodeOfInput) && currentNodeOfInput.hasNext()) {
            while (currentNodeOfInput.val != 0) {
                sum += currentNodeOfInput.val;
                currentNodeOfInput = currentNodeOfInput.next;
            }

            currentNodeOfResult.next = new ListNode(sum);
            sum = 0;
            currentNodeOfResult = currentNodeOfResult.next;
            currentNodeOfInput = currentNodeOfInput.next;

        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(new int[] {0,3,1,0,4,5,2,0});

        ListNode output = mergeNodes(input);
        System.out.println(output);
    }

}
