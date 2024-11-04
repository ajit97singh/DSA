package src.src.leetCodeUtils;

import java.util.ArrayList;
import java.util.Objects;

public class ListNode {
    public Integer val;
    public ListNode next;
    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public ListNode(int [] values) {
        this(values[0]);
        int length = values.length;
        if (length==1) {
            return;
        }
        ListNode current = this;
        for (int i = 1; i < length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
    }


    public boolean hasNext(){
        return Objects.nonNull(this.next);
    }

    @Override
    public String toString() {
        ListNode currentNode = this;
        StringBuilder string = new StringBuilder("[");
        while (Objects.nonNull(currentNode)){
            string.append(currentNode.val);
            string.append(",");
            currentNode = currentNode.next;
        }
        string.deleteCharAt(string.length() - 1);
        string.append("]");
        return string.toString();
    }
}
