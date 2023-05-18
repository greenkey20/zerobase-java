package exercises.src.JavaJeongseok.examples.ch5.bingo;

// 2023.5.18(목) 22h35 ~ 23h45 초안 작성 -> 0h5 ~ 1h10 기능 다듬기 + 메서드 추출 등 refactoring -> ~ 2h45 객체지향적으로 refactoring = 동작이 뭔가 이상함
/* 나의 고민
1. 더 객체 지향적인 프로그램?
2. 무엇을 어떻게 테스트하는 테스트 코드를 짤 수 있을까?
 */

/**
 * 컴퓨터와 내가 하는 숫자 빙고 게임
 */
public class Main {
    public static void main(String[] args) {
        // AppConfigurer 사용 전
        /*
        Settings settings = new Settings(5);
        int firstPlayer = settings.getFirstPlayer();

        Game game = new Game(new GameRules(settings));
        game.playGame(firstPlayer);
         */

        // 2h35 AppConfigurer 사용
        AppConfigurer appConfigurer = new AppConfigurer();
        int firstPlayer = appConfigurer.settings().getFirstPlayer();
        appConfigurer.game().playGame(firstPlayer);
    }
}
