package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author longchao
 * @date 2018/6/27.
 */
public class BubbleSort {
    /**
     * 从小到大，两个相邻的数比较，大的往后移动，一轮循环后，最大的数在最后，被确定
     * 重复上述动作，被确定的数不再比较
     * 重复完成排列
     * @param data
     */
    public void bubbleSort(int[] data) {
        int length = data.length;
        for (int i=0;i<length;i++) {
            for (int j=0;j<length-1-i;j++) {
                if (data[j] > data[j+1]) {
                    swap(data,j,j+1);
                }
            }
        }
    }

    public void swap(int[] data,int p,int m){
        int temp = data[p];
        data[p] = data[m];
        data[m] = temp;
    }

    @Test
    public void sort() {
        int[] data = {3,2,4,6,5,9,12,7};
        bubbleSort(data);
        System.out.println(Arrays.toString(data));
    }
}
