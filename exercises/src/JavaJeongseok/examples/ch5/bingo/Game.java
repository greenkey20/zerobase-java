package exercises.src.JavaJeongseok.examples.ch5.bingo;

// 2023.5.19(금) 1h25
public class Game {
    // 멤버 변수
    private GameRules gameRules;
    private View view;

    // 생성자
    public Game(GameRules gameRules, View view) {
        this.gameRules = gameRules;
        this.view = view;
    }

    // 메서드
    void playGame(int firstPlayer) {
        while (true) {
            int comNum, userNum;

            if (firstPlayer == 0) {
                // 컴퓨터가 숫자 1개 고름
                comNum = gameRules.getComNum();

                // 선택된 숫자 위치에 X(컴퓨터) or O(사용자) 표시
                gameRules.markNum(comNum, 'X');

                // 빙고 되었는지 확인
                gameRules.checkBingo('X');

                firstPlayer = 1;
            } else {
                // 사용자가 숫자 1개 고름
                userNum = gameRules.getUserNum();

                // 선택된 숫자 위치에 X(컴퓨터) or O(사용자) 표시
                gameRules.markNum(userNum, 'O');

                // 빙고 되었는지 확인
                gameRules.checkBingo('O');

                firstPlayer = 0;
            }

            // 게임이 종료되지 않았다면
            // 현재 board 상태 보여줌
            view.printShowBoard(gameRules.getShowBoard());

            // 비기는 상황은 아닌지 확인
            gameRules.isTie();
        }
    }
}
