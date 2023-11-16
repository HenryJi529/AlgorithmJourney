/* 
 * 问题描述: https://leetcode.cn/problems/can-place-flowers/description/
 */

public class LeetCode605 {
    public static void main(String[] args) {
        // 输入：flowerbed = [1,0,0,0,1], n = 1
        // 输出：true
        System.out.println(new Solution605().canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));

        // 输入：flowerbed = [1,0,0,0,1], n = 2
        // 输出：false
        System.out.println(new Solution605().canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));

        // 输入：flowerbed = [0,1,0], n = 1
        System.out.println(new Solution605().canPlaceFlowers(new int[] { 0, 1, 0 }, 1));
    }
}

class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
            return n == 0;
        }
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 1) {
                return n == 0;
            } else {
                return n <= 1;
            }
        }

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            } else {
                if ((i == 0 && flowerbed[1] == 0)
                        || (i == flowerbed.length - 1 && flowerbed[flowerbed.length - 2] == 0)
                        || (i > 0 && i < flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    count++;
                }
            }

        }
        return count >= n;
    }
}
