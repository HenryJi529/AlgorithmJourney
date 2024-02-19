import java.util.Arrays;

public class LeetCode475 {
    public static void main(String[] args) {
        // 输入: houses = [1,2,3], heaters = [2]
        // 输出: 1
        System.out.println(new Solution475().findRadius(new int[] { 1, 2, 3 }, new int[] { 2 }));

        // 输入: houses = [1,2,3,4], heaters = [1,4]
        // 输出: 1
        System.out.println(new Solution475().findRadius(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4 }));

        // 输入：houses = [1,5], heaters = [2]
        // 输出：3
        System.out.println(new Solution475().findRadius(new int[] { 1, 5 }, new int[] { 2 }));

        // 输入：houses =
        // [282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923],
        // heaters =
        // [823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612]
        // 输出：161834419
        System.out.println(new Solution475().findRadius(
                new int[] { 282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923 },
                new int[] { 823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729,
                        823378840, 143542612 }));
    }
}

class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0;
        int right = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isValid(mid, houses, heaters)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isValid(int radius, int[] houses, int[] heaters) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < houses.length) {
            if (Math.abs(houses[p1] - heaters[p2]) <= radius) {
                p1++;
            } else {
                p2++;
                if (p2 == heaters.length) {
                    // System.out.println(String.format("%d is Invalid", radius));
                    return false;
                }
            }
        }
        // System.out.println(String.format("%d is valid", radius));
        return true;
    }
}