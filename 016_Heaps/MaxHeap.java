import java.util.ArrayList;
import java.util.Collections;

class MaxHeap {
    ArrayList<Integer> pq;
    int ptr;

    public MaxHeap() {
        this.pq = new ArrayList<>();
        this.ptr = -1;
    }

    public void push(int x) {
        this.pq.add(x);
        this.ptr++;
        hepifyUp(this.ptr);
    }

    private void hepifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;

            if (this.pq.get(i) > this.pq.get(parent)) {
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

        hepifyDown(0);
    }

    private void hepifyDown(int i) {
        while (i <= this.ptr) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            int largest = i;

            if (left <= this.ptr && this.pq.get(left) > this.pq.get(largest))
                largest = left;
            if (right <= this.ptr && this.pq.get(right) > this.pq.get(largest))
                largest = right;
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
        return this.pq.size();
    }
}

//  public void heapifyDown(List<Pair> list, int i){
//         int n = list.size();
//         while (i <= n) {
//             int left = i * 2 + 1;
//             int right = i * 2 + 2;

//             int largest = i;

//             if (left <= n && list.get(left).count > list.get(largest).count)
//                 largest = left;
//             if (right <= n && list.get(right).count > list.get(largest).count)
//                 largest = right;

//             if (i == largest)
//                 break;

//             Collections.swap(list, i, largest);

//             i = largest;
//         }
//     }

//     public void heapifyUp(List<Pair> list, int i){
//         while(i > 0){
//             int parent = (i-1) / 2;
//             if(list.get(parent).count > list.get(i).count){
//                 Collections.swap(list, i, parent);
//                 i = parent;
//             }
//             else 
//                 break;
//         }
//     }
