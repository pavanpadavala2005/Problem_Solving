import java.util.*;

public class July22 {
    // ! =============== LC 141. Linked List Cycle ================
    // !============= CYCLE IN LINKED LIST =============
    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public static boolean hasCycleOptimal(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            if (fast == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    // @ Time Complexity: O(N)
    // @ Space Complexity: O(N)
    public static boolean hasCycleBrute(Node head) {
        HashSet<Node> nodes = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (nodes.contains(temp))
                return true;
            nodes.add(temp);
            temp = temp.next;
        }
        return false;
    }

    // ! =============== LC 142. Linked List Cycle II ================
    // !======= STARTING NODE OF CYCLE =========
    // @ Time Complexity: O(N)
    // @ Space Complexity: O(N)
    public static Node startingNodeOfCycle(Node head) {
        HashSet<Node> nodes = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (nodes.contains(temp))
                return temp;
            nodes.add(temp);
            temp = temp.next;
        }
        return null;
    }

}