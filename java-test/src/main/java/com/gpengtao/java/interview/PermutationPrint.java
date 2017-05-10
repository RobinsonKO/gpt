package com.gpengtao.java.interview;

/**
 * 全排序
 * <p>
 * Created by gpengtao on 2017/5/10.
 */
public class PermutationPrint {

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};

        perm(list, 0, list.length - 1);
    }

    private static void perm(int[] list, int left, int right) {
        if (left == right) {
            printArray(list);
        } else {
            for (int i = left; i <= right; ++i) {
                swap(list, left, i);
                perm(list, left + 1, right);
                swap(list, left, i);
            }
        }
    }

    private static void printArray(int[] list) {
        for (int i : list) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static void swap(int[] list, int left, int right) {
        int tmp = list[left];
        list[left] = list[right];
        list[right] = tmp;
    }
}
