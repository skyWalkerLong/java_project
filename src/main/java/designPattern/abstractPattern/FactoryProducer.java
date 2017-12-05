package designPattern.abstractPattern;

/**
 * @Author longchao
 * @Date 2017/12/5.
 */
public class FactoryProducer {
    public Object getObject(Class<? extends AbstrctFactory> clazz) {
        Object o = null;
        try{
            o = Class.forName(clazz.getName()).newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return o;
    }
}
