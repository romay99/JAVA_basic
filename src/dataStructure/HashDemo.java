package dataStructure;
import java.util.*;

public class HashDemo {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(Arrays.toString(sol.solution(new int[]{7,15,1,3},10)));
            System.out.println(Arrays.toString(sol.solution(new int[]{8,3,-2},6)));
        System.out.println(Arrays.toString(sol.solution(new int[]{1,2,3},12)));

    }
}

class Solution2 {
    public int[] solution(int[] arr ,int target){
        HashMap<Integer,Integer> map = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                result[0] = map.get(arr[i]);
                result[1] = i;
                return result;
            }
            map.put(target - arr[i] , i);
        }
        return null;
    }
}
