package src.src.ztmCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack {
    public int length;
    public Node top;
    public Node bottom;

    public Stack(Object val){
        this.length = 1;
        this.top = new Node(val);
        this.bottom = this.top;

    }
    public Object peek(){
        Object result = this.top.value;
        System.out.println(result);
        return result;
    }

    public void add(Object val){
        Stack temp = this;
        Node newNode = new Node(val);
        newNode.next = temp.top;
        this.top = newNode;
        this.length++;
    }

    public Object pop(){
        if(this.length>1){
            Object result =  this.top.value;
            this.top = this.top.next;
            this.length --;
            System.out.println(result);
            return result;
        }else {
            this.top = null;
            this.bottom = null;
            this.length --;
            return null;
        }
    }

    public void printStack(){
        List<Object> res = new ArrayList<>();
        if(this.length>0){
            Node currentNode = this.top;
            while (Objects.nonNull(currentNode)){
                res.add(currentNode.value);
//                System.out.println(currentNode.value);
                currentNode = currentNode.next;
            }
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        Stack x = new Stack(12);
        x.add("1");
        x.add("2");
        x.add("3");
        x.peek();
        x.pop();
        x.pop();
        x.pop();
        x.pop();
        x.peek();
    }
}
