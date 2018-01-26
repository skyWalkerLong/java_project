package lambda.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author longchao
 * @Date 2018/1/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String firstName, lastName, job, gender;
    private int age,salary;
}
