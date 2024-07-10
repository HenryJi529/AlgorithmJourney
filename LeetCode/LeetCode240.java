public class LeetCode240 {
    public static void main(String[] args) {
        // 输入：matrix =
        // [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
        // target = 5
        // 输出：true
        System.out.println(new Solution240().searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 5));

        // 输入：matrix =
        // [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
        // target = 20
        // 输出：false
        System.out.println(new Solution240().searchMatrix(new int[][] { { 1, 4, 7,
                11, 15 }, { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 20));

        // 输入：matrix =
        // [[1,1]],
        // target = 2
        // 输出：false
        System.out.println(new Solution240().searchMatrix(new int[][] { { 1, 1 } }, 2));

        // 输入：matrix =
        // [[1,1,2]],
        // target = 2
        // 输出：false
        System.out.println(new Solution240().searchMatrix(new int[][] { { 1, 1, 2 } }, 2));
    }
}

class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    public boolean binarySearch(int[][] matrix, int rl, int rh, int cl, int ch, int target) {
        if (rl > rh || cl > ch) {
            return false;
        }
        // try {
        // Thread.sleep(100);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // 处理1x1
        if (rl == rh && cl == ch) {
            return target == matrix[rl][cl];
        }
        // 处理 1x2
        if (rl == rh && cl + 1 == ch) {
            return target == matrix[rl][cl] || target == matrix[rl][cl + 1];
        }
        if (rl + 1 == rh && cl == ch) {
            return target == matrix[rl][cl] || target == matrix[rl + 1][cl];
        }
        // 处理 2x2
        if (rl + 1 == rh && cl + 1 == ch) {
            if (matrix[rl][cl] == target) {
                return true;
            }
            if (matrix[rl][ch] == target) {
                return true;
            }
            if (matrix[rh][cl] == target) {
                return true;
            }
            if (matrix[rh][ch] == target) {
                return true;
            }
            return false;
        }
        // System.out.println(rl + " " + rh + " " + cl + " " + ch);
        int rm = (rl + rh) / 2;
        int cm = (cl + ch) / 2;
        if (matrix[rm][cm] != target) {
            // 搜索左下
            if (binarySearch(matrix, rm + 1, rh, cl, cm - 1, target)) {
                return true;
            }
            // 搜索右上
            if (binarySearch(matrix, rl, rm - 1, cm + 1, ch, target)) {
                return true;
            }
            if (matrix[rm][cm] > target) {
                // 搜索左上
                return binarySearch(matrix, rl, rm, cl, cm, target);
            } else {
                // 搜索右下
                return binarySearch(matrix, rm, rh, cm, ch, target);
            }
        } else {
            return true;
        }
    }
}