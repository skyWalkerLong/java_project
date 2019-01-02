package arithmetic.le;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author longchao
 * @date 2018/7/10.
 * 输出数组中两数相加为0的所有情况
 */
public class TwoSum_1 {

    @Test
    public void test() {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        twoSum(nums,target);
    }

    public void twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = Maps.newHashMap();

        for(int i=0;i<nums.length;i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                System.out.println(i+"--"+map.get(temp));
            } else {
                map.put(nums[i],i);
            }
        }
    }
}
