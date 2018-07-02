package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author longchao
 * @date 2018/6/27.
 */
public class InsertSort {

    public void insertSort(int[] a) {
        int length = a.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            int temp = a[i];
            for (j = i ; j > 0 && temp < a[j-1]; j--) {
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
    }

    @Test
    public void sort() {
        int[] data = {3, 2, 4, 6, 5, 9, 12, 7};
        insertSort(data);
        System.out.println(Arrays.toString(data));
    }
}
