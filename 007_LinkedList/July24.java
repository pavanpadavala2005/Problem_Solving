
import java.util.ArrayList;

public class July24 {

    // ! ============= ODD EVEN LINKED LIST ==============

    public static Node oddEvenListOptimalV2(Node head) {
        if (head == null || head.next == null)
            return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static Node oddEvenListOptimalV1(Node head) {
        if (head == null || head.next == null)
            return head;
        Node temp = head.next;
        Node odd = head;
        Node even = head.next;
        while (odd != null && odd.next != null) {
            odd.next = odd.next.next;
            odd = odd.next.next;
        }
        while (even != null && even.next != null) {
            even.next = even.next.next;
            even = even.next.next;
        }
        head.next = temp;
        return head;
    }

    public static Node oddEvenListBrute(Node head) {
        ArrayList<Integer> res = new ArrayList<>();
        Node temp = head;
        while (temp != null && temp.next != null) {
            res.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null)
            res.add(temp.data);
        temp = head.next;
        while (temp != null && temp.next != null) {
            res.add(temp.data);
            temp = temp.next.next;
        }
        temp = head;
        for (int i = 0; i < res.size(); i++) {
            temp.data = res.get(i);
            temp = temp.next;
        }
        return head;
    }

    // ! ============= ODD EVEN LIST ==============
    public static void oddEvenListBrute(int[] nums) {
        int pos = 1;
        for (int i = 2; i < nums.length; i += 2) {
            int temp = nums[i];
            for (int j = i; j >= pos; j--)
                nums[j] = nums[j - 1];
            nums[pos] = temp;
            pos++;
        }
    }

    public static void oddEvenList(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if ((j + 1) % 2 == 1) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
    }

    // ! =========== LENGTH OF LOOP IN LL ===========
    public static int lengthOfCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slow = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                Node temp = slow.next;
                int ctr = 1;
                while (temp != slow) {
                    ctr++;
                    temp = temp.next;
                }
                return ctr;
            }
        }
        return -1;
    }

    // ! =========== PALINDROME LIST ================
    public static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node prev = null;
        Node next = slow;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        while (prev != null) {
            if (head.data != prev.data)
                return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    public static boolean isPalindromeBrute(Node head) {
        ArrayList<Integer> lis = new ArrayList<>();
        while (head != null) {
            lis.add(head.data);
            head = head.next;
        }
        int n = lis.size();
        for (int i = 0; i < n / 2; i++)
            if (lis.get(i) != lis.get(n - i - 1))
                return false;
        return true;
    }
}
