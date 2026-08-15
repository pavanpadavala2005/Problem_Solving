public class MyStack {
    int[] stack;
    int capacity;
    int top;

    // ! =============== UTILITY METHODS ==============
    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top >= this.capacity - 1;
    }

    // ! =============== OPERATIONS ===================
    public MyStack(int capacity) {
        this.stack = new int[capacity];
        this.capacity = capacity;
        this.top = -1;
    }

    public void push(int data) {
        if (this.isFull()) {
            System.out.println("Stack Was full Can't Add Elements !!");
            return;
        }
        this.top++;
        this.stack[this.top] = data;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty Can't Pop !!");
            return -1;
        }
        int elem = this.stack[this.top];
        this.stack[this.top] = 0;
        this.top--;
        return elem;
    }

    public int peek() {
        return this.stack[this.top];
    }

    public int size() {
        return this.top + 1;
    }

    public void printStack() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty Can't Print !!");
            return;
        }
        for (int i = this.top; i >= 0; i--) {
            System.out.println("|" + this.stack[i] + "|");
        }
    }
}

// public class PersonalStack {

// }