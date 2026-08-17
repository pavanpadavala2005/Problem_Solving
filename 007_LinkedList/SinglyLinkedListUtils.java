// ! =============== GENERAL. Singly Linked List Utilities ================
import java.util.*;

public class SinglyLinkedListUtils {

    // * =============== NORMAL UTILS =============
    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node temp = head;
        Node after = head;
        while (temp != null) {
            after = temp.next;
            temp.next = prev;
            prev = temp;
            temp = after;
        }
        return prev;
    }

    // ! ================ UTILITY METHODS =================
    // @ Time Complexity: O(N^2)
    // @ Space Complexity: O(1)
    public static Node getHead(int[] nums) {
        SinglyLinkedList sll = new SinglyLinkedList();
        for (int i : nums)
            sll.insertAtTail(i);
        return sll.head;
    }

    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public static Node getNode(Node head, int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target)
                break;
            temp = temp.next;
        }
        return temp;
    }

    // @ Time Complexity: O(N)
    // @ Space Complexity: O(N)
    public static ArrayList getList(Node head) {
        ArrayList<Integer> res = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            res.add(temp.data);
            temp = temp.next;
        }
        return res;
    }

    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public static void keepCycle(Node head, int pos) {
        if (pos == -1)
            return;
        int ctr = 1;
        Node curr = null;
        Node temp = head;
        while (temp.next != null) {
            if (ctr == pos)
                curr = temp;
            ctr++;
            temp = temp.next;
        }
        temp.next = curr;
    }

    // @ Time Complexity: O(N + M)
    // @ Space Complexity: O(1)
    public static void createIntersection(Node headA, Node headB, int skipA, int skipB, boolean isIntersect) {
        if (isIntersect == false)
            return;
        Node tempA = headA;
        Node tempB = headB;
        for (int i = 0; i < skipA; i++)
            tempA = tempA.next;
        for (int i = 1; i < skipB; i++)
            tempB = tempB.next;
        tempB.next = tempA;
    }
}
