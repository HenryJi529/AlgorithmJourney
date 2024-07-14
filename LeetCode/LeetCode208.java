import java.util.HashMap;

public class LeetCode208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // 返回 True
        System.out.println(trie.search("app")); // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app")); // 返回 True
    }
}

/**
 * 构造一个字典树，可以将children的类型改为Node[]
 */
class Trie {
    class Node {
        public HashMap<Character, Node> children = new HashMap<>();
        public boolean isWord = false;

        public void insert(char c) {
            children.put(c, new Node());
        }

        public boolean contains(char c) {
            return children.containsKey(c);
        }

        public Node get(char c) {
            return children.get(c);
        }

        public int childCount() {
            return children.size();
        }
    }

    private Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        int ind = 0;
        while (ind < word.length()) {
            char c = word.charAt(ind);
            if (!curr.contains(c)) {
                curr.insert(c);
            }
            curr = curr.get(c);
            ind++;
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        int ind = 0;
        while (ind < word.length()) {
            char c = word.charAt(ind);
            if (!curr.contains(c)) {
                return false;
            }
            curr = curr.get(c);
            ind++;
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        int ind = 0;
        while (ind < prefix.length()) {
            char c = prefix.charAt(ind);
            if (!curr.contains(c)) {
                return false;
            }
            curr = curr.get(c);
            ind++;
        }
        return true;
    }
}
