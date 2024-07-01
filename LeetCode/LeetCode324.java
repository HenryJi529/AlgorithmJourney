import java.util.Arrays;

public class LeetCode324 {
    public static void main(String[] args) {
        int[] nums;
        // 输入：nums = [1,5,1,1,6,4]
        // 输出：[1,6,1,5,1,4]
        // 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
        nums = new int[] { 1, 5, 1, 1, 6, 4 };
        new Solution324_2().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        // 输入：nums = [1,3,2,2,3,1]
        // 输出：[2,3,1,3,1,2]
        nums = new int[] { 1, 3, 2, 2, 3, 1 };
        new Solution324_2().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        // 输入：nums = [1,1,2,1,2,2,1]
        // 输出：
        nums = new int[] { 1, 1, 2, 1, 2, 2, 1 };
        new Solution324_2().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        // 输入：nums = [1,2,3,3,3,4]
        // 输出：
        nums = new int[] { 1, 2, 3, 3, 3, 4 };
        new Solution324_2().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

/**
 * 分为前后两段，交替赋值，并通过循环移位避免出现相等的点紧挨着
 */
class Solution324_1 {
    public void wiggleSort(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int half = nums.length % 2 == 0 ? nums.length / 2 : (nums.length + 1) / 2;
        for (int i = 0; i < half; i++) {
            nums[2 * i] = sortedNums[i];
        }
        for (int i = half; i < nums.length; i++) {
            nums[2 * (i - half) + 1] = sortedNums[i];
        }

        while (!check(nums)) {
            rotate(nums);
        }
    }

    public boolean check(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] >= nums[i + 1]) {
                    return false;
                }
            } else {
                if (nums[i] <= nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void rotate(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < copy.length; i++) {
            nums[i] = copy[(i + 1) % copy.length];
        }
    }
}

/**
 * 可以通过让中间的点出现在边上，来避免相等的值靠近
 */
class Solution324_2 {
    public void wiggleSort(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int half = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
        for (int i = half; i >= 0; i--) {
            nums[(half - i) * 2] = sortedNums[i];
        }
        for (int i = nums.length - 1; i > half; i--) {
            nums[(nums.length - i) * 2 - 1] = sortedNums[i];
        }
    }
}
