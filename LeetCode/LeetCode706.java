public class LeetCode706 {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap);
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap);
        myHashMap.get(1); // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap);
        myHashMap.get(3); // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap);
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMap);
        myHashMap.get(2); // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        System.out.println(myHashMap);
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap);
        myHashMap.get(2); // 返回 -1(未找到)，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap);
    }
}

class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] buckets;
    int size;

    public MyHashMap() {
        this.buckets = new Node[16];
        this.size = 0;
    }

    public void put(int key, int value) {
        // NOTE: 新的相同index的元素插在队尾(插在队首代码可以更简洁)
        if (this.size >= this.buckets.length * 0.75) {
            expand();
        }
        int index = Integer.valueOf(key).hashCode() % buckets.length;
        Node cur = this.buckets[index];
        if (cur == null) {
            this.buckets[index] = new Node(key, value);
            this.size++;
            return;
        }

        while (true) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            if (cur.next == null) {
                cur.next = new Node(key, value);
                this.size++;
                return;
            }
            cur = cur.next;
        }
    }

    public int get(int key) {
        int index = Integer.valueOf(key).hashCode() % buckets.length;
        Node cur = this.buckets[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = Integer.valueOf(key).hashCode() % buckets.length;
        Node cur = this.buckets[index];
        Node pre;
        if (cur == null) {
            return;
        }
        if (cur.key == key) {
            this.buckets[index] = cur.next;
        } else {
            while (cur.next != null) {
                pre = cur;
                cur = cur.next;
                if (cur.key == key) {
                    pre.next = cur.next;
                }
            }
        }

    }

    private void expand() {
        Node[] oldBuckets = this.buckets;
        this.buckets = new Node[buckets.length * 2];
        for (int i = 0; i < oldBuckets.length; i++) {
            Node cur = oldBuckets[i];
            while (cur != null) {
                put(cur.key, cur.value);
                cur = cur.next;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < buckets.length; i++) {
            Node cur = buckets[i];
            while (cur != null) {
                sb.append(String.format("[%d, %d],", cur.key, cur.value));
                cur = cur.next;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" ]");
        return sb.toString();
    }
}
