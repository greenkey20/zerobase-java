package exercises.src.JavaJeongseok.exercises.ch3;

import java.util.Scanner;

// 2022.8.9(화) 1h20
public class Ex3_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("== 프로그램을 종료하려면 0을 입력하세요 ==");
            System.out.print("양의 정수를 1개 입력해 주세요 > ");
            int num = sc.nextInt();

            if (num != 0) {
                if (num % 10 != 0) {
                    System.out.println("코드1 = " + ((num / 10 + 1) * 10 - num));
                    System.out.println("코드2 = " + (10 - num % 10));
                } else {
                    System.out.println(10);
                }
            } else {
                System.out.println("== 프로그램을 종료합니다 ==");
                return;
            }
        } // while() 영역 끝
    } // main() 종료
}
