package exercises.src.JavaJeongseok.examples.ch10;

// 2023.7.10(월) 23h45
public class CalendarEx8 {
    public static void main(String[] args) {
        String month1 = "202302";
        String month2 = "202308";

        int months1 = Integer.parseInt(month1.substring(0, 4)) * 12 + Integer.parseInt(month1.substring(4));
        int months2 = Integer.parseInt(month2.substring(0, 4)) * 12 + Integer.parseInt(month2.substring(4));

        System.out.println(month1 + "과 " + month2 + "는 " + Math.abs(months1 - months2) + "개월 차이 납니다");
    }
}
