public class StackUsingArray {
    int top;
    int[] stack;
    int capacity;

    public StackUsingArray(int size) {
        this.top = -1;
        this.stack = new int[size];
        this.capacity = size;
    }

    // ! ============= Utility Methods =============
    /*
    @ TC --> O(1)
    @ SC --> O(N)
    */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /*
    @ TC --> O(1)
    @ SC --> O(N)
    */
    public boolean isFull() {
        return this.top == capacity - 1;
    }

    // ! ============= Working Methods =============
    // * ========== PUSH ==========
    /*
    @ TC --> O(1)
    @ SC --> O(N)
    */
    public void push(int data) {
        if (this.isFull()) {
            System.out.println("Stack is Full Can't Push");
            return;
        }
        this.top++;
        this.stack[this.top] = data;
    }

    // * ========== POP ==========
    /*
    @ TC --> O(1)
    @ SC --> O(N)
    */
    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty Can't Pop");
            return -1;
        }
        int value = this.stack[this.top];
        this.top--;
        return value;
    }

    // * ========== PEEK ==========
    /*
    @ TC --> O(1)
    @ SC --> O(N)
    */
    public int peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty Can't Peek");
            return -1;
        }
        return this.stack[this.top];
    }

    // * ========== Display ==========
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public void display() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty Can't Display");
            return;
        }
        for (int i = this.top; i >= 0; i--) {
            System.out.println("|" + this.stack[i] + "|");
        }
    }
}
