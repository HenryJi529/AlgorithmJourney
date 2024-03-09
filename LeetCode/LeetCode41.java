import java.util.Arrays;
import java.util.HashSet;

public class LeetCode41 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,0]
        // 输出：3
        System.out.println(new Solution41_2().firstMissingPositive(new int[] { 1, 2, 0 }));

        // 输入：nums = [3,4,-1,1]
        // 输出：2
        System.out.println(new Solution41_2().firstMissingPositive(new int[] { 3, 4, -1, 1 }));

        // 输入：nums = [7,8,9,11,12]
        // 输出：1
        System.out.println(new Solution41_2().firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));

        // 输入：nums = [0,2,2,1,1]
        // 输出：3
        System.out.println(new Solution41_2().firstMissingPositive(new int[] { 0, 2, 2, 1, 1 }));

    }
}

class Solution41_1 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int expected = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < expected) {
                continue;
            } else if (expected == nums[i]) {
                expected++;
            } else {
                return expected;
            }
        }
        return expected;
    }
}

class Solution41_2 {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }
        int expected = 1;
        while (true) {
            if (set.contains(expected)) {
                expected++;
            } else {
                return expected;
            }
        }
    }
}

class Solution41_3 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 大小为i的数字放在i-1的位置上,不在的交换位置
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        // 判断找出答案
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}