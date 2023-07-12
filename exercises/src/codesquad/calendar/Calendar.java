package exercises.src.codesquad.calendar;

// 2023.7.12(수) 21h20

import java.util.Scanner;

/**
 * [프로그램 조건]
 * - 월을 입력하면 해당 월의 달력 출력
 * - 달력 모양은 1단계에서 작성한 모양으로 만듦
 * - 1일은 일요일로 정해도 무방
 * - -1을 입력받기 전까지 반복 입력받음
 * - 프롬프트 출력
 */
public class Calendar {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMaxDaysOfMonth(int month) {
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

    public void printCalendar(int maxDaysOfMonth) {
        // 월 최대 날짜 수에 따라 달력 그림/출력
        System.out.println("일  월  화 수  목 금  토");
        System.out.println("--------------------");
        for (int i = 1; i <= maxDaysOfMonth; i++) {
            // 1일을 x요일이라고 가정, 1~7(일~월)
            int day = 3; // 화요일
            if (i == 1) {
                System.out.print(" ".repeat((day - 1) * 3));
            }

            if (i < 10) {
                System.out.print(" " + i + " ");
            } else {
                System.out.print(i + " ");
            }


            if (i % 7 == 8 - day) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        String PROMPT = "cal > ";
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        int month = 0;

        while (true) {
            System.out.println("달을 입력하세요 ");
            System.out.print(PROMPT);
            month = scanner.nextInt();

            if (month == -1) {
                break;
            } else if (month == 0 || month < -1 || month > 12) {
                System.out.println("정확한 숫자를 입력해 주세요");
                continue;
            }

            // 사용자가 입력한 월의 최대 날짜 수 구해옴
            int maxDaysOfMonth = cal.getMaxDaysOfMonth(month);
            cal.printCalendar(maxDaysOfMonth);
        } // while문

        System.out.println("Bye~");
    }
}
