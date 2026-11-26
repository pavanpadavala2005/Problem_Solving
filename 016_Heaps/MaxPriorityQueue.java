import java.util.*;

class MaxPriorityQueue {
    ArrayList<Integer> pq;
    int ptr;

    public MaxPriorityQueue() {
        this.pq = new ArrayList<>();
        this.ptr = -1;
    }

    public void push(int x) {
        this.pq.add(x);
        this.ptr++;
        heapifyUp(this.ptr);
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (this.pq.get(i) > this.pq.get(parent)) {
                Collections.swap(this.pq, i, parent);
                i = parent;
            } else
                break;
        }
    }

    public int pop() {
        if (this.ptr < 0)
            return -1;
        Collections.swap(this.pq, 0, this.ptr);
        int max = this.pq.get(this.ptr);
        this.pq.remove(this.ptr);
        this.ptr--;

        heapifyDown(0);

        return max;
    }

    private void heapifyDown(int i) {
        while (i <= this.ptr) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            int largest = i;

            if (left <= this.ptr && this.pq.get(left) > this.pq.get(largest))
                largest = left;
            if (right <= this.ptr && this.pq.get(right) > this.pq.get(largest))
                largest = right;

            if (largest == i)
                break;

            Collections.swap(this.pq, i, largest);

            i = largest;
        }
    }

    public int peek() {
        if (this.ptr >= 0)
            return this.pq.get(0);
        return -1;
    }

    public boolean isEmpty() {
        return this.ptr == -1;
    }

    public int size() {
        return this.ptr + 1;
    }
}