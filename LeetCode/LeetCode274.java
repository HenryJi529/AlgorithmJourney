public class LeetCode274 {
    public static void main(String[] args) {
        // 输入：citations = [3,0,6,1,5]
        // 输出：3
        System.out.println(new Solution274().hIndex(new int[] { 3, 0, 6, 1, 5 }));

        // 输入：citations = [1,3,1]
        // 输出：1
        System.out.println(new Solution274().hIndex(new int[] { 1, 3, 1 }));

        // 输入：citations = [4,4,0,0]
        // 输出：2
        System.out.println(new Solution274().hIndex(new int[] { 4, 4, 0, 0 }));
    }
}

class Solution274 {
    public int hIndex(int[] citations) {
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            int currentMaxIndex = i;
            int currentMaxValue = citations[i];
            for (int j = i + 1; j < citations.length; j++) {
                if (citations[j] > currentMaxValue) {
                    currentMaxIndex = j;
                    currentMaxValue = citations[j];
                }
            }
            swap(citations, i, currentMaxIndex);
            if (currentMaxValue < i + 1) {
                return h;
            } else {
                h++;
            }
        }
        return h;
    }

    public void swap(int[] citations, int i, int j) {
        int temp = citations[i];
        citations[i] = citations[j];
        citations[j] = temp;
    }
}