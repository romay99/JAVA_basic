package sortAlgorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {22,24,21,100,102,10, 2, 1, 40, 60, 42, 34};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr) {
        int length = arr.length;
        if(length == 1 ) return;

        int midIdx = length / 2;

        int[] leftArray = new int[midIdx];
        int[] rightArray = new int[length - midIdx];
        int i = 0; // 왼
        int j = 0; // 오

        for (; i < length; i++) {
            if (i < midIdx) {
                leftArray[i] = arr[i];
            } else {
                rightArray[j++] = arr[i];
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray,rightArray,arr);
    }
    static void merge(int[] leftArr , int[] rightArr , int[] arr){
        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;
        int i = 0, l = 0, r = 0; // 인덱스 ,왼쪽인덱스 , 오른쪽인덱스

        while (l < leftSize && r < rightSize) { // 두 배열을 검사해서
            if (leftArr[l] < rightArr[r]) { // 왼쪽게 더 작으면 왼쪽걸 arr 에 넣고
                arr[i++] = leftArr[l++];
            } else {
                arr[i++] = rightArr[r++]; // 오른쪽게 더 작으면 오른쪽걸 arr 에 넣는다.
            }
        }
        if (l < leftSize) { // 남은 배열 다 넣어주기.
            while (l < leftSize) { // 왼쪽배열이 남았다면 왼쪽배열 다 넣어주기
                arr[i++] = leftArr[l++];
            }
        } else if (r < rightSize) {
            while (r < rightSize) { // 오른쪽배열이 다 남았다면 오른쪽배열 다 넣어주기
                arr[i++] = rightArr[r++];
            }
        }
    }
}
