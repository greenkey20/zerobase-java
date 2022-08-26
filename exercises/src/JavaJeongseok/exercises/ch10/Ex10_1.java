package exercises.src.JavaJeongseok.exercises.ch10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// 2022.8.26(금) 0h10
public class Ex10_1 {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2010, 0, 1); // cal의 날짜를 2010년 1월 1일로 설정

        Date day = cal.getTime(); // Calendar를 Date로 변환

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd는 ");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("F번째 E요일입니다");
        SimpleDateFormat sdf2 = new SimpleDateFormat("F번째 E요일입니다", Locale.KOREAN); // 요일 한글-영어 변환(참고: https://javafactory.tistory.com/304)

        // version1
        /*
        int end = 0;
        if (isLeapYear(cal.get(Calendar.YEAR))) {
            end = 366;
        } else {
            end = 365;
        }

        for (int i = 0; i < end; i++) {
            cal.add(Calendar.DATE, 1);
            day = cal.getTime();
            System.out.println(sdf1.format(day));

            if (sdf2.format(day).equals("2번째 일요일입니다")) {
                System.out.print(sdf1);
                System.out.println(sdf2);
            }
        }
         */

        // 2022.8.26(금) 0h50 version2
        /*
        do {
            day = cal.getTime();
            System.out.println(sdf1.format(day));

            if (sdf2.format(day).equals("2번째 일요일입니다")) {
                System.out.print(sdf1);
                System.out.println(sdf2);
            }

            cal.add(Calendar.DATE, 1);
        } while (cal.get(Calendar.YEAR) == 2010);
         */

        // 2022.8.26(금) 1h version3
        while (cal.get(Calendar.YEAR) == 2010) {
            day = cal.getTime();
//            System.out.println(sdf1.format(day));
//            System.out.println(sdf2.format(day));

            if (sdf2.format(day).equals("2번째 일요일입니다")) { // Locale.KOREAN 설정 전에는 'Sun요일'이라고 만듦
                System.out.print(sdf1.format(day));
                System.out.println(sdf2.format(day));
            }

            cal.add(Calendar.DATE, 1);
        }
    }
}
