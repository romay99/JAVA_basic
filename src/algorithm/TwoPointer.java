package algorithm;

import java.util.Arrays;

public class TwoPointer {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 2, 4, 3, 2};
        System.out.println(Arrays.toString(twoPointer(arr,9)));
        System.out.println(Arrays.toString(twoPointer(arr,14)));

    }

    /*
    배열 arr 에서 부분의 합이 target 이 되는 구간을 찾아라
     */
    static int[] twoPointer(int[] arr, int target) {
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int[] result = {-1, -1};

        while (true) {
            if (sum > target) {
                sum -= arr[p1];
                p1++;
            } else if (p2 == arr.length) {
                break;
            } else {
                sum += arr[p2];
                p2++;
            }
            if (sum == target) {
                result[0] = p1;
                result[1] = p2 - 1;
                return result;
            }
        }
        return null;
    }
}
