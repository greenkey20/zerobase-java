package exercises.src.codesquad.calendar;

import java.util.Scanner;

// 2023.7.12(수) 22h20
public class PromptReference {
    private final static String PROMPT = "cal > ";

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        int year = -1;
        int month = -1;

        while (true) {
            // 2023.7.12(수) 22h35 추가
            System.out.println("연도를 입력하세요 ");
            System.out.print("YEAR > ");
            year = scanner.nextInt();

//            scanner.hasNextLine(); // 안 써도 되는 것 같네

            System.out.println("달을 입력하세요 ");
            System.out.print("MONTH > ");
            month = scanner.nextInt();

            if (month == -1) {
                break;
            } else if (month == 0 || month < -1 || month > 12) {
                System.out.println("정확한 숫자를 입력해 주세요");
                continue;
            }

            cal.printCalendarReference(year, month);
        } // while문

        System.out.println("Bye~");
    }

    public static void main(String[] args) {
        // 셸 실행
        PromptReference prompt = new PromptReference();
        prompt.runPrompt();
    } // main 함수
}
