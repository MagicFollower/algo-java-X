package org.example;

import org.junit.Test;

import java.util.Arrays;

/**
 * 康拓逆向展开（求M个数的第N个排列）                     -> bubbleSort
 * 康拓展开（给定一个数组0~n，求这个数组是0~n排列的第几个）  -> selectSort
 *
 * @Description CantoTest
 * @Author abc
 * @Date 24/02/04 22:19
 * @Version 1.0
 */
public class CantoTest {
    @Test
    public void test_CantoTest3_1706943608019() {
        int[] rawArr = {88, 23, 71};

        int num = rawArr.length;
        int total = fact(num);
        for (int i = 0; i < total; i++) {
            int[] arr = cantor(num, i);
            int[] newArr = new int[3];
            for (int j = 0; j < num; j++) {
                newArr[j] = rawArr[arr[j]];
            }
            System.out.println(Arrays.toString(arr));
            //System.out.println(Arrays.toString(newArr));
        }

        // 0, 1, 2
        int[] arr = {1, 2, 0};
        int index = canto(arr);
        System.out.println("index = " + index);  // 3
    }

    private int[] cantor(int num, int x) {
        int tag = 0;  // 康拓逆向展开的存在标记（memory's core）
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            int a = x / fact(num - i - 1);  // 比当前位取值小的有a个
            for (int j = 0; j < num; j++) {
                if ((tag & (1 << j)) != 0) continue;
                if (a-- == 0) {
                    tag |= 1 << j;
                    arr[i] = j;
                    break;
                }
            }
            x = x % fact(num - i - 1);  // 余数作为下一轮的被除数参与迭代
        }
        return arr;
    }

    private int fact(int num) {
        return num <= 1 ? 1 : num * fact(num - 1);
    }

    private int canto(int[] arr) {
        int index = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            // a的含义
            // 1.数学：1的原索引为1，移除1后3的原索引为2，移除3后0的原索引为0，移除0后2的原索引位置为0（a表示原数的第i个元素在当前未出现的元素中的位置索引）
            //     => 1+2+0+0
            // 2.编码：1在当前数组/排列中后方比它小的元素有1个，3在当前数组中后方比它小的元素有2个，0在当前排列中后方比它晓得元素有0个，2在当前排列中后方元素比它小的有0个
            //     => 1+2+0+0
            int a = 0;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[i]) a++;
            }
            index += a * fact(length - i - 1);
        }
        return index;
    }
}
