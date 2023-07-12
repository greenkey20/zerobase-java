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

        // 2023.7.12(수) 22h45 추가
        int year = 0;
        int month = 0;
        String day = "";

        while (true) {
            System.out.println("연도를 입력하세요 ");
            System.out.print(PROMPT);
            year = scanner.nextInt();

            if (year == -1) {
                break;
            }

            System.out.println("달을 입력하세요 ");
            System.out.print(PROMPT);
            month = scanner.nextInt();

//            if (month == -1) {
//                break;
//            } else if (month == 0 || month < -1 || month > 12) {
//                System.out.println("정확한 숫자를 입력해 주세요");
//                continue;
//            }

            scanner.nextLine();

            System.out.println("1일의/첫번째 요일을 입력하세요(SU, MO, TU, WE, TH, FR, SA) ");
            System.out.print("DAY > ");
            day = scanner.nextLine();

            // 2023.7.12(수) 22h45 변경
            cal.printCalendar(year, month, day);
        } // while문

        System.out.println("Bye~");
    }

    public static void main(String[] args) {
        // 셸 실행
        Prompt prompt = new Prompt();
        prompt.runPrompt();
    } // main 함수
}
