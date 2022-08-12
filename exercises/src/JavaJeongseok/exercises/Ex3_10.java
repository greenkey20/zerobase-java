package exercises.src.JavaJeongseok.exercises;

import java.util.Scanner;

// 2022.8.11(목) 2h
public class Ex3_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("== 프로그램을 종료하려면 0을 입력하세요 ==");
            System.out.print("알파벳 1개를 입력해 주세요 > ");
            char ch = sc.nextLine().charAt(0);

            if (ch != '0') {
//                char lowerCase = ('A' <= ch && ch <= 'Z') && !(0 <= ch && ch <= 64) && !(91 <= ch && ch <= 96) && !(123 <= ch && ch <= 127) ? ch += 32 : ch;
//                char lowerCase = 'A' <= ch && ch <= 'Z' ? ch += 32 : ch; // 내가 의도한대로 나오지 않음
                // 나의 답안
//                char lowerCase = (char)('A' <= ch && ch <= 'Z' ? ch + 32 : ch);
                // 저자 답안
                char lowerCase = 'A' <= ch && ch <= 'Z' ? (char)(ch + 32) : ch;

                System.out.println("ch = " + ch);
                System.out.println("ch to lowerCase = " + lowerCase);

            } else {
                System.out.println("== 프로그램을 종료합니다 ==");
                return;
            }
        }

    }
}
