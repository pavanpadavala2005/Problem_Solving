public class QueueUsingArray {
    int front;
    int rear;
    int capacity;
    int[] queue;
    int count;

    public QueueUsingArray(int size) {
        this.front = -1;
        this.rear = -1;
        this.capacity = size;
        this.queue = new int[size];
        this.count = 0;
    }

    // ! ============= Utility Methods =============
    /*
    @ TC --> O(1)
    @ SC -->
    */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /*
    @ TC --> O(1)
    @ SC -->
    */
    public boolean isFull() {
        return this.count == this.capacity;
    }

    // ! ============= Working Methods  =============
    // * ========== ENQUEUE ==========
    /*
    @ TC --> O(1)
    @ SC -->
    */
    public void enqueue(int data) {
        if (this.isFull()) {
            System.out.println("Queue is Empty Can't Enqueue");
            return;
        }
        if (this.front == -1 && this.rear == -1)
            this.front = 0;
        this.rear = (this.rear + 1) % this.capacity;
        this.count++;
        this.queue[this.rear] = data;
    }

    // * ========== DEQUEUE ==========
    /*
    @ TC --> O(1)
    @ SC -->
    */
    public int dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is Empty Can't Dequeue");
            return -1;
        }
        int elem = this.queue[this.front];
        if (this.front == this.rear) {
            this.front = this.rear = -1;
        } else {
            this.front = (this.front + 1) % this.capacity;
        }
        this.count--;
        return elem;
    }

    // * ========== DISPLAY ==========
    /*
    @ TC --> O(N)
    @ SC -->
    */
    public void display() {
        if (this.isEmpty()) {
            System.out.println("Queue is Empty Can't Display");
            return;
        }
        System.out.print("Front->");
        for (int i = this.front; i < this.front + this.count; i++) {
            System.out.print("|" + this.queue[i % this.capacity]);
        }
        System.out.println("|<- Back");
    }

    // * ========== PEEK ==========
    /*
    @ TC --> O(1)
    @ SC -->
    */
    public int peek() {
        if (this.isEmpty()) {
            System.out.println("Queue is Empty Can't Peek");
            return -1;
        }
        return this.queue[this.front];
    }

    public void getDetails() {
        System.out.println("front " + this.front);
        System.out.println("rear " + this.rear);
        System.out.println("capacity " + this.capacity);
        System.out.println("count " + this.count);
    }
}
