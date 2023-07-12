package exercises.src.codesquad.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

// 2023.7.12(수) 21h5
public class Calendar_maxDays4 {
    /**
     * 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
     *
     * @param args
     */
    public static void main(String[] args) {
        String PROMPT = "cal> ";
        Scanner scanner = new Scanner(System.in);
        Calendar_maxDays3 cal = new Calendar_maxDays3();

        int month = 0;

        while (true) {
            System.out.println("달을 입력하세요");
            System.out.print(PROMPT);
            month = scanner.nextInt();
            if (month == -1) {
                break;
            }

            if (month > 12) {
                continue; // loop의 처음으로 돌아가는 명령
            }

            System.out.printf("%d월은 %d일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
        }

        System.out.println("Bye~");
    }

}
