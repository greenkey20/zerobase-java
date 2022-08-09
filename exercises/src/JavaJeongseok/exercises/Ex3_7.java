package exercises.src.JavaJeongseok.exercises;

import java.util.Scanner;

// 2022.8.9(화) 1h25
public class Ex3_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("== 프로그램을 종료하려면 0을 입력하세요 ==");
            System.out.print("정수를 1개 입력해 주세요 > ");
            int fahrenheit = sc.nextInt();

            if (fahrenheit != 0) {
                float celcius = (int)(5f / 9 * (fahrenheit - 32) * 100 + 0.5) / 100f; // 소수점 셋째자리에서 반올림 <- 책 pp.106-107 로직 참고
                System.out.println("화씨 온도 = " + fahrenheit);
                System.out.println("섭씨 온도 = " + celcius);
            } else {
                System.out.println("== 프로그램을 종료합니다 ==");
                return;
            }
        } // while() 영역 끝
    } // main() 종료
}
