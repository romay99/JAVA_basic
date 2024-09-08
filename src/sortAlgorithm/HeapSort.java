package sortAlgorithm;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 9, 10, 2, 40, 6, 35};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, 0, i);
        }
    }

    static void heapify(int[] arr,int parentIdx ,int size){
        int left = parentIdx * 2 + 1;
        int right = parentIdx * 2 + 2;
        int maxIdx = parentIdx;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != parentIdx) {
            int tmp = arr[maxIdx];
            arr[maxIdx] = arr[parentIdx];
            arr[parentIdx] = tmp;
            heapify(arr,maxIdx,size);
        }
    }
}

