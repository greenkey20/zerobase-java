package exercises.src.JavaJeongseok.examples.ch10;

import java.util.Calendar;
import java.util.Scanner;

// 2023.7.10(월) 1h
public class CalendarEx6 {
    public static void main(String[] args) {
//        if (args.length != 2) {
//            System.out.println("Usage : java CalendarEx6 2023 7");
//            return;
//        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("달력을 출력할 연(year)과 월(month)를 입력하세요(띄어쓰기 1칸으로 구분) > ");
        String input = scanner.nextLine();

//        int year = Integer.parseInt(args[0]);
        int year = Integer.parseInt(input.split(" ")[0]);
//        int month = Integer.parseInt(args[1]);
        int month = Integer.parseInt(input.split(" ")[1]);
        int START_DAY_OF_WEEK = 0;
        int END_DAY = 0;

        Calendar startDay = Calendar.getInstance();
        Calendar endDay = Calendar.getInstance();

        startDay.set(year, month - 1, 1);
        endDay.set(year, month, 1);

        endDay.add(Calendar.DATE, -1); // 다음 달의 1일에서 하루를 빼면 전 달의 마지막 날

        START_DAY_OF_WEEK = startDay.get(Calendar.DAY_OF_WEEK); // 요일 = 1(일요일) ~ 7(토요일)
        END_DAY = endDay.get(Calendar.DATE);

        System.out.println("    " + year + "년 " + month + "월");
        System.out.println(" SU MO TU WE TH FR SA");

        for (int i = 1; i < START_DAY_OF_WEEK; i++) {
            System.out.print("   ");
        }

        for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
            System.out.print(i < 10 ? "  " + i : " " + i);
            if (n % 7 == 0) System.out.println();
        }
    }
}
