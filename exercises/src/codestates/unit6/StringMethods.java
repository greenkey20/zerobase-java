package exercises.src.codestates.unit6;

// 2022.8.30(화) 16h
public class StringMethods {
    public static void main(String[] args) {
        // charAt()
        String str = new String("Java");
        System.out.println("문자열 = " + str);
        for (int i = 0; i < str.length(); i++) {
            System.out.println("str의 " + (i + 1) + "번째 문자 = " + str.charAt(i));
        }
        System.out.println("charAt() 메서드 호출 후 문자열 = " + str); // Java
        System.out.println("====");

        // compareTo(IgnoreCase)(): 해당 문자열을 인수로 전달된 문자열과 사전 편찬 순으로 비교 + 대/소문자 구분해서 비교 -> 나의 질문 = 이 메소드 반환 int 값의 의미는?
        str = new String("abcd");
        System.out.println("문자열 = " + str);
        System.out.println(str.compareTo("bcef")); // 문자열 str이 인수로 전달된 문자열 bcef보다 작음 -> 음수 -1 반환
        System.out.println(str.compareTo("edey")); // -4
        System.out.println(str.compareTo("abcd")); // 0
        System.out.println(str.compareTo("aBcd")); // 문자열 str이 인수로 전달된 문자열 aBcd보다 큼 -> 양수 32 반환
        System.out.println(str.compareTo("Abcd")); // 32
        System.out.println(str.compareToIgnoreCase("aBcd")); // 0
        System.out.println("compareTo(IgnoreCase)() 메서드 호출 후 문자열 = " + str); // abcd
        System.out.println("====");

        // concat(): 해당 문자열의 뒤에 인수로 전달된 문자열을 추가한 새로운 문자열을 반환 <- concatenate(연결하다)
        str = new String("Java"); // 이렇게 str에 "Java"라는 문자열 값을 '다시' 할당하는 경우, new 연산자로 String 인스턴스 만들어서 하면 새로운 주소/객체로 만들어진다는 거지? vs "Java" 문자열을 직접 대입하면 이 클래스 맨 위에서 만든 문자열 주소를 다시 가리키게 되는 것인가?
        System.out.println("문자열 = " + str);
        System.out.println(str.concat(" 수업 신나요~")); // Java 수업 신나요~
        System.out.println(str.concat(" 수업 신나요~").concat(" 열심히, 즐겁게, 공부해요")); // Java 수업 신나요~ 열심히, 즐겁게, 공부해요
        System.out.println(str.concat(" 수업 신나요~").concat(" 열심히, 즐겁게, 공부해요").concat(String.valueOf(88))); // Java 수업 신나요~ 열심히, 즐겁게, 공부해요88
        System.out.println("concat() 메서드 호출 후 문자열 = " + str); // Java
        System.out.println("====");

        // indexOf(): 인수로 전달된 특정 문자(열)가 해당 문자열에서 처음으로 등장하는 위치의 인덱스 반환 -> 인수로 전달된 문자(열)가 포함되어 있지 않으면 -1 반환
        str = new String("Oracle Java");
        System.out.println("문자열 = " + str);
        System.out.println(str.indexOf('o')); // -1 <- 대/소문자 구분해서 탐색
        System.out.println(str.indexOf('a')); // 2
        System.out.println(str.indexOf(97)); // 2 -> 나의 생각 = 인수로 int 값 전달되면 ASCII 코드 값으로 해석하는 듯?
        System.out.println(str.indexOf("a")); // 2
        System.out.println(str.indexOf("java")); // -1 <- 대/소문자 구분해서 탐색
        System.out.println(str.indexOf("Java")); // 7
        System.out.println("indexOf() 메서드 호출 후 문자열 = " + str); // Oracle Java
        System.out.println("====");

        // trim(): 해당 문자열의 맨 앞/뒤에 포함된 모든 공백 문자 제거; 문자열 중간에 포함된 공백 문자는 제거x -> 나의 질문 = 문자열 중간에 포함된 공백 문자 제거는 어떻게 하면 좋을까?
        str = new String(" Jav a     ");
        System.out.println("문자열 = " + str); // " Jav a     "
        System.out.println("|" + str + "|"); // | Jav a     |
        System.out.println("|" + str.trim() + "|"); // | Jav a     |
        System.out.println("trim() 메서드 호출 후 문자열 = " + str); // " Jav a     "
        System.out.println("====");

    }
}
