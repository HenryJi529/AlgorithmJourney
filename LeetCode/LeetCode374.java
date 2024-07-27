public class LeetCode374 {
    public static void main(String[] args) {
        System.out.println(new Solution374(1702766719).guessNumber(2126753390));
    }
}

class GuessGame {
    private int pick;

    GuessGame(int pick) {
        this.pick = pick;
    }

    public int guess(int num) {
        return pick - num;
    }
}

class Solution374 extends GuessGame {
    Solution374(int pick) {
        super(pick);
    }

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        int mid = 1;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            int comp = guess(mid);
            if (comp < 0) {
                r = mid - 1;
            } else if (comp > 0) {
                l = mid + 1;
            } else {
                break;
            }
        }
        return mid;
    }
}