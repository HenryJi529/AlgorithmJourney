import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class LeetCode1403 {
    public static void main(String[] args) {
        // 输入：nums = [4,3,10,9,8]
        // 输出：[10,9]
        System.out.println(Arrays.toString(new Solution1403().minSubsequence(new int[] { 4, 3, 10, 9, 8 }).toArray()));

        // 输入：nums = [4,4,7,6,7]
        // 输出：[7,7,6]
        System.out.println(Arrays.toString(new Solution1403().minSubsequence(new int[] { 4, 4, 7, 6, 7 }).toArray()));

    }
}

class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < nums.length; i++) {
            sumLeft += nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            sumRight += nums[i];
            sumLeft -= nums[i];
            if (sumLeft < sumRight) {
                List<Integer> result = new ArrayList<Integer>();
                for (int ind = nums.length - 1; ind >= i; ind--) {
                    result.add(nums[ind]);
                }
                return result;
            }
        }
        return null;
    }
}