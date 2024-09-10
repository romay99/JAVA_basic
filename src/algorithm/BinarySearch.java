package algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(binarySearchWithFor(arr,30));
        System.out.println(binarySearchWithRecur(arr,30,0,arr.length-1));

    }

    static int binarySearchWithFor(int[] arr, int target) {
        // 반복문 구조 이진탐색
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(target == arr[mid]){
                return mid;
            } else if (target < arr[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    static int binarySearchWithRecur(int[] arr, int target, int left, int right) {
        // 재귀함수 구조 이진탐색
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearchWithRecur(arr , target , left , mid -1);
        } else {
            return binarySearchWithRecur(arr, target, mid + 1, right);
        }
    }
}
