package com.chenxin.algorithm;

import android.util.Log;

/**
 * Created by chenxin on 2017/7/25.
 * O(∩_∩)O~
 */

public class SortUtils {

    public static final String TAG = "SortUtils";

    /**
     * 冒泡排序
     *
     * @param array 待排序的数组
     */
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 选择排序
     *
     * @param arr 待排序的数组
     */
    public static void selectionSort(int[] arr) {
        int i, j, min, temp, len = arr.length;
        for (i = 0; i < len - 1; i++) {
            min = i;//未排序序列中最小数据数组下标
            for (j = i + 1; j < len; j++)//在未排序元素中继续寻找最小元素，并保存其下标
                if (arr[min] > arr[j]) {
                    min = j;
                }
            temp = arr[min]; //将最小元素放到已排序序列的末尾
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 快速排序入口
     *
     * @param arr 待排序的数组
     */
    public static void quckSort(int arr[]) {
        quckSortStep1(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序步骤一(递归实现)
     *
     * @param arr  待排序的数组
     * @param low  数组下标
     * @param high 数组下标
     */
    private static void quckSortStep1(int arr[], int low, int high) {
        if (low < high) {
            int pivot = quckSortStep2(arr, low, high);
            quckSortStep2(arr, low, pivot - 1);
            quckSortStep2(arr, pivot + 1, high);
        }
    }

    /**
     * 快速排序步骤二(将比“枢轴”(pivot)这个数小的放到左边，大的放到右边)
     *
     * @param arr  待排序的数组
     * @param low  数组下标
     * @param high 数组下标
     * @return 返回“枢轴”(pivot)的下标
     */
    private static int quckSortStep2(int arr[], int low, int high) {
        int pivot = arr[low];
        //这个循环就是将 比pivot小的放到它的左边，比pivot大的放到它的右边。
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot) {
                low++;

                arr[high] = arr[low];
            }
        }
        arr[low] = pivot;
        return low;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //

    /**
     * 将有二个有序数列a[first...mid]和a[mid...last]合并。
     *
     * @param a     待排序的数组
     * @param first 待排序数组的前一个索引
     * @param mid   待排序数组的中间的索引
     * @param last  待排序数组的后一个索引
     * @param temp  临时数组用来存放排序后的值
     */
    private static void mergearray(int a[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;

        while (i <= m && j <= n) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= m)
            temp[k++] = a[i++];

        while (j <= n)
            temp[k++] = a[j++];

        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
        printArray(a);
    }

    /**
     * 归并排序的递归
     *
     * @param a     待排序的数组
     * @param first 待排序数组的前一个索引
     * @param last  待排序数组的后一个索引
     * @param temp  临时数组用来存放排序后的值
     */
    private static void mergesort(int a[], int first, int last, int temp[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergesort(a, first, mid, temp);    //左边有序
            mergesort(a, mid + 1, last, temp); //右边有序
            mergearray(a, first, mid, last, temp); //再将二个有序数列合并
        }
    }


    /**
     * 归并排序入口
     *
     * @param a 待排序的数组
     * @param n 待排序的数组长度
     */
    public static void MergeSort(int a[], int n) {
        int[] p = new int[n];
        mergesort(a, 0, n - 1, p);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * 打印数组的元素
     *
     * @param array
     */
    public static void printArray(int[] array) {
        StringBuffer b = new StringBuffer();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            b.append(array[i]);
            b.append(" ");
        }
        Log.e(TAG, "排序后的数组元素为  " + b.toString());
    }
}
