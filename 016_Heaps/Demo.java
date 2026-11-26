import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        // MaxPriorityQueue mpq = new MaxPriorityQueue();
        // mpq.push(10);
        // mpq.push(15);
        // mpq.push(20);
        // mpq.push(9);
        // mpq.push(8);
        // mpq.push(99);

        // System.out.println(
        //         mpq.peek());

        // ! ============= Nov 26 Problems ============

        // System.out.println(Nov26.findKthLargestOptimal(
        //         new int[] {
        //                 3, 2, 1, 5, 6, 4
        //         },
        //         2));

        // System.out.println(Nov26.thirdMax(new int[] {
        //         // 3, 2, 1
        //         2, 2, 3, 1
        // }));

        System.out.println(Arrays.toString(
                Nov26.topKFrequentOptimal(new int[] { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 }, 2)));
    }
}
