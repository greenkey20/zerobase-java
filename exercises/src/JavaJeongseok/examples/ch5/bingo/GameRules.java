package exercises.src.JavaJeongseok.examples.ch5.bingo;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 2023.5.19(금) 1h25
public class GameRules {
    // 멤버 변수

    private Settings settings;
    private View view;
    private Set<Integer> numsCalled = new TreeSet<>();
    private char[][] showBoard;

    // 생성자
    public GameRules(Settings settings, View view) {
        this.settings = settings;
        this.view = view;
        setShowBoard();
    }

    // getter
    public char[][] getShowBoard() {
        return showBoard;
    }

    public void setShowBoard() {
        this.showBoard = new char[settings.getSize()][settings.getSize()];
    }

    // 메서드
    int getComNum() {
        int comNum = 0;

        for (int i = 0; i < 1; i++) {
            comNum = (int) (Math.random() * settings.getSize() * settings.getSize()) + 1;
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

    int getUserNum() {
        Scanner scanner = new Scanner(System.in);

        int userNum = 0;
        for (int i = 0; i < 1; i++) {
            System.out.printf("%s님, 1부터 %d 사이의 정수 하나를 입력해 주세요\n (0을 누르면 현재 board와 선택된 숫자들을 보여드립니다) > ", settings.getUserName(), settings.getSize() * settings.getSize());
            userNum = Integer.parseInt(scanner.nextLine());

            if (userNum == 0) {
                view.printShowBoard(showBoard); // 사용자가 현재 board를 보고 싶어하는 경우, 보여줌
                view.printNumsCalled(numsCalled);
                i--;
            } else if (userNum < 0 || settings.getSize() * settings.getSize() < userNum) {
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

    void markNum(int num, char player) {
        for (int i = 0; i < settings.getSize(); i++) {
            for (int j = 0; j < settings.getSize(); j++) {
                if (settings.getBoard()[i][j] == num) {
                    showBoard[i][j] = player;
                }
            }
        }
    }

    void checkBingo(char player) { // 컴퓨터 = X vs 사용자 = O
        // '빙고'되는 조건 문자열 만들어두기
        StringBuilder bingo = new StringBuilder();
        for (int i = 0; i < settings.getSize(); i++) {
            bingo.append(player);
        }

        // 가로로 쭉 연결되었는지 확인
        for (int i = 0; i < settings.getSize(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < settings.getSize(); j++) {
                sb.append(showBoard[i][j]);
            }

            isBingo(sb.toString(), bingo.toString(), player);
        }

        // 세로로 쭉 연결되었는지 확인
        for (int i = 0; i < settings.getSize(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < settings.getSize(); j++) {
                sb.append(showBoard[j][i]);
            }

            isBingo(sb.toString(), bingo.toString(), player);
        }

        // 왼쪽 상단에서 시작하는 대각선으로 연결되었는지 확인
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < settings.getSize(); i++) {
            sb.append(showBoard[i][i]);
        }

        isBingo(sb.toString(), bingo.toString(), player);

        // 오른쪽 상단에서 시작하는 대각선으로 연결되었는지 확인
        sb = new StringBuilder();
        for (int i = 0; i < settings.getSize(); i++) {
            sb.append(showBoard[i][settings.getSize() - 1 - i]);
        }

        isBingo(sb.toString(), bingo.toString(), player);
    }

    private void isBingo(String sb, String bingo, char player) {
        if (sb.equals(bingo)) {
            view.printShowBoard(showBoard); // bingo인 player가 있어서 게임 종료하기 전 현재 board를 마지막으로 보여줌
            view.printWinner(player);
        }
    }

    void isTie() {
        if (numsCalled.size() == settings.getSize() * settings.getSize()) {
            System.out.println("비겼습니다. 수고하셨습니다!");
            exitGame();
        }
    }

    // 2023.5.22(월) 17h30 나의 질문 = static이 아닌 클래스 안에 static 멤버 메서드 포함 가능한 게 맞나?
    static void exitGame() {
        System.exit(0);
    }
}
