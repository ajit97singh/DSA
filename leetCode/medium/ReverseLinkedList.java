package src.src.leetCode.medium;

import src.src.leetCodeUtils.ListNode;

import java.util.Objects;
import java.util.Stack;

public class ReverseLinkedList {

//    Given the head of a singly linked list, reverse the list, and return the reversed list.
    public static ListNode reverseList(ListNode head) {
        if(Objects.isNull(head)){
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode result = new ListNode();
        ListNode currentNode = head;
        while (Objects.nonNull(currentNode)){
            stack.add(currentNode.val);
            currentNode = currentNode.next;
        }
        currentNode = result;
        while (!stack.isEmpty()){
            currentNode.val = stack.pop();
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
        }

        return result;

    }

    public static void main(String[] args) {
        ListNode input = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        ListNode output = reverseList(input);
        System.out.println(output);
    }
}
