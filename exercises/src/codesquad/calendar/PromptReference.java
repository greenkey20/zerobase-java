package exercises.src.codesquad.calendar;

import java.util.Scanner;

// 2023.7.12(수) 22h20
public class PromptReference {
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

            cal.printCalendarReference(2023, month);
        } // while문

        System.out.println("Bye~");
    }

    public static void main(String[] args) {
        // 셸 실행
        PromptReference prompt = new PromptReference();
        prompt.runPrompt();
    } // main 함수
}
