import java.util.Arrays;

public class LeetCode31 {
    public static void main(String[] args) {
        int[] nums;
        // 输入：nums = [1,2,3]
        // 输出：[1,3,2]
        nums = new int[] { 1, 2, 3 };
        System.out.println(Arrays.toString(nums));
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("================================================================");

        // 输入：nums = [1,3,2]
        // 输出：[2,1,3]
        nums = new int[] { 1, 3, 2 };
        System.out.println(Arrays.toString(nums));
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("================================================================");

        // 输入：nums = [3,2,1]
        // 输出：[1,2,3]
        nums = new int[] { 3, 2, 1 };
        System.out.println(Arrays.toString(nums));
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("================================================================");

        // 输入：nums = [1,1,5]
        // 输出：[1,5,1]
        nums = new int[] { 1, 1, 5 };
        System.out.println(Arrays.toString(nums));
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("================================================================");
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

        int x = -1;
        int y = -1;

        int index;
        for (index = nums.length - 1; index >= 1; index--) {
            if (nums[index] > nums[index - 1]) {
                break;
            }
        }
        if (index == 0) {
            reverse(nums, 0);
        } else {
            y = index;
            x = y - 1;

            if (y == nums.length - 1) {
                swap(nums, y, y - 1);
            } else {
                int z = -1;
                for (index = y; index < nums.length; index++) {
                    if (nums[index] > nums[x]) {
                        continue;
                    } else {
                        z = index - 1;
                        break;
                    }
                }
                if (index == nums.length) {
                    z = nums.length - 1;
                }

                swap(nums, x, z);
                reverse(nums, y);
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