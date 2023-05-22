package exercises.src.JavaJeongseok.examples.ch5.tictactoe;

// 2023.5.22(월) 17h50 ~ 19h15 v1 절차적 프로그래밍 = 제대로 동작 안 함 -> 23h30 ~ 2023.5.23(화) 0h45 v2 debug = 기능 동작 확인
// ~ 1h50 v3 oop

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * 컴퓨터와 내가 하는 tic tac toe 게임
 */
public class Main {
    public static void main(String[] args) {
        Settings settings = new Settings();
        View view = new View(settings);
        Rules rules = new Rules(settings);

        settings.setBoard(); // [Settings]
        view.printBoard(); // [View]
        settings.setUserName(); // [Settings]

        char firstPlayer = settings.getFirstPlayer(); // 이 메서드는 이름 그대로 게임 시작하는 player 정할 때만 호출하면 됨 [Settings]

        Game game = new Game(settings, view, rules);
        game.playGame(firstPlayer);
    }
}
