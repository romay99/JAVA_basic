package sortAlgorithm;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {10, 50, 40, 20, 30, 80, 70};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i]]++;
        }
        int idx = 0 ;
        for (int i = 0; i < cntArr.length; i++) {
            while (cntArr[i] > 0) {
                arr[idx++] = i;
                cntArr[i] --;
            }
        }
    }
}
