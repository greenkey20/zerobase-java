package exercises.src.JavaJeongseok.exercises;

import java.util.Scanner;

// 2022.8.12(금) 0h45
public class Ex4_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("== 프로그램을 종료하려면 0을 누르세요 ==");
            System.out.print("양의 정수를 입력해 주세요 > ");

            String input = sc.nextLine();
//            int inputNum = Integer.parseInt(input);

            if (!input.equals("0")) {
                int sum = 0;

                for (int i = 0; i < input.length(); i++) {
                    sum += Character.getNumericValue(input.charAt(i));

                    // 저자 해설: 문자 '3'을 숫자 3으로 바꾸는 방법 = 문자 '3'에서 문자 '0'을 뺌 <- 알파벳이나 숫자는 문자코드가 연속적으로 할당되었기 때문에 이런 방법 가능
//                    sum += input.charAt(i) - '0'; // char 자료형(int보다 작은 타입의 피연산자)끼리 이항 연산 시 int 자료형으로 자동 형 변환되고, 결과도 int 자료형임
                    // 만약 input.charAt(2)에 의해 '3'이라는 문자가 반환되었다면 '3' - '0' = 51 - 48로 연산되고, 결과는 정수 3
                }

                System.out.println("입력하신 정수의 각 자리의 합은 " + sum + "입니다");
            } else {
                System.out.print("== 프로그램을 종료합니다 ==");
                sc.close();
//                return;
                break; // 가장 가까운 반복문을 빠져나가게 하므로, while(true) 무한 반복문을 빠져나감
            }
        } // while문 영역 끝
    }
}
