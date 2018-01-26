package lambda;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author longchao
 * @Date 2018/1/24.
 */
public class SortList {

    /**
     * 使用匿名内部类排序
     */
    public static void nomal(String[] players) {

        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });

        out(players);
    }

    /**
     * 使用lambda表达式
     */
    public static void lambda(String[] players) {
        //根据名字首字母排序
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
        //根据名字长度排序
        Arrays.sort(players,(String s1,String s2) -> (s1.length() - s2.length()));
        out(players);
    }

    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        nomal(players);
        lambda(players);


    }

    public static void out(String[] players) {
        List<String> list = Lists.newArrayList(players);
        list.forEach(i -> System.out.println(i));
    }
}
