package dataStructure;

import java.util.Arrays;

public class TreeDemo {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < 10; i++) {
            char ch = (char)('A' + i);
            arr[i] = ch;
        }
        BinaryTree bt = new BinaryTree(arr);
        bt.preOrder(0);
        System.out.println();
        bt.inOrder(0);
        System.out.println();
        bt.postOrder(0);
        System.out.println();
        bt.levelOrder(0);

    }
}
class BinaryTree{
    char[] arr;

    public BinaryTree(char[] c) {
        this.arr = c.clone();
    }

    public void preOrder(int idx) { // 전위 탐색 (현재 -> 왼쪽 -> 오른쪽)
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;

        System.out.print(arr[idx] + " ");

        if (left < arr.length) {
            preOrder(left);
        }
        if (right < arr.length) {
            preOrder(right);
        }
    }

    public void inOrder(int idx) { //
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;

        if (left < arr.length) {
            inOrder(left);
        }

        System.out.print(arr[idx] + " ");

        if (right < arr.length) {
            inOrder(right);
        }
    }

    public void postOrder(int idx) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        if (left < arr.length) {
            preOrder(left);
        }
        if (right < arr.length) {
            preOrder(right);
        }
        System.out.print(arr[idx] + " ");
    }

    public void levelOrder(int idx) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
