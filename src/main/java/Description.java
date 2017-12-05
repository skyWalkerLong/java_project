import java.lang.annotation.*;

/**
 * @Author longchao
 * @Date 2017/11/28.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Description {
    String value();
}
