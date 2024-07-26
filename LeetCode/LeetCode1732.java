public class LeetCode1732 {
    public static void main(String[] args) {
        // 输入：gain = [-5,1,5,0,-7]
        // 输出：1
        System.out.println(new Solution1732().largestAltitude(new int[] { -5, 1, 5, 0, -7 }));

        // 输入：gain = [-4,-3,-2,-1,4,3,2]
        // 输出：0
        System.out.println(new Solution1732().largestAltitude(new int[] { -4, -3, -2, -1, 4, 3, 2 }));
    }
}

class Solution1732 {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}