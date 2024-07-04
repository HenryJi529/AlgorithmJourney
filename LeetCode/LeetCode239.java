import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode239 {
    public static void main(String[] args) {
        // 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        // 输出：[3,3,5,5,6,7]
        System.out.println(
                Arrays.toString(new Solution239_3().maxSlidingWindow(new int[] { 1, 3, -1,
                        -3, 5, 3, 6, 7 }, 3)));

        // 输入：nums = [1], k = 1
        // 输出：[1]
        System.out.println(
                Arrays.toString(new Solution239_3().maxSlidingWindow(new int[] { 1 }, 1)));

        // 输入：nums = [7,2,4], k = 2
        // 输出：[7,4]
        System.out.println(
                Arrays.toString(new Solution239_3().maxSlidingWindow(new int[] { 7, 2, 4 },
                        2)));
    }
}

/**
 * 自带的PriortyQueue删除的复杂度比较高
 */
class Solution239_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return new int[] { nums[0] };
        }
        if (k == 1) {
            return Arrays.copyOf(nums, nums.length);
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
            result[0] = pq.peek();
        }
        for (int i = k; i < nums.length; i++) {
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            result[i - k + 1] = pq.peek();
        }
        return result;
    }
}

/**
 * 手动实现的效率大大降低，但还不够(46/51)
 */
class Solution239_2 {
    class Element implements Comparable<Element> {
        public int index;
        public int value;
        public int order;

        public Element(int index, int value, int order) {
            this.index = index;
            this.value = value;
            this.order = order;
        }

        @Override
        public int compareTo(Element that) {
            return Integer.compare(this.value, that.value);
        }

        public String toString() {
            return String.valueOf(this.value);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return new int[] { nums[0] };
        }
        if (k == 1) {
            return Arrays.copyOf(nums, nums.length);
        }

        int[] result = new int[nums.length - k + 1];
        Element[] elements = new Element[k];
        HashMap<Integer, Element> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                Element ele = new Element(i, nums[i], i);
                elements[i] = ele;
                map.put(i, ele);
                // 对每个采用元素swim
                swim(i, elements);
                if (i == k - 1) {
                    // 设置最大元素为result[0]
                    result[0] = elements[0].value;
                }
            } else {
                // 获取窗口开头的元素(i-k)
                Element ele = map.get(i - k);
                // 从窗口中删除
                map.remove(i - k);
                // 通过修改这个元素的index和value，实现将pq中的对应位置换成新元素
                ele.index = i;
                ele.value = nums[i];
                // 将新元素放回map
                map.put(i, ele);
                // 调整pq中的次序
                sink(ele.order, elements);
                swim(ele.order, elements);
                // 设置最大元素为result[i-k+1]
                result[i - k + 1] = elements[0].value;
            }
        }
        return result;
    }

    // 上浮
    private void swim(int index, Element[] elements) {
        int parent = index % 2 == 0 ? (index - 2) / 2 : (index - 1) / 2;
        while (index != 0) {
            if (elements[index].compareTo(elements[parent]) > 0) {
                swap(index, parent, elements);
            }
            index = parent;
        }
    }

    // 下沉
    private void sink(int index, Element[] elements) {
        if (index * 2 + 1 < elements.length) {
            if (elements[index].compareTo(elements[index * 2 + 1]) < 0) {
                swap(index, index * 2 + 1, elements);
            }
            sink(index * 2 + 1, elements);
        }
        if (index * 2 + 2 < elements.length) {
            if (elements[index].compareTo(elements[index * 2 + 2]) < 0) {
                swap(index, index * 2 + 2, elements);
            }
            sink(index * 2 + 2, elements);
        }
    }

    private void swap(int i, int j, Element[] elements) {
        elements[i].order = j;
        elements[j].order = i;
        Element temp = null;
        temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}

/**
 * 思路打开，窗口为k，不代表pq一定要存k个，如果取出的元素不在合理范围内可以继续取
 */
class Solution239_3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair1[1] - pair2[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[] { nums[i], i });
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[] { nums[i], i });
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
