import java.util.LinkedList;

public class ExperimentLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        a.add(1); // 加到尾部
        a.push(2); // 加到头部
        a.offer(3); // 加到尾部
        a.offer(4); // 加到尾部
        System.out.println(a);
        a.remove(); // 删除头部
        System.out.println(a);
        System.out.println(a.peek() + " " + a.peekFirst() + " " + a.peekLast()); // peek == peekFirst 查看头部
        a.pop(); // 删除头部
        System.out.println(a);
        a.poll(); // 删除头部
        System.out.println(a);
    }
}
