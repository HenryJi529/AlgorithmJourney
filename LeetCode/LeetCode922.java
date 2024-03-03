import java.util.Arrays;

public class LeetCode922 {
    public static void main(String[] args) {
        // 输入：nums = [4,2,5,7]
        // 输出：[4,5,2,7]
        System.out.println(Arrays.toString(new Solution922().sortArrayByParityII(new int[] { 4, 2, 5, 7 })));

        // 输入：nums = [2,3]
        // 输出：[2,3]
        System.out.println(Arrays.toString(new Solution922().sortArrayByParityII(new int[] { 2, 3 })));
    }
}

class Solution922 {
    public int[] sortArrayByParityII(int[] nums) {
        int evenP = 0;
        int oddP = 1;
        while (evenP < nums.length && oddP < nums.length) {
            while (nums[evenP] % 2 == 0) {
                evenP += 2;
                if (evenP >= nums.length) {
                    break;
                }
            }
            while (nums[oddP] % 2 == 1) {
                oddP += 2;
                if (oddP >= nums.length) {
                    break;
                }
            }
            if (evenP >= nums.length || oddP >= nums.length) {
                break;
            }
            int temp;
            temp = nums[evenP];
            nums[evenP] = nums[oddP];
            nums[oddP] = temp;
        }
        return nums;
    }
}