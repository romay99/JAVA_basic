package ioDemo;

public class ConsoleOutPut {
    public static void main(String[] args) {
        System.out.println("Hello"); // Enter 키 포함
        System.out.print("Word"); // 줄바꿈 없음

        System.out.printf("Hello "); // 포맷 지정안하면 똑같음
        System.out.printf("World \n"); // 포맷 지정안하면 똑같음

        String s = "자바";
        int number = 3;

        System.out.printf("%s는 언어 선호도 %d위 입니다\n",s,number);

        System.out.printf("%d\n",10);
        System.out.printf("%o\n",10); // 8진수
        System.out.printf("%x\n",10); // 16진수

        System.out.printf("%f\n" , 5.2f); // 실수형

        System.out.printf("%c\n",'A'); // 캐릭터
        System.out.printf("%s\n","안녕하세요"); // 문자열
        System.out.printf("%5d\n", 1234); // 앞에 5만큼 공백채우기
        System.out.printf("%-5d\n", 1234); // 뒤에 5만큼 공백채우기

        System.out.printf("%.2f\n", 1.25251221); // 소수점 2개까지만

    }
}
