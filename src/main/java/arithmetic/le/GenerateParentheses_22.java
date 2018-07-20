package arithmetic.le;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * 生成能够相互抵消的n对括号的所有排列
 *
 * 定义剩余的左括号数和右括号数left、right，起始状态left=right，
 * 一旦 left<0 或 right<0 或 left>right(添加过程中，右括号不能多于左括号，否则不能抵消)，则失败
 *
 * @author longchao
 * @date 2018/7/20.
 */
public class GenerateParentheses_22 {

    void generate(int left,int right,String out,List<String> result) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(out);
            return;
        }

        generate(left-1,right,out + "(",result);
        generate(left,right-1,out + ")",result);
    }

    @Test
    public void test() {
        List<String> list = Lists.newArrayList();
        String out = "";
        generate(4,4,out,list);
        System.out.println(list);
    }
}
