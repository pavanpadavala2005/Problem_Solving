import java.util.*;

class StackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueue() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int data) {
        q2.add(data);
        int size = q1.size();
        for (int i = 0; i < size; i++)
            q2.add(q1.poll());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public void printStack() {
        if (!this.q1.isEmpty()) {
            for (int i : this.q1)
                System.out.println(i);
        }
    }
}

public class Aug08 {
    public StackUsingQueue implementStackUsingQueue() {
        return new StackUsingQueue();
    }
}