import java.util.Arrays;

public class LeetCode905 {
    public static void main(String[] args) {
        // 输入：nums = [3,1,2,4]
        // 输出：[2,4,3,1]
        // 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
        System.out.println(Arrays.toString(new Solution905().sortArrayByParity(new int[] { 3, 1, 2, 4 })));

        // 输入：nums = [0]
        // 输出：[0]
        System.out.println(Arrays.toString(new Solution905().sortArrayByParity(new int[] { 0 })));
    }
}

class Solution905 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            int temp;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}