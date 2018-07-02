package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author longchao
 * @date 2018/6/27.
 */
public class SelectSort {

    public void selectSort(int[] a) {
        int length = a.length;
        for(int i=0;i<length-1;i++) {
            for(int j=i+1;j<length;j++){
                if(a[j]<a[i]){
                    swap(a,i,j);
                }
            }
        }
    }

    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Test
    public void sort() {
        int[] data = {3,2,4,6,5,9,12,7};
        selectSort(data);
        System.out.println(Arrays.toString(data));
    }
}
