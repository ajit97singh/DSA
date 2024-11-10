package src.src.ztmCourse;

public class Node {
    public Object value;
    public Node next;

    public Node(Object value){
        this.value = value;
    }
    public Node(Object value, Node next){
        this.value = value;
        this.next = next;
    }

}
