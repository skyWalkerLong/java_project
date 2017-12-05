import java.lang.annotation.*;

/**
 * @Author longchao
 * @Date 2017/11/28.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Author {

    String name();
    String group();
}
