package designPattern.factoryPattern;

/**
 * @Author longchao
 * @Date 2017/12/4.
 */
public class Test {
    public static void main(String[] args) {
        LanguageFactory languageFactory = new LanguageFactory();

        Language j = languageFactory.getLanguage("java");
        j.write();

        Language c = languageFactory.getLanguage("c++");
        c.write();

    }
}
