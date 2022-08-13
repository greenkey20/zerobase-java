package exercises.src.JavaJeongseok.exercises;

// 2022.8.13(토) 1h45
// 구구단 출력
public class Ex4_12 {
    public static void main(String[] args) {
        /*
        for (int i = 1; i < 4; i++) {
            for (int j = 2; j < 9; j += 3) {
                System.out.printf("%d * %d = %d", j, i, j * i);
            }
            System.out.println();
        }
         */

        for (int j = 2; j < 9; j += 3) {
            for (int i = 1; i < 4; i++) {
                System.out.printf("%d * %d = %d\t%d * %d = %d\t%d * %d = %d\n", j, i, j * i, j + 1, i, (j + 1) * i, j + 2, i, (j + 2) * i);
            }
            System.out.println();
        }

    }
}
