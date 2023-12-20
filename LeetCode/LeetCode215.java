import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode215 {
    public static void main(String[] args) {
        // 输入: [3,2,1,5,6,4], k = 2
        // 输出: 5
        System.out.println(new Solution215_2().findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));

        // 输入: [3,2,3,1,2,4,5,5,6], k = 4
        // 输出: 4
        System.out.println(new Solution215_2().findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
    }
}

class Solution215_1 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

class Solution215_2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else {
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.poll();
    }
}