package com.gpengtao.java.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.List;

/**
 * Created by pengtao.geng on 2016/10/13.
 */
public class SubListTest {

    /**
     * 把输入的List按照输入的averageSize，分成若干个List，最后一个List的size小于等于averageSize
     *
     * @param fromList    原List
     * @param averageSize 每个List的size
     * @param <T>         List中元素的类型
     * @return
     */
    public static <T> List<List<T>> divideList(List<T> fromList, int averageSize) {
        List<List<T>> resultList = Lists.newArrayList();
        int totalSize = fromList.size();
        int listCount = (int) Math.ceil((double) totalSize / (double) averageSize);
        for (int i = 0; i < listCount; i++) {
            int start = i * averageSize;
            int end;
            //最后一次分割，直接分割到最末尾
            if (i == listCount - 1) {
                end = totalSize;
            } else {
                end = start + averageSize;
            }
            List<T> subList = fromList.subList(start, end);
            resultList.add(subList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 1; i <= 9; ++i) {
            list.add(i);
        }

        List<List<Integer>> divideList = divideList(list, 3);
        for (List<Integer> subList : divideList) {
            System.out.println(subList);
        }

        list.remove(5);

        System.out.println(list);

        for (List<Integer> subList : divideList) {
            System.out.println(subList);
        }

    }
}
