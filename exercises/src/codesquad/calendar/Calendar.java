package exercises.src.codesquad.calendar;

// 2023.7.12(수) 21h20 ~ 21h50 v1 완성

/**
 * [프로그램 조건]
 * - 월을 입력하면 해당 월의 달력 출력
 * - 달력 모양은 1단계에서 작성한 모양으로 만듦
 * - 1일은 일요일로 정해도 무방
 * - -1을 입력받기 전까지 반복 입력받음
 * - 프롬프트 출력
 */
public class Calendar {
    // 2023.7.12(수) 22h25 현재 문제점 = 윤년 미 반영
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)) { // 윤년인 경우, 윤년용 배열 사용
            return LEAP_MAX_DAYS[month - 1];
        } else { // 평년인 경우, 평년용 배열 사용
            return MAX_DAYS[month - 1];
        }
    }

    // 2023.7.12(수) 강의 22h15 reference
    public void printCalendarReference(int year, int month) {
        System.out.printf("  <<%4d년%3d월>>\n", year, month);

        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");

        int maxDay = getMaxDaysOfMonth(year, month);

        for (int i = 1; i <= maxDay; i++) {
            System.out.printf("%3d", i);
            if (i % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println(); // 줄바꿈

        // hard coding
//        System.out.println("          1  2  3  4");
//        System.out.println(" 5  6  7  8  9 10 11");
//        System.out.println("12 13 14 15 16 17 18");
//        System.out.println("19 20 21 22 23 24 25");
//        System.out.println("26 27 28 29 30 31");
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
}
