import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author longchao
 * @date 2018/4/3.
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 4;
        }
        return climbStairs(n-1) + climbStairs(n-2) + climbStairs(n-3);
    }
}
