package exercises.src.JavaJeongseok.examples.ch5.bingo;

import java.util.Set;

// 2023.5.19(금) 1h50
public class View {
    // 멤버 변수
    private Settings settings;

    // 생성자
    public View(Settings settings) {
        this.settings = settings;
    }

    void printShowBoard(char[][] showBoard) {
        for (int i = 0; i < settings.getSIZE(); i++) {
            System.out.println(showBoard[i]);
        }
    }

    void printNumsCalled(Set<Integer> numsCalled) {
        System.out.println(numsCalled);
    }

    void printWinner(char player) {
        if (player == 'X') {
            System.out.println("컴퓨터가 이겼습니다!");
            System.exit(0);
        } else {
            System.out.printf("%s 님이 이겼습니다!\n", settings.getUserName());
            System.exit(0);
        }
    }
}
