package exercises.src.codesquad.calendar.maxdays;

import java.util.Scanner;

// 2021.8월초 inflearn 강의 + 2022.8.15(월) 18h25 IntelliJ package로 clone 후, code > reformat code
public class Calendar_maxDays3 {
    public static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    // 2023.7.12(수) 21h 복습
    /**
     * 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램 + 해당 동작을 사용자 입력 횟수만큼 반복
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        Calendar_maxDays3 cal = new Calendar_maxDays3();
        String PROMPT = " Cal> ";

        System.out.print("반복 횟수를 입력하세요");
        System.out.print(PROMPT);
        int repeat = scanner1.nextInt();

        // 반복 횟수를 모를 때는 while문 vs 알 때는 for문
        for (int i = 0; i < repeat; i++) {
//            Scanner scanner2 = new Scanner(System.in); // 2022.8.15(월) 18h 나의 질문 = scanner1 객체 사용하면 (왜)안 되나? -> 2023.7.12(수) 20h55 나의 생각 = 사용해도 된다?
            System.out.print("달을 입력하세요");
            System.out.print(PROMPT);
//            int month = scanner2.nextInt();
            int month = scanner1.nextInt(); // 2022.8.15(월) 18h30 scanner1 써도 프로그램 상 데이터 입력받고 그에 따라 코드 실행 결과에 차이 없는 것 같은데, 아니려나..?
            System.out.printf("%d월은 %d일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
        }

        System.out.println("Goodbye. Have a nice day!");

        scanner1.close();
    }
}
