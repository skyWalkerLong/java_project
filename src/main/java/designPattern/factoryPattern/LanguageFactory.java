package designPattern.factoryPattern;

/**
 * 普通工厂模式
 * @Author longchao
 * @Date 2017/12/4.
 */
public class LanguageFactory {

    //每增加一个对象都需要在LanguageFactory类中增加一段实现该对象的方法
    public Language getLanguage(String language) {
        if (language.equals("java")) {
            return new JavaLanguage();
        }
        if (language.equals("c++")) {
            return new CplusLanguage();
        }
        return null;
    }

}
