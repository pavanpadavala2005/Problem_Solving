
import java.util.Stack;

// ! ============= LC155. Min Stack =============
public class MinStack {
    /*
    @ TC --> O(1) --> Every time we just pushing into the Stack so All operations costs O(1)
    @ SC --> O(N * 2) -- we are storing something like [Curr,Min] and we are storing all the elements so O(N*2)
    */
    public class MinStackExtraSpace {
        Stack<int[]> st;

        public MinStackExtraSpace() {
            this.st = new Stack<>();
        }

        public void push(int value) {
            int[] elem = new int[] { value, value };
            if (!st.isEmpty())
                if (st.peek()[1] < elem[1])
                    elem[1] = st.peek()[1];
            st.push(elem);
        }

        public void pop() {
            st.pop();
        }

        public int top() {
            return st.peek()[0];
        }

        public int getMin() {
            return st.peek()[1];
        }
    }

    /*
    @ TC --> O(1) --> all Operations costs O(1)
    @ SC --> O(N) --> here we are just storing the ELements in integers
    */
    public class MinStackNoExtraSpace {
        Stack<Long> st;
        long min;

        MinStackNoExtraSpace() {
            this.st = new Stack<>();
            this.min = Long.MAX_VALUE;
        }

        /*
         * IMP: when pushing elements Encode Them --> new_value = 2 * val - curr_min which will gives us the New value (when the val < min) Only
        */
        public void push(int val) {
            long value;
            if (st.isEmpty()) {
                min = val;
                value = val;
            } else if (val < this.min) {
                value = 2L * val - min;
                min = val;
            } else
                value = val;
            st.push(value);
        }

        /*
         * IMP: When we popping the element form stack we nee to get the Original Value DECODE (peek < min) decode the value using original_value = 2 * curr_min - peek
        */
        public void pop() {
            if (st.isEmpty())
                return;
            long peek = st.pop();
            if (peek < this.min)
                min = 2 * min - peek;
        }

        public int top() {
            if (st.isEmpty())
                return -1;
            long peek = st.peek();
            if (peek < this.min)
                return (int) min;
            return (int) peek;
        }

        public int getMin() {
            return (int) this.min;
        }

        public void printStack() {
            System.out.println(this.st + " " + this.min);
        }
    }

    /*
    @ TC --> O(1) --> Every time O(1) because Linked insert at head only
    @ SC --> O(N) --> Nodes are distributed but Storage can be considerable 
    */
    public class MinStackWithLinkedList {
        Node head;

        public MinStackWithLinkedList() {
            this.head = null;
        }

        public void push(int val) {
            if (this.head == null) {
                this.head = new Node(val, val);
                return;
            }
            Node newNode = new Node(val, Math.min(val, this.head.min));
            newNode.next = head;
            head = newNode;
        }

        public void pop() {
            this.head = this.head.next;
        }

        public int top() {
            if (this.head == null)
                return -1;
            return this.head.data;
        }

        public int getMin() {
            if (this.head == null)
                return -1;
            return this.head.min;
        }
    }

    // * Helper Methods to Test code in Demo
    public MinStackExtraSpace getMinStackExtraSpace() {
        return new MinStackExtraSpace();
    }

    public MinStackNoExtraSpace getMinStackNoExtraSpace() {
        return new MinStackNoExtraSpace();
    }

    public MinStackWithLinkedList getMinStackWithLinkedList() {
        return new MinStackWithLinkedList();
    }

    // * Node class
    private class Node {
        private int data;
        private int min;
        private Node next;

        public Node(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }
}
