import java.util.*;

public class StackUsingQueue {
    /*
    * keeping this **CostlyPush** and **CostlyPop** class inside **StackUsingQueue** is for Scope, Getting access form Demo class 
    */

    public class CostlyPush {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public CostlyPush() {
            this.q1 = new ArrayDeque<>();
            this.q2 = new ArrayDeque<>();
        }

        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty())
                q2.add(q1.poll());
            Queue<Integer> temp = this.q1;
            this.q1 = this.q2;
            this.q2 = temp;
        }

        public int pop() {
            if (this.q1.isEmpty())
                return -1;
            return q1.poll();
        }

        public int top() {
            if (this.q1.isEmpty())
                return -1;
            return this.q1.peek();
        }

        public boolean empty() {
            return this.q1.isEmpty();
        }
    }

    public class CostlyPop {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public CostlyPop() {
            this.q1 = new ArrayDeque<>();
            this.q2 = new ArrayDeque<>();
        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            if (this.empty())
                return -1;
            while (!this.q1.isEmpty())
                this.q2.add(this.q1.poll());
            Queue<Integer> temp = this.q1;
            this.q1 = this.q2;
            this.q2 = temp;
            return this.q1.poll();
        }

        public int top() {
            if (empty())
                return -1;
            return this.q1.peek();
        }

        public boolean empty() {
            return this.q1.isEmpty();
        }

        public void display() {
            for (int i : this.q1)
                System.out.println(i);
        }
    }

    public CostlyPush getCostlyPush() {
        return new CostlyPush();
    }

    public CostlyPop getCostlyPop() {
        return new CostlyPop();
    }
}
