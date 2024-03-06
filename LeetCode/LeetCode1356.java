import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class LeetCode1356 {
    public static void main(String[] args) {
        // 输入：arr = [0,1,2,3,4,5,6,7,8]
        // 输出：[0,1,2,4,8,3,5,6,7]
        System.out.println(Arrays.toString(new Solution1356().sortByBits(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 })));

        // 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
        // 输出：[1,2,4,8,16,32,64,128,256,512,1024]
        System.out.println(Arrays
                .toString(new Solution1356().sortByBits(new int[] { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 })));

        // 输入：arr = [10000,10000]
        // 输出：[10000,10000]
        System.out.println(Arrays
                .toString(new Solution1356().sortByBits(new int[] { 10000, 10000 })));

        // 输入：arr = [2,3,5,7,11,13,17,19]
        // 输出：[2,3,5,17,7,11,13,19]
        System.out.println(Arrays
                .toString(new Solution1356().sortByBits(new int[] { 2, 3, 5, 7, 11, 13, 17, 19 })));

        // 输入：arr = [10,100,1000,10000]
        // 输出：[10,100,10000,1000]
        System.out.println(Arrays
                .toString(new Solution1356().sortByBits(new int[] { 10, 100, 1000, 10000 })));
    }
}

class Solution1356 {
    public int[] sortByBits(int[] arr) {
        int[] values = new int[10001];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            values[arr[i]] = getValue(arr[i]);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (values[o1] != values[o2]) {
                    return values[o1] - values[o2];
                } else {
                    return o1 - o2;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int getValue(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }
}