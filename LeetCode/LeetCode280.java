import java.util.Arrays;

public class LeetCode280 {
    public static void main(String[] args) {
        int[] nums;
        // 输入：nums = [3,5,2,1,6,4]
        // 输出：[3,5,1,6,2,4]
        nums = new int[] { 3, 5, 2, 1, 6, 4 };
        new Solution280_1().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        // 输入：nums = [6,6,5,6,3,8]
        // 输出：[6,6,5,6,3,8]
        nums = new int[] { 6, 6, 5, 6, 3, 8 };
        new Solution280_1().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

/**
 * 排序后拆分为前后两段，交替拼接
 */
class Solution280_1 {
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
    }
}

/*
 * 排序后，通过交换元素实现交替
 */
class Solution280_2 {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }
}

/**
 * 贪心算法，直接交换元素就可以实现交替
 */
class Solution280_3 {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (((i % 2 == 0) && nums[i] > nums[i + 1])
                    || ((i % 2 == 1) && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }
}
