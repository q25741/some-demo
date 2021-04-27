package com.yxf.demo.demo.algorithm;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序算法
 *      分为有序数组和无序数组，每次遍历无序数组，将最小的数存放在有序数组的末尾
 * @author yangxiangfeng
 * @date 2021/4/25 11:50
 */
public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] ints = selectionSort.getArray(20);
        System.out.print("原数组：" + Arrays.toString(ints));
        System.out.println();
        selectionSort.algorithm(ints);
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
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            int min = ints[minIndex];
            for (int j = i; j < n; j++) {
                if (ints[j] < min) {
                    minIndex = j;
                    min = ints[j];
                }
            }
            ints[minIndex] = ints[i];
            ints[i] = min;
        }
        return ints;
    }

}
