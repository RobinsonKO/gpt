package com.gpengtao.java.sort;

/**
 * Created by pengtao.geng on 2017/4/14.
 */
public class SelectSort_MainTest {

    public static void main(String[] args) {
        int array[] = {4, 6, 2, 1, 8, 3, 7, 9, 5};

        selectSort(array);

        for (int i : array) {
            System.out.printf("%d\t", i);
        }
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
        }
    }

    private static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
