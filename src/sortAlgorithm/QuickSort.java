package sortAlgorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {20,10,40,30,50,60,90,80,70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    static void quickSort(int[] arr, int left , int right) {
        if (left >= right) return;

        int pivot = partion(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    static int partion(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (arr[j] > pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, left, i);
        return i;
    }
}
