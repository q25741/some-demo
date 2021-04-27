package com.yxf.demo.demo.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序算法
 * @author yangxiangfeng
 * @date 2021/4/26 17:20
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] ints = mergeSort.getArray(20);
        System.out.print("原数组：" + Arrays.toString(ints));
        System.out.println();
        ints = mergeSort.split(ints);
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

    private int[] split(int[] ints) {
        int n = ints.length;
        if (ints.length < 2) {
            return ints;
        }

        int mid = ints.length / 2;
        int[] left = Arrays.copyOfRange(ints, 0, mid);
        int[] right = Arrays.copyOfRange(ints, mid, ints.length);

        return merge(split(left), split(right));
    }

    private int[] merge(int[] left, int[] right) {
        int i = 0, j = 0;
        int[] ints = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                ints[i + j] = left[i++];
            } else {
                ints[i + j] = right[j++];
            }
        }

        while (i < left.length) {
            ints[i + j] = left[i++];
        }

        while (j < right.length) {
            ints[i + j] = right[j++];
        }
//        System.out.println(Arrays.toString(left) + " " + Arrays.toString(right));
//        System.out.println(Arrays.toString(ints));
        return ints;
    }

}
