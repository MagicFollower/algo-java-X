package org.example;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 10种排序算法
 * <pre>
 * 01.选择排序
 * 02.冒泡排序
 * 03.插入排序
 * 04.希尔排序
 * 05.计数排序X2
 * 06.快速排序
 * 07.归并排序
 * 08.基数排序(位数循环)
 * 09.桶排序(桶内使用外部排序)
 * 10.堆排序(构建大堆首尾交换堆排序，大堆排序后获取顺序数据)
 * </pre>
 *
 * @Description SortTest
 * @Author abc
 * @Date 24/01/30 13:49
 * @Version 1.0
 */
public class SortTest {
    @Test
    public void test_SortTest3_1706593801603() {
        Gson gson = new Gson();
        final int[] arr1 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, -5, 0, 0};
        selectSort(arr1);
        System.out.println(gson.toJson(arr1));

        final int[] arr2 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, -5, 0, 0};
        bubbleSort(arr2);
        System.out.println(gson.toJson(arr2));

        final int[] arr3 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, -5, 0, 0};
        insertSort(arr3);
        System.out.println(gson.toJson(arr3));

        final int[] arr4 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, -5, 0, 0};
        shellSort(arr4);
        System.out.println(gson.toJson(arr4));

        /* 基数排序针对正整数 */
        final int[] arr51 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, 5, 0, 0};
        countingSort(arr51);
        System.out.println(gson.toJson(arr51));
        final int[] arr52 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, -5, 0, 0};
        countingSortUpdated(arr52);
        System.out.println(gson.toJson(arr52));

        final int[] arr6 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, -5, 0, 0};
        quickSort(arr6);
        System.out.println(gson.toJson(arr6));

        final int[] arr7 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, -5, 0, 0};
        mergeSort(arr7);
        System.out.println(gson.toJson(arr7));

        /* 基数排序针对正整数 */
        final int[] arr8 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, 5, 0, 0};
        radixSort(arr8);
        System.out.println(gson.toJson(arr8));

        final int[] arr9 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, -5, 0, 0};
        bucketSort(arr9);
        System.out.println(gson.toJson(arr9));

        final int[] arr10 = {5, 8, 7, 9, 8, 5, 4, 5, 4, 5, 6, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 9, 8, 7, 6, -5, 0, 0};
        heapSort(arr10);
        System.out.println(gson.toJson(arr10));
    }

    private void heapSort(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            // 1.构建大堆
            for (int i = length / 2 - 1; i >= 0; i--) {
                heapify(arr, i, length);
            }
            // 2.堆排序
            for (int i = length - 1; i > 0; i--) {
                int t = arr[i];
                arr[i] = arr[0];
                arr[0] = t;
                heapify(arr, 0, i);
            }
        }
    }

    private void heapify(int[] arr, int i, int length) {
        int root = i;
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        if (left < length && arr[left] > arr[root]) {
            root = left;
        }
        if (right < length && arr[right] > arr[root]) {
            root = right;
        }
        if (root != i) {
            int t = arr[i];
            arr[i] = arr[root];
            arr[root] = t;
            heapify(arr, root, length);
        }
    }

    private void bucketSort(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            int max = arr[0];
            int min = arr[0];
            for (int i = 1; i < length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            List<List<Integer>> buckets = new ArrayList<>();
            for (int i = 0; i < (max - min) / length + 1; i++) {
                buckets.add(new ArrayList<>());
            }
            for (int num : arr) {
                int bucketIndex = (num - min) / length;
                buckets.get(bucketIndex).add(num);
            }
            for (List<Integer> bucket : buckets) {
                // Collections.sort(bucket);
                int[] bucketArray = bucket.stream().mapToInt(x -> x).toArray();
                mergeSort(bucketArray);
                ListIterator<Integer> i = bucket.listIterator();
                for (int e : bucketArray) {
                    i.next();
                    i.set(e);
                }
            }
            int index = 0;
            for (List<Integer> bucket : buckets) {
                for (int num : bucket) {
                    arr[index++] = num;
                }
            }
        }
    }

    private void radixSort(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            int max = arr[0];
            for (int i = 1; i < length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            int maxDigitCount = 0;
            while (max != 0) {
                max /= 10;
                maxDigitCount++;
            }
            List<List<Integer>> buckets = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<>());
            }
            for (int i = 0; i < maxDigitCount; i++) {
                for (int num : arr) {
                    int bucketIndex = (num / (int) Math.pow(10, i)) % 10;
                    buckets.get(bucketIndex).add(num);
                }
                int index = 0;
                for (List<Integer> bucket : buckets) {
                    for (int num : bucket) {
                        arr[index++] = num;
                    }
                    bucket.clear();
                }
            }
        }
    }

    private void mergeSort(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            int[] arrTmp = new int[length];
            mergeSortInner(arr, arrTmp, 0, length - 1);
        }
    }

    private void mergeSortInner(int[] arr, int[] arrTmp, int l, int h) {
        if (l < h) {
            int middle = (l + h) / 2;
            mergeSortInner(arr, arrTmp, l, middle);
            mergeSortInner(arr, arrTmp, middle + 1, h);
            mergeSortMerge(arr, arrTmp, l, middle, h);
        }
    }

    private void mergeSortMerge(int[] arr, int[] arrTmp, int leftStart, int middle, int rightEnd) {
        int leftEnd = middle;
        int rightStart = middle + 1;
        int size = rightEnd - leftStart + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                arrTmp[index++] = arr[left++];
            } else {
                arrTmp[index++] = arr[right++];
            }
        }
        System.arraycopy(arr, left, arrTmp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, arrTmp, index, rightEnd - right + 1);
        System.arraycopy(arrTmp, leftStart, arr, leftStart, size);
    }

    private void quickSort(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            quickSortInner(arr, 0, length - 1);
        }
    }

    private void quickSortInner(int[] arr, int l, int h) {
        if (l < h) {
            int pivotIndex = quickSortPartition(arr, l, h);
            quickSortInner(arr, l, pivotIndex - 1);
            quickSortInner(arr, pivotIndex + 1, h);
        }
    }

    private int quickSortPartition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int ld = l - 1;
        for (int i = l; i < h; i++) {
            if (arr[i] < pivot) {
                ld++;
                if (ld != i) {
                    int t = arr[ld];
                    arr[ld] = arr[i];
                    arr[i] = t;
                }
            }
        }
        ld++;
        int t = arr[ld];
        arr[ld] = arr[h];
        arr[h] = t;
        return ld;
    }

    private void countingSortUpdated(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i : arr) {
                map.merge(i, 1, Integer::sum);
            }
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int count = entry.getValue();
                while (count-- > 0) {
                    arr[index++] = entry.getKey();
                }
            }
        }
    }

    private void countingSort(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            int max = arr[0];
            for (int i = 1; i < length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            int[] arrTmp = new int[max + 1];
            for (int i : arr) {
                arrTmp[i]++;
            }
            int index = 0;
            for (int i = 0; i < max + 1; i++) {
                int count = arrTmp[i];
                while (count-- > 0) {
                    arr[index++] = i;
                }
            }
        }
    }

    private void shellSort(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            for (int gap = length / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < length; i++) {
                    int k = arr[i];
                    int id = i - gap;
                    if (arr[id] > k) {
                        while (id >= 0 && arr[id] > k) {
                            arr[id + gap] = arr[id];
                            id -= gap;
                        }
                        arr[id + gap] = k;
                    }
                }
            }
        }
    }

    private void insertSort(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            for (int i = 1; i < length; i++) {
                int k = arr[i];
                int id = i - 1;
                if (arr[id] > k) {
                    while (id >= 0 && arr[id] > k) {
                        arr[id + 1] = arr[id];
                        id -= 1;
                    }
                    arr[id + 1] = k;
                }
            }
        }
    }

    private void bubbleSort(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            for (int i = 0; i < length - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                        swapped = true;
                    }
                }
                if (!swapped) return;
            }
        }
    }

    private void selectSort(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 1) {
            for (int i = 0; i < length - 1; i++) {
                int minIndex = i;
                for (int j = i; j < length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    int t = arr[minIndex];
                    arr[minIndex] = arr[i];
                    arr[i] = t;
                }
            }
        }
    }
}


