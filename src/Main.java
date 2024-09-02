import java.time.LocalTime;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<>();
        list.sort(new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                if(n1.nodeNum == n2.nodeNum){
                    return n1.num2 - n2.num2;
                }
                return n1.nodeNum - n2.nodeNum;
            }
        });
    }
}

class Node {
    int num ;
    int num2;
    int nodeNum;

    public Node(int num, int num2,int nodeNum) {
        this.num = num;
        this.num2 = num2;
        this.nodeNum = nodeNum;
    }

    @Override
    public String toString() {
        return "num=" + num +
                ", num2=" + num2 +
                ", nodeNum=" + nodeNum +
                '}';
    }
}

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer[]> busQ = new LinkedList<>();
        int startHour = 9;
        int startMin = 0;
        busQ.add(new Integer[]{startHour, startMin});
        for (int i = 0; i < n; i++) {
            startMin += t;
            if(startMin >= 60){
                startHour += startMin / 60;
                startMin %= 60;
            }
            busQ.add(new Integer[]{startHour, startMin});
        }


        String answer = "";
        return answer;
    }
}