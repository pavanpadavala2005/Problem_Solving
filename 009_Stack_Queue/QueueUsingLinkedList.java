class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueUsingLinkedList {
    Node head;
    Node tail;

    public QueueUsingLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public int dequeue() {
        int val;
        if (this.isEmpty())
            val = -1;
        else if (this.head == this.tail) {
            val = this.head.data;
            this.head = this.tail = null;
        } else {
            val = this.head.data;
            this.head = this.head.next;
        }
        return val;
    }

    public int peek() {
        int val;
        if (this.isEmpty())
            val = -1;
        else
            val = this.head.data;
        return val;
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }
}