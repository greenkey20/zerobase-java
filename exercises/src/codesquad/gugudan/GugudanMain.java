package exercises.src.codesquad.gugudan;

// 2023.7.12(수) 16h55
// 다른 클래스에 있는 메서드 호출 시, 그 클래스의 이름 지정해야 함
public class GugudanMain {
    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            int[] results = Gugudan.calculate(i);
            Gugudan.print(results);
        }
    }
}
