import java.util.Scanner;

public class LanQiao504 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        int[] counts = new int[26];
        for (int i = 0; i < input.length(); i++) {
            counts[(int) (input.charAt(i) - 'a')]++;
        }
        // System.out.println(input);
        // System.out.println(Arrays.toString(counts));
        char resChar = 'a';
        int resCount = 0;
        for (int i = 0; i < counts.length; i++) {
            if (resCount < counts[i]) {
                resCount = counts[i];
                resChar = (char) (i + 'a');
            }
        }
        System.out.println(resChar);
        System.out.println(resCount);
    }
}
