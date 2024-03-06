import java.util.Arrays;

public class LeetCode1385 {
    public static void main(String[] args) {
        // 输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
        // 输出：2
        System.out
                .println(
                        new Solution1385_2().findTheDistanceValue(new int[] { 4, 5, 8 }, new int[] { 10, 9, 1, 8 }, 2));
        System.out.println("==================================");

        // 输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
        // 输出：2
        System.out
                .println(new Solution1385_2().findTheDistanceValue(new int[] { 1, 4, 2, 3 },
                        new int[] { -4, -3, 6, 10, 20, 30 },
                        3));
        System.out.println("==================================");

        // 输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
        // 输出：1
        System.out
                .println(new Solution1385_2().findTheDistanceValue(new int[] { 2, 1, 100, 3 },
                        new int[] { -5, -2, 10, -3, 7 },
                        6));
        System.out.println("==================================");
    }
}

class Solution1385_1 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < arr1.length; i++) {
            flag = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}

class Solution1385_2 {
    // NOTE: 理论时间复杂度低于解法1
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        int closestElem;
        for (int i = 0; i < arr1.length; i++) {
            closestElem = arr2[binarySearch(arr2, arr1[i])];
            if (Math.abs(arr1[i] - closestElem) > d) {
                count++;
            }
        }
        return count;
    }

    public int binarySearch(int[] arr2, int target) {
        int left = 0;
        int right = arr2.length - 1;
        int mid;
        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (arr2[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.abs(target - arr2[left]) > Math.abs(target - arr2[right]) ? right : left;
    }
}