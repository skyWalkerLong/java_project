package lambda;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author longchao
 * @Date 2018/1/17.
 */
public class Loop {
    public static void main(String[] args) {
        String[] a ={"1","2","3"};
        List<String> list = Arrays.asList(a);


        //原来的循环方式
        for(String i : a) {
            System.out.println(i);
        }

        //lambda表达式循环
        list.forEach(i -> System.out.println(i));

        //双冒号操作符
        list.forEach(System.out::println);



    }


}
