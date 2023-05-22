package exercises.src.JavaJeongseok.examples.ch5.tictactoe;

import java.util.Random;
import java.util.Scanner;

// 2023.5.23(화) 1h
public class Settings {
    private final int SIZE = 3;
    private char[][] board;
    private char firstPlayer;
    private String userName;

    public Settings() {
        setBoard();
        setUserName();
        setFirstPlayer();
    }

    public int getSIZE() {
        return SIZE;
    }

    public char[][] getBoard() {
        return board;
    }

    /**
     * 게임판(board) 초기화
     */
    public void setBoard() {
        this.board = new char[SIZE + 1][SIZE + 1];

        for (int i = 1; i < this.board.length; i++) {
            this.board[i][0] = this.board[0][i] = (char) (i + '0');
        }

        for (int i = 1; i < this.board.length; i++) {
            for (int j = 1; j < this.board.length; j++) {
                this.board[i][j] = '*';
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    /**
     * 사용자의 이름을 입력받아 userName 변수 값 초기화
     */
    public void setUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("안녕하세요! 사용자의 이름을 입력해 주세요 > ");
        this.userName = scanner.nextLine();
    }

    public char getFirstPlayer() {
        return firstPlayer;
    }

    /**
     * 시작할 플레이어를 무작위로 선택 -> 무작위 수 0이 나오면 사용자, 1이 나오면 컴퓨터가 시작할 플레이어가 됨
     * 사용자는 'O', 컴퓨터는 'X'로 표시하기로 함
     */
    public void setFirstPlayer() {
//        int numOfFirstPlayer = (int) (Math.random() * 2); // 컴퓨터에게 불공평 <- 0이 나올 확률 < 1이 나올 확률
        Random random = new Random();
        int numOfFirstPlayer = random.nextInt(2);

        if (numOfFirstPlayer == 0) {
            System.out.printf("%s 님이 먼저 시작합니다~\n", userName); // ui 요소
            this.firstPlayer = 'O';
        } else {
            System.out.println("컴퓨터가 먼저 시작합니다~"); // ui 요소
            this.firstPlayer = 'X';
        }
    }
}
