package exercises.src.JavaJeongseok.exercises;

// 2022.8.9(화) 23h15
public class Ex4_4 {
    public static void main(String[] args) {
        int sum = 0;

        // 방법1)
        /*
        for (int i = 1; i < 1000000; i++) { // i의 값이 임의로 큰 정수값인 동안 반복문을 돌리기 위해 임의로 큰 정수값 1000000을 정함
            if (i % 2 == 1) { // i가 홀수인 경우
                sum += i;
            } else { // i가 짝수인 경우
                sum -= i;
            }

            if (sum >= 100) {
                System.out.println("i 값이 " + i + "일 때 sum(총합)이 " + sum + "가/이 되어 100 이상이 되었습니다. 따라서 프로그램을 종료합니다 ^^"); // i = 199, sum = 100
                return;
            }
        }
         */

        // 2022.8.11(목) 19h30
        // 방법2) 조건식에 임의의 큰 수를 사용하지 말고 조건을 작성해보자 + 저자 해설 참고
        int sign = 1;
        int num = 0; // num까지 더해야 총합이 100 이상이 되는지 구하고자 함
        /*
        for (int i = 1; ; i++, sign *= -1) { // 조건식 생략 시 true로 간주되어 무한 반복문이 됨 -> 블럭{} 안에 특정 조건을 만족하면 for문을 빠져나오게 해야 함
            sum += i * sign;
            num = i;

            if (sum >= 100) {
                break;
            }
        }
         */

        // 방법3) 보다 간략한 for문 작성
        /*
        for (int i = 1; sum < 100; i++, sign *= -1) { // 조건식 생략 시 true로 간주되어 무한 반복문이 됨 -> 블럭{} 안에 특정 조건을 만족하면 for문을 빠져나오게 해야 함
            sum += i * sign;
            num = i;
        }
         */

//        System.out.println(num + "까지 더해야 총합이 " + sum + "이/가 되어 100 이상이 되네요 :D"); // 199까지 더해야 총합이 100이/가 되어 100 이상이 되네요 :D

        // 방법4) while문 사용
        int j = 1; // 반복문의 제어변수 초기화
        while (sum < 100) { // 조건식
            sum += j * sign;
            j++; // 반복문의 제어변수 증감식
            sign *= -1;
        }

        System.out.println((j - 1) + "까지 더해야 총합이 " + sum + "이/가 되어 100 이상이 되네요 :D"); // 199까지 더해야 총합이 100이/가 되어 100 이상이 되네요 :D
    }
}
