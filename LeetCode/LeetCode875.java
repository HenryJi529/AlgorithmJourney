public class LeetCode875 {
    public static void main(String[] args) {
        // 输入：piles = [3,6,7,11], h = 8
        // 输出：4
        System.out.println(new Solution875().minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));

        // 输入：piles = [30,11,23,4,20], h = 5
        // 输出：30
        System.out.println(new Solution875().minEatingSpeed(new int[] { 30, 11, 23,
                4, 20 }, 5));

        // 输入：piles = [30,11,23,4,20], h = 6
        // 输出：23
        System.out.println(new Solution875().minEatingSpeed(new int[] { 30, 11, 23,
                4, 20 }, 6));

        // 输入：piles =
        // [332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184],
        // h = 823855818
        // 输出：14
        System.out.println(new Solution875().minEatingSpeed(new int[] { 332484035, 524908576, 855865114, 632922376,
                222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947,
                688210097, 692137887, 718203285, 629455728, 941802184 }, 823855818));
    }
}

class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int sumPile = 0;
        int maxPile = 0;
        for (int i = 0; i < piles.length; i++) {
            maxPile = Math.max(maxPile, piles[i]);
            sumPile += piles[i];
        }
        int left = Math.max(sumPile / h, 1);
        int right = maxPile / (h / piles.length);
        int mid;
        // System.out.println(left + " " + right);

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isValid(piles, h, mid)) {
                // System.out.println(mid + " true");
                right = mid - 1;
            } else {
                left = mid + 1;
                // System.out.println(mid + " false");
            }
        }

        return left;
    }

    public boolean isValid(int[] pile, int h, int k) {
        int count = 0;
        for (int i = 0; i < pile.length; i++) {
            if (count > h) {
                return false;
            }
            count += pile[i] % k == 0 ? pile[i] / k : pile[i] / k + 1;
        }
        return count <= h;
    }
}