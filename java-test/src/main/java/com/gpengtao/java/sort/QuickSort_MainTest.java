package com.gpengtao.java.sort;

/**
 * Created by pengtao.geng on 2016/10/26.
 */
public class QuickSort_MainTest {

    public static void main(String[] args) {

        int array[] = {4, 6, 2, 1, 8, 3, 7, 9, 5};

        quickSort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.printf("%d\t", i);
        }

    }

    public static void quickSort(int[] array, int left, int right) {
        // 递归终点
        if (left >= right) {
            return;
        }

        int originLeft = left;  // 原始左边坐标
        int originRight = right;// 原始右边坐标
        int base = array[left]; // 排序基准数字
        while (left < right) {
            while (left < right && array[right] >= base) {  // 从右至左找到第一个比base小的数
                right--;
            }
            if (left < right) {
                array[left] = array[right]; // 让这个数覆盖left位置
                left++;
            }

            while (left < right && array[left] < base) {    // 从左至右找第一个比base大的数
                left++;
            }

            if (left < right) { // 让这个数覆盖right位置
                array[right] = array[left];
                right--;
            }
        }

        array[left] = base;// 排完一次，left位置在放回去，至此，左边都比base小，右边都比base大

        quickSort(array, originLeft, left - 1); // 原始左边到当前left未知排序
        quickSort(array, left + 1, originRight);// 当前left位置到最后再排序
    }
}
