package exercises.src.codesquad.calendar;

import java.text.ParseException;
import java.util.Scanner;

// 2023.7.12(수) 22h20 -> 23h 요일 입력받기 조건/기능 추가
public class PromptReference {
    // 2023.7.14(금) 17h30 일정표 기능 추가
    public void printMenu() {
        System.out.println("+----------------------+");
        System.out.println("| 1. 일정 등록");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말 q. 종료");
        System.out.println("+----------------------+");
    }

    /**
     * @param weekdayInput 요일명
     * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
     */
    public int parseDay(String weekdayInput) {
        /*
        if (weekdayInput.equals("su")) return 0;
        else if (weekdayInput.equals("mo")) return 1;
        else if (weekdayInput.equals("tu")) return 2;
        else if (weekdayInput.equals("we")) return 3;
        else if (weekdayInput.equals("th")) return 4;
        else if (weekdayInput.equals("fr")) return 5;
        else if (weekdayInput.equals("sa")) return 6;
        else return 0; // 혹시 이상한 입력 들어오면 일요일로 간주하기로 함
         */

        // 2023.7.14(금) 21h String에 대한 switch문으로 refactoring
        switch (weekdayInput) {
            case "su":
                return 0; // return이 함수 탈출하는 것인 바, break 필요 없음
            case "mo":
                return 1;
            case "tu":
                return 2;
            case "we":
                return 3;
            case "th":
                return 4;
            case "fr":
                return 5;
            case "sa":
                return 6;
            default:
                return 0;
        }
    }

    public void runPrompt() throws ParseException {
        printMenu();

        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        boolean isLoop = true;

        while (true) {
            // 2023.7.14(금) 17h30 일정표 기능 추가
            System.out.print("명령 (1, 2, 3, h, q) > ");
            String command = scanner.next();
            /*
            if (command.equals("1")) commandRegister(scanner, cal);
            else if (command.equals("2")) commandSearch(scanner, cal);
            else if (command.equals("3")) commandCalendar(scanner, cal);
            else if (command.equals("h")) printMenu();
            else if (command.equals("q")) break;
             */

            // 2023.7.14(금) 21h10 String에 대한 switch문으로 refactoring
            switch (command) {
                case "1":
                    commandRegister(scanner, cal);
                    break;
                case "2":
                    commandSearch(scanner, cal);
                    break;
                case "3":
                    commandCalendar(scanner, cal);
                    break;
                case "h":
                    printMenu();
                    break;
                case "q":
                    isLoop = false;
                    break; // 이 break는 switch문(o) 이를 감싸고 있는 while문(x)을 빠져나가는 것
                default:
                    break;
            }

            if (!isLoop) {
                break;
            }
        } // while문

        System.out.println("Thank you. Bye~");
        scanner.close();
    }

    // 2023.7.14(금) 17h40
    private void commandCalendar(Scanner scanner, Calendar cal) { // 밖에서 누가 만들어놓은 Scanner, Calendar 참조 넘겨받아 사용(call by reference, 여기서는 이게 성능상 조금 더 좋음) vs 이 기능/함수 사용/호출할 때마다 Scanner, Calendar 객체 생성 + close() 하는 건 컴퓨터 내부적으로 비용 발생
        int year = 2023;
        int month = 7;
//        int weekday = 0;

        // 2023.7.12(수) 22h35 추가
        System.out.println("연도를 입력하세요");
        System.out.print("YEAR > ");
        year = scanner.nextInt();

//        if (year == -1) {
//            break; // 무한 loop를 빠져나가는 코드
//        }

//            scanner.hasNextLine(); // 안 써도 되는 것 같네

        System.out.println("달을 입력하세요 ");
        System.out.print("MONTH > ");
        month = scanner.nextInt();

        // month 입력에 대한 유효성 검사
        if (month < 1 || month > 12) {
            System.out.println("잘못된 입력입니다");
            return; // 함수/메서드 종료
//            continue;
        }

        // 2023.7.13(목) 22h30 reference 강의
//            System.out.println("첫째 날의 요일을 입력하세요(su, mo, tu, we, th, fr, sa) ");
//            System.out.print("DAY > ");
//            String weekdayInput = scanner.next();
//            weekday = parseDay(weekdayInput);

        cal.printCalendarReference(year, month);
    }

    private void commandSearch(Scanner scanner, Calendar calendar) {
        System.out.println("[일정 검색]");

        System.out.print("날짜를 입력해 주세요 (yyyy-MM-dd) > ");
        String date = scanner.next();

        String plan = "";
        try {
            plan = calendar.searchPlan(date);
        } catch (ParseException e) {
            System.err.println("일정 검색 중 오류가 발생했습니다");
            throw new RuntimeException(e);
        }
        System.out.println("plan = " + plan);
    }

    private void commandRegister(Scanner scanner, Calendar calendar) throws ParseException {
        System.out.println("[새 일정 등록]");

        System.out.print("날짜를 입력해 주세요 (yyyy-MM-dd) > ");
        String date = scanner.next();

        String text = "";
        scanner.nextLine(); // ignore one new line
        System.out.print("일정을 입력해 주세요 > ");
        text = scanner.nextLine(); // 1줄을 통째로 읽어옴

        calendar.registerPlan(date, text);
    }

    public static void main(String[] args) throws ParseException {
        // 셸 실행
        PromptReference prompt = new PromptReference();
        prompt.runPrompt();
    } // main 함수
}
