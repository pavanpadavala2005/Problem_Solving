import java.util.*;

// ! =============== GEN. Singly Linked List Utilities ================

class SLLNode {
    int data; // ! Data Part
    SLLNode next; // ! Link Part to the next SLLNode

    public SLLNode() {
        this.data = Integer.MIN_VALUE;
        this.next = null;
    }

    public SLLNode(int data) {
        this.data = data;
        this.next = null;
    }

    public SLLNode(int data, SLLNode next) {
        this.data = data;
        this.next = next;
    }

}

public class SinglyLinkedListUtils {

    // * =============== NORMAL UTILS =============
    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    public static SLLNode reverseLinkedList(SLLNode head) {
        SLLNode prev = null;
        SLLNode temp = head;
        SLLNode after = head;
        while (temp != null) {
            after = temp.next;
            temp.next = prev;
            prev = temp;
            temp = after;
        }
        return prev;
    }

    // ! ================ UTILITY METHODS =================
    /*
     @ TC --> O(N^2)
     @ SC --> O(1)
    */
    public static SLLNode getHead(int[] nums) {
        SinglyLinkedList sll = new SinglyLinkedList();
        for (int i : nums)
            sll.insertAtTail(i);
        return sll.head;
    }

    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    public static SLLNode getLLNode(SLLNode head, int target) {
        SLLNode temp = head;
        while (temp != null) {
            if (temp.data == target)
                break;
            temp = temp.next;
        }
        return temp;
    }

    /*
     @ TC --> O(N)
     @ SC --> O(N)
    */
    public static ArrayList getList(SLLNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        SLLNode temp = head;
        while (temp != null) {
            res.add(temp.data);
            temp = temp.next;
        }
        return res;
    }

    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    public static void keepCycle(SLLNode head, int pos) {
        if (pos == -1)
            return;
        int ctr = 1;
        SLLNode curr = null;
        SLLNode temp = head;
        while (temp.next != null) {
            if (ctr == pos)
                curr = temp;
            ctr++;
            temp = temp.next;
        }
        temp.next = curr;
    }

    /*
     @ TC --> O(N + M)
     @ SC --> O(1)
    */
    public static void createIntersection(SLLNode headA, SLLNode headB, int skipA, int skipB, boolean isIntersect) {
        if (isIntersect == false)
            return;
        SLLNode tempA = headA;
        SLLNode tempB = headB;
        for (int i = 0; i < skipA; i++)
            tempA = tempA.next;
        for (int i = 1; i < skipB; i++)
            tempB = tempB.next;
        tempB.next = tempA;
    }
}
