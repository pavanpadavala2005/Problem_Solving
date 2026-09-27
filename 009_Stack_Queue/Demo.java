public class Demo {
    public static void main(String[] args) {
        // ! ============= Sep 27 Problems and Implementations =============
        // StackUsingArray st = new StackUsingArray(5);
        // st.push(10);
        // st.push(20);
        // st.push(30);
        // st.push(30);
        // st.push(30);
        // st.push(30);
        // st.display();

        // QueueUsingArray q = new QueueUsingArray(5);
        // q.enqueue(10);
        // q.enqueue(20);
        // q.enqueue(30);
        // q.enqueue(40);
        // q.enqueue(50);
        // q.dequeue();
        // q.enqueue(1000);
        // q.enqueue(200);
        // q.getDetails();
        // q.display();

        // StackUsingQueue.CostlyPush cPush = new StackUsingQueue().getCostlyPush();
        // cPush.push(10);
        // cPush.push(10);
        // cPush.push(10);
        // cPush.push(10);
        // cPush.pop();
        // cPush.display();

        // StackUsingQueue.CostlyPop cPop = new StackUsingQueue().getCostlyPop();
        // cPop.push(100);
        // cPop.push(200);
        // cPop.push(300);
        // System.out.println("II" + cPop.pop());
        // cPop.display();

        QueueUsingStack.CostlyPop q = new QueueUsingStack().getCostlyPop();
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        q.push(2000);
        q.push(3000);
        q.push(4000);
        System.out.println(q.peek());
    }
}
