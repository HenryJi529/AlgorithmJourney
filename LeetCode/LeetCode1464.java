public class LeetCode1464 {
    public static void main(String[] args) {
        // 输入：nums = [3,4,5,2]
        // 输出：12
        System.out.println(new Solution1464().maxProduct(new int[] { 3, 4, 5, 2 }));

        // 输入：nums = [1,5,4,5]
        // 输出：16
        System.out.println(new Solution1464().maxProduct(new int[] { 1, 5, 4, 5 }));

        // 输入：nums = [3,7]
        // 输出：12
        System.out.println(new Solution1464().maxProduct(new int[] { 3, 7 }));
    }
}

class Solution1464 {
    public int maxProduct(int[] nums) {
        int firstMaxIndex = nums[0] >= nums[1] ? 0 : 1;
        int secondMaxIndex = nums[0] >= nums[1] ? 1 : 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[secondMaxIndex]) {
                if (nums[i] > nums[firstMaxIndex]) {
                    secondMaxIndex = firstMaxIndex;
                    firstMaxIndex = i;
                } else {
                    secondMaxIndex = i;
                }
            }
        }
        return (nums[firstMaxIndex] - 1) * (nums[secondMaxIndex] - 1);
    }
}