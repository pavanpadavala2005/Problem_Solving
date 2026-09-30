class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLinkedList {
    Node head = null;

    public void push(int val) {
        Node newNode = new Node(val);
        if (this.isEmpty()) {
            this.head = newNode;
            return;
        }
        newNode.next = this.head;
        this.head = newNode;
    }

    public int pop() {
        if (this.isEmpty())
            return -1;
        int val = this.head.data;
        this.head = this.head.next;
        return val;
    }

    public int top() {
        if (this.isEmpty())
            return -1;
        return this.head.data;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}