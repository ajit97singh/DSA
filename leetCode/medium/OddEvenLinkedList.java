package src.src.leetCode.medium;

import src.src.leetCodeUtils.ListNode;
import src.src.ztmCourse.LinkedList;

import java.util.Objects;

public class OddEvenLinkedList {
    /*
    Given the head of a singly linked list, group all the nodes with odd indices together followed by
    the nodes with even indices, and return the reordered list.
    The first node is considered odd, and the second node is even, and so on.
    Note that the relative order inside both the even and odd groups should remain as it was in the input.
    You must solve the problem in O(1) extra space complexity and O(n) time complexity.
    */

    public static ListNode oddEvenList(ListNode head) {

        if(Objects.isNull(head) || Objects.isNull(head.next) || Objects.isNull(head.next.next)){
            return head;
        }


        ListNode oddListNode = head;
        ListNode oddListHead = oddListNode;

        ListNode evenListNode = head.next;
        ListNode evenListHead = evenListNode;


        ListNode currentNode = head.next.next;

        int index = 1;
        while (Objects.nonNull(currentNode)){

            if(index%2==0){
                if (Objects.nonNull(evenListNode)) {
                    evenListNode = evenListNode.next;
                }
                evenListNode = new ListNode(currentNode.val);
            }else {
                if (Objects.nonNull(oddListNode)){
                    oddListNode = oddListNode.next;
                }
                oddListNode = new ListNode(currentNode.val);
            }

            currentNode = currentNode.next;
            index++;
            System.gc();

        }
        oddListNode.next = evenListHead;
        return oddListHead;

    }

    public static void test(){

        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode firstPointer = input;
        ListNode secondPointer = input;

        System.out.println("firstPointer --> " + firstPointer.val);
        System.out.println("secondPointer --> " + secondPointer.val);

        firstPointer = firstPointer.next;

        System.out.println("firstPointer --> " + firstPointer.val);
        System.out.println("secondPointer --> " + secondPointer.val);

    }

    public static void main(String[] args) {
//        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode output = oddEvenList(input);
//        System.out.println(output);
        test();
    }


}
