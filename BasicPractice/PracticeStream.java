import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PracticeStream {
    public static void main(String[] args) {
        List<Integer> hearList = new ArrayList<>();
        hearList.add(15);
        hearList.add(32);
        hearList.add(5);
        hearList.add(232);
        hearList.add(56);
        hearList.add(29);
        hearList.add(94);
        // 只要是Stream<Integer>就支持Integer::compareTo方法
        Arrays.asList(hearList.toArray(new Integer[hearList.size()])).stream().max(Integer::compareTo).get();
        Integer maxItem = hearList.stream().max(Integer::compareTo).get();
        Integer minItem = hearList.stream().min(Integer::compareTo).get();
        System.out.println("max:" + maxItem + "，min:" + minItem);
    }
}
