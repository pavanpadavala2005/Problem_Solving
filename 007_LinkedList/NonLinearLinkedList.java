
// ! =============== GENERAL. Non-Linear Linked List Implementation ================
class NlNode {
    int data;
    NlNode next;
    NlNode bottom;

    NlNode(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}

public class NonLinearLinkedList {
    NlNode head;

    public NonLinearLinkedList() {
        this.head = null;
    }

    // ! =========== UTIL METHODS ===========
    // @ Time Complexity: O(1)
    // @ Space Complexity: O(1)
    public boolean isEmpty() {
        return this.head == null;
    }

    // ! ========== INSERTION ===============

    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public void insertAtTail(int data) {
        NlNode newNode = new NlNode(data);
        if (this.isEmpty()) {
            this.head = newNode;
            return;
        }

        NlNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // ! ======== TRAVERSAL =========
    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public void printLL() {
        if (this.isEmpty()) {
            System.out.println("Non Linear Linked List is Empty can't Print LL !!");
            return;
        }
        NlNode temp = this.head;
        System.out.print("HEAD->");
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

}
