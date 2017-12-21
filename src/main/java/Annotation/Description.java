package Annotation;

import java.lang.annotation.*;

/**
 * @Author longchao
 * @Date 2017/11/28.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//类级别的注解
@Documented
public @interface Description {
    String value();
}
