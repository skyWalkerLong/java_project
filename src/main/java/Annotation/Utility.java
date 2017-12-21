package Annotation;

/**
 * @Author longchao
 * @Date 2017/11/28.
 */
@Description(value = "类级别的注解")
public class Utility {
    @Author()//已经定义了默认值，可以不再定义
    public void test(){
        System.out.println("ok");
    }
}
