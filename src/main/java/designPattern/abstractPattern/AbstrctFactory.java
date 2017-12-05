package designPattern.abstractPattern;

/**
 * @Author longchao
 * @Date 2017/12/5.
 */
public abstract class AbstrctFactory {
    public abstract Animal getAnimal(String animal);
    public abstract Language getLanguage(String language);
}
