import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author longchao
 * @Date 2018/1/23.
 */
@Data
@ToString
public class TestPO {
    String name = "long";
    Boolean value;
    Date createTime;

    public TestPO() {}

    public TestPO(String name, Boolean value) {
        this.name = name;
        this.value = value;
    }

    public TestPO(String name, Boolean value, Date createTime) {
        this.name = name;
        this.value = value;
        this.createTime = createTime;
    }
}
