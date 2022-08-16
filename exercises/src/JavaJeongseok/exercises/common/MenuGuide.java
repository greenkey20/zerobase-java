package exercises.src.JavaJeongseok.exercises.common;

// 2022.8.16(화) 6h40
public class MenuGuide {
    public static void displayMenuGuide() {
        System.out.println("== 프로그램을 종료하려면 '종료'을 입력하세요 ==");
        System.out.print("문자열이나 숫자를 입력해 주세요 > ");
    }

    public static boolean selectMenuGuide(String inputValue) {
        boolean isEnd = false;

        if (inputValue.equals("종료")) {
            System.out.println("== 프로그램을 종료합니다 ==");

//            break; // Break outside switch or loop
            isEnd = true;
        }

        return isEnd;
    }
}
