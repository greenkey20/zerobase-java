package exercises.src.codesquad.calendar;

import java.util.Scanner;

// 2023.7.12(수) 21h50 수업

/**
 * 로직 들어있는 Calendar 클래스와 분리 -> 셸 관련 코드 분리
 */
public class Prompt {
    private final static String PROMPT = "cal > ";

    public void runPrompt() {
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

    public static void main(String[] args) {
        // 셸 실행
        Prompt prompt = new Prompt();
        prompt.runPrompt();
    } // main 함수
}
