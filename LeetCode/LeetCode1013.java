import java.util.List;
import java.util.ArrayList;

public class LeetCode1013 {
    public static void main(String[] args) {
        // 输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
        // 输出：true
        System.out.println(new Solution1013_2().canThreePartsEqualSum(new int[] { 0, 2,
                1, -6, 6, -7, 9, 1, 2, 0, 1 }));

        // 输入：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
        // 输出：false
        System.out.println(new Solution1013_2().canThreePartsEqualSum(new int[] { 0, 2,
                1, -6, 6, 7, 9, -1, 2, 0, 1 }));

        // 输入：arr = [3,3,6,5,-2,2,5,1,-9,4]
        // 输出：true
        System.out.println(new Solution1013_2().canThreePartsEqualSum(new int[] { 3, 3,
                6, 5, -2, 2, 5, 1, -9, 4 }));

        // 输入：arr = [6,1,1,13,-1,0,-10,20]
        // 输出：false
        System.out.println(new Solution1013_2().canThreePartsEqualSum(new int[] { 6, 1, 1, 13, -1, 0, -10, 20 }));
    }
}

/**
 * 记录所有分点的位置从而作出判断
 */
class Solution1013_1 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
        }
        if (sum1 % 3 != 0) {
            return false;
        }
        List<Integer> firstTarget = new ArrayList<Integer>();
        List<Integer> secondTarget = new ArrayList<Integer>();
        int sum2 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum2 += arr[i];
            if (sum2 * 3 == sum1) {
                firstTarget.add(i);
            }
            if (sum2 * 3 == sum1 * 2) {
                secondTarget.add(i);
            }
        }
        if (sum1 == 0) {
            if (firstTarget.size() > 1) {
                return true;
            } else {
                return false;
            }
        } else {
            if (firstTarget.size() < 1 || secondTarget.size() < 1) {
                return false;
            }
            if (firstTarget.getFirst() < secondTarget.getLast()) {
                return true;
            } else {
                return false;
            }
        }
    }
}

class Solution1013_2 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
        }
        if (sum1 % 3 != 0) {
            return false;
        }
        int firstTarget = -1;
        int secondTarget = -1;
        int sum2 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum2 += arr[i];
            if (firstTarget == -1 && sum2 * 3 == sum1) {
                firstTarget = i;
            }
            if (sum2 * 3 == sum1 * 2) {
                secondTarget = i;
            }
        }
        if ((firstTarget == -1 || secondTarget == -1) || (firstTarget >= secondTarget)) {
            return false;
        } else {
            return true;
        }
    }
}