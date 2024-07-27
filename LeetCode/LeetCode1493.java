public class LeetCode1493 {
    public static void main(String[] args) {
        // 输入：nums = [1,1,0,1]
        // 输出：3
        System.out.println(new Solution1493().longestSubarray(new int[] { 1, 1, 0, 1 }));

        // 输入：nums = [0,1,1,1,0,1,1,0,1]
        // 输出：5
        System.out.println(new Solution1493().longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }));

        // 输入：nums = [1,1,1]
        // 输出：2
        System.out.println(new Solution1493().longestSubarray(new int[] { 1, 1, 1 }));
    }
}

class Solution1493 {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int start = 0;
        boolean meet = false;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                if (meet) {
                    while (nums[start] != 0) {
                        start++;
                    }
                    start++;
                } else {
                    meet = true;
                }
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}