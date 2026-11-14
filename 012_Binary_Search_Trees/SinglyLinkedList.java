// ! =============== GEN. Singly Linked List Implementation ================
// class SLLNode {
//     int data; // ! Data Part
//     SLLNode next; // ! Link Part to the next SLLNode

//     public SLLNode() {
//         this.data = Integer.MIN_VALUE;
//         this.next = null;
//     }

//     public SLLNode(int data) {
//         this.data = data;
//         this.next = null;
//     }

//     public SLLNode(int data, SLLNode next) {
//         this.data = data;
//         this.next = next;
//     }

// }

public class SinglyLinkedList {
    SLLNode head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // ! ============== HELPER FUNCTIONS FOR LINKED LIST =============
    /*
     @ TC --> O(1)
     @ SC --> O(1)
    */
    private boolean isEmpty() {
        return this.head == null;
    }

    // ! ============== OPERATIONS FOR LINKED LIST =============

    // **************** INSERTION ****************
    /*
     @ TC --> O(1)
     @ SC --> O(1)
    */
    public void insertAtHead(int data) {
        SLLNode newSLLNode = new SLLNode(data);
        if (this.isEmpty()) {
            // * When there is No Head SLLNode
            this.head = newSLLNode;
            return;
        }
        newSLLNode.next = this.head;
        this.head = newSLLNode;
    }

    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    public void insertAtTail(int data) {
        SLLNode newSLLNode = new SLLNode(data);
        if (this.isEmpty()) {
            this.head = newSLLNode;
            return;
        }
        SLLNode temp = this.head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newSLLNode;
    }

    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    public void insertAfterIndex(int index, int data) {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        int ctr = 0; // ! 0 for Insert After and 1 for Insert at That position
        SLLNode temp = this.head;
        while (temp != null) {
            if (ctr++ == index)
                break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Index out of Bounds");
            return;
        }
        SLLNode newSLLNode = new SLLNode(data);
        newSLLNode.next = temp.next;
        temp.next = newSLLNode;
    }

    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    public void insertAfterSLLNode(int SLLnode, int data) {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        SLLNode temp = this.head;
        while (temp != null) {
            if (temp.data == SLLnode)
                break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("SLLNode With Data : " + SLLnode + " Not Found !!");
            return;
        }
        SLLNode newSLLNode = new SLLNode(data);
        newSLLNode.next = temp.next;
        temp.next = newSLLNode;
    }

    // ***************** DELETION ******************

    /*
     @ TC --> O(1)
     @ SC --> O(1)
    */
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

    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    public void deleteAtTail() {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        if (this.head.next == null) {
            this.head = null;
            return;
        }
        SLLNode temp = this.head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    public void deleteIndex(int index) {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        int ctr = 1;
        SLLNode temp = this.head;
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

    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    public void printList() {
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        System.out.print("HEAD-->");
        SLLNode temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("NULL" + "\n");
    }
}