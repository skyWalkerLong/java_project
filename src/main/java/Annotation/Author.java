package Annotation;

import java.lang.annotation.*;

/**
 * @Author longchao
 * @Date 2017/11/28.
 */
@Retention(RetentionPolicy.RUNTIME)//运行期依然保留该注解，SOURCE:编译后失效，CLASS:类加载后失效,RUNTIME:一直有效
@Target(ElementType.METHOD)//方法级别的注解
@Documented
public @interface Author {
    String name() default "方法级别的注解";//属性被定义成方法，仅支持基本类型、String和枚举
    int age() default 26;
}
