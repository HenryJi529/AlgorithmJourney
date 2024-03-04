import java.util.Arrays;

public class LeetCode977 {
    public static void main(String[] args) {
        // 输入：nums = [-4,-1,0,3,10]
        // 输出：[0,1,9,16,100]
        System.out.println(Arrays.toString(new Solution977().sortedSquares(new int[] { -4, -1, 0, 3, 10 })));

        // 输入：nums = [-7,-3,2,3,11]
        // 输出：[4,9,9,49,121]
        System.out.println(Arrays.toString(new Solution977().sortedSquares(new int[] { -7, -3, 2, 3, 11 })));
    }
}

class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        // 找到正数和负数的起始点
        int positiveStart = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                positiveStart = i;
                break;
            }
        }
        int index = 0;
        int negativeStart = positiveStart - 1;
        while (negativeStart >= 0 || positiveStart < nums.length) {
            if (negativeStart >= 0 && positiveStart == nums.length) {
                result[index] = nums[negativeStart] * nums[negativeStart];
                negativeStart--;
            } else if (negativeStart < 0 && positiveStart < nums.length) {
                result[index] = nums[positiveStart] * nums[positiveStart];
                positiveStart++;
            } else {
                if (nums[positiveStart] <= -nums[negativeStart]) {
                    result[index] = nums[positiveStart] * nums[positiveStart];
                    positiveStart++;
                } else {
                    result[index] = nums[negativeStart] * nums[negativeStart];
                    negativeStart--;
                }
            }
            index++;
        }

        return result;
    }
}