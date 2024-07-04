import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode189 {
    public static void main(String[] args) {
        int[] nums;
        int k;
        // 输入: nums = [1,2,3,4,5,6,7], k = 3
        // 输出: [5,6,7,1,2,3,4]
        nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        k = 3;
        new Solution189_3().rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        // 输入：nums = [-1,-100,3,99], k = 2
        // 输出：[3,99,-1,-100]
        nums = new int[] { -1, -100, 3, 99 };
        k = 2;
        new Solution189_3().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}

/**
 * 双向队列
 */
class Solution189_1 {
    public void rotate(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            deque.offer(nums[i]);
        }

        while (k > 0) {
            deque.push(deque.pollLast());
            k--;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = deque.pop();
        }
    }
}

/**
 * 辅助数组
 */
class Solution189_2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}

/**
 * 通过反转数组
 */
class Solution189_3 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    private void reverse(int i, int j, int[] nums) {
        for (int k = 0; k < (j - i + 1) / 2; k++) {
            int temp = nums[i + k];
            nums[i + k] = nums[j - k];
            nums[j - k] = temp;
        }
    }
}