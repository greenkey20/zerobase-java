package exercises.src.codestates.unit6;

// 2022.8.30(화) 15h50
public class TypeString {
    public static void main(String[] args) {
        // String = 참조(o) 기본(x) 타입 -> String 변수는 실제 문자열의 내용(x) 문자열이 존재하는 메모리 공간의 주소 값(o)을 값으로 저장
        // 선언한 String 타입의 변수에 값/문자열(data)을 할당하는 2가지 방법
        String name1 = "KANG Moomin";
        String name2 = "KANG Moomin";
        String name3 = new String("KANG Moomin");
        String name4 = new String("KANG Moomin");

        // String 타입의 변수를 참조하면 String 클래스의 toString() 메서드(String 타입 변수가 저장하고 있는 주소 값에 위치한 String 인스턴스의 내용을 문자열로 반환)가 자동으로 호출됨 -> 나의 질문 = sout에서?
        System.out.println(name1);
        System.out.println(name3);




    }
}
