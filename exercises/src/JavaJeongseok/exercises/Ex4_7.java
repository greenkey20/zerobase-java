package exercises.src.JavaJeongseok.exercises;

import java.util.Scanner;

// 2022.8.12(금) 0h25
public class Ex4_7 {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("== 프로그램을 종료하려면 0을 입력하세요 ==");
            System.out.print("1~6 사이의 임의의 정수를 보시려면 0을 제외한 아무 키나 하나 눌러주셔요 > ");
            String input = sc.nextLine();

            if (!input.equals("0")) {
                int value = (int)(Math.random() * 6) + 1;
                System.out.println("value = " + value);
            } else {
                System.out.println("== 프로그램을 종료합니다 ==");
                return;
            }
        }
    }
}
