package src.src.leetCode.medium;


import src.src.leetCodeUtils.ListNode;
import java.util.Stack;

public class MaximumTwinSumOfLinkedList {
    /*
    In a linked list of size n, where n is even,
    the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
    For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2.
    These are the only nodes with twins for n = 4.
    The twin sum is defined as the sum of a node and its twin.
    Given the head of a linked list with even length, return the maximum twin sum of the linked list.
    */

    public static int pairSum(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode slow = head;
        ListNode fast = head.next;

        while (true){
            stack.add(slow.val);

            if(fast.hasNext()){  // since list has always even number of nodes
                fast = fast.next;
                fast = fast.next;
            }else {
                break;
            }
            slow = slow.next;
        }
        int max = 0;

        while (!stack.isEmpty()){
            slow = slow.next;
            max = Math.max(max, stack.pop() + slow.val);
        }

        return max;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));
        int output = pairSum(input);
        System.out.println(output);
    }
}
