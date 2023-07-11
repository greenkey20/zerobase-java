package exercises.src.JavaJeongseok.examples.ch9;

import static java.lang.Math.*;
import static java.lang.System.out; // 코드를 간단히 하기 위해 정적 import문 추가

// 2023.7.11(화) 20h15
public class MathEx1 {
    public static void main(String[] args) {
        double value = 90.7552;
        out.println("round(" + value + ") = " + round(value)); // 반올림
        out.println();

        value *= 100; // 소수점 셋째자리에서 반올림해서 소수점 2자리까지의 값만 얻고 싶어서 100 곱함
        out.println("round(" + value + ") = " + round(value)); // 반올림
        out.println("round(" + value + ") / 100.0 = " + round(value) / 100.0); // 반올림
        out.println("round(" + value + ") / 100 = " + round(value) / 100); // 반올림
        out.println();

        out.printf("ceil(%3.1f) = %3.1f%n", 1.1, ceil(1.1)); // 올림
        out.printf("floor(%3.1f) = %3.1f%n", 1.5, floor(1.5)); // 버림
        out.printf("round(%3.1f) = %d%n", 1.1, round(1.1)); // 반올림
        out.printf("round(%3.1f) = %d%n", 1.5, round(1.5)); // 반올림
        out.printf("rint(%3.1f) = %f%n", 1.5, rint(1.5)); // 반올림
        out.printf("round(%3.1f) = %d%n", -1.5, round(-1.5)); // 반올림
        out.printf("rint(%3.1f) = %f%n", -1.5, rint(-1.5)); // 반올림
        out.printf("ceil(%3.1f) = %f%n", -1.5, ceil(-1.5)); // 올림
        out.printf("floor(%3.1f) = %f%n", -1.5, floor(-1.5)); // 버림
    }
}
