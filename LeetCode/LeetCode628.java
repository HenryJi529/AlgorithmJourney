import java.util.Arrays;

public class LeetCode628 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3]
        // 输出：6
        System.out.println(new Solution628_2().maximumProduct(new int[] { 1, 2, 3 }));

        // 输入：nums = [1,2,3,4]
        // 输出：24
        System.out.println(new Solution628_2().maximumProduct(new int[] { 1, 2, 3, 4 }));

        // 输入：nums = [-1,-2,-3]
        // 输出：-6
        System.out.println(new Solution628_2().maximumProduct(new int[] { -1, -2, -3 }));
    }
}

class Solution628_1 {
    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int negativeNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeNum++;
            }
        }
        // NOTE: 实际上就是两个数值的比较
        if (negativeNum <= 1 || nums.length - negativeNum == 0) {
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        } else {
            if (nums.length - negativeNum == 1 || nums.length - negativeNum == 2) {
                return nums[0] * nums[1] * nums[nums.length - 1];
            } else {
                return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                        nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
            }
        }
    }
}

class Solution628_2 {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE; // 最大，第二大，第三大
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE; // 最小，第二小
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}