package arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author longchao
 * @Date 2017/11/30.
 */
public class InitSize {
    //类的属性自动初试化为0，如果是方法中定义的变量则必须初始化
    private static int a;
    public static void main(String[] args) {
        List<Integer> appId = new ArrayList<>();
        System.out.println(a);
        appId.add(1);
        appId.add(2);
        //初始化容量为2，只是初始化数组长度为2，集合的长度依然为0，看源码
        List<Integer> result = new ArrayList<>(2);
        System.out.println(result.size());
//        result.set(1,2);
//        System.out.println(result);

    }

}
