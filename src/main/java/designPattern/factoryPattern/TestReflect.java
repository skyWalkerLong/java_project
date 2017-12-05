package designPattern.factoryPattern;

/**
 * @Author longchao
 * @Date 2017/12/5.
 */
public class TestReflect {

    public static void main(String[] args) {
        JavaLanguage j = (JavaLanguage)ReflectFactory.getCalss(JavaLanguage.class);
        j.write();
        CplusLanguage c = (CplusLanguage)ReflectFactory.getCalss(CplusLanguage.class);
        c.write();
    }
}
