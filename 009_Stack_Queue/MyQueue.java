
class MyQueue {
    int capacity;
    int[] arr;
    int count;
    int st;
    int ed;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.count = 0;
        this.st = -1;
        this.ed = -1;
    }

    // ! =================== UTIL METHODS ===============
    public boolean isEmpty() {
        return this.st == -1 && this.ed == -1;
    }

    public boolean isFull() {
        return this.capacity == this.count;
    }

    public void enqueue(int data) {
        if (this.isFull()) {
            System.out.println("Queue is Full Can't Insert !!");
            return;
        }
        if (this.count == 0)
            this.st = this.ed = 0;
        else
            this.ed = (this.ed + 1) % this.capacity;
        this.count++;
        this.arr[ed] = data;
    }

    public int dequeue() {
        int elem = this.arr[this.st];
        if (this.st == this.ed)
            this.st = this.ed = -1;
        else
            this.st = (this.st + 1) % this.capacity;
        this.count--;
        return elem;
        // int elem;
        // if (this.st == this.ed) {
        // elem = this.arr[this.st];
        // this.st = this.ed = -1;
        // this.count--;
        // return elem;
        // }
        // elem = this.arr[this.st];
        // this.st = (this.st + 1) % this.capacity;
        // this.count--;
        // return elem;
    }

    public int peek() {
        if (!this.isEmpty())
            return this.arr[this.st];
        return -1;
    }

    public int size() {
        return this.count;
    }

    public void printQueue() {
        if (this.isEmpty()) {
            System.out.println("Queue is Empty Can't Print !!");
            return;
        }
        for (int i = this.st; i < this.st + this.count; i++) {
            System.out.print(" " + this.arr[i % this.capacity]);
        }
    }
}