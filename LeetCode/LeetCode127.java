import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class LeetCode127 {

    public static void main(String[] args) {
        // 输入：beginWord = "hit", endWord = "cog", wordList =
        // ["hot","dot","dog","lot","log","cog"]
        // 输出：5
        System.out.println(new Solution127_2().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));

        // 输入：beginWord = "hit", endWord = "cog", wordList =
        // ["hot","dot","dog","lot","log"]
        // 输出：0
        System.out.println(new Solution127_2().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }
}

class Solution127_1 {
    // 复杂度为O(n^4)，不可行
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.add(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                if (cur == endWord) {
                    return length;
                }
                for (String word : wordList) {
                    if (!visited.contains(word) && similar(word, cur)) {
                        queue.offer(word);
                    }
                }
            }
            length++;
        }
        return 0;
    }

    public boolean similar(String str1, String str2) {
        int length = str1.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                count++;
            }
        }
        return count == length - 1;
    }
}

class Solution127_2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        HashMap<String, List<String>> graph = buildGraph(beginWord, wordList);
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<String>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return length;
                }
                for (String neighbor : graph.get(word)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            length++;
        }
        return 0;
    }

    public HashMap<String, List<String>> buildGraph(String beginWord, List<String> wordList) {
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        for (String word : wordList) {
            graph.put(word, new ArrayList<String>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (similar(wordList.get(i), wordList.get(j))) {
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        graph.put(beginWord, new ArrayList<String>());
        for (String word : wordList) {
            if (similar(beginWord, word)) {
                graph.get(beginWord).add(word);
                graph.get(word).add(beginWord);
            }
        }
        return graph;
    }

    public boolean similar(String str1, String str2) {
        int length = str1.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                count++;
            }
        }
        return count == length - 1;
    }
}