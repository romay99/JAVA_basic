package dataStructure;
import java.util.*;
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        String str1 = "ab#a";
        String str2 = "aab#";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String[] str1arr = str1.split("");
        String[] str2arr = str1.split("");

        for (int i = 0; i < str1.length(); i++) {
            if(str1arr[i].equals("#")){
                stack.pop();
            } else{
                stack.push(str1arr[i]);
            }
            if(str2arr[i].equals("#")){
                stack2.pop();
            } else {
                stack2.push(str1arr[i]);
            }
        }
        while (!stack.isEmpty()){
            sb1.append(stack.pop());
        }
        while (!stack2.isEmpty()){
            sb2.append(stack2.pop());
        }
        System.out.println(sb1.toString().equals(sb2.toString()));
    }
}
