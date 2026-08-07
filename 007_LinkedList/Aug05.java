
public class Aug05 {
    // ! ===== 1290. Convert Binary Number in a Linked List to Integer ====
    public static int getDecimalValue(Node head) {
        if (head == null)
            return 0;
        int res = 0;
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.data == 1) {
                res |= (1 << n - 1);
            }
            n--;
            temp = temp.next;
        }
        return res;
    }

    // ! ============ 203. Remove Linked List Elements ==========
    public static Node removeElementsOptimal(Node head, int val) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (head != null) {
            if (head.data != val) {
                dummy.next = head;
                dummy = dummy.next;
            }
            head = head.next;
        }
        dummy.next = null;
        return temp.next;
    }

    public static Node removeElementsBrute(Node head, int val) {
        if (head == null)
            return head;
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}