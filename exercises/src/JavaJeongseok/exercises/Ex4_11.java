package exercises.src.JavaJeongseok.exercises;

// 2022.8.13(토) 1h20
// Fibonnaci 수열의 10번째 수 구하기
public class Ex4_11 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 1;
        int num3 = 0;

        System.out.print("Fibonnaci 수열 = " + num1 + ", " + num2);

        for (int i = 0; i < 8; i++) {
            num3 = num1 + num2;
            System.out.print(", " + num3);

            num1 = num2;
            num2 = num3;
        }

        // 재귀 함수로 만들어보기 -> 아직 어떻게 만들어야 할지 잘 모르겠음..
    }

    public static int fibonnaci(int num1, int num2) {
        fibonnaci(num1, num2);
        return num1 + num2;
    }
}
