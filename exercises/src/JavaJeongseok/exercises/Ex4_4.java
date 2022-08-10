package exercises.src.JavaJeongseok.exercises;

// 2022.8.9(화) 23h15
public class Ex4_4 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i < 1000000; i++) { // i의 값이 임의로 큰 정수값인 동안 반복문을 돌리기 위해 임의로 큰 정수값 1000000을 정함
            if (i % 2 == 1) { // i가 홀수인 경우
                sum += i;
            } else { // i가 짝수인 경우
                sum -= i;
            }

            if (sum >= 100) {
                System.out.println("i 값이 " + i + "일 때 sum(총합)이 " + sum + "가/이 되어 100 이상이 되었습니다. 따라서 프로그램을 종료합니다 ^^");
                return;
            }
        }
    }
}
