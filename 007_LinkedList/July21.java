
import java.util.ArrayList;
import java.util.Stack;

public class July21 {
    // ! ================ UTILITY METHODS =================
    // @ TC --> O(N^2)
    // @ SC --> O(1)
    public static Node getHead(int[] nums) {
        SinglyLinkedList sll = new SinglyLinkedList();
        for (int i : nums)
            sll.insertAtTail(i);
        return sll.head;
    }

    // @ TC --> O(N)
    // @ SC --> O(1)
    public static Node getNode(Node head, int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target)
                break;
            temp = temp.next;
        }
        return temp;
    }

    // @ TC --> O(N)
    // @ SC --> O(N)
    public static ArrayList getList(Node head) {
        ArrayList<Integer> res = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            res.add(temp.data);
            temp = temp.next;
        }
        return res;
    }

    // ! =============== LC237. Delete Node in a Linked List ================
    // ! ================= DELETE NODE ===============
    // @ TC --> O(N)
    // @ SC --> O(1)
    public static void deletNodeBrute(Node node) {
        Node prev = node;
        Node curr = prev.next;
        while (curr.next != null) {
            prev.data = curr.data;
            prev = curr;
            curr = curr.next;
        }
        prev.data = curr.data;
        prev.next = null;
    }

    // @ TC --> O(1)
    // @ SC --> O(1)
    public void deleteNodeOptimal(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    // ! =============== LC876. Middle of the Linked List ================
    // ! ================ FIND MIDDLE NODE ===================
    // @ TC --> O(N)
    // @ SC --> O(1)
    public static Node middleOfLinkedListBrute(Node head) {
        Node temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        n = n / 2;
        int ctr = 0;
        temp = head;
        while (temp != null) {
            if (ctr == n)
                break;
            ctr++;
            temp = temp.next;
        }
        return temp;
    }

    // @ TC --> O(N)
    // @ SC --> O(1)
    public static Node middleOfLinkedListOptimal(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // ! =============== LC206. Reverse Linked List ================
    // ! ============= REVERSE LINKED LIST ============
    // @ TC --> O(N)
    // @ SC --> O(N)
    public static Node reverseLinkedListBrute(Node head) {
        Stack<Integer> elems = new Stack<>();
        Node temp = head;
        while (temp != null) {
            elems.add(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = elems.pop();
            temp = temp.next;
        }
        return head;
    }

    // @ TC --> O(N)
    // @ SC --> O(1)
    public static Node reverseLinkedListOptimal(Node head) {
        Node prev = null;
        Node curr = head;
        Node after = head;
        while (curr != null) {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }

    // @ TC --> O(N)
    // @ SC --> O(N)
    public static Node reverseLinkedListRec(Node prev, Node curr, Node after) {
        if (curr == null)
            return prev;
        after = curr.next;
        curr.next = prev;
        prev = curr;
        curr = after;
        return reverseLinkedListRec(prev, curr, after);
    }
}