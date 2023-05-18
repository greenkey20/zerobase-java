package exercises.src.JavaJeongseok.examples.ch5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 2023.5.18(목) 22h35 ~ 23h45 초안 작성 -> 0h5 ~ 1h10 기능 다듬기 + refactoring
/* 나의 고민
1. 더 객체 지향적인 프로그램?
2. 무엇을 어떻게 테스트하는 테스트 코드를 짤 수 있을까?
 */

/**
 * 컴퓨터와 내가 하는 숫자 빙고 게임
 */
public class MultiArrEx2 {
    private static final int SIZE = 5;
    private static int[][] board = new int[SIZE][SIZE];
    private static char[][] showBoard = new char[SIZE][SIZE];
    private static Set<Integer> numsCalled = new TreeSet<>();
    private static String userName;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int x = 0, y = 0, num = 0;

        System.out.print("성함을 입력해 주세요 > ");
        userName = scanner.nextLine();

        // 빙고판 만들기 = 일단 1 ~ SIZE^2 숫자를 순서대로 채워넣음
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = i * SIZE + j + 1;
            }
        }

        // 빙고판 숫자 섞기 = Java 정석 참고
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                x = (int) (Math.random() * SIZE); // 0~4 범위의 랜덤 정수 -> SIZE * SIZE 사이즈 2차원 배열 내 임의의 원소/위치 선택
                y = (int) (Math.random() * SIZE); // 0~4 범위의 랜덤 정수

                int temp = 0;
                temp = board[i][j];
                board[i][j] = board[x][y];
                board[x][y] = temp;
            }
        }

        // 참고용 출력 = 실제 게임 시에는 보여주지 않음
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                System.out.printf("%2d  ", board[i][j]);
//            }
//            System.out.println();
//        }

        // 랜덤 숫자로 0이 나오면 컴퓨터 vs 1이 나오면 사용자가 먼저 번호를 부름
        int firstPlayer = (int) (Math.random() * 2);

        if (firstPlayer == 0) {
            System.out.println("컴퓨터가 먼저 숫자 하나를 부릅니다");
        } else {
            System.out.println(userName + "님 먼저 숫자 하나를 부릅니다");
        }

        while (true) {
            int comNum, userNum;

            if (firstPlayer == 0) {
                // 컴퓨터가 숫자 1개 고름
                comNum = getComNum();

                // 선택된 숫자 위치에 X(컴퓨터) or O(사용자) 표시
                markNum(comNum, 'X');

                // 빙고 되었는지 확인
                checkBingo('X');

                firstPlayer = 1;
            } else {
                // 사용자가 숫자 1개 고름
                userNum = getUserNum();

                // 선택된 숫자 위치에 X(컴퓨터) or O(사용자) 표시
                markNum(userNum, 'O');

                // 빙고 되었는지 확인
                checkBingo('O');

                firstPlayer = 0;
            }

            // 게임이 종료되지 않았다면
            // 현재 board 상태 보여줌
            printShowBoard();

            // 비기는 상황은 아닌지 확인
            isTie();
        }
    }

    private static int getUserNum() {
        int userNum = 0;
        for (int i = 0; i < 1; i++) {
            System.out.printf("%s님, 1부터 %d 사이의 정수 하나를 입력해 주세요\n (0을 누르면 현재 board와 선택된 숫자들을 보여드립니다) > ", userName, SIZE * SIZE);
            userNum = Integer.parseInt(scanner.nextLine());

            if (userNum == 0) {
                printShowBoard();
                printNumsCalled();
                i--;
            } else if (userNum < 0 || SIZE * SIZE < userNum) {
                System.out.println("범위에 맞는 숫자를 다시 입력해 주세요");
                i--;
            } else {
                if (numsCalled.contains(userNum)) {
                    System.out.println("이미 선택된 숫자입니다.");
                    i--;
                } else {
                    numsCalled.add(userNum);
                }
            }
        }

        return userNum;
    }

    private static int getComNum() {
        int comNum = 0;

        for (int i = 0; i < 1; i++) {
            comNum = (int) (Math.random() * SIZE * SIZE) + 1;
            if (numsCalled.contains(comNum)) {
                i--;
            } else {
                System.out.printf("컴퓨터가 부른 숫자는 %d입니다\n", comNum);
                numsCalled.add(comNum);
                break;
            }
        }

        return comNum;
    }

    private static void markNum(int num, char player) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == num) {
                    showBoard[i][j] = player;
                }
            }
        }
    }

    private static void checkBingo(char player) { // 컴퓨터 = X vs 사용자 = O
        StringBuilder bingo = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            bingo.append(player);
        }

        // 가로로 쭉 연결되었는지 확인
        for (int i = 0; i < SIZE; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < SIZE; j++) {
                sb.append(showBoard[i][j]);
            }

            isBingo(sb.toString(), bingo.toString(), player);
        }

        // 세로로 쭉 연결되었는지 확인
        for (int i = 0; i < SIZE; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < SIZE; j++) {
                sb.append(showBoard[j][i]);
            }

            isBingo(sb.toString(), bingo.toString(), player);
        }

        // 왼쪽 상단에서 시작하는 대각선으로 연결되었는지 확인
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append(showBoard[i][i]);
        }

        isBingo(sb.toString(), bingo.toString(), player);

        // 오른쪽 상단에서 시작하는 대각선으로 연결되었는지 확인
        sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append(showBoard[i][SIZE - 1 - i]);
        }

        isBingo(sb.toString(), bingo.toString(), player);
    }

    private static void printWinner(char player) {
        if (player == 'X') {
            System.out.println("컴퓨터가 이겼습니다!");
            System.exit(0);
        } else {
            System.out.printf("%s 님이 이겼습니다!\n", userName);
            System.exit(0);
        }
    }

    private static void isBingo(String sb, String bingo, char player) {
        if (sb.equals(bingo)) {
            printShowBoard();
            printWinner(player);
        }
    }

    private static void printShowBoard() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println(showBoard[i]);
        }
    }

    private static void printNumsCalled() {
        System.out.println(numsCalled);
    }

    private static void isTie() {
        if (numsCalled.size() == SIZE * SIZE) {
            System.out.println("비겼습니다. 수고하셨습니다!");
            System.exit(0);
        }
    }
}
