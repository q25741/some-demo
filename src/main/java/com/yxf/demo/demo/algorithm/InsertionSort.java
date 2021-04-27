package com.yxf.demo.demo.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序算法
 *      将数组分为有序数组和无序数组，遍历无序数组分别和有序数组进行对比，找到合适的位置后插入。
 * @author yangxiangfeng
 * @date 2021/4/25 11:07
 */
public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] ints = insertionSort.getArray(20);
        System.out.print("原数组：" + Arrays.toString(ints));
        System.out.println();
        insertionSort.algorithm(ints);
        System.out.print("新数组：" + Arrays.toString(ints));
    }

    private int[] getArray(int n) {
        int[] ints = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            ints[i] = random.nextInt(100);
        }
        return ints;
    }

    private int[] algorithm(int[] ints) {
        int n = ints.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int tmp = ints[i];
            for (; j >= 0; j--) {
                if (tmp < ints[j]) {
                    ints[j + 1] = ints[j];
                } else {
                    break;
                }
            }
            ints[j + 1] = tmp;
        }
        return ints;
    }

}
