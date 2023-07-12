package exercises.src.codesquad.gugudan;

import java.util.Scanner;

// 2023.7.11(화) 21h25
// 단순 반복 있는 부분은 빨리 더 효율적인 방법을 찾아서 실행해야 한다! e.g. IDE 단축키, 구글링..
// 프로그래머는 끊임없이 문제를 발견 + 해결(검색해서 스스로)한다! -> 능력 및 자신감 향상
public class GugudanBasic {
    public static void main(String[] args) {
        // 2단
//        System.out.println("-- 2단 --");
//        System.out.println(2 * 1);
//        System.out.println(2 * 2);
//        System.out.println(2 * 3);
//        System.out.println(2 * 4);
//        System.out.println(2 * 5);
//        System.out.println(2 * 6);
//        System.out.println(2 * 7);
//        System.out.println(2 * 8);
//        System.out.println(2 * 9);

        // 3단
//        System.out.println("-- 3단 --");
//        System.out.println(3 * 1);
//        System.out.println(3 * 2);
//        System.out.println(3 * 3);
//        System.out.println(3 * 4);
//        System.out.println(3 * 5);
//        System.out.println(3 * 6);
//        System.out.println(3 * 7);
//        System.out.println(3 * 8);
//        System.out.println(3 * 9);

        // 2023.7.12(수) 15h30
        // 변수 + 자료형(type)
        // 4단
//        System.out.println("-- 4단 --");
//        int result = 4 * 1;
//        System.out.println(result);
//        result = 4 * 2;
//        System.out.println(result);
//        result = 4 * 3;
//        System.out.println(result);
//        result = 4 * 4;
//        System.out.println(result);
//        result = 4 * 5;
//        System.out.println(result);
//        result = 4 * 6;
//        System.out.println(result);
//        result = 4 * 7;
//        System.out.println(result);
//        result = 4 * 8;
//        System.out.println(result);
//        result = 4 * 9;
//        System.out.println(result);

        // 사용자 입력받기
        // 5단
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("구구단 중 출력할 단은? > ");
//        int number = scanner.nextInt();
//        int result2 = number * 1;
//        System.out.println(result2);
//        System.out.println(number * 2);
//        System.out.println(number * 3);
//        System.out.println(number * 4);
//        System.out.println(number * 5);
//        System.out.println(number * 6);
//        System.out.println(number * 7);
//        System.out.println(number * 8);
//        System.out.println(number * 9);

        // 반복문
        // 컴퓨터는 단순 반복 작업을 잘 한다 + 반복/중복되는 부분/코드를 반복문으로 줄일 수 있다
        // 6단
//        System.out.println("-- 6단 --");
//        int i = 1;
//        while (i < 10) {
//            System.out.println(6 * i);
//            i = i + 1; // i++
//        }

        // 7단
//        System.out.println("-- 7단 --");
//        for (int j = 1; j < 1000; j++) {
//            System.out.println(7 * j);
//        }

        // 8/9단
        // 조건문 = 특정 경우에 따라 어떤 작업, 아니면 다른 작업 등 분기 처리
        Scanner scanner = new Scanner(System.in);
        System.out.print("구구단 중 출력할 단은? > ");
        int number = scanner.nextInt();
//        System.out.println("사용자가 입력한 값 = " + number);

        if (number < 2) {
            System.out.println("값을 잘못 입력했습니다.");
        } else if (number > 9) {
            System.out.println("값을 잘못 입력했습니다.");
        } else {
            System.out.println("-- " + number + "단 --");
            for (int i = 1; i < 10; i++) {
                System.out.println(number * i);
            }
        }
    }
}
