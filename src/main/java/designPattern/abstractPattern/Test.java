package designPattern.abstractPattern;

/**
 * @Author longchao
 * @Date 2017/12/5.
 */
public class Test {
    /**
     *
     *
     */
    public static void main(String[] args){
        FactoryProducer factoryProducer = new FactoryProducer();
        AnimalFactory a = (AnimalFactory) factoryProducer.getObject(AnimalFactory.class);
        Cat cat = (Cat) a.getAnimal("cat");
        cat.getName();
    }
}
