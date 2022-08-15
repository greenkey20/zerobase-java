package exercises.src.JavaJeongseok.exercises.ch3;

// 2022.8.9(화) 23h35
public class Ex3_8 {
    public static void main(String[] args) {
        byte a = 10;
        ++a;
        byte a2 = a; // 나의 질문 = Java 정석 p.92에 따르면 (일반)산술 변환 자동 형 변환은 단항 연산에서도 일어나는데, 위 행에서 단항 연산 ++를 거친 a(이 설명에 따르면 a가 int형으로 변환되는 것 아닌가?)가 어떻게 byte 변수 d에 문제 없이 저장되는 것이지?
        System.out.println("a2 = " + a2); // a2 = 11

        byte b = 20;
        byte c = (byte)(a + b);
        System.out.println("c = " + c); // c = 31

        // 2022.8.11(목) 0h50
        char ch = 'A';
        ch = (char)(ch + 2);
        System.out.println("ch = " + ch); // ch = C

        float f = 3f / 2;
        System.out.println("f = " + f);

        long l1 = 3000 * 3000 * 3000; // 곱셈 결과는 int인데, int 타입의 최대값(약 20억)을 넘는 결과로 overflow 발생해서 예상과 다른 값을 얻음 -> 나의 질문 = overflow되는 값은 어떻게 계산되지?(overflow의 원리)
        System.out.println("l1 = " + l1); // l1 = 1230196224
        long l2 = 3000l * 3000 * 3000; // 피연산자 중 적어도 1개 값은 long 타입이어야 최종 연산 결과를 long 타입의 값으로 얻음; 가독성을 위해 대문자 L 사용하는 것이 좋음
        System.out.println("l2 = " + l2); // l2 = 27000000000

        float f2 = 0.1f;
        // 내가 푼/생각한 것
        double d = (float)0.1;

        boolean result1 = d == f2;
        System.out.println("result1 = " + result1); // result1 = true

        // 저자 해설
        double d2 = 0.1;
        boolean result2 = (float)d2 == f2;
        System.out.println("result2 = " + result2); // result2 = true
    }
}
