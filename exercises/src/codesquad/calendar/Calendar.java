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

    // 특정 연도의 1월 1일 요일 결정 기준일
    // e.g. 2023.1.1(월) <- 2023.1.1(일) <- 2022.1.1(토) <- 2021.1.1(금)..
    private static final int STANDARD_YEAR = 2023;
    private static int STANDARD_DAY = 0;

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
    public void printCalendarReference(int year, int month, int weekday) {
        System.out.printf("  <<%4d년%3d월>>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");

        // print blank space
        for (int i = 0; i < weekday; i++) {
            System.out.print("   "); // 하나의 요일당 3칸 띄워서 1일을 배치시켜야 함
        }

        int maxDay = getMaxDaysOfMonth(year, month);
        int count = 7 - weekday;
        int delim = (count < 7) ? count : 0;

        /*
        int delim;
        if (count < 7) {
            delim = count;
        } else {
            delim = 0;
        }
         */

        // print 1st line
        for (int i = 1; i <= count; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        // print from 2nd to last line
        count++;
        for (int i = count; i <= maxDay; i++) {
            System.out.printf("%3d", i);
            if (i % 7 == delim) {
                System.out.println();
            }
        }

        System.out.println(); // 줄바꿈
        System.out.println(); // 줄바꿈

        // hard coding
//        System.out.println("          1  2  3  4");
//        System.out.println(" 5  6  7  8  9 10 11");
//        System.out.println("12 13 14 15 16 17 18");
//        System.out.println("19 20 21 22 23 24 25");
//        System.out.println("26 27 28 29 30 31");
    }

    public void printCalendarWithStringDay(int year, int month, String day) {
        // 월 최대 날짜 수에 따라 달력 그림/출력 <- 사용자가 입력한 월의 최대 날짜 수 구해옴
        int maxDaysOfMonth = getMaxDaysOfMonth(year, month);

        // 요일 문자열을 숫자로 바꿔옴
        int dayNum = changeStringDayToIntDay(day);

        System.out.printf("  <<%4d년%3d월>>\n", year, month);

        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");
        for (int i = 1; i <= maxDaysOfMonth; i++) {
            // 1일을 x요일이라고 가정, 1~7(일~월)
//            dayNum = 3; // 화요일
            if (i == 1) {
                System.out.print(" ".repeat((dayNum - 1) * 3));
            }

//            if (i < 10) {
//                System.out.print(" " + i + " ");
//            } else {
//                System.out.print(i + " ");
//            }
            System.out.printf("%3d", i);

            // 2023.7.12(수) 23h40 버그(dayNum이 1(일요일)일 때 7로 나눈 나머지가 7?!) 수정
            int delim = (dayNum == 1) ? 0 : 8 - dayNum;
            if (i % 7 == delim) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println();
    }

    // 2023.7.12(수) 22h55
    public int changeStringDayToIntDay(String day) {
        int dayNum = 0;

        switch (day) {
            case "SU":
                dayNum = 1;
                break;
            case "MO":
                dayNum = 2;
                break;
            case "TU":
                dayNum = 3;
                break;
            case "WE":
                dayNum = 4;
                break;
            case "TH":
                dayNum = 5;
                break;
            case "FR":
                dayNum = 6;
                break;
            case "SA":
                dayNum = 7;
                break;
            default:
        }

        return dayNum;
    }

    // 2023.7.13(목) 15h45 실제 달력 출력
    public void printRealCalendarDraft(int year, int month) {
        // 2023.1.1(일) 기준 <- 2023.8.1(화)로부터 212일 전 요일 계산하면 일요일
        // 일~토요일 0~6으로 표시,
        int numOfDays = 0;
        int day = 0;
        if (year < 2023) {
            for (int i = 2022; i >= year + 1; i--) {
                if (!isLeapYear(i)) {
                    numOfDays += 365;
                } else {
                    numOfDays += 366;
                }
            }

            for (int i = 12; i >= month; i--) {
                numOfDays += getMaxDaysOfMonth(year, i);
            }

            day = numOfDays % 7;
        }

        System.out.println("numOfDays = " + numOfDays);
        printCalendarWithIntDay(year, month, day);
    }

    public void printRealCalendar(int year, int month) {
        int firstDayOfYear = calculateFirstDayOfYear(year);
        System.out.println("year = " + year + ", firstDayOfYear = " + firstDayOfYear); // todo

        int numOfDays = 0;

        for (int i = 1; i < month; i++) {
            numOfDays += getMaxDaysOfMonth(year, i);
        }
//        System.out.println("numOfDays = " + numOfDays); // todo

        int delim = firstDayOfYear + numOfDays % 7;
        int firstDayOfMonth = delim >= 7 ? delim - 7 : delim;

        printCalendarWithIntDay(year, month, firstDayOfMonth);
    }

    /**
     * @param year
     * @return 0 ~ 6(일요일 0 ~ 토요일 6)
     */
    public int calculateFirstDayOfYear(int year) {
        int count = 0;
        int startYear = year;
        int endYear = STANDARD_YEAR;

        // e.g. 2023.1.1(일) 기준
        if (year > STANDARD_YEAR) {
            startYear = STANDARD_YEAR;
            endYear = year;
        }

        for (int i = startYear; i < endYear; i++) {
            if (isLeapYear(i)) {
                count += 2;
            } else {
                count++;
            }
        }

        int delim = count % 7;
        if (year < STANDARD_YEAR) {
            return (STANDARD_DAY < delim) ? STANDARD_DAY + 7 - delim : STANDARD_DAY - delim;
        } else {
            return (STANDARD_DAY + delim < 7) ? STANDARD_DAY + delim : STANDARD_DAY + delim - 7;
        }
    }

    /**
     * @param year  달력을 출력하고자 하는 연도
     * @param month 달력을 출력하고자 하는 월
     * @param day   해당 월의 1번째 날의 요일, 0 ~ 6(일요일 ~ 토요일)
     */
    public void printCalendarWithIntDay(int year, int month, int day) {
        int maxDaysOfMonth = getMaxDaysOfMonth(year, month);
        System.out.println("firstDayOfMonth = " + day); // todo

        System.out.printf("  <<%4d년%3d월>>\n", year, month);

        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");

        for (int i = 0; i < day; i++) {
            System.out.print("   "); // 3칸 공백
        }

        for (int i = 1; i <= maxDaysOfMonth; i++) {
            System.out.printf("%3d", i);

            int delim = 7 - day < 7 ? 7 - day : 0;
            if (i % 7 == delim) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println();
    }
}
