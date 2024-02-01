public class LeetCode852 {
    public static void main(String[] args) {
        // 输入：arr = [0,1,0]
        // 输出：1
        System.out.println(new Solution852().peakIndexInMountainArray(new int[] { 0,
                1, 0 }));

        // 输入：arr = [0,2,1,0]
        // 输出：1
        System.out.println(new Solution852().peakIndexInMountainArray(new int[] { 0,
                2, 1, 0 }));

        // 输入：arr = [0,10,5,2]
        // 输出：1
        System.out.println(new Solution852().peakIndexInMountainArray(new int[] { 0,
                10, 5, 2 }));
    }
}

class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}