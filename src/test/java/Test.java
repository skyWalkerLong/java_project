import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author longchao
 * @Date 2018/1/23.
 */
public class Test {

    public static void main(String... args) {
        TestPO testVo = new TestPO();
        testVo.setName("s");
        cast(testVo);
        //System.out.print(testVo.getName());
        System.out.println(Integer.valueOf(""));

        try {
            Object o = Class.forName("java.util.Date").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Method[] methods = Class.forName("java.util.Date").getMethods();
            List<Method> list = Arrays.asList(methods);
            list.forEach(i -> System.out.println(i));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void cast(TestPO testPO) {
        testPO.setName("ok");
    }

    //实验发现，如果是普通类型的值，相当于复制一份到方法中执行，原值不变；如果是对象，相当于把对象直接传进方法内，原对象在
    //方法中如果有改变，原对象就会变化。
}
