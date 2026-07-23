import java.util.*;

public class July22 {
    // !============= CYCLE IN LINKED LIST =============
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

    // !======= STARTING NODE OF CYCLE =========
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