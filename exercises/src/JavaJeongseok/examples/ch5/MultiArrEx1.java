package exercises.src.JavaJeongseok.examples.ch5;

// 2023.5.17(수) 17h30

import java.util.Arrays;
import java.util.Scanner;

/**
 * 사용자 입력 = 좌표에 X표 하기 -> shipBaord(바다+배 지도)1 상의 배의 위치 맞추는 게임
 */
public class MultiArrEx1 {
    public static void main(String[] args) {
        final int SIZE = 10;
        int x = 0, y = 0, findCount = 0, numOfShips = 0;

        // 사용자의 탐색 상황 지도
        char[][] board = new char[SIZE][SIZE];
        for (int i = 1; i < SIZE; i++) {
            board[i][0] = board[0][i] = (char) (i + '0');
        }

        // board 잘 만들어졌나 확인용 출력
        /*
        for (int i = 0; i < SIZE; i++) {
            System.out.println(board[i]);
        }
         */

        // 주어진 바다-배 지도
        byte[][] shipBoard1 = {
                //  1  2  3  4  5  6  7  8  9
                {0, 0, 0, 0, 0, 0, 1, 0, 0}, // 1
                {1, 1, 1, 1, 0, 0, 1, 0, 0}, // 2
                {0, 0, 0, 0, 0, 0, 1, 0, 0}, // 3
                {0, 0, 0, 0, 0, 0, 1, 0, 0}, // 4
                {0, 0, 0, 0, 0, 0, 0, 0, 0}, // 5
                {1, 1, 0, 1, 0, 0, 0, 0, 0}, // 6
                {0, 0, 0, 1, 0, 0, 0, 0, 0}, // 7
                {0, 0, 0, 1, 0, 0, 0, 0, 0}, // 8
                {0, 0, 0, 0, 0, 1, 1, 1, 0}, // 9
        };

        for (int i = 0; i < shipBoard1.length; i++) {
            for (int j = 0; j < shipBoard1.length; j++) {
                if (shipBoard1[i][j] == 1) {
                    numOfShips++;
                }

//                System.out.print(shipBoard1[i][j]);
            }
//            System.out.println();
        }

        System.out.printf("배의 총 개수 = %d척\n", numOfShips);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 게임 시작
            System.out.print("좌표를 입력하세요(게임 종료는 00) > ");
            String input = scanner.nextLine();

            // 사용자 입력 값 유효성 검사
            if (input.length() == 2) {
                x = input.charAt(0) - '0';
                y = input.charAt(1) - '0';

                if (x == 0 && y == 0) {
                    System.out.println("게임을 종료합니다");
                    break;
                } else if (x < 1 || SIZE <= x || y < 1 || SIZE <= y) {
                    System.out.println("잘못된 입력입니다. 좌표를 다시 입력해 주세요");
                    continue;
                }
            }

            if (input.length() != 2) {
                System.out.println("잘못된 입력입니다. 좌표를 다시 입력해 주세요");
                continue;
            }

            // 유효한 입력 값에 대한 게임 룰 처리
            if (shipBoard1[x - 1][y - 1] == 1) {
                board[x][y] = 'O';
                findCount++;
                System.out.printf("⛴️ 배를 찾았습니다! (현재 찾은 배: %d척)\n", findCount);
            } else {
                board[x][y] = 'X';
                System.out.println("꽝! 지금 위치는 바다입니다 🌊");
            }

            // 현재 board의 상태를 보여줌
            for (int i = 0; i < SIZE; i++) {
                System.out.println(board[i]);
            }
        }
    }
}
