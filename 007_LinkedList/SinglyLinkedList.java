class Node {
    int data; // ! Data Part
    Node next; // ! Link Part to the next Node

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // ! ============== HELPER FUNCTIONS FOR LINKED LIST =============
    private boolean isEmpty() {
        return this.head == null;
    }

    // ! ============== OPERATIONS FOR LINKED LIST =============

    // **************** INSERTION ****************
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            // * When there is No Head Node
            this.head = newNode;
            return;
        }
        newNode.next = this.head;
        this.head = newNode;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.head = newNode;
            return;
        }
        Node temp = this.head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public void insertAfterIndex(int index, int data) {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        int ctr = 0; // ! 0 for Insert After and 1 for Insert at That position
        Node temp = this.head;
        while (temp != null) {
            if (ctr++ == index)
                break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Index out of Bounds");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertAfterNode(int node, int data) {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        Node temp = this.head;
        while (temp != null) {
            if (temp.data == node)
                break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node With Data : " + node + " Not Found !!");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // ***************** DELETION ******************

    public void deleteAtHead() {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        if (this.head.next == null) {
            this.head = null;
            return;
        }
        this.head = this.head.next;
    }

    public void deleteAtTail() {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        if (this.head.next == null) {
            this.head = null;
            return;
        }
        Node temp = this.head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteIndex(int index) {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        int ctr = 1;
        Node temp = this.head;
        while (temp != null) {
            if (ctr == index)
                break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Index out of Bounds");
            return;
        }
    }

    public void printList() {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        System.out.print("HEAD-->");
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("NULL" + "\n");
    }
}