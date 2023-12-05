import java.util.Arrays;

public class LeetCode34 {
    public static void main(String[] args) {
        int[] nums;
        int target;

        // 输入：nums = [5,7,7,8,8,10], target = 8
        // 输出：[3,4]
        nums = new int[] { 5, 7, 7, 8, 8, 10 };
        target = 8;
        System.out.println(Arrays.toString(new Solution34_2().searchRange(nums, target)));

        // 输入：nums = [5,7,7,8,8,10], target = 6
        // 输出：[-1,-1]
        nums = new int[] { 5, 7, 7, 8, 8, 10 };
        target = 6;
        System.out.println(Arrays.toString(new Solution34_2().searchRange(nums, target)));

        // 输入：nums = [], target = 0
        // 输出：[-1,-1]
        nums = new int[] {};
        target = 0;
        System.out.println(Arrays.toString(new Solution34_2().searchRange(nums, target)));
    }
}

class Solution34_1 {
    public int[] searchRange(int[] nums, int target) {
        int left = -1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                right = i;
                break;
            }
        }
        int[] result = { left, right };
        return result;
    }
}

class Solution34_2 {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearchLeft(nums, target);
        int right = binarySearchRight(nums, target);
        if (left > right) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { left, right };
        }
    }

    public int binarySearchLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int binarySearchRight(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}