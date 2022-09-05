package exercises.src.JavaJeongseok.exercises.ch14;

import java.util.stream.Stream;

// 2022.9.5(월) 0h30
public class Ex14_5 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        Stream<String> strStream = Stream.of(strArr);

        int sum = strStream.mapToInt(s -> s.length()).sum();
        System.out.println("sum = " + sum);
    }
}
