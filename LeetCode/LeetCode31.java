import java.util.Arrays;

import util.PrintUtil;

public class LeetCode31 {
    public static void main(String[] args) {
        int[] nums;
        // 输入：nums = [1,2,3]
        // 输出：[1,3,2]
        nums = new int[] { 1, 2, 3 };
        System.out.println(Arrays.toString(nums));
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();

        // 输入：nums = [1,3,2]
        // 输出：[2,1,3]
        nums = new int[] { 1, 3, 2 };
        System.out.println(Arrays.toString(nums));
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();

        // 输入：nums = [3,2,1]
        // 输出：[1,2,3]
        nums = new int[] { 3, 2, 1 };
        System.out.println(Arrays.toString(nums));
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();

        // 输入：nums = [1,1,5]
        // 输出：[1,5,1]
        nums = new int[] { 1, 1, 5 };
        System.out.println(Arrays.toString(nums));
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();

        // 输入：nums = [2,3,1]
        // 输出：[3,1,2]
        nums = new int[] { 2, 3, 1 };
        System.out.println(Arrays.toString(nums));
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        PrintUtil.printDivider();
    }
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }

        // 找到逆序的第一位
        int reversed_first = nums.length - 1;
        while (reversed_first >= 1) {
            if (nums[reversed_first] > nums[reversed_first - 1]) {
                break;
            }
            reversed_first--;
        }

        if (reversed_first == 0) {
            // 如果第一位是0，就整体调换
            reverse(nums, 0);
        } else {
            if (reversed_first == nums.length - 1) {
                // 如果第一位是最后一位，就需要一次简单的对掉
                swap(nums, reversed_first, reversed_first - 1);
            } else {
                int reversed_suitable = reversed_first;
                while (reversed_suitable < nums.length) {
                    if (nums[reversed_suitable] > nums[reversed_first - 1]) {
                        reversed_suitable++;
                    } else {
                        break;
                    }
                }
                swap(nums, reversed_first - 1, reversed_suitable - 1);
                reverse(nums, reversed_first);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        for (int i = 0; i < (nums.length - start) / 2; i++) {
            swap(nums, i + start, nums.length - 1 - i);
        }

    }
}