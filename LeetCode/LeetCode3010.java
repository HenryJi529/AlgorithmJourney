public class LeetCode3010 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3,12]
        // 输出：6
        System.out.println(new Solution3010().minimumCost(new int[] { 1, 2, 3, 12 }));

        // 输入：nums = [5,4,3]
        // 输出：12
        System.out.println(new Solution3010().minimumCost(new int[] { 5, 4, 3 }));

        // 输入：nums = [10,3,1,1]
        // 输出：12
        System.out.println(new Solution3010().minimumCost(new int[] { 10, 3, 1, 1 }));

        // 输入：nums = [1,2,1]
        // 输出：4
        System.out.println(new Solution3010().minimumCost(new int[] { 1, 2, 1 }));

        // 输入：nums = [1,6,1,5]
        // 输出：7
        System.out.println(new Solution3010().minimumCost(new int[] { 1, 6, 1, 5 }));
    }
}

class Solution3010 {
    public int minimumCost(int[] nums) {
        int firstMinIndex = nums[1] > nums[2] ? 2 : 1;
        int secondMinIndex = nums[1] > nums[2] ? 1 : 2;
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] < nums[secondMinIndex]) {
                if (nums[i] <= nums[firstMinIndex]) {
                    secondMinIndex = firstMinIndex;
                    firstMinIndex = i;
                } else {
                    secondMinIndex = i;
                }
            }
        }
        return nums[0] + nums[firstMinIndex] + nums[secondMinIndex];
    }
}