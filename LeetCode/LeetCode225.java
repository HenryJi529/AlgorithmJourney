import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }
}

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void push(int x) {
        this.q1.offer(x);
    }

    public int pop() {
        int size = q1.size();
        for (int i = 0; i < size - 1; i++) {
            this.q2.offer(q1.poll());
        }
        int res = this.q1.poll();
        Queue<Integer> temp = this.q1;
        this.q1 = this.q2;
        this.q2 = temp;
        return res;
    }

    public int top() {
        int size = q1.size();
        for (int i = 0; i < size - 1; i++) {
            this.q2.offer(q1.poll());
        }
        int res = this.q1.poll();
        this.q2.offer(res);
        Queue<Integer> temp = this.q1;
        this.q1 = this.q2;
        this.q2 = temp;
        return res;
    }

    public boolean empty() {

        return this.q1.isEmpty();
    }
}
