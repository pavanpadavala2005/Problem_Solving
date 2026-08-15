import java.util.*;

class StackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    StackUsingQueues() {
        this.q1 = new ArrayDeque<>();
        this.q2 = new ArrayDeque<>();
    }

    public void push(int eleme) {
        this.q1.offer(eleme);
    }

    public int pop() {
        while (this.q1.isEmpty()) {
            this.q2.offer(this.q1.poll());
        }
        int elem = this.q1.poll();
        Queue<Integer> temp = this.q1;
        this.q1 = this.q2;
        this.q2 = temp;
        return elem;
    }
}

public class Aug11 {

}