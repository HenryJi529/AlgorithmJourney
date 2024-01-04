import java.util.PriorityQueue;

public class LeetCode703 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kthLargest.add(3)); // return 4
        System.out.println(kthLargest.add(5)); // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9)); // return 8
        System.out.println(kthLargest.add(4)); // return 8
    }
}

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            this.pq.offer(val);
        } else {
            if (this.pq.peek() < val) {
                this.pq.poll();
                this.pq.offer(val);
            }
        }
        return this.pq.peek();
    }
}