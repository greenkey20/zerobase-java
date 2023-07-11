package exercises.src.JavaJeongseok.examples.ch10;

// 2023.7.10(월) 23h50 ~ 2023.7.11(화) 17h50
public class CalendarEx9 {
    public static void main(String[] args) {
        System.out.println("2023. 5. 31 = " + getDayOFWeek(2023, 5, 31));
        System.out.println("2021. 6. 1 = " + getDayOFWeek(2021, 6, 1));
        System.out.println("2023. 5. 1 - 2023. 4. 28 = " + dayDiff(2023, 5, 1, 2023, 4, 28));
        System.out.println("2024. 6. 29 = " + convertDateToDay(2024, 6, 29));
        System.out.println("735778 = " + convertDayToDate(735778));
    }

    /**
     * 요일을 1~7 정수로 반환, 1이 일요일
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static int getDayOFWeek(int year, int month, int day) {
        return convertDateToDay(year, month, day) % 7 + 1;
    }

    public static int convertDateToDay(int year, int month, int day) {
        int numOfLeapYears = 0;

        for (int i = 1; i < year; i++) {
            if (isLeapYear(i)) {
                numOfLeapYears++;
            }
        }

        int sumOfDaysToLastYear = (year - 1) * 365 + numOfLeapYears;

        int sumOfDaysThisYear = 0;

        for (int i = 0; i < month - 1; i++) {
            sumOfDaysThisYear += endOfMonth[i];
        }

        // 2월이 포함되어 있고, 윤년인 경우
        if (month > 2 && isLeapYear(year)) sumOfDaysThisYear++;

        sumOfDaysThisYear += day;

        return sumOfDaysToLastYear + sumOfDaysThisYear;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }

    public static int[] endOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int dayDiff(int y1, int m1, int d1, int y2, int m2, int d2) {
        return convertDateToDay(y1, m1, d1) - convertDateToDay(y2, m2, d2);
    }

    public static String convertDayToDate(int day) {
        int year = 1;
        int month = 0;

        while (true) {
            int aYear = isLeapYear(year) ? 366 : 365;
            if (day > aYear) {
                day -= aYear;
                year++;
            } else {
                break;
            }
        }

        while (true) {
            int endDay = endOfMonth[month];

            // 윤년이고, 2월/윤달이 포함되어 있으면, 1일 더함
            if (isLeapYear(year) && month == 1) endDay++;

            if (day > endDay) {
                day -= endDay;
                month++;
            } else {
                break;
            }
        }

        return year + "-" + (month + 1) + "-" + day;
    }
}
