package test.yixia.com.testapplication;

import org.junit.Test;

/**
 * Created by zhangjian on 2018/5/17.
 */

public class InsertSort {
    @Test
    public void main() {
        int[] data = new int[]{2, 1, 6, 6, 7, 8, 5, 3, 5};
        insertSort(data);
        printArr(data);
    }

    private void insertSort(int[] data) {
        int temp;
        int n = data.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j - 1] > data[j]) {
                    temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
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
