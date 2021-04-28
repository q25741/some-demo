package com.yxf.demo.demo.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序算法
 * @author yangxiangfeng
 * @date 2021/4/27 17:55
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ints = quickSort.getArray(20);
        System.out.print("原数组：" + Arrays.toString(ints));
        System.out.println();
        quickSort.algorithm(ints);
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

    private void algorithm(int[] ints) {
        this.partition(ints, 0, ints.length);
    }

    private void partition(int[] ints, int left, int right) {
        if (right - left < 2) {
            return;
        }
        // p点的取值可以优化，避免出现最差时间复杂度
        int p = left;
        int index = left + 1;
        System.out.println("排序：" + left + "-" + right);
        System.out.println(Arrays.toString(ints));
        for (int i = index; i < right; i++) {
            if (ints[i] < ints[p]) {
                this.swap(ints, i, index);
                index++;
            }
        }
        this.swap(ints, p, index - 1);
        System.out.println(Arrays.toString(ints));
        this.partition(ints, left, index - 1);
        this.partition(ints, index, right);
    }

    private void swap(int[] ints, int i, int j) {
        if (i != j) {
            int tmp = ints[j];
            ints[j] = ints[i];
            ints[i] = tmp;
        }
    }


}
