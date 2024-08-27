package dataStructure;
import java.util.*;
import java.util.LinkedList;

public class QueueDemo {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(findCard(n));
        System.out.println("getJosephusPermutation(5,2) = " + getJosephusPermutation(7,3));

    }

    static int findCard(int n){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        while(q.size() != 1){
            q.poll();
            q.add(q.poll());
        }
        return q.poll();
    }

    static ArrayList<Integer> getJosephusPermutation(int n,int k){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while(!q.isEmpty()){
            cnt++;
            int now = q.poll();
            if (cnt == k) {
                result.add(now);
                cnt = 0 ;
            } else {
                q.offer(now);
            }
        }
        return result;
    }
}

