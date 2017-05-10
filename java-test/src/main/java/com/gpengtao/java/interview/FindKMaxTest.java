package com.gpengtao.java.interview;

/**
 * Created by gpengtao on 2017/5/10.
 */
public class FindKMaxTest {

    public static void main(String[] args) {
        int[] list1 = {3, 10, 14, 17, 24, 34, 39, 48, 55, 59};

        int[] list2 = {1, 2, 3, 4, 5};

        findKMax(list1, list2, 8);
    }

    private static void findKMax(int[] list1, int[] list2, int k) {
        int i = 0;
        int j = 0;

        int kNum = 0;

        while (i + j < k) {
            int whoSmall = findWhoSmall(list1, i, list2, j);
            if (whoSmall == 1) {
                kNum = list1[i];
                i++;
            }
            if (whoSmall == 2) {
                kNum = list2[j];
                j++;
            }
        }

        System.out.println(kNum);
    }

    private static int findWhoSmall(int[] list1, int i, int[] list2, int j) {
        if (i >= list1.length) {
            return 2;
        }
        if (j >= list2.length) {
            return 1;
        }
        if (list1[i] <= list2[j]) {
            return 1;
        } else {
            return 2;
        }
    }
}
