/* 
 * 问题描述: https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
 */

public class LeetCode1011 {
    public static void main(String[] args) {
        int[] weights;
        int days;
        // 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
        // 输出：15
        weights = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        days = 5;
        System.out.println(new Solution1011().shipWithinDays(weights, days));

        // 输入：weights = [3,2,2,4,1,4], days = 3
        // 输出：6
        weights = new int[] { 3, 2, 2, 4, 1, 4 };
        days = 3;
        System.out.println(new Solution1011().shipWithinDays(weights, days));
    }
}

class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        int l = sum / days, r = sum, mid = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (canShip(weights, days, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean canShip(int[] weights, int days, int load) {
        int remainLoad = load;
        int remainDays = days - 1;
        for (int i = 0; i < weights.length; i++) {
            if (remainLoad >= weights[i]) {
                remainLoad -= weights[i];
            } else {
                if (remainDays == 0) {
                    return false;
                }
                remainDays -= 1;
                remainLoad = load;
                if (remainLoad < weights[i]) {
                    return false;
                } else {
                    remainLoad -= weights[i];
                }
            }
        }
        return true;
    }
}