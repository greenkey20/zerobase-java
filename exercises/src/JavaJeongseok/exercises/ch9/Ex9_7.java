package exercises.src.JavaJeongseok.exercises.ch9;

// 2022.8.25(목) 23h50
public class Ex9_7 {
    public static boolean contains(String src, String target) {
        return src.indexOf(target) != -1; // 주어진 문자열이 존재하는지 확인 -> 해당 문자열이 존재하면 가장 처음/앞에 존재하는 인덱스 반환 vs 존재하지 않으면 -1 반환
    }
    public static void main(String[] args) {
        System.out.println(contains("hello", "hi")); // false
        System.out.println(contains("59432", "43")); // true
    }

}
