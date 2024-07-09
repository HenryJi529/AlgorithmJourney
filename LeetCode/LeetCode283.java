import java.util.Arrays;

import util.PrintUtil;

public class LeetCode283 {
    public static void main(String[] args) {
        int[] nums;
        // 输入: nums = [0,1,0,3,12]
        // 输出: [1,3,12,0,0]
        nums = new int[] { 0, 1, 0, 3, 12 };
        System.out.println(Arrays.toString(nums));
        new Solution283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();

        // 输入: nums = [0]
        // 输出: [0]
        nums = new int[] { 0 };
        System.out.println(Arrays.toString(nums));
        new Solution283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();
    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int firstZero = -1;
        while (index < nums.length) {
            if (nums[index] == 0) {
                if (firstZero == -1) {
                    firstZero = index;
                }
            } else {
                if (firstZero != -1) {
                    swap(nums, index, firstZero);
                    firstZero++;
                }
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