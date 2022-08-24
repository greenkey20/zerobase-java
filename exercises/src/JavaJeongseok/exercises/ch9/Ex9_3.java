package exercises.src.JavaJeongseok.exercises.ch9;

// 2022.8.24(수) 20h15
// String 클래스(Java에서 문자열을 위해 제공하는 클래스)의 메소드 활용
public class Ex9_3 {
    public static void main(String[] args) {
        String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
        String path = "";
        String fileName = "";

        int index = fullPath.lastIndexOf("\\");
//        int index = fullPath.lastIndexOf("*");

        if (index != -1) {
            path = fullPath.substring(0, index); // 나의 질문 = index가 -1인 경우 substring(0, -1)과 같이 메소드 사용하면 어떤 값이 반환되나? -> 23h20 실험 결과, 'String index out of range: -1 at java.lang.String.substring' 따라서 index가 -1인 경우에 대한 예외 처리 필요
            fileName = fullPath.substring(index + 1);
        }

        System.out.println("fullPath = " + fullPath); // c:\jdk1.8\work\PathSeparateTest.java
        System.out.println("path = " + path); // c:\jdk1.8\work
        System.out.println("fileName = " + fileName); // PathSeparateTest.java
    }
}
