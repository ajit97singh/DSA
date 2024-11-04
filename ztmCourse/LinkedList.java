package src.src.ztmCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedList {
    private int value;
    private LinkedList next;
    private LinkedList previous;
    private LinkedList tail;
    private LinkedList head;
    private int length;

    public LinkedList(int val){
        this.value = val;
        this.length = 1;
        this.next = null;
        this.previous = null;
        this.head = this;
        this.tail = this;
    }

    public void append(int val){
        this.length++;
        LinkedList newNode = new LinkedList(val);
        newNode.previous = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public void prepend(int val){
        LinkedList newNode = new LinkedList(val);
        this.head.previous = newNode;
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    public void printList(){
        LinkedList currentNode = this.head;
        List<Integer> array = new ArrayList<>();
        while (Objects.nonNull(currentNode)){
            array.add(currentNode.value);
            currentNode = currentNode.next;
        }
        System.out.println(array);
    }

    public LinkedList traverseToIndex(int index){
        if(index<=0){
            return this.head;
        } else if (index >= this.length) {
            return this.tail;
        }
        int currentIndex = 0;
        LinkedList result = this.head;
        while (Objects.nonNull(result)){
            if(currentIndex == index){
                break;
            }
            currentIndex++;
            result = result.next;
        }

        return result;
    }

    public void insert(int value, int index){
        if(index<=0){
            this.prepend(value);
        }else if (index>= this.length){
            this.append(value);
        }else {
            int currentIndex = 0;
            LinkedList newNode = new LinkedList(value);
            LinkedList leaderNode = this.head;
            LinkedList followerNode = leaderNode.next;
            while (Objects.nonNull(leaderNode)){
                if(currentIndex == index -1 ){
                    newNode.next = followerNode;
                    followerNode.previous = newNode;
                    newNode.previous = leaderNode;
                    leaderNode.next = newNode;
                    break;
                }
                currentIndex++;
                leaderNode = leaderNode.next;
                followerNode = followerNode.next;
            }
        }
        this.length++;
    }

    public void insertNew(int value, int index){
        if(index<=0){
            this.prepend(value);
        }else if (index>= this.length){
            this.append(value);
        }else {
            LinkedList newNode = new LinkedList(value);
            LinkedList leaderNode = this.traverseToIndex(index - 1);
            LinkedList followerNode = leaderNode.next;
            newNode.next = followerNode;
            followerNode.previous = newNode;
            newNode.previous = leaderNode;
            leaderNode.next = newNode;
        }
        this.length++;
    }

    public void remove(int index){
        if(index <= 0){
            this.head = this.next;
        }else {
            if (index>=this.length) {
                index = this.length - 1;
            }
            LinkedList leaderNode = this.traverseToIndex(index - 1);
            LinkedList toDelete = leaderNode.next;
            LinkedList follower = toDelete.next;
            if(Objects.isNull(follower)){
                this.tail = leaderNode;
                leaderNode.next = null;
            }else {
                leaderNode.next = follower;
                follower.previous = leaderNode;
            }
        }
        this.length--;
    }

    public void reverse(){
        if(Objects.isNull(this.head.next)){
            return;
        }
        LinkedList nodeToAppend = this.head;
        this.head = new LinkedList(this.tail.value);
        LinkedList currentNode = this.head;
        while (Objects.nonNull(nodeToAppend.next)){
            currentNode.next = nodeToAppend;
            nodeToAppend = nodeToAppend.next;
            currentNode = currentNode.next;
        }
        currentNode.next = nodeToAppend;
        this.tail = nodeToAppend;
    }

    public static void main(String[] args) {
        LinkedList x = new LinkedList(12);
        x.append(1);
        x.prepend(0);
        x.prepend(111);
        x.insertNew(7, 1);
        x.remove(63);
        x.reverse();
        x.printList();
    }
}
