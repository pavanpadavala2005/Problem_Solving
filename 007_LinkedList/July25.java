import java.util.HashSet;

public class July25 {

    // ! ======= MERGE SORT OF TWO LINKED LIST ========
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node slow = head;
        Node fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node leftHead = head;
        Node rightHead = slow.next;
        slow.next = null;
        Node left = mergeSort(leftHead);
        Node right = mergeSort(rightHead);
        return merge(head, left, right);
    }

    public static Node merge(Node head, Node head1, Node head2) {
        Node temp = new Node(-1);
        Node dummy = temp;
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                dummy.next = new Node(temp1.data);
                temp1 = temp1.next;
            } else {
                dummy.next = new Node(temp2.data);
                temp2 = temp2.next;
            }
            dummy = dummy.next;
        }
        if (temp1 != null)
            dummy.next = temp1;
        if (temp2 != null)
            dummy.next = temp2;
        return temp.next;
    }
    // public static void mergeSort(Node head) {
    // if (head.next != null) {
    // Node slow = head;
    // Node fast = head.next.next;
    // while (fast != null && fast.next != null) {
    // fast = fast.next.next;
    // slow = slow.next;
    // }
    // Node prev = slow;
    // slow = slow.next;
    // prev.next = null;
    // System.out.println(SinglyLinkedListUtils.getList(head));
    // System.out.println(SinglyLinkedListUtils.getList(slow));
    // mergeSort(head);
    // mergeSort(slow);
    // Node temp = merge(head, slow);
    // }
    // }

    // public static Node merge(Node head1, Node head2) {
    // Node temp1 = head1;
    // Node temp2 = head2;
    // Node dummy = new Node();
    // Node temp = dummy;
    // while (temp1 != null && temp2 != null) {
    // if (temp1.data <= temp2.data) {
    // dummy.next = new Node(temp1.data);
    // temp1 = temp1.next;
    // } else {
    // dummy.next = new Node(temp2.data);
    // temp2 = temp2.next;
    // }
    // dummy = dummy.next;
    // }
    // while (temp1 != null) {
    // dummy.next = new Node(temp1.data);
    // temp1 = temp1.next;
    // dummy = dummy.next;
    // }
    // while (temp2 != null) {
    // dummy.next = new Node(temp2.data);
    // temp2 = temp2.next;
    // dummy = dummy.next;
    // }
    // return temp1;
    // }

    // public static Node merge(Node head1, Node head2) {

    // }

    // ! ======= MERGE TWO SORTED LINKED LIST =========
    public static Node mergeSortedLists(Node head1, Node head2) {
        Node temp = new Node(-1);
        Node dummy = temp;
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                dummy.next = new Node(temp1.data);
                temp1 = temp1.next;
            } else {
                dummy.next = new Node(temp2.data);
                temp2 = temp2.next;
            }
            dummy = dummy.next;
        }
        while (temp1 != null) {
            dummy.next = new Node(temp1.data);
            temp1 = temp1.next;
            dummy = dummy.next;
        }
        while (temp2 != null) {
            dummy.next = new Node(temp2.data);
            temp2 = temp2.next;
            dummy = dummy.next;
        }
        return temp.next;
    }

    // * ! ======= SORT LINKED LIST =========
    public static Node sortList(Node head) {
        Node i = head;
        while (i != null) {
            // Node dummy = i;
            Node dummy = i;
            Node j = i;
            while (j.next != null) {
                if (j.data < dummy.data)
                    dummy = j;
                j = j.next;
            }
            int temp = dummy.data;
            dummy.data = i.data;
            i.data = temp;
            i = i.next;
        }
        return head;
    }

    // ! ======= ADD TWO NUMBERS ==========
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        int sum = 0;
        int carry = 0;
        Node temp1 = l1;
        Node temp2 = l2;
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
            Node newNode = new Node(sum % 10);
            temp.next = newNode;
            temp = temp.next;
            carry = sum / 10;
            sum = 0;
        }
        return dummy.next;
    }

    // ! ======= ADD ONE TO LINKED LIST ==========
    public static Node addOneToLLOptimal(Node head) {
        int carry = addOneToLLHelper(head);
        if (carry >= 1) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static int addOneToLLHelper(Node temp) {
        if (temp == null)
            return 1;
        // int carry = addOneToLLHelper(temp.next);
        int sum = temp.data + addOneToLLHelper(temp.next);
        temp.data = sum % 10;
        return sum / 10;
    }

    public static Node addOneToLLBrute(Node head) {
        int carry = 1;
        head = SinglyLinkedListUtils.reverseLinkedList(head);
        Node temp = head;
        while (temp != null) {
            int sum = carry + temp.data;
            temp.data = sum % 10;
            carry = sum / 10;
            if (carry == 0)
                break;
            temp = temp.next;
        }
        head = SinglyLinkedListUtils.reverseLinkedList(head);
        if (carry >= 1) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    // ! ======= INTERSECTION POINT OF LL ========
    public static Node intersectionPointOptimal(Node headA, Node headB) {
        Node temp1 = headA;
        Node temp2 = headB;
        while (temp1 != temp2) {
            if (temp1 == null)
                temp1 = headB;
            else
                temp1 = temp1.next;
            if (temp2 == null)
                temp2 = headA;
            else
                temp2 = temp2.next;
        }
        return temp1;
    }

    public static Node intersectionPointBrute(Node headA, Node headB) {
        HashSet<Node> elems = new HashSet<>();
        while (headA != null) {
            elems.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (elems.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    // ! ======= DELETE MIDDLE NODE OF LL ========
    public static Node deleteMiddleNodeOptimal(Node head) {
        if (head == null || head.next == null)
            return null;
        Node slow = head;
        Node fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static Node deleteMiddleNodeBrute(Node head) {
        if (head.next == null)
            return null;
        Node temp = head;
        int ctr = 0;
        while (temp != null) {
            ctr++;
            temp = temp.next;
        }
        ctr = (ctr / 2) - 1;
        temp = head;
        while (temp != null) {
            if (ctr == 0)
                break;
            ctr--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    // ! ======= REMOVE N TH NODE FORM BACK =======
    public static Node removeNthFromEndOptimal(Node head, int n) {
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        Node slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next == null)
            return null;
        slow.next = slow.next.next;
        return head;
    }

    public static Node removeNthFromEndBrute(Node head, int n) {
        if (head == null)
            return null;
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        count -= n;
        if (count == 0)
            return head.next;
        temp = head;
        for (int i = 1; i < count; i++)
            temp = temp.next;
        temp.next = temp.next.next;
        return head;
    }

}
