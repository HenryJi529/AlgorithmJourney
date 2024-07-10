public class LeetCode74 {
    public static void main(String[] args) {
        // 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        // 输出：true
        System.out.println(new Solution74()
                .searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 3));

        // 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        // 输出：false
        System.out.println(new Solution74()
                .searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 13));
    }
}

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length * matrix[0].length - 1;
        int mid;
        int row;
        int col;
        while (low <= high) {
            mid = (low + high) / 2;
            row = mid / matrix[0].length;
            col = mid % matrix[0].length;
            if (matrix[row][col] < target) {
                low = mid + 1;
            } else if (matrix[row][col] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}