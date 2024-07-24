import java.util.Deque;
import java.util.LinkedList;

public class LeetCode901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 返回 1
        System.out.println(stockSpanner.next(80)); // 返回 1
        System.out.println(stockSpanner.next(60)); // 返回 1
        System.out.println(stockSpanner.next(70)); // 返回 2
        System.out.println(stockSpanner.next(60)); // 返回 1
        System.out.println(stockSpanner.next(75)); // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
        System.out.println(stockSpanner.next(85)); // 返回 6
    }
}

class StockSpanner {
    private Deque<int[]> stack; // int[] = {ind, price, nextRes}
    private int N; // 当前next过的price数量

    public StockSpanner() {
        this.stack = new LinkedList<>();
        this.N = 0;
    }

    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            int[] top = stack.pop();
            res = N - top[0] + top[2];
        }
        stack.push(new int[] { N, price, res });
        this.N++;
        return res;
    }
}