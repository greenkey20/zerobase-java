package exercises.src.JavaJeongseok.exercises;

// 2022.8.12(금) 0h40
public class Ex4_8 {
    public static void main(String[] args) {
        int x, y;

        for (x = 0; x <= 10; x++) {
            for (y = 0; y <= 10; y++) {
                if (2 * x + 4 * y == 10) {
                    System.out.println("x = " + x + ", y = " + y);
                }
            }
        }
    }
}
