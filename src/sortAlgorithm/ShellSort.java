package sortAlgorithm;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {10, 50, 40, 20, 30, 80, 70};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void shellSort(int[] arr) {
        int gap = arr.length/2;

        for (int g = gap; g > 0; g /= 2) {
            for (int i = g; i < arr.length; i++) {
                int tmp = arr[i];

                int j = 0;
                for (j = i - g; j >= 0; j -= g) {
                    if (arr[j] > tmp) {
                        arr[j+g] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j+g] = tmp;
            }
        }
    }
}
