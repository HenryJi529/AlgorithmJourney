import java.util.Scanner;

public class LanQiao97 {
    // NOTE: 时间复杂度为O(n^2)
    // public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    // int N = scanner.nextInt();
    // int K = scanner.nextInt();
    // int[] array = new int[N];
    // int[] record = new int[N];
    // int result = 0;
    // for (int i = 0; i < array.length; i++) {
    // array[i] = scanner.nextInt();
    // if (array[i] % K == 0) {
    // result++;
    // }
    // record[i] = array[i] % K;
    // }
    // scanner.close();

    // for (int len = 2; len <= array.length; len++) {
    // for (int ind = 0; ind + len <= array.length; ind++) {
    // int temp = record[ind] + array[ind + len - 1];
    // if (temp % K == 0) {
    // result++;
    // }
    // record[ind] = temp % K;
    // }
    // }
    // System.out.println(result);
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] cnt = new int[K];
        cnt[0] = 1;
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum = (sum + scanner.nextInt()) % K;
            cnt[sum]++;
        }
        scanner.close();
        long ans = 0L;
        for (int i = 0; i < K; i++) {
            ans += (long) cnt[i] * (cnt[i] - 1) / 2;
        }
        System.out.println(ans);
    }
}
