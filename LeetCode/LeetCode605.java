public class LeetCode605 {
    public static void main(String[] args) {
        // 输入：flowerbed = [1,0,0,0,1], n = 1
        // 输出：true
        System.out.println(new Solution605().canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));

        // 输入：flowerbed = [1,0,0,0,1], n = 2
        // 输出：false
        System.out.println(new Solution605().canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));

        // 输入：flowerbed = [0,1,0], n = 1
        // 输出：false
        System.out.println(new Solution605().canPlaceFlowers(new int[] { 0, 1, 0 }, 1));

        // 输入：flowerbed = [0,0,1,0,1], n = 1
        // 输出：true
        System.out.println(new Solution605().canPlaceFlowers(new int[] { 0, 0, 1, 0, 1 }, 1));
    }
}

class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int start = -2;
        int end = 0;
        int count = 0;
        while (end < flowerbed.length) {
            if (flowerbed[end] == 1) {
                // System.out.println(start + " " + end);
                count += (end - start - 2) / 2;
                start = end;
            }
            end++;
            if (count >= n) {
                return true;
            }
        }
        count += (flowerbed.length - start - 1) / 2;
        return count >= n;
    }
}
