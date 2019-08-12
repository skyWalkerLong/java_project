package arithmetic.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author longchao
 * @date 2018/6/27.
 */
public class QuickSort {
    @Test
    public void sort() {
        int[] a = {39,49,89,97,25,56,13,45};
        int left = 0;
        int right = a.length - 1;
        quickSort(a,left,right);
        System.out.println(Arrays.toString(a));
    }

    public void quickSort(int[] a ,int left,int right) {
        if (left >= right) return;
        int stand = a[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (a[j] >= stand && i < j) {
                j --;
            }
            while (a[i] <= stand && i <j) {
                i ++;
            }
            swap(a,i,j);
        }

        swap(a,left,j);


        quickSort(a,0,j-1);
        quickSort(a,j+1,right);
    }

    public void swap(int[] a,int left,int right) {
        int temp = a[right];
        a[right] = a[left];
        a[left] = temp;
    }
}
