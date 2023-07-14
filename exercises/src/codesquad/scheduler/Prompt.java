package exercises.src.codesquad.scheduler;

import exercises.src.codesquad.calendar.Calendar;

import java.util.List;
import java.util.Scanner;

// 2023.7.14(금) 0h00
public class Prompt {
    private final static String PROMPT = "scheduler > ";

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        prompt.runPrompt();
    }

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Scheduler scheduler = new Scheduler();
        Calendar calendar = new Calendar();

        String inputDate = "";

        showMenu();

        while (true) {
            /*
            +----------------------+
            | 1. 일정 등록
            | 2. 일정 검색
            | 3. 달력 보기
            | h. 도움말 q. 종료
            +----------------------+
            명령 (1, 2, 3, h, q)
             */
            showCommands();

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("[일정 등록] 날짜를 입력하세요.");
                    showCursor();
                    inputDate = scanner.nextLine();
                    System.out.println("일정을 입력하세요.");
                    showCursor();
                    String inputSchedule = scanner.nextLine();

//                    Map<String, String> inputMap = new HashMap<>();
//                    inputMap.put(inputDate, inputSchedule);
                    boolean isSuccess = scheduler.createSchedule(inputDate, inputSchedule);

                    if (isSuccess) {
                        System.out.println("🌱 일정이 등록되었습니다!");
                    } else {
                        System.out.println("🧐 일정 등록에 실패했습니다");
                    }

                    break;
                case "2":
                    System.out.println("[일정 검색] 날짜를 입력하세요.");
                    showCursor();
                    inputDate = scanner.nextLine();

                    List<String> searchResult = scheduler.searchSchedule(inputDate);
                    if (searchResult.isEmpty()) {
                        System.out.println("🧐 등록된 일정이 없습니다");
                    } else {
                        System.out.printf("✅ %d개의 일정이 있습니다\n", searchResult.size());
                        for (int i = 0; i < searchResult.size(); i++) {
                            System.out.printf("%d. %s\n", i + 1, searchResult.get(i));
                        }

                        // 2023.7.14(금) 12h55
                        System.out.println("[일정 변경/삭제]하시겠습니까?");
                        System.out.println("| a. 변경");
                        System.out.println("| b. 삭제");
                        System.out.println("| 0. 돌아가기");
                        showCursor();
                        String inputChoice = scanner.nextLine();
                        int inputNum = 0;

                        switch (inputChoice) {
                            case "a":
                                System.out.println("변경할 일정 번호를 입력하세요");
                                showCursor();
                                inputNum = scanner.nextInt();

                                scanner.nextLine();

                                System.out.println("변경할 일정 내용을 입력하세요");
                                showCursor();
                                String updatedSchedule = scanner.nextLine();

                                isSuccess = scheduler.updateSchedule(inputDate, inputNum, updatedSchedule);

                                if (isSuccess) {
                                    System.out.println("🌱 일정이 변경되었습니다!");
                                } else {
                                    System.out.println("🧐 일정 변경에 실패했습니다");
                                }

                                break;
                            case "b":
                                System.out.println("삭제할 일정 번호를 입력하세요");
                                showCursor();
                                inputNum = scanner.nextInt();
                                scanner.nextLine();

                                isSuccess = scheduler.deleteSchedule(inputDate, inputNum);

                                if (isSuccess) {
                                    System.out.println("🌱 일정이 삭제되었습니다!");
                                } else {
                                    System.out.println("🧐 일정 삭제에 실패했습니다");
                                }

                                break;
                            case "0":
                                break;
                        }
                    }

                    break;
                case "3":
                    // 오늘 날짜를 인식해서 해당 월의 달력을 출력
                    int year = Integer.parseInt(inputDate.split("-")[0]);
                    int month = Integer.parseInt(inputDate.split("-")[1]);
                    calendar.printRealCalendar(year, month);
                    break;
                case "h":
                    showMenu();
                    break;
                case "q":
                    System.out.println("Thank you. Bye~");
                    scanner.close();
                    return;
            } // switch문
        } // while문
    } // runPrompt() 메서드 종료

    public void showMenu() {
        System.out.println("+----------------------+");
        System.out.println("| 1. 일정 등록");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말 q. 종료");
        System.out.println("+----------------------+");
    }

    public void showCommands() {
        System.out.println("명령 (1, 2, 3, h, q)");
        showCursor();
    }

    public void showCursor() {
        System.out.print(PROMPT);
    }
}
