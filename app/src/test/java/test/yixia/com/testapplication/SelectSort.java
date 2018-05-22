package test.yixia.com.testapplication;

import org.junit.Test;

/**
 * Created by zhangjian on 2018/5/17.
 */

public class SelectSort {
    @Test
    public void main() {
        int[] data = new int[]{2, 1, 6, 6, 7, 8, 5, 3, 5};
        selectSortMin(data);
        printArr(data);
        selectSortMax(data);
        printArr(data);
    }

    private void selectSortMin(int[] data) {
        int temp;
        for (int i = 0; i < data.length - 1; i++) {//最左边是最小的
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
    private void selectSortMax(int[] data) {
        int temp;
        for (int i = 0; i < data.length - 1; i++) {//最左边是最小的
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] < data[j]) {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
    private void printArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
