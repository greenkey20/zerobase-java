package exercises.src.JavaJeongseok.examples.ch5.bingo;

// 2023.5.19(금) 1h25
public class Game {
    // 멤버 변수
    private Rules rules;
    private View view;

    // 생성자
    public Game(Rules rules, View view) {
        this.rules = rules;
        this.view = view;
    }

    // 메서드
    void playGame(int firstPlayer) {
        while (true) {
            int comNum, userNum;

            if (firstPlayer == 0) {
                // 컴퓨터가 숫자 1개 고름
                comNum = rules.getComNum();

                // 선택된 숫자 위치에 X(컴퓨터) or O(사용자) 표시
                rules.markNum(comNum, 'X');

                // 빙고 되었는지 확인
                rules.checkBingo('X');

                firstPlayer = 1;
            } else {
                // 사용자가 숫자 1개 고름
                userNum = rules.getUserNum();

                // 선택된 숫자 위치에 X(컴퓨터) or O(사용자) 표시
                rules.markNum(userNum, 'O');

                // 빙고 되었는지 확인
                rules.checkBingo('O');

                firstPlayer = 0;
            }

            // 게임이 종료되지 않았다면
            // 현재 board 상태 보여줌
            view.printShowBoard(rules.getShowBoard());

            // 비기는 상황은 아닌지 확인
            rules.isTie();
        }
    }
}
