package designPattern.abstractPattern;

/**
 * @Author longchao
 * @Date 2017/12/5.
 */
public class LanguageFactory extends AbstrctFactory {

    @Override
    public Language getLanguage(String language){
        if(language.equals("java")){
            return new JavaLanguage();
        } else if(language.equals("c++")){
            return new CplusLanguage();
        }
        return null;
    }

    @Override
    public Animal getAnimal(String animal){
        return null;
    }
}
