import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.TreeSet;

public class LeetCode414 {
    public static void main(String[] args) {
        // 输入：[3, 2, 1]
        // 输出：1
        System.out.println(new Solution414_2().thirdMax(new int[] { 3, 2, 1 }));

        // 输入：[1, 2]
        // 输出：2
        System.out.println(new Solution414_2().thirdMax(new int[] { 1, 2 }));

        // 输入：[2, 2, 3, 1]
        // 输出：1
        System.out.println(new Solution414_2().thirdMax(new int[] { 2, 2, 3, 1 }));

        // 输入：[1,2,2,5,3,5]
        // 输出：2
        System.out.println(new Solution414_2().thirdMax(new int[] { 1, 2, 2, 5, 3, 5 }));
    }
}

class Solution414_1 {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (pq.size() < 3) {
                pq.add(nums[i]);
            } else {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        if (set.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
            return pq.peek();
        } else {
            return pq.peek();
        }

    }
}

class Solution414_2 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                s.remove(s.first());
            }
        }
        return s.size() == 3 ? s.first() : s.last();
    }
}
