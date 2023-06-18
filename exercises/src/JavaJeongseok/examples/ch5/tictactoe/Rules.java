package exercises.src.JavaJeongseok.examples.ch5.tictactoe;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 2023.5.23(화) 1h10
public class Rules {
    private Settings settings;
    private Set<String> points = new HashSet<>();

    public Rules(Settings settings) {
        this.settings = settings;
    }

    // 말을 놓을 위치 결정
    public String setPoint(char player) {
        String point = null;

        if (player == 'O') {
            point = getUserPoint(player);
        } else {
            point = getComPoint(player);
        }

        setPoints(point);
//        System.out.println("금번 선택된 point = " + point); // todo
//        System.out.println("현재까지 선택된 points = " + points); // todo
        return point;
    }

    public Set<String> getPoints() {
        return points;
    }

    public void setPoints(String point) {
        this.points.add(point);
    }

    /**
     * 컴퓨터 또는 사용자가 결정한 위치에 기호를 채움
     * 사용자인 경우 'O', 컴퓨터인 경우 'X'를 채움
     *
     * @param firstPlayer
     * @param point
     */
    public void markPoint(char firstPlayer, String point) {
        int row = Character.getNumericValue(point.charAt(0));
        int column = point.charAt(1) - '0';

        settings.getBoard()[row][column] = firstPlayer;
    }

    /**
     * 사용자 또는 컴퓨터가 게임판에 기호를 채운 뒤, 이기는 상황인지 확인
     *
     * @param firstPlayer
     * @return
     */
    public boolean isVictory(char firstPlayer) {
        StringBuilder sb = new StringBuilder();
        char[][] board = settings.getBoard();

        for (int i = 0; i < settings.getSIZE(); i++) {
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
     * 게임 종료
     */
    public void exitGame() {
        System.out.println("수고하셨습니다 ^_^"); // ux 요소
        System.exit(0);
    }

    /**
     * 게임판에 빈칸이 남아있는지 확인
     *
     * @return
     */
    public boolean isBoardFull() {
        int numOfEmptySpace = 0;
        char[][] board = settings.getBoard();

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
    public char switchPlayer(char player) {
        if (player == 'O') {
            return 'X';
        } else {
            return 'O';
        }
    }

    /**
     * 사용자가 기호를 채울 칸 결정     *
     *
     * @return
     */
    private String getUserPoint(char player) {
        String point = null;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 1; i++) {
            System.out.printf("%s 님, 기호를 채울 칸의 행/열 번호를 입력해 주세요 > ", settings.getUserName());
            point = scanner.nextLine();

            // 입력 값 예외 처리 추가
            int row = Character.getNumericValue(point.charAt(0));
            int column = point.charAt(1) - '0';

            if (point.equals("00")) {
                System.out.println("게임을 종료합니다"); // ui 요소
                exitGame();
            } else if (point.length() > 2 || row < 1 || settings.getSIZE() < row || column < 1 || settings.getSIZE() < column) {
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
    private String getComPoint(char player) {
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

    private boolean isSelected(String point, char player) {
        boolean isSelected = points.contains(point);

        // ui 요소 = 컴퓨터가 이미 채워진 위치 입력할 때는 굳이 이 문장 보여줄 필요 없음
        if (player == 'O' && isSelected) {
            System.out.println("이미 기호가 채워진 위치입니다");
        }

        return isSelected;
    }
}
