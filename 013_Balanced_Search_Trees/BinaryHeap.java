
public class BinaryHeap {
    public class MaxHeap {
        int[] heap;
        int n;
        int ptr;

        public MaxHeap(int n) {
            this.heap = new int[n];
            this.n = n;
            this.ptr = -1;
        }

        public MaxHeap(int[] arr) {
            this.n = arr.length;
            this.heap = new int[this.n];
            this.ptr = -1;
            for (int i : arr)
                insert(i);
        }

        public void insert(int val) {
            if (this.ptr >= this.n)
                return;
            this.heap[++this.ptr] = val;
            heapifyUp(this.ptr);
        }

        public void heapifyUp(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (this.heap[i] > this.heap[parent]) {
                    swap(this.heap, i, parent);
                    i = parent;
                } else
                    break;
            }
        }

        public void heapifyDown(int i, int n) {
            while (i <= n) {
                int left = i * 2 + 1;
                int right = i * 2 + 2;

                int largest = i;

                if (left <= n && this.heap[left] > this.heap[largest])
                    largest = left;

                if (right <= n && this.heap[right] > this.heap[largest])
                    largest = right;

                if (largest == i)
                    break;

                swap(this.heap, i, largest);

                i = largest;
            }
        }

        public int getMax() {
            if (this.ptr < 0)
                return -1;
            int max = this.heap[0];
            swap(this.heap, 0, this.ptr--);
            heapifyDown(0, this.ptr);
            return max;
        }

        public void heapSort() {
            int n = this.heap.length - 1;
            while (n >= 0) {
                swap(this.heap, n, 0);

                n--;

                heapifyDown(0, n);
            }
        }

        public void printHeap() {
            for (int i = 0; i <= this.ptr; i++)
                System.out.print(this.heap[i] + " ");
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
