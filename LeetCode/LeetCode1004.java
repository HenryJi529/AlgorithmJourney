public class LeetCode1004 {
    public static void main(String[] args) {
        // 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
        // 输出：6
        System.out.println(new Solution1004().longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));

        // 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
        // 输出：10
        System.out.println(new Solution1004()
                .longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
    }
}

class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                if (k > 0) {
                    k--;
                } else {
                    while (nums[start] != 0) {
                        start++;
                    }
                    start++;
                }
            }
            // System.out.println("start: " + start + " end: " + end);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}