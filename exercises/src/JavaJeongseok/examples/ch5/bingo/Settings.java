package exercises.src.JavaJeongseok.examples.ch5.bingo;

import java.util.Scanner;

// 2023.5.19(금) 1h15
public class Settings {
    // 멤버 변수
    public int size;
    private int[][] board;
    private String userName;
    private int firstPlayer;

    // 생성자
    // 이 객체 생성 시 board 멤버변수를 아래와 같이 초기화해야 함
    public Settings(int size) {
        this.size = size;
        setBoard();
        setUserName();
        setFirstPlayer();
    }

    // g/setter
    public int getSize() {
        return size;
    }

    void setBoard() {
        this.board = new int[size][size];
        int x, y;

        // 빙고판 만들기 = 일단 1 ~ size^2 숫자를 순서대로 채워넣음
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = i * size + j + 1;
            }
        }

        // 빙고판 숫자 섞기 = Java 정석 참고
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                x = (int) (Math.random() * size); // 0~4 범위의 랜덤 정수 -> size * size 사이즈 2차원 배열 내 임의의 원소/위치 선택
                y = (int) (Math.random() * size); // 0~4 범위의 랜덤 정수

                int temp = 0;
                temp = this.board[i][j];
                this.board[i][j] = this.board[x][y];
                this.board[x][y] = temp;
            }
        }

        // 참고용 출력 = 실제 게임 시에는 보여주지 않음 todo
        /*
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%2d  ", this.board[i][j]);
            }
            System.out.println();
        }
         */
    }

    public int[][] getBoard() {
        return board;
    }

    void setUserName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("성함을 입력해 주세요 > ");
        this.userName = scanner.nextLine();
    }

    public String getUserName() {
        return userName;
    }

    void setFirstPlayer() {
        // 랜덤 숫자로 0이 나오면 컴퓨터 vs 1이 나오면 사용자가 먼저 번호를 부름
        this.firstPlayer = (int) (Math.random() * 2);

        if (this.firstPlayer == 0) {
            System.out.println("컴퓨터가 먼저 숫자 하나를 부릅니다");
        } else {
            System.out.println(userName + "님 먼저 숫자 하나를 부릅니다");
        }
    }

    public int getFirstPlayer() {
        return firstPlayer;
    }
}
