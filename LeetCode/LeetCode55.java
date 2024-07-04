import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LeetCode55 {
    public static void main(String[] args) {
        // 输入：nums = [2,3,1,1,4]
        // 输出：true
        // System.out.println(new Solution55_2().canJump(new int[] { 2, 3, 1, 1, 4 }));

        // 输入：nums = [3,2,1,0,4]
        // 输出：false
        // System.out.println(new Solution55_2().canJump(new int[] { 3, 2, 1, 0, 4 }));

        // 输入: nums =
        // [2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6]
        System.out.println(new Solution55_4().canJump(new int[] { 2, 0, 6, 9, 8, 4,
                5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6,
                3,
                1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2,
                0, 1, 4, 6, 5, 8, 0, 7, 9,
                3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9,
                4, 9, 0, 1, 9, 5, 7, 7, 1,
                5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6 }));
    }

}

/**
 * 递归检索【超时(70/172)】
 */
class Solution55_1 {
    public boolean canJump(int[] nums) {
        boolean[] canJumps = new boolean[nums.length];
        canJumps[0] = true;
        return canJump(nums.length - 1, nums, canJumps);
    }

    private boolean canJump(int index, int[] nums, boolean[] canJumps) {
        if (canJumps[index]) {
            return true;
        }
        for (int i = index - 1; i >= 0; i--) {
            if (canJumps[i] || (!canJumps[i] && canJump(i, nums, canJumps))) {
                if (nums[i] + i >= index) {
                    canJumps[index] = true;
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * 使用双向队列，并尽可能让位置靠后的节点优先访问【能通过，但不理想】
 */
class Solution55_2 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] visited = new boolean[nums.length];
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (queue.size() > 0) {
            int ind = queue.poll();
            // System.out.println(ind);
            int l = Math.max(0, ind - nums[ind]);
            int r = Math.min(ind + nums[ind], nums.length - 1);
            if (r == nums.length - 1) {
                return true;
            }
            for (int index = l; index <= r; index++) {
                if (!visited[index]) {
                    visited[index] = true;
                    queue.push(index);
                }
            }
        }
        return false;
    }
}

/**
 * 使用优先队列，确保位置靠后的节点优先访问【速度并没变快，内存占用反而增大】
 */
class Solution55_3 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] visited = new boolean[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(0);
        visited[0] = true;
        while (pq.size() > 0) {
            int ind = pq.poll();
            // System.out.println(ind);
            int l = Math.max(0, ind - nums[ind]);
            int r = Math.min(ind + nums[ind], nums.length - 1);
            if (r == nums.length - 1) {
                return true;
            }
            for (int index = l; index <= r; index++) {
                // NOTE: 这里是瓶颈
                if (!visited[index]) {
                    visited[index] = true;
                    pq.add(index);
                }
            }
        }
        return false;
    }
}

/**
 * 考虑到如果i点可以访问，那么i-1点一定能被访问，因此不需要visited，只需维护最远位置
 */
class Solution55_4 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}