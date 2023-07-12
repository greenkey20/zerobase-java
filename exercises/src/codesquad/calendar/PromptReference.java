package exercises.src.codesquad.calendar;

import java.util.Scanner;

// 2023.7.12(수) 22h20 -> 23h 요일 입력받기 조건/기능 추가
public class PromptReference {
    /**
     *
     * @param weekdayInput 요일명
     * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
     */
    public int parseDay(String weekdayInput) {
        if (weekdayInput.equals("su")) return 0;
        else if (weekdayInput.equals("mo")) return 1;
        else if (weekdayInput.equals("tu")) return 2;
        else if (weekdayInput.equals("we")) return 3;
        else if (weekdayInput.equals("th")) return 4;
        else if (weekdayInput.equals("fr")) return 5;
        else if (weekdayInput.equals("sa")) return 6;
        else return 0; // 혹시 이상한 입력 들어오면 일요일로 간주하기로 함
    }

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        int year = 2023;
        int month = 7;
        int weekday = 0;

        while (true) {
            // 2023.7.12(수) 22h35 추가
            System.out.println("연도를 입력하세요 [exit = -1] ");
            System.out.print("YEAR > ");
            year = scanner.nextInt();

            if (year == -1) {
                break; // 무한 loop를 빠져나가는 코드
            }

//            scanner.hasNextLine(); // 안 써도 되는 것 같네

            System.out.println("달을 입력하세요 ");
            System.out.print("MONTH > ");
            month = scanner.nextInt();

            // month 입력에 대한 유효성 검사
            if (month < 1 || month > 12) {
                System.out.println("잘못된 입력입니다");
                continue;
            }

            System.out.println("첫째 날의 요일을 입력하세요(su, mo, tu, we, th, fr, sa) ");
            System.out.print("DAY > ");
            String weekdayInput = scanner.next();
            weekday = parseDay(weekdayInput);

            cal.printCalendarReference(year, month, weekday);
        } // while문

        System.out.println("Bye~");
    }

    public static void main(String[] args) {
        // 셸 실행
        PromptReference prompt = new PromptReference();
        prompt.runPrompt();
    } // main 함수
}
