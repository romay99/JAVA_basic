package streamDemo;

import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {
        // 1 배열 스트림
        String[] arr = {"a", "b", "c"};
        Stream stream1 = Arrays.stream(arr);
        stream1.forEach(a -> System.out.println(a));

        // 2 컬렉션 스트림
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        Stream stream2 = list.stream();
        stream2.forEach(a -> System.out.println(a));

        // 3 스트림 builder
        Stream stream3 = Stream.builder().add(1).add(2).add(3).build();
        stream3.forEach(a -> System.out.println(a));

        // 4 스트림 generate
        Stream stream4 = Stream.generate(() -> "abc").limit(3);
        stream4.forEach(a-> System.out.println(a));

        // 5 스트림 iterate
        Stream stream5 = Stream.iterate(10, n -> n * 2).limit(3); // seed 값 = 초기값
        stream5.forEach(a-> System.out.println(a));

        // 6 기본 타입 스트림
        IntStream intStream = IntStream.range(1,5);
        intStream.forEach(a -> System.out.println(a));

        /*/
        스트림 중개연산
         */
        // 1 필터링
        IntStream intStream2 = IntStream.range(1, 10).filter(a -> a % 2 == 0); // 필터메소드로 짝수만 구하기
        intStream2.forEach(a-> System.out.println(a));

        // 2 맵핑
        IntStream intStream3 = IntStream.range(1, 10).map(n -> n + 1); // map 으로 각각의 요소에 특정기능 하기
        intStream3.forEach(a -> System.out.println(a));

        // 3 소팅
        IntStream intStream4 = IntStream.builder().add(1).add(5).add(3).build();
        intStream4.sorted().forEach(System.out::println);

        /*
        스트림 최종 연산
         */
        // sum , Average
        int sum = IntStream.range(1,5).sum();
        System.out.println("sum = " + sum);
        double average = IntStream.range(1, 5).average().getAsDouble();
        System.out.println("average = " + average);

        // min , max
        int min = IntStream.range(1,5).min().getAsInt();
        int max = IntStream.range(1,5).max().getAsInt();

        // reduce
        ArrayList<Integer> reduceStream = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(reduceStream.stream().reduce((x,y) -> x + y).get());

        // forEach
        IntStream.range(1,10).filter(n -> n ==5).forEach(System.out::println);
    }
}
