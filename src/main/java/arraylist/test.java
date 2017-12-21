package arraylist;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author longchao
 * @Date 2017/12/5.
 */
public class test {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        Set<String> set2 = new HashSet<>();
        set2.add("1");
        set2.add("2");
        set2.add("3");
        Set<String> set3 = Sets.difference(set2,set1);
        System.out.println(set1);
        System.out.println(set3);

    }

}
