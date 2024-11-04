package src.src.ztmCourse;

class MinStack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    private Node minValueNode;
    private Node top;



    public MinStack() {
        this.minValueNode = null;
        this.top = null;
    }

    public void push(int val) {
        this.minValueNode = new Node(
                Math.min(
                        Integer.parseInt(this.minValueNode.value.toString()),
                        val)
        );
        Node newNode = new Node(val);
        newNode.next = this.top;
        this.top = newNode;
    }

    public void pop() {

    }

    public int top() {
        return 0;
    }

    public int getMin() {
        return 0;
    }
}
