package exercises.src.JavaJeongseok.examples.ch5.bingo;

// 2023.5.19(금) 2h30
public class AppConfigurer {
    public final int SIZE = 5;

    public Settings settings = new Settings(SIZE);

    public View view() {
        return new View(settings);
    }

    public GameRules gameRules = new GameRules(settings, view());

    public Game game() {
        return new Game(gameRules, view());
    }
}
