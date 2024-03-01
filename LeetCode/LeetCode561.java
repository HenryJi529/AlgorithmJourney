import java.util.Arrays;

public class LeetCode561 {
    public static void main(String[] args) {
        // 输入：nums = [1,4,3,2]
        // 输出：4
        System.out.println(new Solution561().arrayPairSum(new int[] { 1, 4, 3, 2 }));

        // 输入：nums = [6,2,6,5,1,2]
        // 输出：9
        System.out.println(new Solution561().arrayPairSum(new int[] { 6, 2, 6, 5, 1, 2 }));
    }
}

class Solution561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}