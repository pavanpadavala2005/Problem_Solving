import java.util.*;

public class July22 {
    // ! =============== LC141. Linked List Cycle ================
    // !============= CYCLE IN LINKED LIST =============
    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
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

    /*
     @ TC --> O(N)
     @ SC --> O(N)
    */
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

    // ! =============== LC142. Linked List Cycle II ================
    // !======= STARTING NODE OF CYCLE =========
    /*
     @ TC --> O(N)
     @ SC --> O(N)
    */
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