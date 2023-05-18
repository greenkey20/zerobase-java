package exercises.src.JavaJeongseok.examples.ch5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 2023.5.18(목) 22h35

/**
 * 컴퓨터와 내가 하는 숫자 빙고 게임
 */
public class MultiArrEx2 {
    public static void main(String[] args) {
        final int SIZE = 5;
        int x = 0, y = 0, num = 0;

        int[][] board = new int[SIZE][SIZE];
        char[][] showBoard = new char[SIZE][SIZE];

        Scanner scanner = new Scanner(System.in);

        System.out.print("성함을 입력해 주세요 > ");
        String userName = scanner.nextLine();

        // 빙고판 만들기 = 일단 1 ~ SIZE^2 숫자를 순서대로 채워넣음
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = i * SIZE + j + 1;
            }
        }

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

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%2d  ", board[i][j]);
            }
            System.out.println();
        }

        // 랜덤 숫자로 0이 나오면 컴퓨터 vs 1이 나오면 사용자가 먼저 번호를 부름
        int firstPlayer = (int) (Math.random() * 2);

        if (firstPlayer == 0) {
            System.out.println("컴퓨터가 먼저 숫자 하나를 부릅니다");
        } else {
            System.out.println(userName + "님 먼저 숫자 하나를 부릅니다");
        }

        while (true) {
            int comNum = 0;
            int userNum = 0;
            Set<Integer> numsCalled = new HashSet<>();

            if (firstPlayer == 0) {
                // 컴퓨터가 숫자 1개 고름
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

                // 선택된 숫자 위치에 X(컴퓨터) or O(사용자) 표시
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (board[i][j] == comNum) {
                            showBoard[i][j] = 'X';
                        }
                    }
                }

                // 빙고 되었는지 확인
                for (int i = 0; i < SIZE; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < SIZE; j++) {
                        sb.append(showBoard[i][j]);
                    }

                    if (sb.equals("XXXXX")) {
                        System.out.println("컴퓨터가 이겼습니다!");
                        return;
                    } else if (sb.equals("OOOOO")) {
                        System.out.printf("%s 님이 이겼습니다!\n", userName);
                        return;
                    }
                }

                for (int i = 0; i < SIZE; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < SIZE; j++) {
                        sb.append(showBoard[j][i]);
                    }

                    if (sb.equals("XXXXX")) {
                        System.out.println("컴퓨터가 이겼습니다!");
                    } else if (sb.equals("OOOOO")) {
                        System.out.printf("%s 님이 이겼습니다!\n", userName);
                        return;
                    }
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SIZE; i++) {
                    sb.append(showBoard[i][i]);
                }

                if (sb.equals("XXXXX")) {
                    System.out.println("컴퓨터가 이겼습니다!");
                } else if (sb.equals("OOOOO")) {
                    System.out.printf("%s 님이 이겼습니다!\n", userName);
                    return;
                }

                sb = new StringBuilder();
                for (int i = 0; i < SIZE; i++) {
                    sb.append(showBoard[i][SIZE - 1 - i]);
                }

                if (sb.equals("XXXXX")) {
                    System.out.println("컴퓨터가 이겼습니다!");
                } else if (sb.equals("OOOOO")) {
                    System.out.printf("%s 님이 이겼습니다!\n", userName);
                    return;
                }

                // 게임이 종료되지 않았다면 현재 board 상태 보여줌
                for (int i = 0; i < SIZE; i++) {
                    System.out.println(showBoard[i]);
                }

                // 사용자가 숫자 1개 고름
                for (int i = 0; i < 1; i++) {
                    System.out.printf("%s님, 1부터 %d 사이의 정수 하나를 입력해 주세요 > ", userName, SIZE * SIZE);
                    userNum = Integer.parseInt(scanner.nextLine());

                    if (numsCalled.contains(userNum)) {
                        System.out.println("이미 선택된 숫자입니다.");
                        i--;
                    } else {
                        numsCalled.add(userNum);
                    }
                }

                // 선택된 숫자 위치에 X(컴퓨터) or O(사용자) 표시
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (board[i][j] == comNum) {
                            showBoard[i][j] = 'O';
                        }
                    }
                }

                // 빙고 되었는지 확인

                // 게임이 종료되지 않았다면 현재 board 상태 보여줌
                for (int i = 0; i < SIZE; i++) {
                    System.out.println(showBoard[i]);
                }

            } else {
                for (int i = 0; i < 1; i++) {
                    System.out.printf("%s님, 1부터 %d 사이의 정수 하나를 입력해 주세요 > ", userName, SIZE * SIZE);
                    userNum = Integer.parseInt(scanner.nextLine());

                    if (numsCalled.contains(userNum)) {
                        System.out.println("이미 선택된 숫자입니다.");
                        i--;
                    }
                }

                for (int i = 0; i < 1; i++) {
                    comNum = (int) (Math.random() * SIZE * SIZE) + 1;
                    if (numsCalled.contains(comNum)) {
                        i--;
                    } else {
                        System.out.printf("컴퓨터가 부른 숫자는 %d입니다\n", comNum);
                        break;
                    }
                }
            }

        }
    }
}
