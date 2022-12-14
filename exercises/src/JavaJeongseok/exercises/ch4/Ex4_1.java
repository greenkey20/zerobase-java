package exercises.src.JavaJeongseok.exercises.ch4;

// 2022.8.11(목) 12h5
public class Ex4_1 {
    /* 제어자(modifier) = 클래스, 변수, 메소드 선언부에 함께 사용되어 부가적인 의미 부여
    접근 제어자 public/protected/default/private 중 1개 + static, final, abstract, native, transient, synchronized, volatile, strictfp 중복 사용 가능
    제어자들 간 순서는 관계 없으나, 주로 접근 제어자를 제일 왼쪽에 놓는 경향 있음
     */
    public static void main(String[] args) {
        // 1
        int x = 0;
        if (10 < x && x < 20) {

        }

        char ch1 = '\u0000'; // char 자료형의 기본 값으로,  로 콘솔에 찍힘
        System.out.println(ch1);

        char ch2 = '\u0041'; // A
        System.out.println(ch2);

        // 2
//        char ch; // 멤버/클래스 변수이기 때문에 초기화하지 않아도 자동적으로 변수의 자료형에 맞는 기본 값으로 초기화됨 -> 단, 이러한 사용을 권장하지는 않음 vs IntelliJ 컴파일러는 왜 'java: variable ch might not have been initialized'라며 빨간줄 오류를 띄우지?
        char ch = 0; // IntelliJ 추천에 따라 자동 초기화함
        if (ch != ' ' || ch != '\t') { // 이건 문제의 문장이 의미한 바(ch는 공백도 아니고 tab도 아님)가 아님

        }

        if (ch != ' ' && ch != '\t') {

        }

        if (!(ch == ' ' || ch == '\t')) { // 위 조건식에 대한 드모르간 법칙 적용해서 생각해보기

        }

        // 3
        if (ch == 'x' || ch == 'X') {

        }

        // 4
        if ('0' <= ch && ch <= '9') {

        }

        // 5
        if ('A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z') {

        }

        // 6
        int year = 0;
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            
        }

        // 7
        boolean powerOn = false;
        if (powerOn) {
            
        }

        // 8
        String str = "";
        if (str.equals("yes")) {

        }

    } // main() 종료
}
