package dataStructure;
import java.util.*;

public class DequeDemo {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5,6,7};
        sol.reOrderData(arr);
        sol.reOrderData(arr2);

        System.out.println(sol.checkPalindrome("abba")); // false
        System.out.println(sol.checkPalindrome("abcab")); // false
        System.out.println(sol.checkPalindrome("abcba")); // true
    }
}

class Solution{ // 문제풀이
    void reOrderData(int[] arr){
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        boolean first = true;
        for (int i = 0; i < arr.length; i++) {
            deque.add(arr[i]);
        }
        while (!deque.isEmpty()){
            if(first){
                result.add(deque.pollFirst());
                first = false;
            } else {
                result.add(deque.pollLast());
                first = true;
            }
        }
        System.out.println(result);
    }

    boolean checkPalindrome(String str) {
        if (str.length() % 2 == 0) return false;
        if (str.length() == 1 ) return true;
        String[] list = str.split("");
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(list));

        while(deque.size() > 1 ){
            sb1.append(deque.pollFirst());
            sb2.append(deque.pollLast());
        }
        return sb1.toString().equals(sb2.toString());
    }
}
