import java.util.Stack;

public class MinStack {
    Stack<int[]> stack;

    MinStack() {
        this.stack = new Stack<>();
    }

    // ! ================ UTILITY METHODS ===============

    public void push(int data) {
        if (this.stack.isEmpty()) {
            this.stack.push(new int[] { data, data });
            return;
        }
        this.stack.push(new int[] {
                data,
                Math.min(this.stack.peek()[1], data)
        });
    }

    public int getMin() {
        if (this.stack.isEmpty())
            return -1;
        return this.stack.peek()[1];
    }

    @Override
    public String toString() {
        System.out.println("-".repeat(10));
        for (int[] arr : this.stack)
            System.out.println(arr[1]);
        return "";
    }

}