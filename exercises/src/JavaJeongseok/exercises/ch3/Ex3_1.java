package exercises.src.JavaJeongseok.exercises.ch3;

// 2022.8.8(월) 22h35
public class Ex3_1 {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        char c = 'A';

        System.out.println(1 + x << 33); // 6
        System.out.println(1 + x << -33); // -2147483648 -> Java의 정석 p.126 'n은 정수만 가능하며, 음수인 경우 부호없는 정수로 자동 변환된다'고 되어있는데, 왜 결과는 이렇게 찍히는 것일까?

        System.out.println(!('A' <= c && c <= 'Z')); // c가 대문자가 아닌지 확인하는 조건식 cf. 나는 처음에 문제 풀 때 부정연산자 !를 못 봤다 >.<

        System.out.println('C' - c); // 2; 이항 연산자는 피연산자가 int보다 작은 타입(byte, short, char)인 경우 int로
        System.out.println('5' - '0'); // 5
        System.out.println(c + 1); // 문자형(char) 자료에 대해 println()은 어떻게 정의되어 있나? -> 이 문장에서는 왼쪽 질문과 관계 없고, 문자형 변수 c와 int형 자료 1이 산술연산되며 c가 int로 자동 형 변환되는 바, 66이 찍힘
        System.out.println(++c); // B -> 문자형(char) 자료에 대해 println()은 문자를 출력하도록 정의되어 있는 것인가? -> 궁금한 메소드나 클래스 이름에 커서 올려두고 command 키 눌러서 설명 볼 수 있음; 단항 연산자는 이항 연산자와 달리 int보다 작은 타입도 형 변환 안 함
        System.out.println(c++); // B
        System.out.println(c); // C
    }
}
