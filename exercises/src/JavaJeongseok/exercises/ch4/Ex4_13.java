package exercises.src.JavaJeongseok.exercises.ch4;

import java.util.Scanner;

// 2022.8.15(월) 2h55
public class Ex4_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("== 프로그램을 종료하려면 '종료'을 입력하세요 ==");
            System.out.print("문자열이나 숫자를 입력해 주세요 > ");
            String value = sc.nextLine();
            char ch = ' ';
            boolean isNumber = true;

            if (!value.equals("종료")) {
                for (int i = 0; i < value.length(); i++) {
                    ch = value.charAt(i);

                    if (ch < '0' || ch > '9') {
                        isNumber = false;
                    }
                }

                if (isNumber) {
                    System.out.println(value + "는 숫자입니다");
                } else {
                    System.out.println(value + "는 숫자가 아닙니다");
                }
            } else {
                System.out.println("== 프로그램을 종료합니다 ==");
                return;
            }
        } // while문 영역 끝

    }
}
