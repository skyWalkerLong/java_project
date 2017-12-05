package arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author longchao
 * @Date 2017/11/30.
 */
public class InitSize {
    private static int a;
    public static void main(String[] args) {
        List<Integer> appId = new ArrayList<>();
        System.out.println(a);
        appId.add(1);
        appId.add(2);
        List<Integer> result = new ArrayList<>(2);
        System.out.println(result.size());
//        result.set(1,2);
//        System.out.println(result);

    }

}
