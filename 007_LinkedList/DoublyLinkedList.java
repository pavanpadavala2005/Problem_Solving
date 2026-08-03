
class DNode {
    DNode prev;
    int data;
    DNode next;

    public DNode() {
        this.prev = null;
        this.data = -1;
        this.next = null;
    }

    public DNode(int data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }

    public DNode(int data, DNode prev, DNode next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

}

public class DoublyLinkedList {
    DNode head;
    DNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // * ============ UTILS ===========
    public boolean isEmpty() {
        return (this.head == null) && (this.tail == null);
    }

    // ! ========= INSERTION OPERATIONS ===========
    public void insertAtHead(int data) {
        DNode newNode = new DNode(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        newNode.next = this.head;
        this.head.prev = newNode;
        this.head = newNode;
    }

    public void insertAtTail(int data) {
        DNode newNode = new DNode(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
    }

    public void insertAtPos(int pos, int data) {
        if (this.isEmpty()) {
            System.out.println("Doubly Linked List is Empty can't Insert");
            return;
        }
        DNode temp = this.head;
        while (temp != null && pos > 1) {
            temp = temp.next;
            pos--;
        }
        if (temp == null) {
            System.out.println("Position out Of range Can't Insert !!");
            return;
        }
        if (temp == head) {
            this.insertAtHead(data);
            return;
        }
        if (temp == tail) {
            this.insertAtTail(data);
            return;
        }
        DNode newNode = new DNode(data);
        newNode.next = temp.next;
        temp.next.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
    }

    // ! ========= DELETE OPERATIONS ===============
    public void deleteHead() {
        if (this.isEmpty()) {
            System.out.println("Doubly Linked List is Empty Can't Delete Head !!");
            return;
        }
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            return;
        }
        this.head = this.head.next;
        this.head.prev = null;
    }

    public void deleteTail() {
        if (this.isEmpty()) {
            System.out.println("Doubly Linked List is Empty Can't Delete Head !!");
            return;
        }
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            return;
        }
        this.tail = this.tail.prev;
        this.tail.next = null;
    }

    public void deletePos(int pos) {
        if (this.isEmpty()) {
            System.out.println("Doubly Linked List is Empty Can't Delete At Position");
            return;
        }
        DNode temp = this.head;
        while (temp != null && pos > 1) {
            temp = temp.next;
            pos--;
        }
        if (temp == this.head) {
            this.deleteHead();
            return;
        }
        if (temp == this.tail) {
            this.deleteTail();
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // ! ========= TRAVERSING OPERATIONS ===========
    public void printForward() {
        if (this.isEmpty()) {
            System.out.println("Doubly Linked List is Empty !! can't Print Forward");
            return;
        }
        DNode temp = this.head;
        System.out.print("HEAD<->");
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print("TAIL");
        System.out.println();
    }

    public void printBackward() {
        if (this.isEmpty()) {
            System.out.println("Doubly Linked List is Empty !! can't Print Backward");
            return;
        }
        DNode temp = this.head;
        System.out.print("TAIL<->");
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print("HEAD");
        System.out.println();
    }
}
