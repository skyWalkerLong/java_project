package arithmetic.le;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author longchao
 * @date 2018/7/10.
 * 输出数组中两数相加为0的所有情况
 */
public class TwoSum_1 {

    @Test
    public void test() {
        int[] nums = {2,4,3,1,-3,4,-2,-5};
        int target = 0;
        twoSum(nums,target);
    }

    public void twoSum(int[] nums, int target) {
        List list = Lists.newArrayList();
        for(int i=0;i<nums.length;i++) {
            int temp = target - nums[i];
            if (list.contains(temp)) {
                System.out.println(nums[i] + " "  + temp);
            } else {
                list.add(nums[i]);
            }
        }
    }
}
