package exercises.src.JavaJeongseok.exercises;

// 2022.8.9(화) 23h35
public class Ex3_8 {
    public static void main(String[] args) {
        byte a = 10;
        ++a;
        byte d = a; // 나의 질문 = Java 정석 p.92에 따르면 (일반)산술 변환 자동 형 변환은 단항 연산에서도 일어나는데, 위 행에서 단항 연산 ++를 거친 a(이 설명에 따르면 a가 int형으로 변환되는 것 아닌가?)가 어떻게 byte 변수 d에 문제 없이 저장되는 것이지?
        System.out.println("d = " + d);

        byte b = 20;
        byte c = (byte)(a + b);
        System.out.println("c = " + c);
    }
}
