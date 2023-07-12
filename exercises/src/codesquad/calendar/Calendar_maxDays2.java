package exercises.src.codesquad.calendar;

import java.util.Scanner;

// 2021.8월초 inflearn 강의
public class Calendar_maxDays2 {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMaxDaysOfMonth(int month) {
        // 배열 사용 안 하면
        // 방법1) if, if else.. 구문
        /*
        if (month == 2) {
            return 28;
        } else if (month == 4) {
            return 30;
        } // 등등

        return 31;
         */

        // 방법2) switch문
        /*
        switch (month) {
            case 2:
                return 28;
            case 4:
                return 30;
            // 등등
            default:
                return 31;
        }
         */

        // 배열 사용
        return MAX_DAYS[month - 1];
    }

    public void printSampleCalendar() {
        System.out.println("일  월  화 수  목 금  토");
        System.out.println("--------------------");
        System.out.println("          1  2  3  4");
        System.out.println(" 5  6  7  8  9 10 11");
        System.out.println("12 13 14 15 16 17 18");
        System.out.println("19 20 21 22 23 24 25");
        System.out.println("26 27 28 29 30 31");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calendar_maxDays2 cal = new Calendar_maxDays2();
        System.out.print("달을 입력하세요 > ");
        int month = scanner.nextInt();

        System.out.printf("%d월은 %d일까지 있습니다\n", month, cal.getMaxDaysOfMonth(month));

        cal.printSampleCalendar();
        scanner.close();
    }
}