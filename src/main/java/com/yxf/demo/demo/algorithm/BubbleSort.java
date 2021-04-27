package com.yxf.demo.demo.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序算法
 *      相邻数据对比，并进行交换
 * @author yangxiangfeng
 * @date 2021/4/25 10:43
 */
public class BubbleSort {


    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] ints = bubbleSort.getArray(20);
        System.out.print("原数组：" + Arrays.toString(ints));
        System.out.println();
        bubbleSort.algorithm(ints);
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
        boolean flag;
        int n = ints.length;
        for (int j = n; j > 1; j--) {
            flag = true;
            for (int i = 1; i < j; i++) {
                if (ints[i - 1] > ints[i]) {
                    int tmp = ints[i];
                    ints[i] = ints[i - 1];
                    ints[i - 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return ints;
    }

}
