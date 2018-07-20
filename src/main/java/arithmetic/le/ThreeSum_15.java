package arithmetic.le;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author longchao
 * @date 2018/7/10.
 */
public class ThreeSum_15 {

    @Test
    public void test(){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> all=new ArrayList<List<Integer>>();
        int length=nums.length;
        Arrays.sort(nums);
        if(nums.length<3){
            return all;
        }
        for(int i=0;i<length-2;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    all.add(list);
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                    continue;
                }
                if(nums[i]+nums[left]+nums[right]<0){
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    left++;
                    continue;
                }
                if(nums[i]+nums[left]+nums[right]>0){
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    right--;
                }

            }
        }

        //Iterator it=all.iterator();
        // while(it.hasNext()){
        // 	System.out.println(it.next());
        // }
        return all;

    }
}
