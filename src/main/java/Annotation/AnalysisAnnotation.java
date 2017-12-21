package Annotation; /**
 * @Author longchao
 * @Date 2017/11/28.
 */
import java.lang.reflect.Method;

public class AnalysisAnnotation {

    public static void main(String[] args) {
        try {
            //通过运行时反射API获得annotation信息
            //反射机制获取类
            Class rt_class = Class.forName("Annotation.Utility");
            //获取类中的所有方法
            Method[] methods = rt_class.getMethods();
            //判断该类是否使用了@Description注解
            boolean flag = rt_class.isAnnotationPresent(Description.class);

            if(flag)
            {
                //获取注解实例
                Description description = (Description)rt_class.getAnnotation(Description.class);
                //获取注解中定义的属性值
                System.out.println("Utility's Description--->"+description.value());
                for (Method method : methods) {
                    System.out.println(method);
                    //判断该方法是否使用了@Author注解
                    if(method.isAnnotationPresent(Author.class))
                    {
                        Author author = (Author)method.getAnnotation(Author.class);
                        System.out.println("Utility's Author--->"+author.name()+" from "+author.age());

                    }
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
