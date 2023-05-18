package exercises.src.JavaJeongseok.examples.ch5.bingo;

// 2023.5.19(금) 2h30
public class AppConfigurer {
    private final int SIZE = 5;

    public Settings settings() {
        return new Settings(SIZE);
    }

    public View view() {
        return new View(settings());
    }

    public GameRules gameRules() {
        return new GameRules(settings(), view());
    }

    public Game game() {
        return new Game(gameRules(), view());
    }
}
