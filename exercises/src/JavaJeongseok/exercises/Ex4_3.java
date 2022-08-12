package exercises.src.JavaJeongseok.exercises;

// 2022.8.11(목) 18h25
public class Ex4_3 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
        }

        System.out.println(sum); // 220
    }
}
