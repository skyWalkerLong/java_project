/**
 * @Author longchao
 * @Date 2018/1/23.
 */
public class TestPO {
    String name = "long";
    Number value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public TestPO() {}

    public TestPO(String name, Number value) {
        this.name = name;
        this.value = value;
    }
}
