
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

        //     QueueUsingStack.CostlyPop q = new QueueUsingStack().getCostlyPop();
        //     q.push(10);
        //     q.push(20);
        //     q.push(30);
        //     q.push(40);
        //     System.out.println(q.pop());
        //     System.out.println(q.pop());
        //     System.out.println(q.pop());
        //     System.out.println(q.pop());
        //     q.push(2000);
        //     q.push(3000);
        //     q.push(4000);
        //     System.out.println(q.peek());
        // }

        // ! ============= Sep 28 Problems =============

        // System.out.println(Sep28.infixToPostFix(
        // "a+(b*c+(d^e ))"
        // "(a + b) * (c + d)"
        //"a+b*(c^d-e)^(f+g*h)-i"
        // "h^m^q^(7-4)"
        // ));

        // System.out.println(Sep28.infixToPrefix(
        // "a+(b*c)+d"
        // "(a-b/c)*(a/k-l)"
        // "a*(b+c)/d"
        // 'h^m^q^(7-4)"
        //
        // ));

        // ! ============= Sep 29 Problems =============

        // System.out.println(Sep29.prefixEvaluation(
        // new String[] {
        // "+", "*", "/", "+", "100", "200", "2", "5", "7"
        // "^", "+", "2", "3", "2"
        // "+", "/", "-24", "5", "/", "-91", "-20"
        // }));

        // System.out.println(Sep29.postfixEvaluation(new String[] {
        // "2", "3", "1", "*", "+", "9", "-"
        // "2", "3", "^", "10", "+"
        // }));

        // System.out.println(Sep29.postToInfix(
        // "ab*c+"
        // "abc/-"
        // 
        // ));

        // System.out.println(Sep29.preToInfix(
        // "*-A/BC-/AKL"
        // "+A*BC"
        // 
        // ));

        // System.out.println(Sep29.preToPost(
        // "*+ABC"
        // 
        // ));

        // System.out.println(Sep29.postToPre(
        // "ab+c*"
        //  
        // ));

        // System.out.println(Sep29.evalRPN(new String[] {
        // "2", "1", "+", "3", "*"
        // "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        // "4", "13", "5", "/", "+"
        // }));

        // ! ============= Sep 30 Problems =============

        // MinStack.MinStackExtraSpace ms = new MinStack().getMinStackExtraSpace();
        // ms.push(10);
        // ms.push(4);
        // ms.push(20);
        // ms.push(-2);
        // System.out.println(ms.getMin());
        // MinStack.MinStackNoExtraSpace ms = new MinStack().getMinStackNoExtraSpace();
        // ms.push(10);
        // ms.push(15);
        // ms.push(5);
        // ms.pop();
        // ms.printStack();

        // MinStack.MinStackWithLinkedList ms = new MinStack().getMinStackWithLinkedList();
        // ms.push(-2);
        // ms.push(0);
        // ms.push(-1);
        // System.out.println(ms.getMin());
        // ms.pop();

        // ! ============= Oct 01 Problems =============
        // System.out.println(Oct01.calculateIIBetter(
        //         "256+482-46/5*7"
        // " 3+5/2"
        // " 3/ 2"
        // 
        // ));

        // ! ============= Oct 02 Problems =============

        // System.out.println(Oct02.decodeString(
        //         // "3[a]2[bc]"
        //         // "3[a2[b]]"
        //         "3[a]2[b]4[c]"
        // ));

        // Oct02.FreqStack st = new Oct02().new FreqStack();
        // st.push(5);
        // st.push(7);
        // st.push(5);
        // st.push(7);
        // st.push(4);
        // st.push(5);
        // st.pop();
        // st.pop();
        // st.printStacks();

        // System.out.println(Oct02.nextLargerElement(
        // new int[] {
        // 1, 3, 2, 4
        // 6, 8, 0, 1, 3
        // }));

        // System.out.println(Oct02.nextGreaterElement(
        // new int[] { 4, 1, 2 },
        // new int[] { 1, 3, 4, 2 }
        // 
        // ));

        // System.out.println(Oct02.getString(
        // "ab##"
        //         "c#d#"
        // 
        // ));
        // ! ============= Oct 03 Problems =============
        // System.out.println(Oct03.trapOptimal(new int[] {
        // 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        // 4, 2, 0, 3, 2, 5
        // 0, 2, 0
        // 
        // }));

        // System.out.println(Oct03.countGreater(
        //         new int[] { 3, 4, 2, 7, 5, 8, 10, 6 },
        //         new int[] { 0, 5 }
        // 
        // ));

        // System.out.println(Oct03.sumSubarrayMinsBetter(new int[] {
        // 3, 1, 2, 4
        // 11, 81, 94, 43, 3
        // 
        // }));

        // ! ============= Oct 04 Problems =============

        // System.out.println(Oct04.sumSubarrayMins(new int[] {
        //         3, 1, 2, 4
        // }));
        // System.out.println(Arrays.toString(Oct04.asteroidCollision(new int[] {
        // 5, 10, -5
        // 4, 7, 1, 1, 2, -3, -7, 17, 15, -16
        // 8, -8
        // 8, -8
        // 10, 2, -5
        // 3, 5, -6, 2, -1, 4
        // -2, -1, 1, 2
        // })));
        // ! ============= Oct 05 Problems =============
        // System.out.println(Oct05.removeKdigitsOptimal(
        // "1432219", 3
        // "10200", 1
        // "10", 2
        // "1234", 1
        // "10001", 1
        //  
        // ));

        // ! ============= Oct 06 Problems =============

        // System.out.println(Oct06.largestRectangleAreaOptimalV2(new int[] {
        // 2, 1, 5, 6, 2, 3
        // 2, 4
        // 0
        // 2, 1, 5, 6, 2, 3
        // }));

        // System.out.println(Oct06.maximalRectangle(new char[][] {
        // new char[] { '1', '0', '1', '0', '0' },
        // new char[] { '1', '0', '1', '1', '1' },
        // new char[] { '1', '1', '1', '1', '1' },
        // new char[] { '1', '0', '0', '1', '0' }
        // new char[] { '1' }
        // }));

        // ! ============= Oct 07 Problems =============
        // System.out.println(Oct07.maximalSquareHelper(new int[] {
        // 3, 3, 0, 3, 3, 3
        // 3, 1, 3, 2, 2
        // 1, 1, 1, 1, 2, 2, 2
        // }));

        // System.out.println(Oct07.maximalSquare(new char[][] {
        //         new char[] { '1', '0', '0', '1', '1', '0', '1', '1' },
        //         new char[] { '1', '0', '0', '0', '0', '1', '0', '0' },
        //         new char[] { '0', '1', '1', '1', '0', '0', '1', '1' },
        //         new char[] { '0', '0', '0', '1', '0', '0', '0', '1' },
        //         new char[] { '0', '0', '0', '0', '0', '1', '1', '1' },
        //         new char[] { '1', '1', '1', '1', '1', '1', '1', '1' },
        //         new char[] { '1', '0', '0', '1', '0', '1', '1', '0' },
        //         new char[] { '0', '1', '1', '0', '1', '1', '1', '0' },
        // }));

        // ! ============= Oct 08 Problems =============

        // System.out.println(Oct08.nextGreaterElement(
        // 12443322
        // 12
        // 
        // ));

        // ! ============= Oct 09 Problems =============

        // System.out.println(Oct09.find132patternBetterV1(new int[] {
        // 1, 2, 3, 4
        // 3, 1, 4, 2
        // -1, 3, 2, 0
        // 9, 7, 5, 1, 8, 3, 6, 2
        // 3, 5, 0, 3, 4
        // 
        // }));

        System.out.println(Oct09.totalStepsBetter(new int[] {
                5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11
                // 4, 5, 7, 7, 13
                // 
        }));
    }
}
