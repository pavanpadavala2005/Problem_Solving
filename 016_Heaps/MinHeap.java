import java.util.*;

class MinHeap {
    ArrayList<Integer> pq;
    int ptr;

    public MinHeap() {
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
            if (this.pq.get(i) < this.pq.get(parent)) {
                Collections.swap(this.pq, i, parent);
                i = parent;
            } else
                break;
        }
    }

    public void pop() {
        if (this.ptr < 0)
            return;
        Collections.swap(this.pq, 0, this.ptr);
        this.pq.remove(this.ptr);
        this.ptr--;

        heapifyDown(0);
    }

    private void heapifyDown(int i) {
        while (i <= this.ptr) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            int largest = i;

            if (left <= this.ptr && this.pq.get(left) < this.pq.get(largest)) {
                largest = left;
            }

            if (right <= this.ptr && this.pq.get(right) < this.pq.get(largest)) {
                largest = right;
            }

            if (i == largest)
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

    public int size() {
        return pq.size();
    }
}