package designPattern.abstractPattern;

/**
 * @Author longchao
 * @Date 2017/12/5.
 */
public class AnimalFactory extends AbstrctFactory {

    @Override
    public Animal getAnimal(String animal){
        if(animal.equals("cat")){
            return new Cat();
        }else if(animal.equals("dog")){
            return new Dog();
        }
        return null;
    }

    @Override
    public Language getLanguage(String language){
        return null;
    }
}
