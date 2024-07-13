import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1); // arr = [1]
        medianFinder.addNum(2); // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }
}

class MedianFinder {
    private PriorityQueue<Integer> minPQ = new PriorityQueue<>(); // 存放比较大的元素
    private PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder()); // 存放比较小的元素(可能比minPQ中多一个)
    private int N = 0;

    public MedianFinder() {
    }

    public void addNum(int num) {
        if (N % 2 == 0) {
            // 此时maxPQ中的元素数应该等于minPQ的
            // NOTE: 可以先对比而不是直接插入，复杂度还能进一步降低
            minPQ.offer(num);
            maxPQ.offer(minPQ.poll());
        } else {
            // 此时maxPQ中的元素数应该大于minPQ的
            maxPQ.offer(num);
            minPQ.offer(maxPQ.poll());
        }
        this.N++;
    }

    public double findMedian() {
        if (N % 2 == 0) {
            return (0.0 + minPQ.peek() + maxPQ.peek()) / 2;
        } else {
            return maxPQ.peek();
        }
    }
}