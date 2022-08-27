package exercises.src.JavaJeongseok.exercises.ch10;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.DayOfWeek.TUESDAY;
import static java.time.temporal.TemporalAdjusters.dayOfWeekInMonth;

// 2022.8.27(토) 23h50
// JDK1.8부터 추가된 java.time 패키지 -> Java 탄생부터 날짜 및 시간 다룰 때 사용하던 Date, Calendar의 단점들 해소 e.g. java.time 패키지에 속한 클래스들은 immutable(불변) -> 멀티 쓰레드 환경에서 안전
public class Ex10_7 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2016, 12, 1); // java.time 패키지에 속한 클래스의 객체 생성 <- of() 메소드 사용
        System.out.println(date.with(dayOfWeekInMonth(4, TUESDAY))); // 2016-12-27
    }
}
