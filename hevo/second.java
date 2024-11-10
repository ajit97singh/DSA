package src.src.hevo;

import src.src.ztmCourse.Node;

import java.util.HashSet;
import java.util.Stack;

public class second {
    // linked list of size n , n is even always
    // node i , node n - i - 1 are twin nodes , max twin sum
    // n = 6
    // node , index = 1, val = 3 ,
    // twin = 6 - 1 - 1 ,it's index --> basically mirror in middle
    // sum = 3 + (5)
    // 6,0,0
    // 8, 4 -> 8

    public static int solution(Node root) {
        int result = 0;
        int size = 0;
        // use slow fast to reach the middle
        // this gives me size of list
        Node slow = root;
        Node fast = root;
        while (true) {
            size++;
            if (fast.next!=null) {
                slow = slow.next;
                fast = fast.next;
                if (fast.next!=null) {
                    fast = fast.next;
                }else {

                    break;
                }
            }
        }

        Node secondHalf = slow;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<size; i++) {
            stack.push((Integer) root.value);
            root = root.next;
        }
        Node firstHalf = new Node(stack.pop());
        Node pointer = firstHalf;
        while(!stack.isEmpty()) {
            pointer.next = new Node(stack.pop());
            pointer = pointer.next;
        }

        while (firstHalf!=null) {
            result = Math.max(result, (Integer) firstHalf.value + (Integer) secondHalf.value);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return result;
    }


    public static void main(String[] args) {
        Node root = new Node(1, new Node(-2, new Node(3, new Node(-4, new Node(5, new Node(96))))));
        System.out.println(solution(root));
    }
}
