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

    // 2023.7.13(목) 22h55 reference 강의에서 변경
    private static final int[] MAX_DAYS_REFERENCE = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS_REFERENCE = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 특정 연도의 1월 1일 요일 결정 기준일
    // e.g. 2023.1.1(월) <- 2023.1.1(일) <- 2022.1.1(토) <- 2021.1.1(금)..
    private static int STANDARD_YEAR = 0;
    private static int STANDARD_DAY = 0; // STANDARD_YEAR의 1/1의 요일, 0~6의 값 중 하나

    // 2023.7.13(목) 금일 날짜 및 요일 입력받아 기준 연도 및 해당 년 1/1 세팅하도록 프로그램 수정하며 추가
    public static void setStandardYear(int standardYear) {
        STANDARD_YEAR = standardYear;
    }

    public static void setStandardDay(int standardDay) {
        STANDARD_DAY = standardDay;
    }

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

    // 2023.7.13(목) 22h55 reference 강의
    public int getMaxDaysOfMonthReference(int year, int month) {
        if (isLeapYear(year)) { // 윤년인 경우, 윤년용 배열 사용
            return LEAP_MAX_DAYS_REFERENCE[month];
        } else { // 평년인 경우, 평년용 배열 사용
            return MAX_DAYS_REFERENCE[month];
        }
    }

    // 2023.7.12(수) 강의 22h15 reference -> 2023.7.13(목) 22h30 실제 달력 출력 reference 강의
    public void printCalendarReference(int year, int month) {
        System.out.printf("  <<%4d년%3d월>>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");

        // 2023.7.13(목) 22h25 reference 강의
        // get weekday automatically
        int weekday = getWeekdayReference(year, month, 1);

        // print blank space
        for (int i = 0; i < weekday; i++) {
            System.out.print("   "); // 하나의 요일당 3칸 띄워서 1일을 배치시켜야 함
        }

        int maxDay = getMaxDaysOfMonthReference(year, month);
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

    // 2023.7.13(목) 22h30 reference 강의
    public int getWeekdayReference(int year, int month, int day) {
        // 인터넷 검색을 통해 1970년 1월 1일이 목요일임을 찾음
        int sYear = 1970;
//        int sMonth = 1;
//        int sDay = 1;
        final int STANDARD_WEEKDAY = 3; // 1970/Jan/1st = Thursday

        int count = 0;

        for (int i = sYear; i < year; i++) {
            int delta = isLeapYear(i) ? 366 : 365;
            count += delta;
        }
//        System.out.println("count = " + count); // todo

        for (int i = 1; i < month; i++) {
            int delta = getMaxDaysOfMonthReference(year, i);
            count += delta;
        }

        count += day - 1; // 1월1일은 더할 필요 없는 바, 1 뺌

        int weekday = (count + STANDARD_WEEKDAY) % 7;
        return weekday;
    }

    // simple test code = 이렇게 main() 만들어서 찍어보는 거 좋은 방법은 아님
    public static void main(String[] args) {
        Calendar c = new Calendar();
        /*
        System.out.println(c.getWeekdayReference(1970, 5, 1));
        System.out.println(c.getWeekdayReference(1971, 5, 1));
        System.out.println(c.getWeekdayReference(1972, 5, 1));
        System.out.println(c.getWeekdayReference(1973, 5, 1));
         */

        /*
        System.out.println(c.getWeekdayReference(1970, 1, 1) == 3);
//        System.out.println(c.getWeekdayReference(1970, 2, 1) == 31);
//        System.out.println(c.getWeekdayReference(1970, 3, 1) == 31 + 28);
        System.out.println(c.getWeekdayReference(1971, 1, 1) == 4);
        System.out.println(c.getWeekdayReference(1972, 1, 1) == 5);
        System.out.println(c.getWeekdayReference(1973, 1, 1) == 0);
        System.out.println(c.getWeekdayReference(1974, 1, 1) == 1);
         */
    }

    public void printCalendarWithStringDay(int year, int month, String day) {
        // 월 최대 날짜 수에 따라 달력 그림/출력 <- 사용자가 입력한 월의 최대 날짜 수 구해옴
        int maxDaysOfMonth = getMaxDaysOfMonth(year, month);

        // 요일 문자열을 숫자로 바꿔옴
        int dayNum = changeStringDayToIntDayV1(day);

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

    /**
     * 일~월 -> 1~7
     *
     * @param day
     * @return 1 ~ 7
     */
    public int changeStringDayToIntDayV1(String day) {
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

    // 2023.7.13(목) 21h30

    /**
     * 일~월 -> 0~6
     *
     * @param day
     * @return
     */
    public int changeStringDayToIntDayV2(String day) {
        int dayNum = 0;

        switch (day) {
            case "SU":
                dayNum = 0;
                break;
            case "MO":
                dayNum = 1;
                break;
            case "TU":
                dayNum = 2;
                break;
            case "WE":
                dayNum = 3;
                break;
            case "TH":
                dayNum = 4;
                break;
            case "FR":
                dayNum = 5;
                break;
            case "SA":
                dayNum = 6;
                break;
            default:
        }

        return dayNum;
    }

    // 2023.7.13(목) 15h45 실제 달력 출력

    /**
     * 이 메서드 짤 때는 전체적인 로직 잘못 생각했음..
     *
     * @param year
     * @param month
     */
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

    /**
     * 셸이 호출하는 메서드로써, 출력하고자 하는 연도와 월의 정보를 받아옴
     * -> 출력하고자 하는 연도의 1월 1일의 요일,
     * 출력하고자 하는 연도의 월의 1일의 요일을 구하는 과정 포함
     *
     * @param year
     * @param month
     */
    public void printRealCalendar(int year, int month) {
        // 출력하고자 하는 연도 1월 1일의 요일을 구함
        int firstDayOfYear = calculateFirstDayOfYear(year);
//        System.out.println("year = " + year + ", firstDayOfYear = " + firstDayOfYear); // todo

        // 출력하고자 하는 연도의 특정 월(의 전월)까지의 날짜 수를 구함
        int numOfDays = 0;

        for (int i = 1; i < month; i++) {
            numOfDays += getMaxDaysOfMonth(year, i);
        }
//        System.out.println("numOfDays = " + numOfDays); // todo

        // 출력하고자 하는 연도 1월 1일로부터 경과한 날 수를 7로 나눈 나머지로 출력하고자 하는 달의 첫번째 날의 요일을 구함
        int delim = firstDayOfYear + numOfDays % 7;
        int firstDayOfMonth = delim >= 7 ? delim - 7 : delim; // 출력하고자 하는 달의 첫번째 날의 요일

        // 출력하고자 하는 연도, 달, 1일의 요일 정보를 인자로 전달하여 달력 출력
        printCalendarWithIntDay(year, month, firstDayOfMonth);
    }

    /**
     * 출력하고자 하는 연도 year의 1월 1일의 요일을 구해서 정수 값으로 반환하는 메서드
     *
     * @param year
     * @return 0 ~ 6(일요일 0 ~ 토요일 6)
     */
    public int calculateFirstDayOfYear(int year) {
        int count = 0;
        int startYear = year; // 출력하고자 하는 연도
        int endYear = STANDARD_YEAR; // 1/1의 요일을 별도로 입력한 기준 연도

        // 최초 구현 시 기준 = 2023.1.1(일) -> 2023.7.13(목) 20h50 어느 연도의 1월 1일 데이터를 입력해도 동작함

        // 출력하고자 하는 연도가 기준 연도보다 미래인 경우 -> for문용 start/endYear 알맞게 설정 필요
        if (year > STANDARD_YEAR) {
            startYear = STANDARD_YEAR;
            endYear = year;
        }

        // 평년을 지나며 1요일씩 밀림 vs 윤년을 지나며 2요일씩 밀림
        for (int i = startYear; i < endYear; i++) {
            if (isLeapYear(i)) {
                count += 2;
            } else {
                count++;
            }
        }

        int delim = count % 7;
        if (year < STANDARD_YEAR) { // 출력하고자 하는 연도가 기준 연도보다 과거인 경우 -> x%7만큼의 변화를 STANDARD_DAY에서 빼줘야 함
            return (STANDARD_DAY < delim) ? STANDARD_DAY + 7 - delim : STANDARD_DAY - delim;
        } else { // 출력하고자 하는 연도가 기준 연도보다 미래인 경우 -> x%7만큼의 변화를 STANDARD_DAY에 더해줘야 함
            return (STANDARD_DAY + delim < 7) ? STANDARD_DAY + delim : STANDARD_DAY + delim - 7;
        }
    }

    /**
     * @param year            달력을 출력하고자 하는 연도
     * @param month           달력을 출력하고자 하는 월
     * @param firstDayOfMonth 해당 월의 1번째 날의 요일, 0 ~ 6(일요일 ~ 토요일)
     */
    public void printCalendarWithIntDay(int year, int month, int firstDayOfMonth) {
//        System.out.println("firstDayOfMonth = " + firstDayOfMonth); // todo 매개변수로 받아온, 출력하고자 하는 연/월의 첫번째 날의 요일 값 확인
        int maxDaysOfMonth = getMaxDaysOfMonth(year, month); // 출력하고자 하는 연/월의 최대 일 수

        System.out.printf("  <<%4d년%3d월>>\n", year, month);

        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");

        for (int i = 0; i < firstDayOfMonth; i++) {
            System.out.print("   "); // 3칸 공백
        }

        for (int i = 1; i <= maxDaysOfMonth; i++) {
            System.out.printf("%3d", i);

            int delim = 7 - firstDayOfMonth < 7 ? 7 - firstDayOfMonth : 0;
            if (i % 7 == delim) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println();
    }

    // 2023.7.13(목) 21h25
    public void calculateFirstDayOfTodayYear(int todayYear, int todayMonth, int todayDate, String dayInput) {
//        System.out.println("today = " + todayYear + "년 " + todayMonth + "월 " + todayDate + "일 " + dayInput + "요일"); // todo 매개변수로 받아온, 오늘 날짜 및 요일 확인

        setStandardYear(todayYear);
        int intDay = changeStringDayToIntDayV2(dayInput);

        int numOfDays = todayDate - 1; // 경과 일자를 구하는 거라서 1 빼줘야 함

        for (int i = 1; i < todayMonth; i++) {
            numOfDays += getMaxDaysOfMonth(todayYear, i);
        }

//        System.out.println("numOfDays = " + numOfDays); // todo

        int delim = numOfDays % 7;
        int firstDayOfYear = intDay < delim ? intDay - delim + 7 : intDay - delim;

        setStandardDay(firstDayOfYear);
//        System.out.println("STANDARD_YEAR = " + STANDARD_YEAR + ", STANDARD_DAY = " + STANDARD_DAY); // todo
    }
}
