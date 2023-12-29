import java.util.Deque;
import java.util.LinkedList;

public class LeetCode232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}

class MyQueue {
    // NOTE: 时间复杂度略高
    Deque<Integer> s1;
    Deque<Integer> s2;
    boolean state;

    public MyQueue() {
        s1 = new LinkedList<Integer>();
        s2 = new LinkedList<Integer>();
        state = true;
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        int size = s1.size();
        for (int i = 0; i < size - 1; i++) {
            s2.push(s1.pop());
        }
        int res = s1.pop();
        for (int i = 0; i < size - 1; i++) {
            s1.push(s2.pop());
        }
        return res;
    }

    public int peek() {
        int size = s1.size();
        for (int i = 0; i < size - 1; i++) {
            s2.push(s1.pop());
        }
        int res = s1.peek();
        for (int i = 0; i < size - 1; i++) {
            s1.push(s2.pop());
        }
        return res;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}