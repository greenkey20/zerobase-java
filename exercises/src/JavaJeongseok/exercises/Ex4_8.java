package exercises.src.JavaJeongseok.exercises;

// 2022.8.12(금) 0h40
public class Ex4_8 {
    public static void main(String[] args) {
        int x, y; // 이 변수들을 아래 for문 외부에서 사용할 일 없으므로, 이렇게 for문 외부에서 변수 선언할 필요는 없었음

        for (x = 0; x <= 10; x++) {
            for (y = 0; y <= 10; y++) {
                if (2 * x + 4 * y == 10) {
//                    System.out.println("x = " + x + ", y = " + y);

                    // 2022.8.13(토) 0h50 printf 연습
                    System.out.printf("x = %d, y = %d%n", x, y); // OS마다 줄 바꿈 문자가 다를 수 있는 바, \n보다 %n을 사용하는 것이 더 안전함(Java 정석 p36)
                }
            }
        }
    }
}
