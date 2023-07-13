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

        // 2023.7.13(목) 오늘 날짜와 요일을 입력받아, 이 정보를 가지고 기준 연도 + 그 해의 1/1 요일을 세팅하여 동작하는 프로그램으로 만들어봄
        System.out.println("오늘 날짜와 요일을 다음 형식으로 입력하세요 [YYYY-MM-DD 요일(SU, MO, TU, WE, TH, FR, SA 중 하나)]");
        System.out.print(PROMPT);
        String todayInput = scanner.nextLine();
        String dateInput = todayInput.split(" ")[0];
        String dayInput = todayInput.split(" ")[1];

        int todayYear = Integer.parseInt(dateInput.split("-")[0]);
        int todayMonth = Integer.parseInt(dateInput.split("-")[1]);
        int todayDate = Integer.parseInt(dateInput.split("-")[2]);

        cal.calculateFirstDayOfTodayYear(todayYear, todayMonth, todayDate, dayInput);

        while (true) {
            System.out.println("연도를 입력하세요 [exit = -1] ");
            System.out.print(PROMPT);
            year = scanner.nextInt();

            if (year == -1) {
                break;
            }

            System.out.println("달을 입력하세요 ");
            System.out.print(PROMPT);
            month = scanner.nextInt();

            if (month < 1 || month > 12) {
                System.out.println("정확한 숫자를 입력해 주세요");
                continue;
            }

//            if (month == -1) {
//                break;
//            } else if (month == 0 || month < -1 || month > 12) {
//                System.out.println("정확한 숫자를 입력해 주세요");
//                continue;
//            }

            // 2023.7.13(목) 15h40 연도 및 월만 입력받아, 진짜 달력과 똑같은 모양의 달력 출력 <- 날짜 계산 알고리즘 공부/이해 <- 그레고리력, 달력 알고리즘 등 참고
            /*
            scanner.nextLine();

            System.out.println("1일의/첫번째 요일을 입력하세요(SU, MO, TU, WE, TH, FR, SA) ");
            System.out.print("DAY > ");
            day = scanner.nextLine();
             */

            // 2023.7.12(수) 22h45 변경
//            cal.printCalendarWithStringDay(year, month, day);
            // 2023.7.13(목) 15h45 추가
            cal.printRealCalendar(year, month);
        } // while문

        System.out.println("Bye~");
    }

    public static void main(String[] args) {
        // 셸 실행
        Prompt prompt = new Prompt();
        prompt.runPrompt();
    } // main 함수
}
