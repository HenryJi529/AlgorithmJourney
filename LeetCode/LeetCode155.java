import java.util.Deque;
import java.util.LinkedList;

public class LeetCode155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    int minVal;

    public MinStack() {
        this.stack1 = new LinkedList<Integer>();
        this.stack2 = new LinkedList<Integer>();
        this.stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.peek() > val) {
            stack2.push(val);
        } else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
