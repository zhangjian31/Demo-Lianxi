package test.yixia.com.testapplication;

import org.junit.Test;

/**
 * Created by zhangjian on 2018/5/17.
 */

public class QuickSort {
    @Test
    public void testQuick() {
        int[] a = new int[]{2, 1, 6, 6, 7, 8, 5, 3, 5};
        quick(a, 0, a.length - 1);
        printArr(a);
    }

    private void printArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private void quick(int[] a, int i, int j) {
        if (i < j) {
            int mid = quickSub(a, i, j);
            quick(a, i, mid - 1);
            quick(a, mid + 1, j);
        }
    }

    private int quickSub(int s[], int l, int r) {
        int i = l, j = r;
        int x = s[i];
        while (i < j) {
            while (i < j && s[j] > x) {
                j--;
            }
            if (i < j) {
                s[i] = s[j];
                i++;
            }
            while (i < j && s[i] < x) {
                i++;
            }
            if (i < j) {
                s[j] = s[i];
                j--;
            }
        }
        s[i] = x;
        return i;
    }
}
