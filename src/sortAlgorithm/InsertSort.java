package sortAlgorithm;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 1, 4, 10};
        System.out.println(Arrays.toString(insertSort(arr)));

    }
    static int[] insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                } else { // 비교할 필요가없을때는 break
                    break;
                }
            }
        }
        return arr;
    }
}
