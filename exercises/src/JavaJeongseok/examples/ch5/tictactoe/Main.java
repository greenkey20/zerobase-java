package exercises.src.JavaJeongseok.examples.ch5.tictactoe;

// 2023.5.22(월) 17h50 ~ 19h15 v1 절차적 프로그래밍 = 제대로 동작 안 함 -> 23h30 ~ 2023.5.23(화) 0h45 v2 debug = 기능 동작 확인

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * 컴퓨터와 내가 하는 tic tac toe 게임
 */
public class Main {
    static final int SIZE = 3;
    static char[][] board = new char[SIZE + 1][SIZE + 1];
    static char firstPlayer;
    static String userName;
    static Scanner scanner = new Scanner(System.in);
    static Set<String> points = new HashSet<>();

    public static void main(String[] args) {
        setBoard();
        printBoard();

        setUserName();

        firstPlayer = getFirstPlayer(); // 이 메서드는 이름 그대로 게임 시작하는 player 정할 때만 호출하면 됨

        while (true) {
            String point = setPoint(firstPlayer);
            markPoint(firstPlayer, point);
            printBoard(); // ui 요소

            // 한 플레이어가 이기는 상황인지 체크
            if (isVictory(firstPlayer)) {
                String winner = null;
                if (firstPlayer == 'O') {
                    winner = "짝짝짝! " + userName + " 님이";
                } else {
                    winner = "컴퓨터가";
                }

                System.out.printf("%s 이겼습니다!\n", winner); // ui 요소
                exitGame();
            } else {
                if (!isBoardFull()) {
                    switchPlayer(firstPlayer);
                } else {
                    System.out.println("빈칸이 남아있지 않습니다. 비겼습니다. 게임을 종료합니다");
                    exitGame();
                }
            }
        }
    }

    /**
     * 사용자 또는 컴퓨터가 게임판에 기호를 채운 뒤, 이기는 상황인지 확인
     *
     * @param firstPlayer
     * @return
     */
    static boolean isVictory(char firstPlayer) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < SIZE; i++) {
            sb.append(firstPlayer);
        }

        String ttt = sb.toString();
//        System.out.println("ttt = " + ttt); // todo

        for (int i = 1; i < board.length; i++) {
            sb = new StringBuilder(); // 이 sb 초기화 위치 때문에 첫째 가로줄 외의 다른 가로줄은 victory 처리 안 됨
            for (int j = 1; j < board.length; j++) {
                sb.append(board[i][j]);
            }

            if (sb.toString().equals(ttt)) {
                return true;
            }
        }

        for (int i = 1; i < board.length; i++) {
            sb = new StringBuilder(); // 이 sb 초기화 위치 때문에 첫째 세로줄 외의 다른 세로줄은 victory 처리 안 됨
            for (int j = 1; j < board.length; j++) {
                sb.append(board[j][i]);
            }

            if (sb.toString().equals(ttt)) {
                return true;
            }
        }

        sb = new StringBuilder();
        for (int i = 1; i < board.length; i++) {
            sb.append(board[i][i]);
            if (sb.toString().equals(ttt)) {
                return true;
            }
        }

        sb = new StringBuilder();
        for (int i = 1; i < board.length; i++) {
            sb.append(board[i][board.length - i]);
            if (sb.toString().equals(ttt)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 게임판에 빈칸이 남아있는지 확인
     *
     * @return
     */
    static boolean isBoardFull() {
        int numOfEmptySpace = 0;
        for (int i = 1; i < board.length; i++) { // board의 첫번째 가로/세로줄에는 위치 번호 기재한 바, *를 세어야 하는 범위는 이렇게 지정해야 함
            for (int j = 1; j < board.length; j++) {
                if (board[i][j] == '*') {
                    numOfEmptySpace++;
                }
            }
        }

        if (numOfEmptySpace == 0) { // '*' 표시가 하나도 남아있지 않으면 = 게임판에 빈칸이 안 남아있음 = board is full
            return true;
        } else { // '*' 표시가 남아있으면 = 게임판에 빈칸이 남아있음 = board is NOT full
            return false;
        }
    }

    /**
     * player 순서 바꾸기
     *
     * @param player
     */
    static void switchPlayer(char player) {
        if (player == 'O') {
            firstPlayer = 'X';
        } else {
            firstPlayer = 'O';
        }
    }

    /**
     * 컴퓨터 또는 사용자가 결정한 위치에 기호를 채움
     * 사용자인 경우 'O', 컴퓨터인 경우 'X'를 채움
     *
     * @param firstPlayer
     * @param point
     */
    static void markPoint(char firstPlayer, String point) {
        int row = Character.getNumericValue(point.charAt(0));
        int column = point.charAt(1) - '0';

        board[row][column] = firstPlayer;
    }

    // 말을 높을 위치 결정
    static String setPoint(char player) {
        String point = null;

        if (player == 'O') {
            point = getUserPoint(player);
        } else {
            point = getComPoint(player);
        }

        points.add(point);
//        System.out.println("금번 선택된 point = " + point); // todo
//        System.out.println("현재까지 선택된 points = " + points); // todo
        return point;
    }

    /**
     * 사용자가 기호를 채울 칸 결정     *
     *
     * @return
     */
    static String getUserPoint(char player) {
        String point = null;

        for (int i = 0; i < 1; i++) {
            System.out.printf("%s 님, 기호를 채울 칸의 행/열 번호를 입력해 주세요 > ", userName);
            point = scanner.nextLine();

            // 입력 값 예외 처리 추가
            int row = Character.getNumericValue(point.charAt(0));
            int column = point.charAt(1) - '0';

            if (point.length() > 2 || row < 1 || SIZE < row || column < 1 || SIZE < column) {
                System.out.println("잘못된 범위의 행/열 번호를 입력하셨습니다");
                i--;
            }

            if (isSelected(point, player)) {
                i--;
            }
        }

        return point;
    }

    /**
     * 컴퓨터가 기호를 채울 칸 결정
     *
     * @return
     */
    static String getComPoint(char player) {
        System.out.println("컴퓨터가 기호를 채웁니다"); // ui 요소

        StringBuilder sb = null;
        for (int i = 0; i < 1; i++) {
            sb = new StringBuilder(); // 이 sb 초기화 위치 때문에, 이 반복문 다시 돌아도 새로운 위치가 제대로 뽑히지 않음
            int row = (int) (Math.random() * 3) + 1;
            int column = (int) (Math.random() * 3) + 1;
            sb.append(row).append(column);

            if (isSelected(sb.toString(), player)) {
                i--;
            }
        }

//        System.out.println(sb); // todo
        return sb.toString();
    }

    static boolean isSelected(String point, char player) {
        boolean isSelected = points.contains(point);

        // ui 요소 = 컴퓨터가 이미 채워진 위치 입력할 때는 굳이 이 문장 보여줄 필요 없음
        if (player == 'O' && isSelected) {
            System.out.println("이미 기호가 채워진 위치입니다");
        }

        return isSelected;
    }

    /**
     * 게임판(board) 초기화
     */
    static void setBoard() {
        for (int i = 1; i < board.length; i++) {
            board[i][0] = board[0][i] = (char) (i + '0');
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                board[i][j] = '*';
            }
        }
    }

    /**
     * 게임판 현재 상태를 출력
     */
    static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i]);
        }
    }

    /**
     * 사용자의 이름을 입력받아 userName 변수 값 초기화
     */
    static void setUserName() {
        System.out.print("안녕하세요! 사용자의 이름을 입력해 주세요 > ");
        userName = scanner.nextLine();
    }

    /**
     * 시작할 플레이어를 무작위로 선택 -> 무작위 수 0이 나오면 사용자, 1이 나오면 컴퓨터가 시작할 플레이어가 됨
     * 사용자는 'O', 컴퓨터는 'X'로 표시하기로 함
     */
    static char getFirstPlayer() {
//        int numOfFirstPlayer = (int) (Math.random() * 2); // 컴퓨터에게 불공평 <- 0이 나올 확률 < 1이 나올 확률
        Random random = new Random();
        int numOfFirstPlayer = random.nextInt(2);

        if (numOfFirstPlayer == 0) {
            System.out.printf("%s 님이 먼저 시작합니다~\n", userName); // ui 요소
            return 'O';
        } else {
            System.out.println("컴퓨터가 먼저 시작합니다~"); // ui 요소
            return 'X';
        }
    }

    /**
     * 게임 종료
     */
    static void exitGame() {
        System.out.println("수고하셨습니다 ^_^"); // ux 요소
        System.exit(0);
    }
}
