import java.util.*;

public class Sep30 {
    // * https://www.geeksforgeeks.org/problems/get-max-from-stack/1
    // ! ============= GFG.Get Max from Stack =============
    /*
    @ TC --> O(1) --> because All operations are cost O(1)
    @ SC --> O(N) --> because we are storing data in Stack
    */
    class SpecialMaxStack {
        Stack<Long> st;
        long max;

        public SpecialMaxStack() {
            this.st = new Stack<>();
            this.max = Long.MAX_VALUE;
        }

        public void push(int x) {
            long value;
            if (this.isEmpty()) {
                value = x;
                max = x;
            } else if (x > max) {
                value = 2 * x - max;
                max = x;
            } else
                value = x;
            st.push(value);
        }

        public void pop() {
            if (this.isEmpty())
                return;
            long peek = st.pop();
            if (peek > max)
                max = 2 * max - peek;
        }

        public int peek() {
            if (this.isEmpty())
                return -1;
            long peek = st.peek();
            if (peek > max)
                peek = max;
            return (int) peek;
        }

        boolean isEmpty() {
            return this.st.isEmpty();
        }

        public int getMax() {
            if (this.isEmpty())
                return -1;
            return (int) max;
        }
    }

    // * 
    // ! ============= GFG. Get Min from Stack =============
    /*
    @ TC --> O(1) --> because All operations are cost O(1)
    @ SC --> O(N) --> because we are storing data in Stack  
    */
    public class SpecialMinStack {
        Stack<Long> st;
        long min;

        public SpecialMinStack() {
            this.st = new Stack<>();
            this.min = Long.MAX_VALUE;
        }

        public void push(int x) {
            long value;
            if (this.isEmpty()) {
                value = x;
                min = x;
            } else if (x < min) {
                value = 2 * x - min;
                min = x;
            } else
                value = x;
            st.push(value);
        }

        public void pop() {
            if (this.isEmpty())
                return;
            long peek = st.pop();
            if (peek < min)
                min = 2 * min - peek;
        }

        public int peek() {
            if (this.isEmpty())
                return -1;
            long peek = st.peek();
            if (peek < min)
                peek = min;
            return (int) peek;
        }

        boolean isEmpty() {
            return st.isEmpty();
        }

        public int getMin() {
            if (this.isEmpty())
                return -1;
            return (int) min;
        }
    }

    // * https://www.geeksforgeeks.org/problems/get-min-at-pop/1
    // ! ============= GFG. Get Min with Stack Pop =============
    /*
    @ TC --> O(N + N) --> putting min elements in Stack and Popping out form the stack 
    @ SC --> O(N) --> using a Stack to store all the data 
    */
    class GetMin {
        public static Stack<Integer> _push(int arr[], int n) {
            Stack<Integer> st = new Stack<>();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i > 0)
                    min = Math.min(arr[i], min);
                else
                    min = arr[i];
                st.push(min);
            }
            return st;
        }

        static void _getMinAtPop(Stack<Integer> st) {
            while (!st.isEmpty()) {
                System.out.print(st.pop() + " ");
            }
        }
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Get Min from Stack ✅
// 2. GFG. Get Min with Stack Pop ✅    
// 3. GFG. Get Max from Stack ✅
