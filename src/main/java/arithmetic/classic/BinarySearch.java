package arithmetic.classic;

import org.junit.Test;

/**
 * 二分前提-数组有序
 * @author longchao
 * @date 2018/7/20.
 */
public class BinarySearch {

    /**
     * 二分查找-递归
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    int bsearch(int[] arr,int left,int right,int target) {
        int mid = (left + right) / 2;
        if (arr[mid] > target) return bsearch(arr,left,mid-1,target);
        if (arr[mid] < target) return  bsearch(arr,mid + 1,right,target);
        return mid;
    }

    /**
     * 二分查找-非二分
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    int bsearchWithoutRecursion(int[] arr,int left,int right,int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] arr = {1,3,4,6,12,34,54};
        int index = bsearch(arr,0,arr.length,54);
        int index_p = bsearchWithoutRecursion(arr,0,arr.length,54);
        System.out.println(index+"    ---     "+index_p);
    }
}
