package exercises.src.JavaJeongseok.exercises.ch4;

import java.util.Scanner;

import static exercises.src.JavaJeongseok.exercises.common.MenuGuide.*;

// 2022.8.15(월) 2h55
public class Ex4_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2022.8.16(화) 6h30 zb 깜짝과제 해설 강의에서 배운 내용 적용해서 refactoring해봄
//        boolean flag = true;

        String inputValue = "";

        do {
            displayMenuGuide();

            inputValue = scanner.nextLine();

            /* 나의 생각 = '메뉴 선택' 메소드의 반환 값으로 'isEnd' 의미를 갖는 boolean 값을 받는 게 이해가 쉬운가/논리,합리적인가? + 사용자가 메뉴를 보고 (숫자 여부 판별하기 전) 바로 '종료' 입력했을 때 프로그램 실행하지 않고 바로 프로그램 종료할 수 있도록 아래와 같이 분기하는 것이 맞나? 내가 의도한대로 작동은 하는 것 같은데..
            나의 의도 = '메뉴 선택'은 프로그램 종료 여부만 확인하게 되어있음, 그런데 메소드명이 잘 와닿지 않는 것 같음..
             */
            if (!selectMenuGuide(inputValue)) {
                char ch = ' ';
                boolean isNumber = true;

                int countDot = 0;

                for (int i = 0; i < inputValue.length(); i++) { // 사용자가 입력한 문자열을 1글자 1글자씩 돌면서
                    ch = inputValue.charAt(i);

                    // 2022.8.24(수) 23h30 저자 해설에 따르면 출제 의도는 '정수' 여부 판단이었던 것 같지만, 나는 실수 포함 '숫자' 여부 판단으로 만들어봄
                    if (ch == '.') {
                        countDot++;
                    }

                    if (countDot > 1) { // 소수점(.)을 2개 이상 가진 문자열은 숫자가 아님
                        isNumber = false;
                    } else if (ch < '.' || ch == '/' || ch > '9') { // 소수점이 0 또는 1개인데, 숫자나 소수점이 아닌 문자/기호가 1개라도 들어있는 경우 숫자가 아님 -> 소수점 0 또는 1개이며, 문자 0~9로만 이루어진 경우만 숫자
                        isNumber = false;
                    }
                }

                if (isNumber) {
                    System.out.println(inputValue + "는 숫자입니다");
                } else {
                    System.out.println(inputValue + "는 숫자가 아닙니다");
                }

            }

            /*
            if (!value.equals("종료")) {

            } else {
                System.out.println("== 프로그램을 종료합니다 ==");
                flag = false;
                break;
            }
             */

        } while (!inputValue.equals("종료")); // do-while문 영역 끝

    }
}
