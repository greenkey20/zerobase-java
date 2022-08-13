package exercises.src.JavaJeongseok.exercises;

// 2022.8.10(수) 23h50
public class Ex4_10 {
    public static void main(String[] args) {
        int num = 12345;
        int sum = 0;

        // 문자열로 변환하지 말고 숫자로만 처리해야 한다는 조건을 제대로 못 보고 안 지켰다..ㅠㅠ
        /*
        String numString = String.valueOf(num);

        for (int i = 0; i < numString.length(); i++) { // String.valueOf(num).length()라고 썼을 때 의도한대로 작동하지 않는 이유는 무엇이지?
            sum += num % 10;
            num = num / 10;
        }
         */

        // 2022.8.12(금) 23h20 문자열로 변환하지 않고 다시 작성해보기
        /*
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
         */

        // 동료 수강생분들의 논의 중, 아래와 같이 써서 while문 탈출 조건이 더 명확하게 보이게 할 수 있고,
        // while문 안의 로직이 1바퀴 돌지 않고 로직 타고 내려가다가 특정 조건에서 바로 탈출할 수 있어서(break 위치에 따라 더 자유도가 높은 것 같아서)
        // 이렇게 쓰시는 분들이 있다는 것을 알게 됨
        while (true) {
            sum += num % 10;
            num = num / 10;

            if (num == 0) { // IntelliJ의 suggestion에 따라, num <= 0이라고 조건식 작성했던 것을 ==(equality)로 바꿈
                break; // 2022.8.14(일) 0h45 나의 질문 = 'conditional break inside infinite loop'에 대해 IntelliJ는 왜 경고(warning)를 띄울까?
            }
        }

        System.out.print("sum = " + sum); // sum = 15
    }
}
