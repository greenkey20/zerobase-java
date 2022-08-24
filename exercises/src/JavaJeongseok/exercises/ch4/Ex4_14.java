package exercises.src.JavaJeongseok.exercises.ch4;

import java.util.Scanner;

import static exercises.src.JavaJeongseok.exercises.common.MenuGuide.*;

// 2022.8.21(일) 23h50
public class Ex4_14 {

    public static void main(String[] args) {
        int answer = (int)(Math.random() * 100) + 1; // 1~100 사이의 임의의 값을 얻어서 answer에 저장
        System.out.println(answer);

        Scanner scanner = new Scanner(System.in);
        int input = 0; // 사용자가 입력하는 정수를 젖아할 공간

        int count = 0; // 사용자의 시도 회수를 세기 위한 변수

        do {
            count++;
            displayMenuGuide();

            input = scanner.nextInt();

            if (input == 0) {
                System.out.println("프로그램을 종료합니다 >.<");
                break;
            } else if (input < answer) {
                System.out.println("더 큰 수를 입력하세요");
                count++;
            } else if (input > answer) {
                System.out.println("더 작은 수를 입력하세요");
                count++;
            } else {
                System.out.println("맞췄습니다! 시도 회수는 " + count + "번입니다");
            }
        } while (input != 0);

    }

    public static void displayMenuGuide() {
        System.out.println("== 프로그램을 종료하려면 '0'을 입력하세요 ==");
        System.out.print("1~100 사이의 정수를 1개 입력해 주세요 > ");
    }
}
