package exercises.src.JavaJeongseok.exercises.ch4;

// 2022.8.11(목) 18h
public class Ex4_2 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 20; i++) {
            // 처음에 이렇게 풀었는데 의도한대로 sum 안 구해짐(sum = 174)
//            if (i % 2 != 0 || i % 3 != 0) { // '2의 배수도 아니고, 3의 배수도 아닌 경우' = 'i % 2 != 0 && i % 3 != 0'
            if (!(i % 2 == 0 || i % 3 == 0)) {
                sum += i;
            }
        }

        System.out.println("1~20 정수 중 2 또는 3의 배수가 아닌 수의 총합 = " + sum); // 73
    }
}
