
public class Demo {
    public static void main(String[] args) {
        // MyStack ms = new MyStack(4);
        // ms.push(10);
        // ms.push(20);
        // ms.printStack();
        // // System.out.println(ms.size());

        // MyQueue mq = new MyQueue(6);
        // mq.enqueue(10);
        // mq.enqueue(20);
        // mq.enqueue(30);
        // mq.enqueue(40);
        // mq.enqueue(50);
        // mq.enqueue(60);
        // mq.dequeue();
        // mq.dequeue();
        // mq.enqueue(100);
        // mq.enqueue(200);
        // mq.printQueue();

        // ! =============== Aug 08 Stuff ======================
        // Aug08 ag8 = new Aug08();
        // StackUsingQueue sq = ag8.implementStackUsingQueue();
        // sq.push(100);
        // sq.push(200);
        // sq.push(300);
        // sq.push(400);
        // System.out.println("Top" + sq.pop());
        // sq.printStack();

        // ! =================== Aug 10 Stuff ====================

        // MinStack ms = new MinStack();
        // ms.push(10);
        // ms.push(20);
        // ms.push(1);
        // System.out.println(ms.getMin());

        // ms.toString();

        // System.out.println(Aug10.isValid("][f "));

        StackUsingQueues suq = new StackUsingQueues();
        suq.push(100);
        suq.push(200);
        suq.push(300);
        System.out.println(suq.q1);
    }
}
