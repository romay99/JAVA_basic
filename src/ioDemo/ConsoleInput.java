package ioDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleInput {
    public static void referInputStream() throws IOException {
        //System.in = 1개의 값만 가져올 수 있음
        System.out.print("입력 : ");
        int a = System.in.read() - '0';
        System.out.println(a);
        System.in.read(new byte[System.in.available()]); // 엔터키를 없애주는 부분

        //InputStreamReader
        System.out.print("입력 : ");
        InputStreamReader reader = new InputStreamReader(System.in);
        char[] arr = new char[3];
        reader.read(arr); // 데이터를 읽어서 이 배열에 넣어줌
        System.out.println(arr);

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("입력 : ");
        System.out.println(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        referInputStream(); // 위에 1,2,3 번 방식
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 : ");
        System.out.println(sc.next());
        sc.nextLine();
        sc.nextInt(); // 이건 int 값만 받아와야함
        sc.nextLine(); // 이걸 가장 많이 사용함

    }
}
