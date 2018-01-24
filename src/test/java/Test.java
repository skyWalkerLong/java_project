/**
 * @Author longchao
 * @Date 2018/1/23.
 */
public class Test {

    public static void main(String[] args) {
        TestPO testVo = new TestPO();
        testVo.setName("s");
        cast(testVo);
        System.out.print(testVo.getName());
    }

    public static void cast(TestPO testPO) {
        testPO.setName("ok");
    }

    //实验发现，如果是普通类型的值，相当于复制一份到方法中执行，原值不变；如果是对象，相当于把对象直接传进方法内，原对象在
    //方法中如果有改变，原对象就会变化。
}
