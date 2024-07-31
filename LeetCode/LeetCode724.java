public class LeetCode724 {
    public static void main(String[] args) {
        // 输入：nums = [1, 7, 3, 6, 5, 6]
        // 输出：3
        System.out.println(new Solution724().pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));

        // 输入：nums = [1, 2, 3]
        // 输出：-1
        System.out.println(new Solution724().pivotIndex(new int[] { 1, 2, 3 }));

        // 输入：nums = [2, 1, -1]
        // 输出：0
        System.out.println(new Solution724().pivotIndex(new int[] { 2, 1, -1 }));
    }
}

class Solution724 {
    public int pivotIndex(int[] nums) {
        int sumAll = 0;
        for (int i = 0; i < nums.length; i++) {
            sumAll += nums[i];
        }
        int sumLeft = 0;
        int ind = 0;
        while (ind < nums.length) {
            if (sumLeft * 2 + nums[ind] == sumAll) {
                return ind;
            }
            sumLeft += nums[ind];
            ind++;
        }
        return -1;
    }
}