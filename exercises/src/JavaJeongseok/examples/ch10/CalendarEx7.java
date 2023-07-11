package exercises.src.JavaJeongseok.examples.ch10;

import java.util.Calendar;
import java.util.Scanner;

// 2023.7.10(월) 23h30
public class CalendarEx7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("달력을 출력할 연(year)과 월(month)를 입력하세요(띄어쓰기 1칸으로 구분) > ");
        String input = scanner.nextLine();

        int year = Integer.parseInt(input.split(" ")[0]);
        int month = Integer.parseInt(input.split(" ")[1]);

        Calendar startDay = Calendar.getInstance();
        Calendar endDay = Calendar.getInstance();

        startDay.set(year, month - 1, 1);
        endDay.set(year, month - 1, startDay.getActualMaximum(Calendar.DATE));

        startDay.add(Calendar.DATE, -startDay.get(Calendar.DAY_OF_WEEK) + 1); // 1일이 속한 주의 일요일로 날짜 설정 -> 코드 이해 잘 안 됨
        endDay.add(Calendar.DATE, -endDay.get(Calendar.DAY_OF_WEEK) + 7); // 말일이 속한 주의 토요일로 날짜 설정 -> 코드 이해 잘 안 됨

        System.out.println("    " + year + "년 " + month + "월");
        System.out.println(" SU MO TU WE TH FR SA");

        for (int n = 1; startDay.before(endDay) || startDay.equals(endDay); startDay.add(Calendar.DATE, 1)) {
            int day = startDay.get(Calendar.DATE);
            System.out.print(day < 10 ? "  " + day : " " + day);
            if (n++ % 7 == 0) System.out.println();
        }
    }
}
