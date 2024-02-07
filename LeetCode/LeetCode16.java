import java.util.Arrays;

public class LeetCode16 {
    public static void main(String[] args) {
        // 输入：nums = [-1,2,1,-4], target = 1
        // 输出：2
        System.out.println(new Solution16_2().threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));

        // 输入：nums = [0,0,0], target = 1
        // 输出：0
        System.out.println(new Solution16_2().threeSumClosest(new int[] { 0, 0, 0 }, 1));
    }
}

class Solution16_1 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int current = nums[i] + nums[j] + nums[k];
                    if (Math.abs(result - target) > Math.abs(current - target)) {
                        result = current;
                    }
                }
            }
        }
        return result;
    }
}

class Solution16_2 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int l = j + 1;
                int r = nums.length - 1;
                int mid;
                while (l < r - 1) {
                    mid = l + (r - l) / 2;
                    if (nums[i] + nums[j] + nums[mid] < target) {
                        l = mid;
                    } else {
                        r = mid;
                    }
                }
                int leftValue = nums[i] + nums[j] + nums[l];
                int rightValue = nums[i] + nums[j] + nums[r];
                if (Math.abs(result - target) > Math.abs(leftValue - target)) {
                    result = leftValue;
                }
                if (Math.abs(result - target) > Math.abs(rightValue - target)) {
                    result = rightValue;
                }
            }
        }
        return result;
    }
}