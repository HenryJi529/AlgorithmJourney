public class LeetCode334 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3,4,5]
        // 输出：true
        System.out.println(new Solution334_2().increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));

        // 输入：nums = [5,4,3,2,1]
        // 输出：false
        System.out.println(new Solution334_2().increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));

        // 输入：nums = [2,1,5,0,4,6]
        // 输出：true
        System.out.println(new Solution334_2().increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));

    }
}

/**
 * 贪心算法(非常tricky)
 */
class Solution334_1 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}

/**
 * 双向遍历找最值
 */
class Solution334_2 {
    public boolean increasingTriplet(int[] nums) {
        int[] leftMin = new int[nums.length];
        int[] rightMax = new int[nums.length];
        leftMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        // System.out.println(Arrays.toString(leftMin));
        // System.out.println(Arrays.toString(rightMax));
        for (int i = 1; i <= nums.length - 2; i++) {
            if (leftMin[i] < nums[i] && nums[i] < rightMax[i]) {
                return true;
            }
        }
        return false;
    }
}
