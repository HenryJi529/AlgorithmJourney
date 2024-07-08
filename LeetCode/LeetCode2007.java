import java.util.Arrays;

public class LeetCode2007 {
    public static void main(String[] args) {
        // 输入：changed = [1,3,4,2,6,8]
        // 输出：[1,3,4]
        System.out.println(Arrays.toString(new Solution2007().findOriginalArray(new int[] { 1, 3, 4, 2, 6, 8 })));

        // 输入：changed = [6,3,0,1]
        // 输出：[]
        System.out.println(Arrays.toString(new Solution2007().findOriginalArray(new int[] { 6, 3, 0, 1 })));

        // 输入：changed = [1]
        // 输出：[]
        System.out.println(Arrays.toString(new Solution2007().findOriginalArray(new int[] { 1 })));

        // 输入：changed = [2,1]
        // 输出：[1]
        System.out.println(Arrays.toString(new Solution2007().findOriginalArray(new int[] { 2, 1 })));

        // 输入：changed = [1,2,3,2,4,6,2,4,6,4,8,12]
        // 输出：[1,2,2,3,4,6]
        System.out.println(Arrays
                .toString(new Solution2007().findOriginalArray(new int[] { 1, 2, 3, 2, 4, 6,
                        2, 4, 6, 4, 8, 12 })));

        // 输入：changed = [0,1,0,0]
        // 输出：[]
        System.out.println(Arrays.toString(new Solution2007().findOriginalArray(new int[] { 0, 1, 0, 0 })));
    }

}

class Solution2007 {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        if (changed.length % 2 != 0) {
            return new int[] {};
        }
        int[] origin = new int[changed.length / 2];
        int ind = 0;
        int left = 0;
        int right = 1;
        boolean[] visited = new boolean[changed.length];
        while (true) {
            while (left < changed.length - 1 && visited[left]) {
                left++;
            }
            if (left == changed.length - 1) {
                break;
            }
            visited[left] = true;
            while (right < changed.length && (visited[right] || changed[right] != 2 * changed[left])) {
                right++;
            }
            if (right == changed.length) {
                break;
            }
            origin[ind] = changed[left];
            visited[right] = true;
            ind++;
        }
        return ind != changed.length / 2 ? new int[] {} : origin;
    }
}