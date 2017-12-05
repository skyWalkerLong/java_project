package designPattern.factoryPattern;

/**
 * 利用反射的工厂模式
 * @Author longchao
 * @Date 2017/12/5.
 */
public class ReflectFactory {

    //无论增加多少对象，都不需要在工厂类中增加代码，较普通的工厂方法更通用
    public static Object getCalss(Class<? extends Language> clazz) {
        Object o = null;
        try {
            o = Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
