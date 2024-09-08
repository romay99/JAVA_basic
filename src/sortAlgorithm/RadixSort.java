package sortAlgorithm;

import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {10, 50, 40, 20, 30, 80, 70};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void radixSort(int[] arr) {
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }

        int idx = 0;
        int div = 1;
        int maxLen = getMaxLen(arr);

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < arr.length; j++) {
                list.get((arr[j] / div) % 10).offer(arr[j]);
            }

            for (int j = 0; j < 10; j++) {
                Queue<Integer> q = list.get(j);
                while (!q.isEmpty()) {
                    arr[idx++] = q.poll();
                }
            }
            idx = 0 ;
            div *= 10;
        }

    }

    static int getMaxLen(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int) Math.log10(arr[i]) + 1;
            if (maxLen < len) {
                maxLen = len;
            }
        }
        return maxLen;
    }

}
