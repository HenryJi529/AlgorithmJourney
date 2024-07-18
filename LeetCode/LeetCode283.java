import java.util.Arrays;

import util.PrintUtil;

public class LeetCode283 {
    public static void main(String[] args) {
        int[] nums;
        // 输入: nums = [0,1,0,3,12]
        // 输出: [1,3,12,0,0]
        nums = new int[] { 0, 1, 0, 3, 12 };
        System.out.println(Arrays.toString(nums));
        new Solution283_2().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();

        // 输入: nums = [0]
        // 输出: [0]
        nums = new int[] { 0 };
        System.out.println(Arrays.toString(nums));
        new Solution283_2().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();
    }
}

/**
 * 过于繁琐
 */
class Solution283_1 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int index = 0;
        int firstZero = -1;
        while (index < nums.length) {
            if (nums[index] == 0) {
                firstZero = index;
                break;
            }
            index++;
        }
        while (index < nums.length) {
            if (nums[index] != 0) {
                swap(nums, index, firstZero);
                firstZero++;
            }
            index++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution283_2 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}