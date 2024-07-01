import java.util.Arrays;

public class LeetCode238 {
    public static void main(String[] args) {
        // 输入: nums = [1,2,3,4]
        // 输出: [24,12,8,6]
        System.out.println(Arrays.toString(new Solution238().productExceptSelf(new int[] { 1, 2, 3, 4 })));

        // 输入: nums = [-1,1,0,-3,3]
        // 输出: [0,0,9,0,0]
        System.out.println(Arrays.toString(new Solution238().productExceptSelf(new int[] { -1, 1, 0, -3, 3 })));
    }
}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                prod *= nums[i];
            }

        }
        int[] result = new int[nums.length];
        if (zeroCount >= 2) {
        } else if (zeroCount == 1) {
            for (int i = 0; i < result.length; i++) {
                if (nums[i] == 0) {
                    result[i] = prod;
                }
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                result[i] = prod / nums[i];
            }
        }
        return result;
    }
}