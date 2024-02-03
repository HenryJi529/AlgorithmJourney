public class LeetCode1534 {
    public static void main(String[] args) {
        // 输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
        // 输出：4
        // 解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
        System.out.println(new Solution1534().countGoodTriplets(new int[] { 3, 0, 1, 1, 9, 7 }, 7, 2, 3));

        // 输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
        // 输出：0
        // 解释：不存在满足所有条件的三元组。
        System.out.println(new Solution1534().countGoodTriplets(new int[] { 1, 1, 2, 2, 3 }, 0, 0, 1));
    }
}

class Solution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}