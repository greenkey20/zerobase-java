package exercises.src.JavaJeongseok.examples.ch5.tictactoe;

// 2023.5.23(화) 1h5
public class View {
    private Settings settings;

    public View(Settings settings) {
        this.settings = settings;
    }

    /**
     * 게임판 현재 상태를 출력
     */
    public void printBoard() {
        for (int i = 0; i < settings.getBoard().length; i++) {
            System.out.println(settings.getBoard()[i]);
        }
    }
}
