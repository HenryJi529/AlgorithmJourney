import java.util.Deque;
import java.util.LinkedList;

public class LeetCode933 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1)); // requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(recentCounter.ping(100)); // requests = [1, 100]，范围是 [-2900,100]，返回 2
        System.out.println(recentCounter.ping(3001)); // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        System.out.println(recentCounter.ping(3002)); // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }
}

class RecentCounter {
    private Deque<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.offer(t);
        while (!deque.isEmpty() && deque.peek() < t - 3000) {
            deque.pollFirst();
        }
        return deque.size();
    }
}