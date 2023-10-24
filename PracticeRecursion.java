public class PracticeRecursion {
    public static void main(String[] args) {
        greeting(1);
        System.out.print(factorial(10));
    }

    public static void greeting(int n) {
        System.out.println("hello");

        if (n > 0) {
            greeting(n - 1);
        }
    }

    public static long factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}