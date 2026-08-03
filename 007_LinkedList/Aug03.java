import java.util.Stack;

public class Aug03 {

    // ! ============= ADD TWO NUMBERS BRUTE USING STACK ==================
    public static Node addTwoNumbersBrute(Node head1, Node head2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (head1 != null) {
            st1.add(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            st2.add(head2.data);
            head2 = head2.next;
        }
        int sum = 0;
        int carry = 0;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (!st1.isEmpty() || !st2.isEmpty() || carry > 0) {
            if (!st1.isEmpty())
                sum += st1.pop();
            if (!st2.isEmpty())
                sum += st2.pop();
            sum += carry;
            temp.next = new Node(sum % 10);
            carry = sum / 10;
            sum = 0;
            temp = temp.next;
        }
        return dummy.next;
    }

    // ! ============= ADD TWO NUMBERS ==================
    public static Node addTwoNumbers(Node head1, Node head2) {
        Node temp1 = reverse(head1);
        Node temp2 = reverse(head2);
        Node dummy = new Node();
        Node temp = dummy;
        int sum = 0;
        int carry = 0;
        while (temp1 != null || temp2 != null || carry > 0) {
            if (temp1 != null) {
                sum += temp1.data;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                sum += temp2.data;
                temp2 = temp2.next;
            }
            sum += carry;
            temp.next = new Node(sum % 10);
            carry = sum / 10;
            sum = 0;
            temp = temp.next;
        }
        return reverse(dummy.next);
    }

    public static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node after = head.next;
            head.next = prev;

            prev = head;
            head = after;
        }
        return prev;
    }
}