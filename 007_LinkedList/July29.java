
public class July29 {

    // !============== REVERSE DLL ==============
    // public static DNode reverseDoublyLinkedListOptimal(DNode head) {
    // DNode prev = null;
    // DNode temp = head;
    // DNode after = head;
    // while (temp != null) {
    // after = temp.next;
    // temp.next = prev;
    // temp.prev = after;

    // prev = temp;
    // temp = after;
    // }
    // return prev;
    // }

    // public static DNode reverseDoublyLinkedListBrute(DNode head) {
    // Stack<Integer> vals = new Stack<>();
    // DNode temp = head;
    // while (temp != null) {
    // vals.add(temp.data);
    // temp = temp.next;
    // }
    // temp = head;
    // while (temp != null) {
    // temp.data = vals.pop();
    // temp = temp.next;
    // }
    // return head;
    // }
}