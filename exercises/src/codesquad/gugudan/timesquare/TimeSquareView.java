package exercises.src.codesquad.gugudan.timesquare;

import java.util.Scanner;

// 2023.7.12(수) 17h25
public class TimeSquareView {
    private TimeSquare timeSquare = new TimeSquare();

    public void view() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("구구단 중 출력할 단은? (종료하시려면 0 입력해 주세요) > ");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                try {
                    int number = Integer.parseInt(input);

                    if (number < 0) {
                        System.out.print("잘못된 형식을 입력하셨습니다. 자연수를 하나 입력해 주세요. ");
                    }

                    timeSquare.square(number);
                } catch (Exception e) {
                    System.out.print("잘못된 형식을 입력하셨습니다. 자연수를 하나 입력해 주세요. ");
                }
            } // else절
        } // while문
    }

}
