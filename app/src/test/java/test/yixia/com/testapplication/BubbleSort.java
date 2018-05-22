package test.yixia.com.testapplication;

import org.junit.Test;

/**
 * Created by zhangjian on 2018/5/17.
 */

public class BubbleSort {
    @Test
    public void main() {
        int[] data = new int[]{2, 1, 6, 6, 7, 8, 5, 3, 5};
        bubbleSort(data);
        printArr(data);
    }


    private void bubbleSort(int[] data) {//最右边是最大
        int temp;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
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
