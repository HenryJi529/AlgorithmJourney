import java.util.Arrays;

import util.PrintUtil;

public class LeetCode75 {
    public static void main(String[] args) {
        int[] nums;
        // 输入：nums = [2,0,2,1,1,0]
        // 输出：[0,0,1,1,2,2]
        nums = new int[] { 2, 0, 2, 1, 1, 0 };
        System.out.println(Arrays.toString(nums));
        new Solution75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();

        // 输入：nums = [2,0,1]
        // 输出：[0,1,2]
        nums = new int[] { 2, 0, 1 };
        System.out.println(Arrays.toString(nums));
        new Solution75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();

        // 输入：nums = [1,2,0]
        // 输出：[0,1,2]
        nums = new int[] { 1, 2, 0 };
        System.out.println(Arrays.toString(nums));
        new Solution75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();
    }
}

class Solution75 {
    public void sortColors(int[] nums) {
        int left = -1;
        int right = nums.length;
        int i = 0;
        while (i < right && i < nums.length) {
            if (nums[i] == 0) {
                left++;
                nums[i] = nums[left];
                nums[left] = 0;
                i++;
            } else if (nums[i] == 2) {
                right--;
                nums[i] = nums[right];
                nums[right] = 2;
            } else {
                i++;
            }
        }
    }
}