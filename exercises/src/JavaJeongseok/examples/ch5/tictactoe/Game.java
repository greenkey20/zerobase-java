package exercises.src.JavaJeongseok.examples.ch5.tictactoe;

// 2023.5.23(화) 1h40
public class Game {
    private Settings settings;
    private View view;
    private Rules rules;

    public Game(Settings settings, View view, Rules rules) {
        this.settings = settings;
        this.view = view;
        this.rules = rules;
    }

    public void playGame(char firstPlayer) {
        while (true) {
            String point = rules.setPoint(firstPlayer); // [Rules]
            rules.markPoint(firstPlayer, point); // [Rules]
            view.printBoard(); // ui 요소 [View]

            // 한 플레이어가 이기는 상황인지 체크
            if (rules.isVictory(firstPlayer)) { // [Rules]
                String winner = null;
                if (firstPlayer == 'O') {
                    winner = "짝짝짝! " + settings.getUserName() + " 님이";
                } else {
                    winner = "컴퓨터가";
                }

                System.out.printf("%s 이겼습니다!\n", winner); // ui 요소
                rules.exitGame(); // [Rules]
            } else {
                if (!rules.isBoardFull()) { // [Rules]
                    firstPlayer = rules.switchPlayer(firstPlayer); // [Rules]
                } else {
                    System.out.println("빈칸이 남아있지 않습니다. 비겼습니다. 게임을 종료합니다");
                    rules.exitGame();
                }
            }
        }
    }
}
