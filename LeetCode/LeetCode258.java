public class LeetCode258 {
    public static void main(String[] args) {
        // 输入: num = 38
        // 输出: 2
        System.out.println(new Solution258().addDigits(38));

        // 输入: num = 0
        // 输出: 0
        System.out.println(new Solution258().addDigits(0));
    }
}

class Solution258 {
    public int addDigits(int num) {
        int sum = num;
        do {
            num = sum;
            sum = 0;
            while (num >= 10) {
                sum += num % 10;
                num = num / 10;
            }
            sum += num;
        } while (sum >= 10);
        return sum;
    }
}