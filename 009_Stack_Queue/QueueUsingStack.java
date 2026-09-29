
import java.util.Stack;

// ! ============= LC232. Implement Queue using Stacks =============
/*
*/
public class QueueUsingStack {
    // * keeping this **CostlyPush** and **CostlyPop** class inside **StackUsingQueue** is for Scope, Getting access form Demo class 

    /*
    @ TC --> O(N) Only Pop Operation TC --> O(N) remaining is O(1)
    @ SC --> O(N) --> at most we are Storing all the elements in S1
    */
    public class CostlyPop {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public CostlyPop() {
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if (empty())
                return -1;
            if (s2.isEmpty()) {
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            return s2.pop();
        }

        public int peek() {
            if (empty())
                return -1;
            if (s2.isEmpty()) {
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    /*
    @ TC --> O(N) Only Push Operation TC --> O(N) remaining is O(1)
    @ SC --> O(N) --> at most we are Storing all the elements in S1
    */
    public class CostlyPush {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public CostlyPush() {
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void push(int x) {
            while (!this.s1.isEmpty()) {
                this.s2.push(this.s1.pop());
            }
            this.s1.push(x);
            while (!this.s2.isEmpty()) {
                this.s1.push(this.s2.pop());
            }
        }

        public int pop() {
            if (empty())
                return -1;
            return this.s1.pop();
        }

        public int peek() {
            if (empty())
                return -1;
            return this.s1.peek();
        }

        public boolean empty() {
            return this.s1.isEmpty() && s2.isEmpty();
        }

    }

    // * Helper Methods to Test code in Demo
    public CostlyPop getCostlyPop() {
        return new CostlyPop();
    }

    public CostlyPush getCostlyPush() {
        return new CostlyPush();
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC232. Implement Queue using Stacks ✅