package exercises.src.JavaJeongseok.exercises;

import java.util.Scanner;

// 2022.8.11(목) 1h30
public class Ex3_9 {
    public static void main(String[] args) {
//        char ch = 'z';

        Scanner sc = new Scanner(System.in);

        while (true) { // git commit/push 시 warning = 'while문을 마치려면 예외 처리가 필요하다' -> 예외 처리를 어떻게 해야 할까?
            System.out.print("영문자/숫자/한글 등 글자 1개를 입력해 보세요 > ");
            char ch = sc.nextLine().charAt(0);

//            boolean b = ch <= 'z' ? true : false; // 이쿠, ^와 같은 특수문자 처리할 생각을 못 했다..
            boolean b = 48 <= ch && ch <= 57 || 65 <= ch && ch <= 90 || 97 <= ch && ch <= 122; // 인터넷에서 ASCII table 검색해서 보면서 작성

            System.out.println(b);
        }

    }
}
