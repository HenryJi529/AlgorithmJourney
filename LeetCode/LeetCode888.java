import java.util.Arrays;
import java.util.HashSet;

public class LeetCode888 {
    public static void main(String[] args) {
        // 输入：aliceSizes = [1,1], bobSizes = [2,2]
        // 输出：[1,2]
        System.out.println(Arrays.toString(new Solution888_2().fairCandySwap(new int[] { 1, 1 }, new int[] { 2, 2 })));

        // 输入：aliceSizes = [1,2], bobSizes = [2,3]
        // 输出：[1,2]
        System.out.println(Arrays.toString(new Solution888_2().fairCandySwap(new int[] { 1, 2 }, new int[] { 2, 3 })));

        // 输入：aliceSizes = [2], bobSizes = [1,3]
        // 输出：[2,3]
        System.out.println(Arrays.toString(new Solution888_2().fairCandySwap(new int[] { 2 }, new int[] { 1, 3 })));

        // 输入：aliceSizes = [1,2,5], bobSizes = [2,4]
        // 输出：[5,4]
        System.out
                .println(Arrays.toString(new Solution888_2().fairCandySwap(new int[] { 1, 2, 5 }, new int[] { 2, 4 })));
    }
}

class Solution888_1 {
    // NOTE: 排序+二分，相对均衡
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        int aliceSum = 0;
        int bobSum = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            aliceSum += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            bobSum += bobSizes[i];
        }
        for (int aliceIndex = 0; aliceIndex < aliceSizes.length; aliceIndex++) {
            int bobIndex = binarySearch(bobSizes, aliceSizes[aliceIndex] - (aliceSum - bobSum) / 2);
            if (bobIndex != -1) {
                return new int[] { aliceSizes[aliceIndex], bobSizes[bobIndex] };
            }
        }
        return null;
    }

    public int binarySearch(int[] bobSizes, int target) {
        int l = 0;
        int r = bobSizes.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (bobSizes[mid] < target) {
                l = mid + 1;
            } else if (bobSizes[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

class Solution888_2 {
    // NOTE: 这个方案的空间占用太高了，但可以过测试
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum1 = Arrays.stream(aliceSizes).sum();
        int sum2 = Arrays.stream(bobSizes).sum();
        int num = (sum1 - sum2) / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int bobSize : bobSizes) {
            set.add(bobSize);
        }
        for (int aliceSize : aliceSizes) {
            if (set.contains(aliceSize - num)) {
                return new int[] { aliceSize, aliceSize - num };
            }
        }
        return new int[] {};

    }
}