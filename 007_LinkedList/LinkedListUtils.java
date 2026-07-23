import java.util.*;

public class LinkedListUtils {
    // ! ================ UTILITY METHODS =================
    public static Node getHead(int[] nums) {
        SinglyLinkedList sll = new SinglyLinkedList();
        for (int i : nums)
            sll.insertAtTail(i);
        return sll.head;
    }

    public static Node getNode(Node head, int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target)
                break;
            temp = temp.next;
        }
        return temp;
    }

    public static ArrayList getList(Node head) {
        ArrayList<Integer> res = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            res.add(temp.data);
            temp = temp.next;
        }
        return res;
    }

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
}
