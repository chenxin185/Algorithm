package com.chenxin.algorithm;

/**
 * Created by chenxin on 2017/8/25.
 * O(∩_∩)O~
 */

public class TestSort {


    private static void mergeArray(int[] array, int start, int mid, int last, int[] temp) {
        int i, j, k;
        i = start;
        j = mid + 1;
        k = 0;
        int m = last;
        int n = mid;
        while (i <= n && j <= m) {
            if (array[i] < array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }

        while (i <= n) {
            temp[k++] = array[i++];
        }

        while (j <= m) {
            temp[k++] = array[j++];
        }

        for (i = 0; i < k; i++) {
            array[start + i] = temp[i];
        }

        SortUtils.printArray(array);

    }


    private static void merge(int[] array, int start, int last, int[] temp) {
        if (start < last) {
            int mid = (start + last) / 2;
            merge(array, start, mid, temp);
            merge(array, mid + 1, last, temp);
            mergeArray(array, start, mid, last, temp);
        }
    }

    public static void MergeSort(int[] array) {
        int[] temp = new int[array.length];
        merge(array, 0, array.length - 1, temp);
    }
}
