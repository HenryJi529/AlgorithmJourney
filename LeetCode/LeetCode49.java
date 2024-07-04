import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode49 {
    public static void main(String[] args) {
        // 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        // 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(new Solution49_3().groupAnagrams(new String[] { "eat",
                "tea", "tan", "ate", "nat", "bat" }));

        // 输入: strs = [""]
        // 输出: [[""]]
        System.out.println(new Solution49_3().groupAnagrams(new String[] { "" }));

        // 输入: strs = ["a"]
        // 输出: [["a"]]
        System.out.println(new Solution49_3().groupAnagrams(new String[] { "a" }));

        // 输入: strs = ["bdddddddddd","bbbbbbbbbbc"]
        // 输出: [["bbbbbbbbbbc"],["bdddddddddd"]]
        System.out.println(new Solution49_3().groupAnagrams(new String[] {
                "bdddddddddd", "bbbbbbbbbbc" }));
    }
}

/**
 * // 暴力求解，也能通过
 */
class Solution49_1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (String str : strs) {
            boolean flag = false;
            for (List<String> anagrams : result) {
                if (isAnagram(anagrams.get(0), str)) {
                    anagrams.add(str);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result.add(new ArrayList<String>(List.of(str)));
            }
        }
        return result;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
            if (counts[t.charAt(i) - 'a'] == -1) {
                return false;
            }
        }
        return true;
    }
}

/**
 * 对string构成的char[]排序
 */
class Solution49_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

/**
 * 直接用字母的数量作为HashMap的Key
 */
class Solution49_3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            String key = getKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public String getKey(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(counts[i]);
            sb.append('-');
        }
        return sb.toString();
    }
}
