import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1002 {
    public static void main(String[] args) {
        // 输入：words = ["bella","label","roller"]
        // 输出：["e","l","l"]
        System.out
                .println(Arrays.toString(
                        (new Solution1002().commonChars(new String[] { "bella", "label", "roller" }).toArray())));

        // 输入：words = ["cool","lock","cook"]
        // 输出：["c","o"]
        System.out
                .println(Arrays.toString(
                        (new Solution1002().commonChars(new String[] { "cool", "lock", "cook" }).toArray())));
    }
}

class Solution1002 {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        int[] freq;
        for (String word : words) {
            freq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                freq[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(freq[i], minFreq[i]);
            }
        }
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            int count = minFreq[i];
            for (int j = 0; j < count; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}