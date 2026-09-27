
import java.util.Stack;

public class QueueUsingStack {
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

    public CostlyPop getCostlyPop() {
        return new CostlyPop();
    }

    public CostlyPush getCostlyPush() {
        return new CostlyPush();
    }
}
